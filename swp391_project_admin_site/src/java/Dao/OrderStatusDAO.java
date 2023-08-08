/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Course;
import Model.OrderStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doanq
 */
public class OrderStatusDAO extends DBContext{

    public OrderStatus orderStatusByOrderId(String order_id) {
        
        try {
            String strSelect = "select Order_Status.* from Order_Status join Orders\n" +
"on Order_Status.order_status_id = Orders.order_status_id\n" +
"where Orders.order_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, order_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               OrderStatus os = new OrderStatus();
               os.setOrder_status_id(order_id);
               os.setOrder_status_name(rs.getString(2));
               return os;
            }
        } catch (Exception e) {
            System.out.println("OrderStatusByOrderId" + e.getMessage());
        }
        return null;
    }

    public List<OrderStatus> getListOrderStatus() {
        List<OrderStatus> data = new ArrayList<>();
        try {
            String strSelect = "select * from Order_Status";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String order_status_id = rs.getString(1);
                String order_status_name = rs.getString(2);

                data.add(new OrderStatus(order_status_id, order_status_name));
            }
        } catch (Exception e) {
            System.out.println("getListOrderStatus" + e.getMessage());
        }
        return data;
    }
    public static void main(String[] args) {
        OrderStatusDAO o =new OrderStatusDAO();
        
    }
}
