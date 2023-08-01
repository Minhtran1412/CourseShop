/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.AccountCustomer;
import Model.Cart;
import Model.Course;
import Model.Item;
import Model.Order;
import Model.OrderDetail;
import jakarta.servlet.jsp.jstl.sql.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class OrderDAO extends DBContext {

    public void addOrder(AccountCustomer ac, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            String sql = "INSERT INTO Orders(customer_id,order_date,order_total_price) VALUES(?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, ac.getCustomer_id());
            st.setString(2, date);
            st.setDouble(3, cart.getTotalMoney());
            st.executeUpdate();
            String sql1 = "select top 1 order_id from Orders order by order_id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);
            ResultSet rs = st1.executeQuery();
            if (rs.next()) {
                String order_id = rs.getString(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT INTO OrderDetail VALUES(?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    System.out.println(i.getCourse().getCourse_name());
                    st2.setString(1, order_id);
                    st2.setDouble(2, i.getPrice());
                    st2.setString(3, i.getCourse().getCourse_id());
                    st2.executeUpdate();
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void changePaymentStatusSuccess() {
        try {
            String sql = "select top 1 order_id from Orders order by order_id desc";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String order_id = rs.getString(1);
                String sql1 = "UPDATE Orders SET payment_id = 1 where order_id = ?";
                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setString(1, order_id);
                st1.executeUpdate();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public void changePaymentStatusFail() {
        try {
            String sql = "select top 1 order_id from Orders order by order_id desc";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String order_id = rs.getString(1);
                String sql1 = "UPDATE Orders SET payment_id = 0 where order_id = ?";
                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setString(1, order_id);
                st1.executeUpdate();
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Course> selectCheckOut() {
        List<Course> list = new ArrayList<>();
        try {
            String sql = "select top 1 order_id from Orders order by order_id desc";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String order_id = rs.getString(1);
                String sql1 = "select * from  OrderDetail od inner join Courses c on od.course_id = c.course_id where od.id = ?";
                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setString(1, order_id);
                ResultSet rs1 = st1.executeQuery();
                while (rs1.next()) {
                    String course_id = rs1.getString(5);
                    String course_name = rs1.getString(6);
                    String course_description = rs1.getString(7);
                    Double course_price = rs1.getDouble(8);
                    String course_create_date = rs1.getString(9);
                    String course_modified_date = rs1.getString(10);
                    String category_id = rs1.getString(11);
                    String supplier_id = rs1.getString(12);
                    String course_short_desc = rs1.getString(13);
                    String course_create_by = rs1.getString(14);
                    String course_modified_by = rs1.getString(15);
                    String course_img = rs1.getString(16);
                    Double course_discount = rs1.getDouble(17);
                    list.add(new Course(course_id, course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount));

                }
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public Order loadCheckOut(){
            String sql = "select top 1 * from Orders order by order_id desc";
        try {
            Order o = new Order();
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                o.setId(rs.getInt(1));
                o.setCustomer_id(rs.getInt(2));
                o.setOrder_date(rs.getString(3));
                o.setOrder_total_price(rs.getDouble(4));
                return o;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();
        List<Course> listc = od.selectCheckOut();
        for (Course course : listc) {
            System.out.println(course);
        }
    }

}
