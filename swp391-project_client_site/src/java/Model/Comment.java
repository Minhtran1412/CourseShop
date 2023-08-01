/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.AccountDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author doanq
 */
public class Comment {

    private String comment_id, customer_id, course_id, comment_text, comment_date, comment_modified;

    public Comment() {
    }

    public Comment(String comment_id, String customer_id, String course_id, String comment_text, String comment_date, String comment_modified) {
        this.comment_id = comment_id;
        this.customer_id = customer_id;
        this.course_id = course_id;
        this.comment_text = comment_text;
        this.comment_date = comment_date;
        this.comment_modified = comment_modified;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public String getComment_date() {
        String currentFormat = "yyyy-MM-dd HH:mm:ss";
        String newFormat = "dd/MM/yyyy HH:mm:ss";

        try {
            SimpleDateFormat sdfCurrent = new SimpleDateFormat(currentFormat);
            SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);
            Date date = sdfCurrent.parse(comment_date);
            String newDateString = sdfNew.format(date);

            return newDateString;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_modified() {
        return comment_modified;
    }

    public void setComment_modified(String comment_modified) {
        this.comment_modified = comment_modified;
    }

    @Override
    public String toString() {
        return "Comment{" + "comment_id=" + comment_id + ", customer_id=" + customer_id + ", course_id=" + course_id + ", comment_text=" + comment_text + ", comment_date=" + comment_date + ", comment_modified=" + comment_modified + '}';
    }

    public String getCustomer_name() {
        AccountDAO a = new AccountDAO();
        return a.getProfileByID(customer_id).getCustomer_name();
    }

}
