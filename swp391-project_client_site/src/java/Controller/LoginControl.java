///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package Controller;

import Dao.AccountDAO;
import Model.AccountCustomer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");        
        AccountDAO dao = new AccountDAO();
        AccountCustomer a = dao.login(username, password);
        boolean check = dao.checkStatus(username, password);         
        if (a == null) {
            req.setAttribute("mess", "Wrong username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {           
                HttpSession session = req.getSession();
            session.setAttribute("acc", a);
            session.setAttribute("sess_customer_id", a.getCustomer_id());
                resp.sendRedirect("home");
            
            }
            
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

}
