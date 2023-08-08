/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Course;
import Model.Order;
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
public class OrderDAO extends DBContext {

    public List<Order> getListAllOrder(int index) {
        List<Order> data = new ArrayList<>();
        try {
            String strSelect = "select * from Orders \n"
                    + "order by order_id desc\n"
                    + "offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String order_id = rs.getString(1);
                String customer_id = rs.getString(2);
                String order_date = rs.getString(3);
                String order_total_price = rs.getString(4);
                String payment_id = rs.getString(5);

                data.add(new Order(order_id, customer_id, order_date, order_total_price, payment_id));
            }
        } catch (Exception e) {
            System.out.println("getListAllOrder" + e.getMessage());
        }
        return data;
    }

    public Order getOderById(String order_id) {
        try {
            String strSelect = "select * from Orders where Orders.order_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, order_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setOrder_id(order_id);
                o.setCustomer_id(rs.getString(2));
                o.setOrder_date(rs.getString(3));
                o.setOrder_total_price(rs.getString(4));
                o.setPayment_id(rs.getString(5));
                return o;
            }
        } catch (Exception e) {
            System.out.println("getOderById" + e.getMessage());
        }
        return null;
    }

    

    public List<Order> getOrderByFilter(String filter, String search, int index) {
        switch (filter) {
            case "All":
                return searchOrderByAll(search, index);
            case "Customer Phone":
                return searchOrderByCusPhone(search, index);
            case "Customer Name":
                return searchOrderByCusName(search, index);

        }
        return null;
    }

    private List<Order> searchOrderByAll(String search, int index) {
        List<Order> data = new ArrayList<>();
        try {
            String strSelect = "select Orders.* from Orders join Account_Customer\n"
                    + " on Orders.[customer_id] = Account_Customer.[customer_id]\n"
                    + " where Account_Customer.customer_name like '%" + search + "%' or Account_Customer.customer_phone like '%" + search + "%' "
                    + " order by order_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String order_id = rs.getString(1);
                String customer_id = rs.getString(2);
                String order_date = rs.getString(3);
                String order_total_price = rs.getString(4);
                String payment_id = rs.getString(5);

                data.add(new Order(order_id, customer_id, order_date, order_total_price, payment_id));
            }
        } catch (Exception e) {
            System.out.println("searchOrderByAll" + e.getMessage());
        }
        return data;
    }

    private List<Order> searchOrderByCusPhone(String search, int index) {
        List<Order> data = new ArrayList<>();
        try {
            String strSelect = "select Orders.* from Orders join Account_Customer\n"
                    + "on Orders.[customer_id] = Account_Customer.[customer_id]\n"
                    + "where Account_Customer.customer_phone like '%" + search + "%' "
                    + "order by order_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String order_id = rs.getString(1);
                String customer_id = rs.getString(2);
                String order_date = rs.getString(3);
                String order_total_price = rs.getString(4);
                String payment_id = rs.getString(5);

                data.add(new Order(order_id, customer_id, order_date, order_total_price, payment_id));
            }
        } catch (Exception e) {
            System.out.println("searchOrderByCusPhone" + e.getMessage());
        }
        return data;
    }

    private List<Order> searchOrderByCusName(String search, int index) {
        List<Order> data = new ArrayList<>();
        try {
            String strSelect = "select Orders.* from Orders join Account_Customer\n"
                    + "on Orders.[customer_id] = Account_Customer.[customer_id]\n"
                    + "where Account_Customer.customer_name like '%" + search + "%' "
                    + "order by order_id desc offset ? rows fetch next 10 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, (index - 1) * 10);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String order_id = rs.getString(1);
                String customer_id = rs.getString(2);
                String order_date = rs.getString(3);
                String order_total_price = rs.getString(4);
                String payment_id = rs.getString(5);

                data.add(new Order(order_id, customer_id, order_date, order_total_price, payment_id));
            }
        } catch (Exception e) {
            System.out.println("searchOrderByCusName" + e.getMessage());
        }
        return data;
    }

    public int getTotalOrder(String search) {
        String sql = "select count(*) from Orders";
        if (!search.isEmpty()) {
            sql += " join Account_Customer\n"
                    + "on Orders.customer_id = Account_Customer.customer_id\n"
                    + " where Account_Customer.customer_name like '%" + search + "%' or Account_Customer.customer_phone like '%" + search + "%'";
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
        OrderDAO o = new OrderDAO();
        System.out.println(o.getTotalOrder("Cristiano"));
    }

    public void changeStatus(String order_status, String order_id) {
        try {
            String strSelect = "UPDATE [dbo].[Orders]\n"
                    + "   SET \n"
                    + "	  [payment_id] = ?\n"
                    + " WHERE order_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, order_status);
            st.setString(2, order_id);

            st.execute();

        } catch (Exception e) {
            System.out.println("changeStatus" + e.getMessage());
        }
    }
}
