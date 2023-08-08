/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.News;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doanq
 */
public class NewsDAO extends DBContext {

    public List<News> getListNews(String tit) {
        List<News> data = new ArrayList<>();
        try {
            String strSelect = "select * from  News WHERE news_title LIKE ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, "%" + tit + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String title = rs.getString(2);
                String content = rs.getString(3);
                String createDate = rs.getString(4);
                String createBy = rs.getString(5);
                String shortDes = rs.getString("news_short");
                String img = rs.getString("img");
                data.add(new News(id, title, content, shortDes, img, createDate, createBy));
            }
        } catch (Exception e) {
            System.out.println("getListNews" + e.getMessage());
        }
        return data;
    }

    public News getNewsId(String Id) {
        String sql = "select * from News where news_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(Id));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                News c = new News();

                c.setId(rs.getString(1));
                c.setTitle(rs.getString(2));
                c.setContent(rs.getString(3));
                c.setShortDes(rs.getString("news_short"));
                c.setImg(rs.getString("img"));
                return c;
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteNewsById(String id) {
        try {
            String strSelect = "delete from News where news_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, id);
            st.execute();

        } catch (Exception e) {
            System.out.println("newsDelete" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NewsDAO cd = new NewsDAO();
        System.out.println(cd.getNewsId("1"));

    }

    public void newsCreate(String news_title, String news_content, String news_created_date, String news_modified_date, String news_created_by, String news_modified_by, String new_short, String img) {
        try {
            String strSelect = "insert into News (news_title, news_content, news_created_date, news_modified_date, news_created_by, news_modified_by,news_short,img) values (?,?,?,?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, news_title);
            st.setString(2, news_content);
            st.setDate(3, Date.valueOf(news_created_date));
            st.setDate(4, Date.valueOf(news_modified_date));
            st.setString(5, news_created_by);
            st.setString(6, news_modified_by);
            st.setString(7, new_short);
            st.setString(8, img);
            st.execute();

        } catch (Exception e) {
            System.out.println("courseCreate" + e.getMessage());
        }
    }

    public void newsUpdate(String news_id, String news_title, String news_content, String new_short, String img) {
        try {
            String strSelect = "update News set news_title = ?, news_content = ?, news_short = ?, img = ? where news_id = ?";
            PreparedStatement st = connection.prepareStatement(strSelect);
            st.setString(1, news_title);
            st.setString(2, news_content);
            st.setString(3, new_short);
            st.setString(4, img);
            st.setString(5, news_id);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("courseUpdate" + e.getMessage());
        }
    }

}
