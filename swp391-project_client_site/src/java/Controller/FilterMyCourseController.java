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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author doanq
 */
public class FilterMyCourseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        AccountCustomer ac = (AccountCustomer)session.getAttribute("acc");
        CourseDAO cd = new CourseDAO();
        CategoriesDAO cated = new CategoriesDAO();
        List<Categories> listCategories = cated.getListCategories();
        String[] category_id = req.getParameterValues("category_id");
        List<String> checkedCategories = new ArrayList<>();
        if (category_id != null) {
            checkedCategories.addAll(Arrays.asList(category_id));
        }

        String index_row = req.getParameter("index");
        if (index_row == null) {
            index_row = "1";
        }
        int index = Integer.parseInt(index_row);
        int count;
        List<Course> listFilterMyCourse;
        if (category_id != null && category_id.length > 0) {
            count = cd.getTotaMylCourse(ac.getCustomer_id(),category_id);
            listFilterMyCourse = cd.listFilterMyCourse(index,category_id,ac.getCustomer_id());
        } else {
            count = cd.getTotaMylCourse(ac.getCustomer_id(),new String[0]);
            listFilterMyCourse = cd.listFilterMyCourse(index,new String[0],ac.getCustomer_id());
        }

        int endPage = count / 9;
        if (count % 9 != 0) {
            endPage++;
        }
        String selectedCategories_row = String.join(",", checkedCategories);
        String[] selectedCategories_arr = selectedCategories_row.split(",");
        String selectedCategories = "";
        if (!selectedCategories_row.isEmpty()) {
            for (int i = 0; i < selectedCategories_arr.length; i++) {
                selectedCategories += "&category_id=" + selectedCategories_arr[i];
            }
        }
        req.setAttribute("mode", "filter");
        req.setAttribute("selectedCategories", selectedCategories);
        req.setAttribute("index", index);
        req.setAttribute("endP", endPage);
        req.setAttribute("mode", "filter");
        req.setAttribute("listCategories", listCategories);
        req.setAttribute("category_id", category_id);
        req.setAttribute("checkedCategories", checkedCategories);
        req.setAttribute("getListMyCourse", listFilterMyCourse);
        req.getRequestDispatcher("mycourse.jsp").forward(req, resp);
    }
    
}
