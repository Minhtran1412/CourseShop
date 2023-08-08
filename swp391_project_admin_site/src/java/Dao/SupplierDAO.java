/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Categories;
import Model.Supplier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doanq
 */
public class SupplierDAO extends DBContext {

    public List<Supplier> getListSupplier() {
        List<Supplier> data = new ArrayList<>();
        try {
            String strSelect = "select * from  Supplier";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String supplier_id = rs.getString(1);
                String supplier_name = rs.getString(2);
                String supplier_address = rs.getString(3);
                String supplier_phone = rs.getString(4);
                String supplier_email = rs.getString(5);
                String supplier_desc = rs.getString(6);
                data.add(new Supplier(supplier_id, supplier_name, supplier_address, supplier_phone, supplier_email, supplier_desc));
            }
        } catch (Exception e) {
            System.out.println("getListSupplier" + e.getMessage());
        }
        return data;
    }

    public Supplier getSupplierByName(String supplier_name) {
        try {
            String strSelect = "select * from Supplier where supplier_name = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, supplier_name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setSupplier_id(rs.getString(1));
                s.setSupplier_name(rs.getString(2));
                s.setSupplier_address(rs.getString(3));
                s.setSupplier_phone(rs.getString(4));
                s.setSupplier_email(rs.getString(5));
                s.setSupplier_desc(rs.getString(6));
                return s;
            }
        } catch (Exception e) {
            System.out.println("getSupplierByName" + e.getMessage());
        }
        return null;
    }
    
    
    public Supplier getSupplierByID(String supplier_name) {
        try {
            String strSelect = "select * from Supplier where supplier_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, supplier_name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Supplier s = new Supplier();
                s.setSupplier_id(rs.getString(1));
                s.setSupplier_name(rs.getString(2));
                s.setSupplier_address(rs.getString(3));
                s.setSupplier_phone(rs.getString(4));
                s.setSupplier_email(rs.getString(5));
                s.setSupplier_desc(rs.getString(6));
                return s;
            }
        } catch (Exception e) {
            System.out.println("getSupplierByName" + e.getMessage());
        }
        return null;
    }
    public static void main(String[] args) {
        SupplierDAO  sd = new SupplierDAO();
        System.out.println(sd.getSupplierByName("Lê Tu Thành"));
    }

}
