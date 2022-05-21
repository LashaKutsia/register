package com.example.demo14;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        try {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String password1 = request.getParameter("password1");
            String username = request.getParameter("username");
            String profession = request.getParameter("profession");


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Mavirmuni123.");
            PreparedStatement ps = con.prepareStatement("INSERT INTO tasks (name, email, password,password1, username, profession) " + " values (?, ?, ?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4,password1);
            ps.setString(5, username);
            ps.setString(6, profession);
            ps.execute();
            request.setAttribute("name",name);
            request.setAttribute("email",email);
            request.setAttribute("username",username);
            request.setAttribute("profession",profession);
            if(username.isEmpty() || password.isEmpty() || !password.equals(password1)){
                con.close();
                getServletContext().getRequestDispatcher("/incorect.jsp").forward(request,response);
                System.out.println("Empty");
            } else  {
                getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);
            }

        }

        catch (SQLException e) {
            getServletContext().getRequestDispatcher("/error.repeat.jsp").forward(request, response);

        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/incorect.jsp").forward(request,response);
        }

    }
}
