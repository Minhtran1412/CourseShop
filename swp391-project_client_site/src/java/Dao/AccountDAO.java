/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.AccountAdmin;
import Model.AccountCustomer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO extends DBContext {
    
    public AccountCustomer login(String username, String password) {
        String sql = "select * from Account_Customer where customer_username=? and customer_password =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new AccountCustomer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
        }
        
        return null;
    }
    
     public  boolean checkStatus(String username, String password) {
        String sql = "select * from Account_Customer where customer_username=? and customer_password =? and customer_status = 0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);          
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public static void main(String[] args) {
        AccountDAO accountdao = new AccountDAO();
        accountdao.editProfile("23", "Hai", null, null, null, null);
        AccountCustomer ac = accountdao.getProfileByID("23");
        System.out.println(ac);
    }
    
    public AccountCustomer checkAccountExist(String username) {
        String sql = "select * from Account_Customer where customer_username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new AccountCustomer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public AccountCustomer checkEmailExist(String email) {
        String sql = "select * from Account_Customer where customer_email = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new AccountCustomer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getString(9));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void signup(String customer_name,
            String username,
            String password,
            String email,
            String customer_address,
            String customer_phone,
            String customer_dob) {
        String sql = "INSERT INTO [dbo].[Account_Customer]"
                + " ([customer_name]"
                + ",[customer_username]"
                + ",[customer_password]"
                + ",[customer_email]"
                + ",[customer_address]"
                + ",[customer_phone]"
                + ",[customer_dob])\n"
                + "VALUES \n"
                + "(?, ?, ?,?, ?, ?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer_name);
            st.setString(2, username);
            st.setString(3, password);
            st.setString(4, email);
            st.setString(5, customer_address);
            st.setString(6, customer_phone);
            st.setString(7, customer_dob);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void newPassword(String newPass, String email) {
        String sql = "update Account_Customer set customer_password = ? where customer_email=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newPass);
            st.setString(2, email);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void changePass(String newPass, String username) {
        String sql = "update Account_Customer set customer_password = ? where customer_username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newPass);
            st.setString(2, username);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public AccountCustomer getProfileByID(String customer_id) {
        String sql = "select * from Account_Customer where customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AccountCustomer ac = new AccountCustomer(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8),
                        rs.getString(9)
                );
                return ac;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void editProfile(String customer_id, String customer_name, String customer_email, String customer_address, String customer_phone, String customer_dob) {
        String sql = "update Account_Customer set [customer_name] = ?, [customer_email] = ?, [customer_address]=?,[customer_phone]=?,[customer_dob]=? where [customer_id]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer_name);
            st.setString(2, customer_email);
            st.setString(3, customer_address);
            st.setString(4, customer_phone);
            st.setString(5, customer_dob);
            st.setString(6, customer_id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
