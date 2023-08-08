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
import java.io.IOException;

/**
 *
 * @author DUNGVT
 */
public class AdminCreateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        AccountAdminDAO ad = new AccountAdminDAO();
        AccountAdmin a = ad.getAccountByUsername(username);
        if(a==null){
            ad.insertAccount(name, username, password, role);
        }
        else{
            req.setAttribute("name", name);
            req.setAttribute("username", username);
            req.setAttribute("mes", "Username existed!");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
        resp.sendRedirect("admin_acc_manage");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signup.jsp");
    }

}
