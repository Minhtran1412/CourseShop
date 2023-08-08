/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author doanq
 */
public class OrderStatus {
    private String order_status_id,order_status_name;

    public OrderStatus() {
    }

    public OrderStatus(String order_status_id, String order_status_name) {
        this.order_status_id = order_status_id;
        this.order_status_name = order_status_name;
    }

    public String getOrder_status_id() {
        return order_status_id;
    }

    public void setOrder_status_id(String order_status_id) {
        this.order_status_id = order_status_id;
    }

    public String getOrder_status_name() {
        return order_status_name;
    }

    public void setOrder_status_name(String order_status_name) {
        this.order_status_name = order_status_name;
    }

    @Override
    public String toString() {
        return "OrderStatus{" + "order_status_id=" + order_status_id + ", order_status_name=" + order_status_name + '}';
    }
    
}
