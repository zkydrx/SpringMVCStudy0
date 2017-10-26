package app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-26
 * Time: 01:05
 * Description:
 */
public class InputProductController implements Controller
{

    public String handleRequest(HttpServletRequest request, HttpServletResponse response)
    {
        return "/WEB-INF/jsp/ProductForm.jsp";
    }
}
