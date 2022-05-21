package com.example.demo14;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/error")
public class Error extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}