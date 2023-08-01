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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author doanq
 */
public class FilterCourseController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        CategoriesDAO cated = new CategoriesDAO();
        List<Categories> listCategories = cated.getListCategories();
        String sortCourse = req.getParameter("sortCourse");
        String[] category_id = req.getParameterValues("category_id");
        List<String> checkedCategories = new ArrayList<>();
        if (category_id != null) {
            checkedCategories.addAll(Arrays.asList(category_id));
        }

        HttpSession session = req.getSession();
        session.setAttribute("sortCourse", sortCourse);
        String index_row = req.getParameter("index");
        if (index_row == null) {
            index_row = "1";
        }
        int index = Integer.parseInt(index_row);
        int count;
        List<Course> listFilterCourse;
        if (category_id != null && category_id.length > 0) {
            count = cd.getTotalCourse("", category_id);
            listFilterCourse = cd.listFilterCourse(index, sortCourse, category_id);
        } else {
            count = cd.getTotalCourse("", new String[0]);
            listFilterCourse = cd.listFilterCourse(index, sortCourse, new String[0]);
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
        req.setAttribute("selectedCategories", selectedCategories);
        req.setAttribute("index", index);
        req.setAttribute("endP", endPage);
        req.setAttribute("mode", "filter");
        req.setAttribute("listCategories", listCategories);
        req.setAttribute("category_id", category_id);
        req.setAttribute("checkedCategories", checkedCategories);
        req.setAttribute("listCourseOfCateByPaging", listFilterCourse);
        req.getRequestDispatcher("courseofcategory.jsp").forward(req, resp);
    }

}