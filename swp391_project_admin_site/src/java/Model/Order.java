/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.AccountCustomerDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author doanq
 */
public class Order {
    private String order_id,customer_id,order_date,order_total_price,payment_id;

    public Order() {
    }

    public Order(String order_id, String customer_id, String order_date, String order_total_price, String payment_id) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.order_date = order_date;
        this.order_total_price = order_total_price;
        this.payment_id = payment_id;
    }

    

    

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    

    public String getOrder_date() {
        String currentFormat = "yyyy-MM-dd";
        String newFormat = "dd/MM/yyyy";
        try {
            SimpleDateFormat sdfCurrent = new SimpleDateFormat(currentFormat);
            SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);
            Date date = sdfCurrent.parse(order_date);
            String newDateString = sdfNew.format(date);

            return newDateString;
        } catch (ParseException e) {
            e.printStackTrace();
        }
            return null;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    

    public String getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(String order_total_price) {
        this.order_total_price = order_total_price;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", customer_id=" + customer_id + ", order_date=" + order_date + ", order_total_price=" + order_total_price + ", payment_id=" + payment_id + '}';
    }

    

    

    
    public String getCustomer_name() {
        AccountCustomerDAO acd = new AccountCustomerDAO();
        return acd.getAccountCustomerById(customer_id).getCustomer_name();
    }
    public String getCustomer_phone() {
        AccountCustomerDAO acd = new AccountCustomerDAO();
        return acd.getAccountCustomerById(customer_id).getCustomer_phone();
    }
    public String getCustomer_email() {
        AccountCustomerDAO acd = new AccountCustomerDAO();
        return acd.getAccountCustomerById(customer_id).getCustomer_email();
    }
    public String getCustomer_address() {
        AccountCustomerDAO acd = new AccountCustomerDAO();
        return acd.getAccountCustomerById(customer_id).getCustomer_address();
    }
    
}
