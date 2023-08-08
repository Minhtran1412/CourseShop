/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author doanq
 */
public class OrderDetail {
    private String order_detail_id,id,course_price,course_id;

    public OrderDetail() {
    }

    public OrderDetail(String order_detail_id, String id, String course_price, String course_id) {
        this.order_detail_id = order_detail_id;
        this.id = id;
        this.course_price = course_price;
        this.course_id = course_id;
    }

    public String getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(String order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "order_detail_id=" + order_detail_id + ", id=" + id + ", course_price=" + course_price + ", course_id=" + course_id + '}';
    }

    

   
}
