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
 * @author doanq
 */
public class UpdateProfileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountAdminDAO aad = new AccountAdminDAO();
        HttpSession session = req.getSession();
        AccountAdmin aa = (AccountAdmin) session.getAttribute("account");
        String account_email = req.getParameter("account_email");
        String account_phone = req.getParameter("account_phone");
        String account_password = req.getParameter("account_password");
        String account_avatar;
        if (req.getParameter("account_avatar").length() != 0) {
            account_avatar = "img/" + req.getParameter("account_avatar");
        } else {
            account_avatar = req.getParameter("account_avatar_old");
        }

        if (validate.Validate.isValidEmail(account_email) && validate.Validate.isValidPassword(account_password) && validate.Validate.isValidPhone(account_phone)) {
            aad.updateProfile(account_password, account_phone, account_email, account_avatar, aa.getAccount_id());
//            resp.sendRedirect("profileinfo?account_id="+aa.getAccount_id()+"&account_avatar_change="+account_avatar);
            resp.sendRedirect("profileinfo?account_id=" + aa.getAccount_id());
        } else {
            String mess = "";
            if (!validate.Validate.isValidEmail(account_email)) {

                mess += "Email Invalid!";
            }
            if (!validate.Validate.isValidPassword(account_password)) {

                mess += "Pass Invalid!";
            }
            if (!validate.Validate.isValidPhone(account_phone)) {
                mess += "Phone Invalid!";
            }
            req.setAttribute("account_email", account_email);
            req.setAttribute("account_phone", account_phone);
            req.setAttribute("account_password", account_password);
            req.setAttribute("mode", "1");
            req.setAttribute("accprofile", aa);
            req.setAttribute("mess", mess);
            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
