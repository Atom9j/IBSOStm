package kz.bss.ibsostm.handling;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andrey Smirnov
 */
public class ParsingXml
{
    private static final Logger LOGGER = Logger.getLogger(ParsingXml.class);

    private ParsingXml()
    {
        throw new IllegalAccessError("XML class");
    }

    //Создаем тело выписки с данными из запроса
    public static List<String> createStatementBody(List<String> xml)
    {
        LinkedList<String> accList = new LinkedList<>();
        String xmlAccounts;
        for ( String str : xml )
        {
            xmlAccounts = str;
            try
            {
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
                        accList.add(Consts.STATEMENT1 + new SimpleDateFormat("dd.MM.yyyy HH:mm").format(System.currentTimeMillis()) +
                                Consts.STATEMENT2 + Consts.STATEMENT3 +
                                doc.getElementsByTagName("BeginDate").item(0).getTextContent() +
                                Consts.STATEMENT4 + Consts.STATEMENT5 +
                                doc.getElementsByTagName("EndDate").item(0).getTextContent() +
                                Consts.STATEMENT6 + Consts.STATEMENT7 +
                                Consts.STATEMENT8 + account.item(0).getNodeValue() + Consts.STATEMENT9);
                    }
                }
            }
            catch ( Exception e )
            {
                LOGGER.error(e);
            }
        }
        LOGGER.info("Accounts in iteration : " + accList.size());
        return accList;
    }
}
