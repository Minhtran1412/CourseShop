/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Comment;
import Model.Course;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doanq
 */
public class CommentDAO extends DBContext {

    public int getTotalCommentByCourseId(String course_id) {
        String sql = "select count(*) from Comments where course_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, course_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                return rs.getInt(1);
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Comment> getListCommentByCourseID(String id, int index) {
        List<Comment> data = new ArrayList<>();
        try {
            String strSelect = "select * from Comments where course_id = ?\n"
                    + "order by comment_date desc\n"
                    + "offset ? rows fetch next 3 rows only";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, id);
            st.setInt(2, (index - 1) * 3);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String comment_id = rs.getString(1);
                String customer_id = rs.getString(2);
                String course_id = id;
                String comment_text = rs.getString(4);
                String comment_date = rs.getString(5);
                String comment_modified = rs.getString(6);

                data.add(new Comment(comment_id, customer_id, course_id, comment_text, comment_date, comment_modified));
            }
        } catch (Exception e) {
            System.out.println("getListCommentByCourseID" + e.getMessage());
        }
        return data;
    }

    public static void main(String[] args) {
        CommentDAO c = new CommentDAO();
//        LocalDateTime comment_date_row = LocalDateTime.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String comment_date = comment_date_row.format(dateTimeFormatter);
////        c.addComment("1", "2", "123", comment_date);
//        c.updateComment("50", "50", comment_date);
        System.out.println(c.getTotalCommentByCourseId("2"));
    }

    public void addComment(String customer_id, String course_id, String comment_text, String comment_date) {
        try {
            String strSelect = "INSERT INTO [dbo].[Comments]\n"
                    + "           ([customer_id]\n"
                    + "           ,[course_id]\n"
                    + "           ,[comment_text]\n"
                    + "           ,[comment_date])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, customer_id);
            st.setString(2, course_id);
            st.setString(3, comment_text);
            st.setString(4, comment_date);
            st.execute();

        } catch (Exception e) {
            System.out.println("addComment" + e.getMessage());
        }
    }

    public void deleteComment(String comment_id) {
        try {
            String strSelect = "DELETE FROM [dbo].[Comments]\n"
                    + "      WHERE comment_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, comment_id);
            st.execute();

        } catch (Exception e) {
            System.out.println("deleteComment" + e.getMessage());
        }
    }

    public void updateComment(String comment_id, String comment_text, String comment_date) {
        try {
            String strSelect = "UPDATE [dbo].[Comments]\n"
                    + "   SET [comment_text] = ?\n"
                    + "      ,[comment_date] = ?\n"
                    + " WHERE comment_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, comment_text);
            st.setString(2, comment_date);
            st.setString(3, comment_id);
            st.execute();

        } catch (Exception e) {
            System.out.println("updateComment" + e.getMessage());
        }
    }

}