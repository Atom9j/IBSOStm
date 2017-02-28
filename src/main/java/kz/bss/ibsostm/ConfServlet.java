package kz.bss.ibsostm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static kz.bss.ibsostm.ServletController.whatToDo;

/**
 * @author Andrey Smirnov
 */
public class ConfServlet extends HttpServlet
{
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

        whatToDo(request, response);
    }
}
