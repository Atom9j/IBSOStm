package kz.bss.ibsostm.handling;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.Properties;
import java.util.UUID;

/**
 * @author Andrey Smirnov
 */

public class DBInteraction
{
    private static final Logger LOGGER = Logger.getLogger(DBInteraction.class);

    //Конект к БД
    private static Connection getDBConnection()
    {
        Properties jdbcProp = new Properties();
        String url = null;
        String user = null;
        String pass = null;
        try
        {
            FileInputStream inputStream = new FileInputStream(System.getenv("CATALINA_HOME") + "/webapps/" + Consts.CONF_PATH);
            jdbcProp.load(inputStream);
            url = jdbcProp.getProperty("jdbc.URL");
            user = jdbcProp.getProperty("jdbc.USER");
            pass = jdbcProp.getProperty("jdbc.PASS");
            LOGGER.info(url + user + pass);
        }
        catch ( IOException e )
        {
            LOGGER.error(e);
        }
        Connection dbConnection = null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
        }
        catch ( ClassNotFoundException e )
        {
            LOGGER.error(e.getMessage());
        }
        try
        {
            dbConnection = DriverManager.getConnection(url, user, pass);
            return dbConnection;
        }
        catch ( SQLException e )
        {
            LOGGER.error(e.getMessage());
        }
        return dbConnection;
    }

    //Вытаскиваем все запросы на выписку
    public static LinkedList<String> allStatementQueries() throws SQLException
    {
        LinkedList<String> messages = new LinkedList<>();
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        try
        {
            dbConnection = getDBConnection();
            if ( dbConnection != null )
            {
                preparedStatement = dbConnection.prepareStatement(
                        "SELECT * FROM TMP_EXTSYS_INCOMING where DOCTYPE = ?");
                //11 -запрос выписки
                preparedStatement.setInt(1, 11);
                //выполняем запрос
                ResultSet result = preparedStatement.executeQuery();
                while ( result.next() )
                {
                   /* System.out.println("Номер в выборке #" + result.getRow()
                            + "\t Номер в базе #" + result.getString("PSPID")
                            + "\t" + result.getString("DOCCONTENT"));*/
                    messages.add(result.getString("DOCCONTENT"));
                }
            }
        }
        catch ( SQLException e )
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
                catch ( SQLException ex )
                {
                    LOGGER.error(ex);
                }
            }
        }
        return messages;
    }

    //Вставляем готовую выписку
    public static boolean insertNewStatement(LinkedList param) throws SQLException
    {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        String docContent;
        int count = 0;
        boolean itsOk = false;
        try
        {
            dbConnection = getDBConnection();
            if ( dbConnection != null )
            {
                for ( Object aParam : param )
                {
                    docContent = aParam.toString();
                    if ( !"".equals(docContent) )
                    {
                        preparedStatement = dbConnection.prepareStatement(
                                "INSERT INTO TMP_EXTSYS_OUTGOING (ID, DOCTYPE, DOCCONTENT) VALUES (? , ? , ?)");
                        preparedStatement.setString(1, UUID.randomUUID().toString());
                        //12 - выпискa
                        preparedStatement.setInt(2, 12);
                        preparedStatement.setString(3, docContent);
                        //выполняем запрос
                        count += preparedStatement.executeUpdate();
                        preparedStatement.close();
                        itsOk = true;
                    }
                }
                LOGGER.info(count + " - records is inserted!");
            }
        }
        catch ( SQLException e )
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
                catch ( SQLException ex )
                {
                    LOGGER.error(ex);
                }
            }
        }
        return itsOk;
    }

    //Убираем за собой запросы выписок, есть шанс удалить необработанный запрос :)
    public static void deleteRequests() throws SQLException
    {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        try
        {
            dbConnection = getDBConnection();
            if ( dbConnection != null )
            {
                preparedStatement = dbConnection.prepareStatement("DELETE TMP_EXTSYS_INCOMING where DOCTYPE = ?");
                preparedStatement.setInt(1, 11);
                int count = preparedStatement.executeUpdate();
                LOGGER.info(count + " - records is deleted!");
            }
        }
        catch ( SQLException e )
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
