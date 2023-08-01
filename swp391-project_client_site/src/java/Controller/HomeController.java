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
public class HomeController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO pd = new CourseDAO();
        CategoriesDAO cd = new CategoriesDAO();
        List<Course> listNewItem = pd.listNewItem();
        List<Course> listTopSelling = pd.listTopSelling();
        List<Categories> listCategories = cd.getListCategories();
        req.setAttribute("listCategories", listCategories);
        req.setAttribute("listNewItem", listNewItem);
        req.setAttribute("listTopSelling", listTopSelling);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
    
}
