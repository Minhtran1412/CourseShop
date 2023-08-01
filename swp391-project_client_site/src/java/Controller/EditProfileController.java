/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class EditProfileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customer_id = req.getParameter("customer_id");
        String customer_name = req.getParameter("customer_name");
        String customer_email = req.getParameter("customer_email");
        String customer_address = req.getParameter("customer_address");
        String customer_phone = req.getParameter("customer_phone");
        String customer_dob = req.getParameter("customer_dob");
        AccountDAO dao = new AccountDAO();
        dao.editProfile(customer_id, customer_name, customer_email, customer_address, customer_phone, customer_dob);
        resp.sendRedirect("loadProfile");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}
