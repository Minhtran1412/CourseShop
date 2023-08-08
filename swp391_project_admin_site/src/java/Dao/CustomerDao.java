/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Model.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CustomerDao extends DBContext{
    
    public List<Customer> listAllAccountCustomer() {
        List<Customer> data = new ArrayList<>();
        try {
            String strSelect = "select * from  Account_Customer";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String cusID = rs.getString(1);
                String cusName = rs.getString(2);
                String cusUserName = rs.getString(3);
                String cusPassword = rs.getString(4);
                String cusEmail = rs.getString(5);
                String cusAddress = rs.getString(6);
                String phone = rs.getString(7);
                String cusDob = rs.getString(8);
                String cusAvatar = rs.getString(9);
                String cusStatus = rs.getString(10);
               
                data.add(new Customer(cusID, cusName, cusUserName, cusPassword, cusEmail, cusAddress, phone, cusDob, cusAvatar, cusStatus));
            }
        } catch (Exception e) {
            System.out.println("listAllCourse" + e.getMessage());
        }
        return data;
    }
    
     public void changeStatus(String customer_id, String status) {
         if(status.equals("Active")){
             try {
            String strSelect = "update Account_Customer set customer_status = 1 where customer_id = ? ";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, customer_id);
            st.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         }else{
             try {
            String strSelect = "update Account_Customer set customer_status = 0 where customer_id = ? ";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, customer_id);
            st.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         }
        
    }
    
     
    
     
     public static void main(String[] args) {
         CustomerDao cus = new CustomerDao();
//         cus.changeStatus("3");
    }
}
