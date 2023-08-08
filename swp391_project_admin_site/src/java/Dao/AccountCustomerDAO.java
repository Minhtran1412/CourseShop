/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.AccountCustomer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author doanq
 */
public class AccountCustomerDAO extends DBContext{

    public AccountCustomer getAccountCustomerById(String customer_id) {
        try {
            String strSelect = "select * from Account_Customer where customer_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, Integer.parseInt(customer_id));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AccountCustomer ac = new AccountCustomer();
                ac.setCustomer_id(customer_id);
                ac.setCustomer_name(rs.getString(2));
                ac.setCustomer_username(rs.getString(3));
                ac.setCustomer_password(rs.getString(4));
                ac.setCustomer_email(rs.getString(5));
                ac.setCustomer_address(rs.getString(6));
                ac.setCustomer_phone(rs.getString(7));
                ac.setCustomer_dob(rs.getString(8));
                ac.setCustomer_avatar(rs.getString(9));
                ac.setCustomer_status(rs.getString(10));
                return ac;
            }

        } catch (Exception e) {
            System.out.println("getAccountCustomerById" + e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        AccountCustomerDAO acd = new AccountCustomerDAO();
        System.out.println(acd.getAccountCustomerById("1"));
    }
    
}
