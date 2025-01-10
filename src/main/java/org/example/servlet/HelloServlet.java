package org.example.servlet;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        description = "A simple demo servlet",
        urlPatterns = {"/hello"},
        initParams = {
                @WebInitParam(name = "defaultUser", value = "Yogesh")
        })
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String defaultUser = getServletConfig().getInitParameter("defaultUser");
        response.setContentType("text/html");
        String name = (String) request.getSession().getAttribute("name");
        String sessionName = name == null ? defaultUser : name;

        response.getWriter().write("<h2>Session 'name' value = " + sessionName + "!</h2>");
        response.getWriter().write("<h2>Context " + request.getServletContext().getAttribute("name") + "!</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        req.getServletContext().setAttribute("name", name);

        req.getSession().setAttribute("name", name);
        req.getSession().setAttribute("email", email);

        resp.getWriter().write("<h1>Login Success!</h1>");
    }
}