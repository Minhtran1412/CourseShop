/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.CommentDAO;
import Dao.CourseDAO;
import Dao.OrderDAO;
import Dao.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author doanq
 */
public class DeleteController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        CommentDAO comd = new CommentDAO();
        OrderDetailDAO odd = new OrderDetailDAO();
        if(req.getParameter("mode").equals("coursedelete")){
            String course_id = req.getParameter("course_id");
            comd.deleteCommentByCourseId(course_id);
            odd.deleteOrderDetailByCourseId(course_id);
            cd.deleteCourseByCourseId(course_id);
            resp.sendRedirect("coursemanage");
        }
    }
    
}
