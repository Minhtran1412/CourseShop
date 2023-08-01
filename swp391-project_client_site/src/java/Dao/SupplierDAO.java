/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Course;
import Model.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author doanq
 */
public class SupplierDAO extends DBContext{

    public Supplier getSupplierByID(String supplier_id) {
        
        String sql = "SELECT * FROM [Supplier] where supplier_id = ?";
        try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(supplier_id));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Supplier s= new Supplier();
                s.setSupplier_id(supplier_id);
                s.setSupplier_name(rs.getString(2));
                s.setSupplier_address(rs.getString(3));
                s.setSupplier_phone(rs.getString(4));
                s.setSupplier_email(rs.getString(5));
                s.setSupplier_desc(rs.getString(6));
                return s;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
}
