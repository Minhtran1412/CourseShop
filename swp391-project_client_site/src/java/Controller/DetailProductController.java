/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.CommentDAO;
import Dao.CourseDAO;
import Model.Comment;
import Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author DUNGVT
 */
public class DetailProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_id = req.getParameter("course_id");
        CourseDAO cd = new CourseDAO();
        CommentDAO cm = new CommentDAO();
        Course c = cd.getCourseById(course_id);
        List<Course> listc = cd.getCourseByCate(c.getCategory_id());
        
        String index_row = req.getParameter("index");
        if(index_row==null){
            index_row="1";
        }
        int index = Integer.parseInt(index_row);
        int count = cm.getTotalCommentByCourseId(course_id);
        int endPage = count/3;
        if(count%3!=0){
            endPage++;
        }
        List<Comment> listComment = cm.getListCommentByCourseID(course_id,index);
        
        req.setAttribute("index", index);
        req.setAttribute("endP", endPage);
        req.setAttribute("course_id", Integer.parseInt(course_id));
        req.setAttribute("listP", listc);
        req.setAttribute("listComment", listComment);
        req.setAttribute("course", c);
        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }

}
