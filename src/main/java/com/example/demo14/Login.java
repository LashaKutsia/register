package com.example.demo14;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/LoginPage")
public class Login extends HttpServlet {
    @Override

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Mavirmuni123.");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            request.setAttribute("username", username);
            request.setAttribute("password", password);

            PreparedStatement preparedStatement = connection.prepareStatement("select * from tasks where username = \'" + username + "\' and password = \'" + password + "\' order by id");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next() == false){
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);

            }else {
                getServletContext().getRequestDispatcher("/user.jsp").forward(request, response);

            }
//
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
