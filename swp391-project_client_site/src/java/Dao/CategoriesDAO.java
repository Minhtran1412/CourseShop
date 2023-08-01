/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Categories;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUNGVT
 */
public class CategoriesDAO extends DBContext {

    public List<Categories> getListCategories() {
        List<Categories> data = new ArrayList<>();
        try {
            String strSelect = "select * from  Categories";
            PreparedStatement st = connection.prepareStatement(strSelect);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String category_id = rs.getString(1);
                String category_name = rs.getString(2);
                String category_desc = rs.getString(3);

                data.add(new Categories(category_id, category_name, category_desc));
            }
        } catch (Exception e) {
            System.out.println("getListCategories" + e.getMessage());
        }
        return data;
    }

    public Categories getCateById(String Id) {
        String sql = "select * from Categories where category_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(Id));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Categories c = new Categories();

                c.setCategory_id(rs.getString(1));
                c.setCategory_name(rs.getString(2));
                c.setCategory_desc(rs.getString(3));

                return c;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        CategoriesDAO cd = new CategoriesDAO();
        System.out.println(cd.getCateById("3"));
        
    }
}
