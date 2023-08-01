/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.AccountDAO;
import Model.AccountCustomer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import validate.Validate;

/**
 *
 * @author mih
 */
public class SignUpConTrol extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customer_name = request.getParameter("customer_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String email = request.getParameter("email");
        String customer_phone = request.getParameter("customer_phone");
        String customer_address = request.getParameter("customer_address");
        String customer_dob = request.getParameter("customer_dob");
        if (Validate.isValidUsername(username)
                && Validate.isValidPassword(password)
                && Validate.isValidEmail(email)
                && Validate.isValidPhone(customer_phone)) {
            //if password != repassword -> login.jsp
            if (!password.equals(repassword)) {
                request.setAttribute("smess", "Wrong repassword");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            } else {
                AccountDAO dao = new AccountDAO();
                AccountCustomer a = dao.checkAccountExist(username);
                if (a == null) {
                    //Can sign up
                    dao.signup(customer_name, username, password, email, customer_address, customer_phone, customer_dob);
                    request.setAttribute("smess", "Sign Up successful. Login Now");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    //back to login.jsp
                    request.setAttribute("smess", "User Name already exist");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }
            }
            //sign up
        } else {
            if (!Validate.isValidUsername(username)) {
                request.setAttribute("smess", "The username consists of 6 to 30 characters inclusive. If the username\n"
                        + "consists of less than 6 or greater than 30 characters, then it is an invalid username.\n"
                        + "The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters [a – z], uppercase characters [A – Z], and digits [0 – 9].\n"
                        + "The first character of the username must be an alphabetic character, i.e., either lowercase character\n"
                        + "[a – z] or uppercase character [A – Z].");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            if (!Validate.isValidPassword(password)) {
                request.setAttribute("smess", "The password contains at least 8 characters and at most 20 characters.\n"
                        + "It contains at least one digit.\n"
                        + "It contains at least one upper case alphabet.\n"
                        + "It contains at least one lower case alphabet.\n"
                        + "It contains at least one special character which includes !@#$%&*()-+=^.\n"
                        + "It doesn’t contain any white space.");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            if(!Validate.isValidEmail(email)){
                request.setAttribute("smess", "Email is invalid");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
            if(!Validate.isValidPhone(customer_phone)){
                request.setAttribute("smess", "Phone is invalid");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
