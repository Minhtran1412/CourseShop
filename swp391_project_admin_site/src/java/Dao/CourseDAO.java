/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Course;
import java.sql.Date;
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
                c.setCourse_price(rs.getString(4));
                c.setCourse_create_date(rs.getString(5));
                c.setCourse_modified_date(rs.getString(6));
                c.setCategory_id(rs.getString(7));
                c.setSupplier_id(rs.getString(8));
                c.setCourse_short_desc(rs.getString(9));
                c.setCourse_create_by(rs.getString(10));
                c.setCourse_modified_by(rs.getString(11));
                c.setCourse_img(rs.getString(12));
                c.setCourse_discount(rs.getString(13));

                return c;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    public List<Course> getCourseByCate(String Cateid) {
//        String sql = "select * from Courses where category_id = ?";
//        List<Course> list = new ArrayList<>();
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, Integer.parseInt(Cateid));
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                Course c = new Course();
//
//                c.setCourse_id(rs.getString(1));
//                c.setCourse_name(rs.getString(2));
//                c.setCourse_description(rs.getString(3));
//                c.setCourse_price(rs.getString(4));
//                c.setCourse_create_date(rs.getString(5));
//                c.setCourse_modified_date(rs.getString(6));
//                c.setCategory_id(rs.getString(7));
//                c.setSupplier_id(rs.getString(8));
//                c.setCourse_short_desc(rs.getString(9));
//                c.setCourse_create_by(rs.getString(10));
//                c.setCourse_modified_by(rs.getString(11));
//                c.setCourse_img(rs.getString(12));
//                c.setCourse_discount(rs.getString(13));
//
//                list.add(c);
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }

//    public List<Course> listNewItem() {
//        List<Course> data = new ArrayList<>();
//        try {
//            String strSelect = "select top 5 Courses.*,category_name from  Categories join Courses\n"
//                    + "on Categories.category_id = Courses.category_id\n"
//                    + "order by Courses.course_create_date desc";
//            PreparedStatement st = connection.prepareStatement(strSelect);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                String course_id = rs.getString(1);
//                String course_name = rs.getString(2);
//                String course_description = rs.getString(3);
//                String course_price = rs.getString(4);
//                String course_create_date = rs.getString(5);
//                String course_modified_date = rs.getString(6);
//                String category_id = rs.getString(7);
//                String supplier_id = rs.getString(8);
//                String course_short_desc = rs.getString(9);
//                String course_create_by = rs.getString(10);
//                String course_modified_by = rs.getString(11);
//                String course_img = rs.getString(12);
//                String course_discount = rs.getString(13);
//
//                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
//            }
//        } catch (Exception e) {
//            System.out.println("listNewItem" + e.getMessage());
//        }
//        return data;
//    }

//    public static void main(String[] args) {
//        CourseDAO cd = new CourseDAO();
//        System.out.println(cd.listCourseByPaging(1));
//    }
    public List<Course> listCourseByPaging(int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select * from Courses\n"
                    + "order by course_id desc\n"
                    + "offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                String course_price = rs.getString(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                String course_discount = rs.getString(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("listAllCourse" + e.getMessage());
        }
        return data;
    }

    public void courseCreate(String course_name, String course_description, String course_price, String course_create_date, String course_modified_date, String category_id, String supplier_id, String course_short_desc, String course_create_by, String course_modified_by, String course_img, String course_discount) {
        try {
            String strSelect = "INSERT INTO [dbo].[Courses]\n"
                    + "           ([course_name]\n"
                    + "           ,[course_description]\n"
                    + "           ,[course_price]\n"
                    + "           ,[course_create_date]\n"
                    + "           ,[course_modified_date]\n"
                    + "           ,[category_id]\n"
                    + "           ,[supplier_id]\n"
                    + "           ,[course_short_desc]\n"
                    + "           ,[course_create_by]\n"
                    + "           ,[course_modified_by]\n"
                    + "           ,[course_img]\n"
                    + "           ,[course_discount])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, course_name);
            st.setString(2, course_description);
            st.setString(3, course_price);
            st.setDate(4, Date.valueOf(course_create_date));
            st.setDate(5, Date.valueOf(course_modified_date));
            st.setString(6, category_id);
            st.setString(7, supplier_id);
            st.setString(8, course_short_desc);
            st.setString(9, course_create_by);
            st.setString(10, course_modified_by);
            st.setString(11, course_img);
            st.setString(12, course_discount);

            st.execute();

        } catch (Exception e) {
            System.out.println("courseCreate" + e.getMessage());
        }
    }

    public void courseUpdate(String course_id, String course_name, String course_description, String course_price, String course_modified_date, String category_id, String supplier_id, String course_short_desc, String course_modified_by, String course_img, String course_discount) {
        try {
            String strSelect = "UPDATE [dbo].[Courses]\n"
                    + "   SET [course_name] = ?,\n"
                    + "      [course_description] = ?,\n"
                    + "      [course_price] = ?,\n"
                    + "      \n"
                    + "      [course_modified_date] = ?,\n"
                    + "      [category_id] = ?,\n"
                    + "      [supplier_id] = ?,\n"
                    + "      [course_short_desc] = ?,\n"
                    + "      \n"
                    + "      [course_modified_by] = ?,\n"
                    + "      [course_img] = ?,\n"
                    + "      [course_discount] = ?\n"
                    + " WHERE [course_id] = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, course_name);
            st.setString(2, course_description);
            st.setString(3, course_price);
            st.setDate(4, Date.valueOf(course_modified_date));
            st.setString(5, category_id);
            st.setString(6, supplier_id);
            st.setString(7, course_short_desc);
            st.setString(8, course_modified_by);
            st.setString(9, course_img);
            st.setString(10, course_discount);
            st.setString(11, course_id);
            st.execute();

        } catch (Exception e) {
            System.out.println("courseUpdate" + e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        CourseDAO cd = new CourseDAO();
//        cd.courseUpdate("26", "hohoh", "eee", "1234567", "2023-05-24", "2", "2", "...", "quan", "usercss/images/CourseImage/Web4.PNG", "6");
//    }
    public void deleteCourseByCourseId(String course_id) {
        try {
            String strSelect = "DELETE FROM [dbo].[Courses]\n"
                    + "      WHERE course_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, course_id);
            st.execute();

        } catch (Exception e) {
            System.out.println("courseDelete" + e.getMessage());
        }
    }

    public List<Course> getCourseByFilter(String filter, String search, int index) {
        switch (filter) {
            case "All":
                return searchCourseByAll(search,index);
            case "Course Id":
                return searchCourseByCourseID(search,index);
            case "Category Name":
                return searchCourseByCateName(search,index);
            case "Course Name":
                return searchCourseByCourseName(search,index);
            case "Supplier Name":
                return searchCourseBySupName(search,index);
        }
        return null;

    }

    private List<Course> searchCourseByAll(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from Courses join Categories\n"
                    + " on Courses.category_id = Categories.category_id join Supplier \n"
                    + " on Courses.supplier_id = Supplier.supplier_id\n"
                    + " where Courses.course_id like '%" + search + "%' or Categories.category_name like '%" + search + "%'"
                    + " or Courses.course_name like '%" + search + "%' or Supplier.supplier_name like '%" + search + "%'"
                    + " order by course_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                String course_price = rs.getString(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                String course_discount = rs.getString(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("searchCourseByAll" + e.getMessage());
        }
        return data;

    }

    private List<Course> searchCourseByCourseID(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select * from Courses where Courses.course_id like '%" + search + "%'"
                    + " order by course_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                String course_price = rs.getString(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                String course_discount = rs.getString(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("searchCourseByCourseID" + e.getMessage());
        }
        return data;
    }

    private List<Course> searchCourseByCateName(String search, int index) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from Courses join Categories\n"
                    + "on Courses.category_id = Categories.category_id where Categories.category_name like '%" + search + "%'"
                    + " order by course_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                String course_price = rs.getString(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                String course_discount = rs.getString(13);

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
            String strSelect = "select * from Courses where Courses.course_name like '%" + search + "%'"
                    + " order by course_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                String course_price = rs.getString(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                String course_discount = rs.getString(13);

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
                    + "on Courses.supplier_id = Supplier.supplier_id where Supplier.supplier_name like '%" + search + "%'"
                    + " order by course_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                String course_price = rs.getString(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                String course_discount = rs.getString(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("searchCourseBySupName" + e.getMessage());
        }
        return data;
    }

    public List<Course> getListCourseByOrderId(String order_id) {
        List<Course> data = new ArrayList<>();
        try {
            String strSelect = "select Courses.* from OrderDetail join Courses\n"
                    + "on OrderDetail.course_id = Courses.course_id\n"
                    + "where OrderDetail.id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, order_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String course_id = rs.getString(1);
                String course_name = rs.getString(2);
                String course_description = rs.getString(3);
                String course_price = rs.getString(4);
                String course_create_date = rs.getString(5);
                String course_modified_date = rs.getString(6);
                String category_id = rs.getString(7);
                String supplier_id = rs.getString(8);
                String course_short_desc = rs.getString(9);
                String course_create_by = rs.getString(10);
                String course_modified_by = rs.getString(11);
                String course_img = rs.getString(12);
                String course_discount = rs.getString(13);

                data.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));
            }
        } catch (Exception e) {
            System.out.println("getListCourseByOrderId" + e.getMessage());
        }
        return data;
    }

    public int getTotalCourse(String search) {
        String sql = "select count(*) from Courses ";
        if (!search.isEmpty()) {
            sql += "join Categories on Courses.category_id = Categories.category_id join Supplier\n"
                    + " on Courses.supplier_id = Supplier.supplier_id\n"
                    + " where Courses.course_id like '%" + search + "%' or Categories.category_name like '%" + search + "%'\n"
                    + " or Courses.course_name like '%" + search + "%' or Supplier.supplier_name like '%" + search + "%'";
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
    public static void main(String[] args) {
        CourseDAO c = new CourseDAO();
        System.out.println(c.getListCourseByOrderId("4"));
    }
}
