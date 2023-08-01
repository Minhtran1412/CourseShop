/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.AccountDAO;
import Model.AccountCustomer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import validate.Validate;

/**
 *
 * @author acer
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/change"})
public class ChangePassword extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePassword</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassword at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String customer_username = request.getParameter("customer_username");
        String oldpassword = request.getParameter("oldpassword");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmPassword");
        AccountDAO dao = new AccountDAO();
        AccountCustomer a = dao.login(customer_username, oldpassword);
        if (a == null) {
            //Old password wrong
            request.setAttribute("mess", "Wrong old password");
            request.getRequestDispatcher("change.jsp").forward(request, response);
        } else {
            if (Validate.isValidPassword(password)) {
                if (!password.equals(confirmpassword)) {
                    request.setAttribute("mess", "Wrong repassword");
                    request.getRequestDispatcher("change.jsp").forward(request, response);
                }else{
                    AccountCustomer ac = new AccountCustomer();
                    dao.changePass(password, customer_username);
                    HttpSession session = request.getSession();
                    response.sendRedirect("home");
                }
            }if(!Validate.isValidPassword(password)){
                request.setAttribute("mess", "It contains at least 8 characters and at most 20 characters.\n"
                        + "It contains at least one digit.\n"
                        + "It contains at least one upper case alphabet.\n"
                        + "It contains at least one lower case alphabet.\n"
                        + "It contains at least one special character which includes !@#$%&*()-+=^.\n"
                        + "It doesn’t contain any white space.");
                request.getRequestDispatcher("change.jsp").forward(request, response);
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
