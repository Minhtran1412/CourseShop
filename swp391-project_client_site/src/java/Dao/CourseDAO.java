/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doanq
 */
public class CourseDAO extends DBContext {

    public Course getCourseById(String Id) {
        String sql = "select * from Courses where course_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(Id));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Course c = new Course();

                CategoriesDAO cd = new CategoriesDAO();

                c.setCourse_id(rs.getString(1));
                c.setCourse_name(rs.getString(2));
                c.setCourse_description(rs.getString(3));
                c.setCourse_price(rs.getDouble(4));
                c.setCourse_create_date(rs.getString(5));
                c.setCourse_modified_date(rs.getString(6));
                c.setCategory_id(rs.getString(7));
                c.setSupplier_id(rs.getString(8));
                c.setCourse_short_desc(rs.getString(9));
                c.setCourse_create_by(rs.getString(10));
                c.setCourse_modified_by(rs.getString(11));
                c.setCourse_img(rs.getString(12));
                c.setCourse_discount(rs.getDouble(13));

                return c;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Course> getCourseByCate(String Cateid) {
        String sql = "select * from Courses where category_id = ?";
        List<Course> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(Cateid));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course c = new Course();

                c.setCourse_id(rs.getString(1));
                c.setCourse_name(rs.getString(2));
                c.setCourse_description(rs.getString(3));
                c.setCourse_price(rs.getDouble(4));
                c.setCourse_create_date(rs.getString(5));
                c.setCourse_modified_date(rs.getString(6));
                c.setCategory_id(rs.getString(7));
                c.setSupplier_id(rs.getString(8));
                c.setCourse_short_desc(rs.getString(9));
                c.setCourse_create_by(rs.getString(10));
                c.setCourse_modified_by(rs.getString(11));
                c.setCourse_img(rs.getString(12));
                c.setCourse_discount(rs.getDouble(13));

                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        CourseDAO c = new CourseDAO();
        List<Course> data = c.listNewItem();
        for (Course course : data) {
            System.out.println(course);
        }
    }

    public List<Course> listNewItem() {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select top 5 Courses.*,category_name from  Categories join Courses\n"
                    + "on Categories.category_id = Courses.category_id\n"
                    + "order by Courses.course_create_date desc";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("listNewItem" + e.getMessage());
        }
        return data;
    }
    
    public List<Course> listMyCourse(String customer_id){
        String sql = "select * from Orders inner join OrderDetail  on OrderDetail.id = Orders.order_id inner join Courses on OrderDetail.course_id = Courses.course_id where payment_id = 1 and customer_id = ?";
        List<Course> data = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer_id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                Course c = new Course();
                c.setCourse_id(rs.getString(9));
                c.setCourse_name(rs.getString(11));
                c.setCourse_description(rs.getString(12));
                c.setCourse_price(rs.getDouble(13));
                c.setCourse_create_date(rs.getString(14));
                c.setCourse_modified_date(rs.getString(15));
                c.setCategory_id(rs.getString(16));
                c.setSupplier_id(rs.getString(17));
                c.setCourse_short_desc(rs.getString(18));
                c.setCourse_create_by(rs.getString(19));
                c.setCourse_modified_by(rs.getString(20));
                c.setCourse_img(rs.getString(21));
                c.setCourse_discount(rs.getDouble(22));
                data.add(c);
            }
            
        } catch (Exception e) {
        }
        return data;
    }

    public int getTotalCourse(String search, String[] category_id) {
        String sql = "select count(*) from Courses ";
        if (category_id.length > 0 && category_id != null) {
            sql += " where ";
            for (int i = 0; i < category_id.length - 1; i++) {
                sql += "category_id = " + category_id[i] + " or ";
            }
            sql += "category_id = " + category_id[category_id.length - 1];
        }
        if (!search.isEmpty()) {
            sql += "join Categories on Courses.category_id = Categories.category_id\n"
                    + "join Supplier on Courses.supplier_id = Supplier.supplier_id\n"
                    + "where Courses.course_name like '%" + search + "%' or Categories.category_name like '%" + search + "%' or Supplier.supplier_name like '%" + search + "%'";
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                return rs.getInt(1);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Course> listCourseOfCateByPaging(int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select * from Courses order by course_id desc\n"
                    + "offset ? rows fetch next 9 rows only";

            PreparedStatement st = connection.prepareStatement(strSelect);

            st.setInt(1, (index - 1) * 9);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course c = new Course();

                c.setCourse_id(rs.getString(1));
                c.setCourse_name(rs.getString(2));
                c.setCourse_description(rs.getString(3));
                c.setCourse_price(rs.getDouble(4));
                c.setCourse_create_date(rs.getString(5));
                c.setCourse_modified_date(rs.getString(6));
                c.setCategory_id(rs.getString(7));
                c.setSupplier_id(rs.getString(8));
                c.setCourse_short_desc(rs.getString(9));
                c.setCourse_create_by(rs.getString(10));
                c.setCourse_modified_by(rs.getString(11));
                c.setCourse_img(rs.getString(12));
                c.setCourse_discount(rs.getDouble(13));

                data.add(c);
            }
        } catch (Exception e) {
            System.out.println("listCourseOfCateByPaging" + e.getMessage());
        }
        return data;
    }

    public List<Course> listFilterCourse(int index, String sortCourse, String[] arr_category_id) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select * from courses ";
            if (arr_category_id.length > 0 && arr_category_id != null) {
                strSelect += " where ";
                for (int i = 0; i < arr_category_id.length - 1; i++) {
                    strSelect += "category_id = " + arr_category_id[i] + " or ";
                }
                strSelect += "category_id = " + arr_category_id[arr_category_id.length - 1];
            }
            if (sortCourse.equals("0")) {
                strSelect += " order by (course_price - (course_price*course_discount/100)) desc offset ? rows fetch next 9 rows only";
            }
            if (sortCourse.equals("1")) {
                strSelect += " order by (course_price - (course_price*course_discount/100)) asc offset ? rows fetch next 9 rows only";
            }
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 9);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("listFilterCourse" + e.getMessage());
        }
        return data;
    }

    public List<Course> getCourseByFilter(String filter, String search, int index) {
        switch (filter) {
            case "All":
                return searchCourseByAll(search, index);
            case "Category Name":
                return searchCourseByCateName(search, index);
            case "Course Name":
                return searchCourseByCourseName(search, index);
            case "Supplier Name":
                return searchCourseBySupName(search, index);
        }
        return null;

    }

    private List<Course> searchCourseByAll(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from Courses join Categories\n"
                    + "on Courses.category_id = Categories.category_id join Supplier \n"
                    + "on Courses.supplier_id = Supplier.supplier_id\n"
                    + "where Courses.course_id like '%" + search + "%' or Categories.category_name like '%" + search + "%'"
                    + " or Courses.course_name like '%" + search + "%' or Supplier.supplier_name like '%" + search + "%' order by course_id desc offset ? rows fetch next 9 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 9);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("searchCourseByAll" + e.getMessage());
        }
        return data;

    }

    private List<Course> searchCourseByCateName(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from Courses join Categories\n"
                    + "on Courses.category_id = Categories.category_id where Categories.category_name like '%" + search + "%' order by course_id desc offset ? rows fetch next 9 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 9);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("searchCourseByCateName" + e.getMessage());
        }
        return data;
    }

    private List<Course> searchCourseByCourseName(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select * from Courses where Courses.course_name like '%" + search + "%' order by course_id desc offset ? rows fetch next 9 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 9);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("searchCourseByCourseName" + e.getMessage());
        }
        return data;
    }

    private List<Course> searchCourseBySupName(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from Courses join Supplier\n"
                    + "on Courses.supplier_id = Supplier.supplier_id where Supplier.supplier_name like '%" + search + "%' order by course_id desc offset ? rows fetch next 9 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 9);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("searchCourseBySupName" + e.getMessage());
        }
        return data;
    }

    public String test(String[] test) {
        String sql = "select count(*) from Courses ";
        if (test.length > 0) {
            sql += " where ";
            for (int i = 0; i < test.length - 1; i++) {
                sql += "category_id = " + test[i] + " or ";
            }
            sql += "category_id = " + test[test.length - 1];
        }

        return sql;
    }
    public List<Course> getListMyCourse(String customer_id, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from Orders join OrderDetail on Orders.order_id = OrderDetail.id\n"
                    + "join Account_Customer on Account_Customer.customer_id = Orders.customer_id\n"
                    + "join Courses on Courses.course_id = OrderDetail.course_id\n"
                    + "where Account_Customer.customer_id = ? and Orders.[payment_id] = '1'"
                    + " order by Orders.order_date desc offset ? rows fetch next 9 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);

            st.setString(1, customer_id);
            st.setInt(2, (index - 1) * 9);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("getListMyCourse" + e.getMessage());
        }
        return data;
    }

    public int getTotaMylCourse(String customer_id, String[] category_id) {
        String sql = "select count(*) from Orders join OrderDetail on Orders.order_id = OrderDetail.id\n"
                + "join Account_Customer on Account_Customer.customer_id = Orders.customer_id\n"
                + "join Courses on Courses.course_id = OrderDetail.course_id\n"
                + "where Account_Customer.customer_id = ? and Orders.[payment_id] = '1' ";
        if (category_id.length > 0 && category_id != null) {
            sql += " and ";
            for (int i = 0; i < category_id.length - 1; i++) {
                sql += "category_id = " + category_id[i] + " or ";
            }
            sql += "category_id = " + category_id[category_id.length - 1];
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                return rs.getInt(1);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Course> listFilterMyCourse(int index, String[] arr_category_id, String customer_id) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from Orders join OrderDetail on Orders.order_id = OrderDetail.id\n"
                    + "join Account_Customer on Account_Customer.customer_id = Orders.customer_id\n"
                    + "join Courses on Courses.course_id = OrderDetail.course_id where Account_Customer.customer_id = ? and Orders.[payment_id] = '1'";
            if (arr_category_id.length > 0 && arr_category_id != null) {
                strSelect += " and ";
                for (int i = 0; i < arr_category_id.length - 1; i++) {
                    strSelect += "category_id = " + arr_category_id[i] + " or ";
                }
                strSelect += "category_id = " + arr_category_id[arr_category_id.length - 1];
            }
            strSelect += " order by Orders.order_date desc offset ? rows fetch next 9 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, customer_id);
            st.setInt(2, (index - 1) * 9);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("listFilterMyCourse" + e.getMessage());
        }
        return data;
    }
    public List<Course> listTopSelling() {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select * from Courses \n"
                    + "where course_id in (\n"
                    + "SELECT TOP 5 Courses.course_id FROM Orders\n"
                    + "JOIN OrderDetail ON Orders.order_id = OrderDetail.id\n"
                    + "JOIN Courses ON Courses.course_id = OrderDetail.course_id\n"
                    + "GROUP BY Courses.course_id\n"
                    + "ORDER BY COUNT(*) DESC)";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                Double course_price = rs.getDouble(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                Double course_discount = rs.getDouble(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("listTopSelling" + e.getMessage());
        }
        return data;
    }

}
