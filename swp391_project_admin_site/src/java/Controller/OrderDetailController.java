/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.CourseDAO;
import Dao.OrderDAO;
import Dao.OrderStatusDAO;
import Model.Course;
import Model.Order;
import Model.OrderStatus;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author doanq
 */
public class OrderDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        OrderStatusDAO osd = new OrderStatusDAO();
        OrderDAO od = new OrderDAO();
        Order o = new Order();
        String order_id = req.getParameter("order_id");
        List<Course> getListCourseByOrderId = cd.getListCourseByOrderId(order_id);
        o = od.getOderById(order_id);
        req.setAttribute("o", o);
        req.setAttribute("getListCourseByOrderId", getListCourseByOrderId);
        req.getRequestDispatcher("orderdetail.jsp").forward(req, resp);
    }

}