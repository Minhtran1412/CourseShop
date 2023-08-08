/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.CategoriesDAO;
import Dao.CourseDAO;
import Model.Categories;
import Model.Course;
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
public class CourseManageController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        CategoriesDAO cated = new CategoriesDAO();
        String index_row = req.getParameter("index");
        if(index_row==null){
            index_row="1";
        }
        int index = Integer.parseInt(index_row);
        
        int count = cd.getTotalCourse("");
        int endPage = count/10;
        if(count%10!=0){
            endPage++;
        }
        
        List<Course> listCourseByPaging = cd.listCourseByPaging(index);
        req.setAttribute("mode", "coursemanager");
        req.setAttribute("endP", endPage);
        req.setAttribute("index", index);
        req.setAttribute("listAllCourse", listCourseByPaging);
        req.getRequestDispatcher("coursemanage.jsp").forward(req, resp);
    }
    
}
