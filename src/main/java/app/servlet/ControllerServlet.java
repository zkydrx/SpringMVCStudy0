package app.servlet;

import app.domain.Product;
import app.form.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-25
 * Time: 10:40
 * Description:
 */
public class ControllerServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }

    private void process(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        String uri = request.getRequestURI();
        /**
         * uri is in this form:/contextName/resourceName,
         * for example: /app10a/product_input.
         * However, in the event of a default context, the
         * context name is empty, and uri has this form
         * /resouceName, e.g.: /product_input
         */
        int lastIndexOf = uri.lastIndexOf("/");
        String action = uri.substring(lastIndexOf + 1);
        if(action.equals("product_input.action"))
        {
            // no action class,there is nothing to be done
        }
        else if(action.equals("product_save.action"))
        {
            // create form
            ProductForm productForm = new ProductForm();

            // populate action properties
            productForm.setName(request.getParameter("name"));
            productForm.setDescription(request.getParameter("description"));
            productForm.setPrice(request.getParameter("price"));

            // create model
            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try
            {
                product.setPrice(Float.parseFloat(productForm.getPrice()));
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
            }

            // code to save product

            // store model in a scope variable for the view
            request.setAttribute("product",product);

        }

        // forward to a view
        String dispatchUrl = null;
        if(action.equals("product_input.action"))
        {
            dispatchUrl = "WEB-INF/jsp/ProductForm.jsp";
        }
        else if (action.equals("product_save.action"))
        {
            dispatchUrl = "/WEB-INF/jsp/ProductDetails.jsp";
        }

        if(dispatchUrl != null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request,response);
        }

    }
}
