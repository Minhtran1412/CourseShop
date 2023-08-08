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
public class AdminProfileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("account_id");
        AccountAdminDAO ad = new AccountAdminDAO();
        
        //set lai session sau khi update
        AccountAdmin a = ad.getAccountById(id);
        HttpSession session = req.getSession();
        session.setAttribute("account", a);
        
        
        req.setAttribute("accprofile", a);
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

}
