package app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-26
 * Time: 01:03
 * Description:
 */
public interface Controller
{
    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
