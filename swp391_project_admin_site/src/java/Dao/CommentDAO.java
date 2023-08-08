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
public class CommentDAO extends DBContext {

    public void deleteCommentByCourseId(String course_id) {
        try {
            String strSelect = "DELETE FROM [dbo].[Comments]\n"
                    + "      WHERE course_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, course_id);
            st.execute();

        } catch (Exception e) {
            System.out.println("deleteCommentByCourseId" + e.getMessage());
        }
    }

}
