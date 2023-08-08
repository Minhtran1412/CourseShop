/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.CourseDAO;
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
public class SearchCourseController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        String filter = req.getParameter("filter");
        String search = req.getParameter("search");
        
        String index_row = req.getParameter("index");
        if(index_row==null){
            index_row="1";
        }
        int index = Integer.parseInt(index_row);
        
        int count = cd.getTotalCourse(search);
        int endPage = count/10;
        if(count%10!=0){
            endPage++;
        }
        
        
        List<Course> listSearchCourse = cd.getCourseByFilter(filter,search,index);
        req.setAttribute("mode", "searchcourse");
        req.setAttribute("endP", endPage);
        req.setAttribute("index", index);
        req.setAttribute("filter", filter);
        req.setAttribute("search", search);
        req.setAttribute("listAllCourse", listSearchCourse);
        req.getRequestDispatcher("coursemanage.jsp").forward(req, resp);
    }
    
}
