package app.validator;

import app.form.ProductForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-26
 * Time: 16:08
 * Description:
 */
public class ProductValidator
{
    public List<String> validate(ProductForm productForm)
    {
        List<String> errors = new ArrayList<String>();
        String name = productForm.getName();
        if(name == null || name.trim().isEmpty())
        {
           errors.add("Product must have a name");
        }
        String description = productForm.getDescription();

        if(description == null || description.trim().isEmpty())
        {
            errors.add("Product must have the description");
        }
        String price = productForm.getPrice();
        if(price == null || price.trim().isEmpty())
        {
            errors.add("Product must have a price");
        }
        else
        {
            try
            {
                Float.parseFloat(price);
            }
            catch (NumberFormatException e)
            {
                errors.add("Invalid price value");
            }
        }
        return errors;
    }
}
