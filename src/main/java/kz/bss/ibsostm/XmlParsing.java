package kz.bss.ibsostm;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Properties;
import java.util.UUID;

/**
 * @author Andrey Smirnov
 */
class XmlParsing {
    private static final Logger LOGGER = Logger.getLogger(XmlParsing.class);

    private static final String CONF_PATH = "conf.properties";

    private XmlParsing() {
        throw new IllegalAccessError("XML class");
    }

    //Создаем тело выписки с данными из запроса
    static LinkedList<String> prepareStatement(LinkedList<String> xml) {
        LinkedList<String> accList = new LinkedList<>();
        String xmlAccounts;
        for( String str : xml ) {
            xmlAccounts = str;
            if ( !"".equals(xmlAccounts) )
            {
                try {
                    DocumentBuilder docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document doc = docBuild.parse(new InputSource(new StringReader(xmlAccounts)));
                    doc.getDocumentElement().normalize();
                    NodeList nodeLst = doc.getElementsByTagName("Accounts");
                    Node accountNode = nodeLst.item(0);
                    if ( accountNode.getNodeType() == Node.ELEMENT_NODE )
                    {
                        Element childElmnt = (Element) accountNode;
                        NodeList childElmntLst = childElmnt.getElementsByTagName("string");
                        for ( int a = 0; a < childElmntLst.getLength(); a++ )
                        {
                            Element accElmnt = (Element) childElmntLst.item(a);
                            NodeList account = accElmnt.getChildNodes();
                            accList.add(StatementModel.STATEMENT1+new SimpleDateFormat("dd.MM.yyyy HH:mm").format(System.currentTimeMillis())+
                                    StatementModel.STATEMENT2+StatementModel.STATEMENT3 +
                                    doc.getElementsByTagName("BeginDate").item(0).getTextContent()+
                                    StatementModel.STATEMENT4+StatementModel.STATEMENT5 +
                                    doc.getElementsByTagName("EndDate").item(0).getTextContent()+
                                    StatementModel.STATEMENT6 + StatementModel.STATEMENT7 +
                                    StatementModel.STATEMENT8 + account.item(0).getNodeValue() + StatementModel.STATEMENT9);
                        }
                    }
                } catch (Exception e) {
                    LOGGER.error(e);
                }
            }
            else accList.add("");
        }
        LOGGER.info("Accounts in iteration : " + accList.size());
        return accList;
    }

    //Конект к БД
    private static Connection getDBConnection() {
        Properties jdbcProp = new Properties();
        String url = null;
        String user = null;
        String pass = null;
        try {
            FileInputStream inputStream = new FileInputStream(System.getenv("CATALINA_HOME")+"webapps/"+CONF_PATH);
            jdbcProp.load(inputStream);
            url = jdbcProp.getProperty("jdbc.URL");
            user = jdbcProp.getProperty("jdbc.USER");
            pass = jdbcProp.getProperty("jdbc.PASS");
            LOGGER.info(url + user+ pass);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        Connection dbConnection = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(url, user, pass);
            return dbConnection;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return dbConnection;
    }

    //Вытаскиваем все запросы на выписку
    static LinkedList<String> allStatementQueries() throws SQLException {
        LinkedList <String> messages = new LinkedList <>();
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        try {
            dbConnection = getDBConnection();
            if ( dbConnection != null )
            {
                preparedStatement = dbConnection.prepareStatement(
                        "SELECT * FROM TMP_EXTSYS_INCOMING where DOCTYPE = ?");
                //11 -запрос выписки
                preparedStatement.setInt(1, 11);
                //выполняем запрос
                ResultSet result = preparedStatement.executeQuery();
                while (result.next())
                {
                   /* System.out.println("Номер в выборке #" + result.getRow()
                            + "\t Номер в базе #" + result.getString("PSPID")
                            + "\t" + result.getString("DOCCONTENT"));*/
                    messages.add(result.getString("DOCCONTENT"));
                }
            }
        }
        catch (SQLException e)
        {
            LOGGER.error(e);
        }
        finally
        {
            if (preparedStatement != null)
            {
                preparedStatement.close();
            }
            if (dbConnection != null)
            {
                try
                {
                    dbConnection.close();
                }
                catch (SQLException ex)
                {
                    LOGGER.error(ex);
                }
            }
        }
        return messages;
    }

    //Вставляем готовую выписку
    static boolean insertNewStatement(LinkedList param) throws SQLException
    {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String docContent;
        boolean itsOk = false;
        try
        {
            dbConnection = getDBConnection();
            if ( dbConnection != null )
            {
                for (Object aParam : param)
                {
                    docContent = aParam.toString();
                    if( !"".equals(docContent) )
                    {
                        preparedStatement = dbConnection.prepareStatement(
                                "INSERT INTO TMP_EXTSYS_OUTGOING (ID, DOCTYPE, DOCCONTENT) VALUES (? , ? , ?)");
                        preparedStatement.setString(1, UUID.randomUUID().toString());
                        //12 - выпискa
                        preparedStatement.setInt(2, 12);
                        preparedStatement.setString(3, docContent);
                        //выполняем запрос
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                        itsOk = true;
                    }
                }
            }
        }
        catch (SQLException e)
        {
            LOGGER.error(e);
        }
        finally
        {
            if ( preparedStatement != null )
            {
                preparedStatement.close();
            }
            if ( dbConnection != null )
            {
                try
                {
                    dbConnection.close();
                }
                catch (SQLException ex)
                {
                    LOGGER.error(ex);
                }
            }
        }
        return itsOk;
    }

    //Убираем за собой запросы выписок, есть шанс удалить необработанный запрос :)
    static void deleteRequests() throws SQLException
    {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        try
        {
            dbConnection = getDBConnection();
            if( dbConnection != null )
            {
                preparedStatement = dbConnection.prepareStatement("DELETE TMP_EXTSYS_INCOMING where DOCTYPE = ?");
                preparedStatement.setInt(1, 11);
                preparedStatement.executeUpdate();
                LOGGER.info("Records is deleted!");
            }
        }
        catch (SQLException e)
        {
            LOGGER.error(e.getMessage());
        }
        finally
        {
            if ( preparedStatement != null )
            {
                preparedStatement.close();
            }
            if ( dbConnection != null )
            {
                dbConnection.close();
            }
        }
    }
}
