/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.CommentDAO;
import Dao.CourseDAO;
import Model.AccountCustomer;
import Model.Comment;
import Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author doanq
 */
public class CommentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentDAO cm = new CommentDAO();
        CourseDAO cd = new CourseDAO();
        HttpSession session = req.getSession();
        if (req.getParameter("mode").equals("add")) {

            if (session.getAttribute("acc") == null) {
                resp.sendRedirect("login");
            } else {
                String comment_text = req.getParameter("comment_text");
                String course_id = req.getParameter("course_id");
                Course c = cd.getCourseById(course_id);
                AccountCustomer a = (AccountCustomer) session.getAttribute("acc");
                LocalDateTime comment_date_row = LocalDateTime.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String comment_date = comment_date_row.format(dateTimeFormatter);
                cm.addComment(a.getCustomer_id(), course_id, comment_text, comment_date);
                List<Course> listc = cd.getCourseByCate(c.getCategory_id());
                String index_row = req.getParameter("index");
                if (index_row == null) {
                    index_row = "1";
                }
                int index = Integer.parseInt(index_row);
                int count = cm.getTotalCommentByCourseId(course_id);
                int endPage = count / 3;
                if (count % 3 != 0) {
                    endPage++;
                }
                List<Comment> listComment = cm.getListCommentByCourseID(course_id, index);
//                req.setAttribute("id", Integer.parseInt(course_id));
                req.setAttribute("index", index);
                req.setAttribute("endP", endPage);
                req.setAttribute("listP", listc);
                req.setAttribute("listComment", listComment);
                req.setAttribute("course", c);
                req.setAttribute("course_id", course_id);
                req.getRequestDispatcher("detail.jsp").forward(req, resp);
            }
        } else if (req.getParameter("mode").equals("update")) {
            String comment_text = req.getParameter("comment_text");
            String course_id = req.getParameter("course_id");
            String comment_id = req.getParameter("comment_id");
            System.out.println("comment_text:" + comment_text);
            System.out.println("course_id:" + course_id);
            System.out.println("comment_id:" + comment_id);
            Course c = cd.getCourseById(course_id);
//            AccountCustomer a = (AccountCustomer) session.getAttribute("acc");
            LocalDateTime comment_date_row = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String comment_date = comment_date_row.format(dateTimeFormatter);
            cm.updateComment(comment_id, comment_text, comment_date);
            List<Course> listc = cd.getCourseByCate(c.getCategory_id());
            String index_row = req.getParameter("index");
            if (index_row == null) {
                index_row = "1";
            }
            int index = Integer.parseInt(index_row);
            int count = cm.getTotalCommentByCourseId(course_id);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<Comment> listComment = cm.getListCommentByCourseID(course_id, index);
            req.setAttribute("index", index);
            req.setAttribute("endP", endPage);
            req.setAttribute("listP", listc);
            req.setAttribute("listComment", listComment);
            req.setAttribute("course", c);
            req.setAttribute("course_id", course_id);
            req.getRequestDispatcher("detail.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentDAO cm = new CommentDAO();
        CourseDAO cd = new CourseDAO();
        HttpSession session = req.getSession();
        if (req.getParameter("mode").equals("delete")) {
            String comment_id = req.getParameter("comment_id");
            String course_id = req.getParameter("course_id");
            cm.deleteComment(comment_id);
            Course c = cd.getCourseById(course_id);
            List<Course> listc = cd.getCourseByCate(c.getCategory_id());
            String index_row = req.getParameter("index");
            if (index_row == null) {
                index_row = "1";
            }
            int index = Integer.parseInt(index_row);
            int count = cm.getTotalCommentByCourseId(course_id);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<Comment> listComment = cm.getListCommentByCourseID(course_id, index);
            req.setAttribute("index", index);
            req.setAttribute("endP", endPage);
            req.setAttribute("listP", listc);
            req.setAttribute("listComment", listComment);
            req.setAttribute("course", c);
            req.setAttribute("course_id", course_id);
            req.getRequestDispatcher("detail.jsp").forward(req, resp);
        }
        if (req.getParameter("mode").equals("update")) {

            String comment_text = req.getParameter("comment_text");
            String course_id = req.getParameter("course_id");
            String comment_id = req.getParameter("comment_id");
            Course c = cd.getCourseById(course_id);
            List<Course> listc = cd.getCourseByCate(c.getCategory_id());
            String index_row = req.getParameter("index");
            if (index_row == null) {
                index_row = "1";
            }
            int index = Integer.parseInt(index_row);
            int count = cm.getTotalCommentByCourseId(course_id);
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<Comment> listComment = cm.getListCommentByCourseID(course_id, index);
            req.setAttribute("index", index);
            req.setAttribute("endP", endPage);
            req.setAttribute("listP", listc);
            req.setAttribute("listComment", listComment);
            req.setAttribute("course", c);
            req.setAttribute("mode1", "update");
            req.setAttribute("comment_text", comment_text);
            req.setAttribute("course_id", course_id);
            req.setAttribute("comment_id", comment_id);
            req.getRequestDispatcher("detail.jsp").forward(req, resp);

        }
    }

}