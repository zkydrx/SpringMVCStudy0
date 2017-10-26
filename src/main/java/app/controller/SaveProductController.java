package app.controller;

import app.domain.Product;
import app.form.ProductForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-26
 * Time: 01:06
 * Description:
 */
public class SaveProductController implements Controller
{

    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
    {
        ProductForm productForm = new ProductForm();
        // populate form properties
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

        // insert code to add product to the database.
        request.setAttribute("product", product);
        return "/WEB-INF/jsp/ProductDetails.jsp";
    }
}
