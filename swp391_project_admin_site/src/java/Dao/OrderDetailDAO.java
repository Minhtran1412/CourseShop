/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.PreparedStatement;

/**
 *
 * @author doanq
 */
public class OrderDetailDAO extends DBContext {

    public void deleteOrderDetailByCourseId(String course_id) {
        try {
            String strSelect = "DELETE FROM [dbo].[OrderDetail] WHERE course_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, course_id);
            st.execute();

        } catch (Exception e) {
            System.out.println("deleteOrderDetailByCourseId" + e.getMessage());
        }
    }

    
}
