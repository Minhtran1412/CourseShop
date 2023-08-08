/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.AccountCustomer;
import Model.PaymentMethod;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author doanq
 */
public class PaymentMethodDAO extends DBContext{

    public PaymentMethod getPaymentMethodById(String payment_id) {
        try {
            String strSelect = "select * from payment_method where payment_id = ? ";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setInt(1, Integer.parseInt(payment_id));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PaymentMethod pm = new PaymentMethod();
                pm.setPayment_id(payment_id);
                pm.setPayment_name(rs.getString(2));
                return pm;
            }

        } catch (Exception e) {
            System.out.println("getPaymentMethodById" + e.getMessage());
        }
        return null;
    }
    public static void main(String[] args) {
        PaymentMethodDAO pmd = new PaymentMethodDAO();
        System.out.println(pmd.getPaymentMethodById("2"));
    }
}
