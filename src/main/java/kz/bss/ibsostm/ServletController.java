package kz.bss.ibsostm;

import kz.bss.ibsostm.handling.Consts;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

/**
 * @author Andrey Smirnov
 */
public class ServletController
{
    private static final Logger LOGGER = Logger.getLogger(ServletController.class);

    private ServletController()
    {
        throw new IllegalAccessError("ServletController class");
    }

    
    static void whatToDo(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        //Проверка на вид запрашиваемой задачи
        String action = request.getParameter("action");
        if ( Consts.SAVE_CONFIG.equals(action) )
        {
            String port = request.getParameter("port");
            String ip = request.getParameter("ip");
            String sid = request.getParameter("sid");
            String login = request.getParameter("login");
            String pass = request.getParameter("pass");
            writeToFile(port, ip, sid, login, pass);
            response.getWriter().write(Consts.OK_CONF + login);
        }
        else
        {
            if ( readFromFile() == null )
            {
                response.getWriter().write(Consts.NO_CONF);
            }
            else
            {
                response.getWriter().write(Consts.OK_CONF + readFromFile());
            }
        }
    }

    private static void writeToFile(String port, String ip, String sid, String login, String pass)
    {
        File dir = new File(System.getenv(Consts.CATALINA), Consts.FLDR);
        dir.mkdirs();
        File propertyFile = new File(dir, Consts.CONF_PATH);
        try
        {
            if ( !propertyFile.exists() )
            {
                propertyFile.createNewFile();
            }
            try (PrintWriter out = new PrintWriter(propertyFile.getAbsoluteFile()))
            {
                //Записываем текст в файл
                out.print(Consts.URL + Consts.JDBC + ip + ":" + port + ":" + sid + "\r\n" +
                        Consts.USER + "=" + login + "\r\n" +
                        Consts.PASS + "=" + pass);
            }
        }
        catch ( IOException e )
        {
            LOGGER.error(e);
        }
    }

    private static String readFromFile()
    {
        Properties jdbcProp = new Properties();
        String current = null;
        try
        {
            FileInputStream inputStream = new FileInputStream(System.getenv(Consts.CATALINA) + "/" + Consts.FLDR + "/" + Consts.CONF_PATH);
            jdbcProp.load(inputStream);
            current = jdbcProp.getProperty(Consts.USER);
            inputStream.close();
        }
        catch ( IOException e )
        {
            LOGGER.error(e);
        }
        return current;
    }
}
