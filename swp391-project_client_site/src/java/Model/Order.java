/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.io.Serializable;

public class Order implements Serializable{
	private int id;
	private int customer_id;// nguoi mua
	private String order_date;// ngay mua
	private double order_total_price;// tong tien

    public Order() {
    }

    public Order(int id, int customer_id, String order_date, double order_total_price) {
        this.id = id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.order_total_price = order_total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public double getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(double order_total_price) {
        this.order_total_price = order_total_price;
    }

	
}