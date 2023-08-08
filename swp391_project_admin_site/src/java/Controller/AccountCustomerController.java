/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.CustomerDao;
import Model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AccountCustomerController extends HttpServlet{

      @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDao cd = new CustomerDao();
        List<Customer> list = cd.listAllAccountCustomer();
        req.setAttribute("list", list);
//         resp.sendRedirect("accountcustomer");
        req.getRequestDispatcher("accountcustomer.jsp").forward(req, resp);
    }
    public static void main(String[] args) {
          CustomerDao cd = new CustomerDao();
        List<Customer> list = cd.listAllAccountCustomer();
        System.out.println(list);
    }
   
    
}
