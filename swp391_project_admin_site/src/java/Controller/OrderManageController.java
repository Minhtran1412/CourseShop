/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.OrderDAO;
import Model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author doanq
 */
public class OrderManageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        OrderDAO od = new OrderDAO();
//        String order_id = req.getParameter("order_id");
//        String order_status_id = req.getParameter("updateStatus");
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate course_modified_date_row = LocalDate.now();
//        String order_date = course_modified_date_row.format(dateTimeFormatter);
//        od.orderUpdate(order_id,order_status_id,order_date);
//        resp.sendRedirect("ordermanage");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDAO od = new OrderDAO();
        
        String index_row = req.getParameter("index");
        if(index_row==null){
            index_row="1";
        }
        int index = Integer.parseInt(index_row);
        
        int count = od.getTotalOrder("");
        int endPage = count/10;
        if(count%10!=0){
            endPage++;
        }
        
        List<Order> listAllOrder = od.getListAllOrder(index);
        req.setAttribute("mode", "ordermanager");
        req.setAttribute("endP", endPage);
        req.setAttribute("index", index);
        req.setAttribute("listAllOrder", listAllOrder);
        req.getRequestDispatcher("ordermanage.jsp").forward(req, resp);
    }

}