/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.CategoriesDAO;
import Dao.CourseDAO;
import Model.AccountCustomer;
import Model.Categories;
import Model.Course;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author doanq
 */
public class MyCourseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountCustomer ac = (AccountCustomer) session.getAttribute("acc");
        CourseDAO cd = new CourseDAO();
        CategoriesDAO cated = new CategoriesDAO();

        if (session.getAttribute("acc") == null) {
            resp.sendRedirect("login");
        } else {
            String index_row = req.getParameter("index");
            if (index_row == null) {
                index_row = "1";
            }
            int index = Integer.parseInt(index_row);

            int count = cd.getTotaMylCourse(ac.getCustomer_id(),new String[0]);
            int endPage = count / 9;
            if (count % 9 != 0) {
                endPage++;
            }

            List<Categories> listCategories = cated.getListCategories();
            List<Course> getListMyCourse = cd.getListMyCourse(ac.getCustomer_id(), index);
            req.setAttribute("mode", "mycourse");
            req.setAttribute("getListMyCourse", getListMyCourse);
            req.setAttribute("listCategories", listCategories);
            req.setAttribute("index", index);
            req.setAttribute("endP", endPage);
            req.getRequestDispatcher("mycourse.jsp").forward(req, resp);
        }
    }

}
