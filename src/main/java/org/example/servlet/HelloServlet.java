package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String queryString = request.getParameter("username");
        queryString = queryString == null ? "" : queryString;

        response.getWriter().write("<h1>Hello, " + queryString + "!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name.equals("admin") && password.equals("admin")) {
            resp.getWriter().write("<h1>Login Success</h1>");
        } else {
            resp.getWriter().write("<h1>Login Failed</h1>");
        }
    }
}