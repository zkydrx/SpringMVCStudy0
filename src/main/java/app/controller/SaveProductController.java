package app.controller;

import app.domain.Product;
import app.form.ProductForm;
import app.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

        // validate ProductForm

        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(productForm);
        if(errors.isEmpty())
        {
            // create Product from ProductForm
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

            // no validation error,execute action method
            // insert code to save product to the database

            // store product in a scope varibale for the view

            return "/WEB-INF/jsp/ProductDetails.jsp";

        }
        else
        {
            // store errors and form in a scope variable for the view
            request.setAttribute("errors",errors);
            request.setAttribute("form",productForm);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }




    }
}
