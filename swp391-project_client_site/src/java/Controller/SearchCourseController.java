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
public class SearchCourseController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        CategoriesDAO cated = new CategoriesDAO();
        String filtersearch = req.getParameter("filtersearch");
        String search = req.getParameter("search");
        
        List<Categories> listCategories = cated.getListCategories();
        String index_row = req.getParameter("index");
        if(index_row==null){
            index_row="1";
        }
        int index = Integer.parseInt(index_row);
        
        int count = cd.getTotalCourse(search,new String[0]);
        int endPage = count/9;
        if(count%9!=0){
            endPage++;
        }
        List<Course> listSearchCourse = cd.getCourseByFilter(filtersearch,search,index);
        req.setAttribute("endP", endPage);
        req.setAttribute("mode", "searchcourse");
        req.setAttribute("filtersearch", filtersearch);
        req.setAttribute("search", search);
        req.setAttribute("index", index);
        req.setAttribute("listCategories", listCategories);
        req.setAttribute("listCourseOfCateByPaging", listSearchCourse);
        req.getRequestDispatcher("courseofcategory.jsp").forward(req, resp);
    }
    
}
