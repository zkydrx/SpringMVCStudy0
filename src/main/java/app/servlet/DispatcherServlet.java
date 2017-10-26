package app.servlet;

import app.controller.InputProductController;
import app.controller.SaveProductController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-26
 * Time: 01:13
 * Description:
 */
public class DispatcherServlet extends HttpServlet
{
    private static final long serialVersionUID=748495L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req,resp);
    }

    private void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        String uri = request.getRequestURI();
        /**
         * uri is in this form: /contextName/resouceName
         * for example: /app10a/product_input
         * However, in the event of a default context, the
         * context name is empty, and uri has this form
         * /resouceName,e.g.:/product_input
         *
         */
        int lasIndex = uri.lastIndexOf("/");
        String action = uri.substring(lasIndex + 1);


        String dispatchUrl = null;
        if(action.equals("product_input.action"))
        {
            InputProductController controller = new InputProductController();
            dispatchUrl = controller.handleRequest(request, response);
        }
        else if(action.equals("product_save.action"))
        {
            SaveProductController controller = new SaveProductController();
            dispatchUrl = controller.handleRequest(request, response);
        }

        if(dispatchUrl !=null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request,response);
        }

    }
}
