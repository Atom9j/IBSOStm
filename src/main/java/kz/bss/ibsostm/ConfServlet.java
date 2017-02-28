package kz.bss.ibsostm;

import kz.bss.ibsostm.handling.Consts;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Andrey Smirnov
 */
public class ConfServlet extends HttpServlet
{
    private static final Logger LOGGER = Logger.getLogger(ConfServlet.class);
    private static final long serialVersionUID = 1L;

    public ConfServlet()
    {
        // Do nothing
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        String current = "";
        //Проверка на вид запрашиваемой задачи
        String action = request.getParameter("action");
        if ( "Save_config".equals(action) )
        {
            String port = request.getParameter("port");
            String ip = request.getParameter("ip");
            String sid = request.getParameter("sid");
            String login = request.getParameter("login");
            String pass = request.getParameter("pass");

            File d = new File(System.getenv("CATALINA_HOME"), "webapps");
            d.mkdirs();
            File propertyFile = new File(d, Consts.CONF_PATH);
            try
            {
                //проверяем, что если файл не существует то создаем его
                if ( !propertyFile.exists() )
                {
                    propertyFile.createNewFile();
                }
                //PrintWriter обеспечит возможности записи в файл
                PrintWriter out = new PrintWriter(propertyFile.getAbsoluteFile());

                try
                {
                    //Записываем текст в файл
                    out.print("jdbc.URL=jdbc:oracle:thin:@" + ip + ":" + port + ":" + sid + "\r\n" +
                            "jdbc.USER=" + login + "\r\n" +
                            "jdbc.PASS=" + pass);
                    current = "Текущая схема " + login;
                    response.getWriter().write(current);
                }
                finally
                {
                    //После чего мы должны закрыть файл
                    //Иначе файл не запишется
                    out.close();
                }
            }
            catch ( IOException e )
            {
                throw new RuntimeException(e);
            }
        }
        else
        {
            current = "Текущая схема norm";
            response.getWriter().write(current);
        }
    }
}
