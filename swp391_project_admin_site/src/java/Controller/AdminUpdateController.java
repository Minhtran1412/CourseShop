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
public class AdminUpdateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        String id = req.getParameter("id");

        AccountAdminDAO ad = new AccountAdminDAO();

        if (mode.equals("accupdate")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String role = req.getParameter("role");
            
            

            ad.upadateAccount(null, username, password, role, null, null, null, id, mode);
        }

        if (mode.equals("profileupdate")) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String avatar = req.getParameter("avatar");

            ad.upadateAccount(name, null, null, null, email, phone, avatar, id, mode);
        }

        resp.sendRedirect("admin_acc_manage");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = req.getParameter("mode");
        String id = req.getParameter("id");
        if (mode.equals("accupdate")) {
            AccountAdminDAO ad = new AccountAdminDAO();
            req.setAttribute("acc", ad.getAccountById(id));
            req.getRequestDispatcher("updateacc.jsp").forward(req, resp);
        }
        if (mode.equals("profileupdate")) {
            resp.sendRedirect("profileinfo?mode=updateprofile");
        }
    }

}
