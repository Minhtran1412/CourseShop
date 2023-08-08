/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.AccountAdminDAO;
import Model.AccountAdmin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author DUNGVT
 */
public class AdminLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String passsword = req.getParameter("password");

        AccountAdminDAO ad = new AccountAdminDAO();
        AccountAdmin a = ad.getAccountByUserAndPass(username, passsword);
        
        HttpSession session = req.getSession();
        if (a == null) {
            req.setAttribute("mes", "Account don't exits");
            req.getRequestDispatcher("signin.jsp").forward(req, resp);
        } else {
            session.setAttribute("account", a);
            resp.sendRedirect("accountcusmanage");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signin.jsp").forward(req, resp);
    }

}
