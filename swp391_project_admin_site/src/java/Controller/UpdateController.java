/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.CategoriesDAO;
import Dao.CourseDAO;
import Dao.SupplierDAO;
import Model.AccountAdmin;
import Model.Categories;
import Model.Course;
import Model.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author doanq
 */
public class UpdateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course c = new Course();
        CourseDAO cd = new CourseDAO();
        CategoriesDAO cated = new CategoriesDAO();
        Categories cate = new Categories();
        Supplier s = new Supplier();
        SupplierDAO  sd = new SupplierDAO();
        HttpSession session = req.getSession();
        AccountAdmin aa = (AccountAdmin)session.getAttribute("account");
        if(req.getParameter("courseupdate")!=null){
            
            String course_id = req.getParameter("course_id");
            //
            String course_name = req.getParameter("course_name");
            //
            String course_description = req.getParameter("course_description");
            //
            System.out.println(req.getParameter("course_price"));
            String course_price = req.getParameter("course_price");
            course_price = course_price.replaceAll("[^0-9]", "");
            //
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate course_modified_date_row = LocalDate.now();
            String course_modified_date = course_modified_date_row.format(dateTimeFormatter);
            //
            String category_name = req.getParameter("category_name");
            //
            String supplier_name = req.getParameter("supplier_name");
            //
            String course_short_desc = req.getParameter("course_short_desc");
            //
            String course_modified_by = aa.getAccount_name();
            //
            String course_img;
            if(req.getParameter("course_img").length()!=0){
                course_img ="usercss/images/CourseImage/"+ req.getParameter("course_img");
                System.out.println("anh moi" + course_img);
            }
            else{
                course_img =req.getParameter("course_img_old");
                System.out.println("anh cu " + course_img);
            }
            //
            String course_discount = req.getParameter("course_discount");
            //
            cate= cated.getCategoryByName(category_name);
            String category_id = cate.getCategory_id();
            //
            s = sd.getSupplierByName(supplier_name);
            String supplier_id = s.getSupplier_id();
            
            cd.courseUpdate(course_id,course_name,course_description,course_price,course_modified_date,category_id,supplier_id,course_short_desc,course_modified_by,course_img,course_discount);
            resp.sendRedirect("coursemanage");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("mode").equals("courseupdate")) {
            String id = req.getParameter("course_id");
            CourseDAO cd = new CourseDAO();
            SupplierDAO sd = new SupplierDAO();
            CategoriesDAO cad = new CategoriesDAO();
            Course c = cd.getCourseById(id);
            List<Categories> getListCategories = cad.getListCategories();
            List<Supplier> getListSupplier = sd.getListSupplier();
        req.setAttribute("getListSupplier", getListSupplier);
            req.setAttribute("getListCategories", getListCategories);
            req.setAttribute("courseinfo", c);
            req.setAttribute("mode", req.getParameter("mode"));
            req.getRequestDispatcher("coursecrud.jsp").forward(req, resp);
        }
    }
}