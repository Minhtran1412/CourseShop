package com.uniquedeveloper.registration;

import Dao.AccountDAO;
import Model.AccountCustomer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import validate.Validate;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AccountDAO dao = new AccountDAO();
        HttpSession session = request.getSession();
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        String email = (String) session.getAttribute("email");
        RequestDispatcher dispatcher = null;
        if (Validate.isValidPassword(newPassword) && Validate.isValidPassword(confPassword) && newPassword.equals(confPassword)) {
            dao.newPassword(newPassword, email);
            request.setAttribute("mess", "Reset password successful");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("mess", "It contains at least 8 characters and at most 20 characters.\n"
                    + "It contains at least one digit.\n"
                    + "It contains at least one upper case alphabet.\n"
                    + "It contains at least one lower case alphabet.\n"
                    + "It contains at least one special character which includes !@#$%&*()-+=^.\n"
                    + "It doesn’t contain any white space.");
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);

            dispatcher.forward(request, response);
        }
    }

}
