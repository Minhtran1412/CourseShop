/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.CategoriesDAO;
import Dao.SupplierDAO;

/**
 *
 * @author doanq
 */
public class Course {
    private String course_id,course_name,course_description,course_create_date,course_modified_date,category_id,supplier_id,course_short_desc,course_create_by,course_modified_by,course_img;
    private double course_price,course_discount;
    public Course() {
    }

    public Course(String course_id, String course_name, String course_description, double course_price, String course_create_date, String course_modified_date, String category_id, String supplier_id, String course_short_desc, String course_create_by, String course_modified_by, String course_img, Double course_discount) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_description = course_description;
        this.course_price = course_price;
        this.course_create_date = course_create_date;
        this.course_modified_date = course_modified_date;
        this.category_id = category_id;
        this.supplier_id = supplier_id;
        this.course_short_desc = course_short_desc;
        this.course_create_by = course_create_by;
        this.course_modified_by = course_modified_by;
        this.course_img = course_img;
        this.course_discount = course_discount;
    }
    
    
    
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(double course_price) {
        this.course_price = course_price;
    }

    public String getCourse_create_date() {
        return course_create_date;
    }

    public void setCourse_create_date(String course_create_date) {
        this.course_create_date = course_create_date;
    }

    public String getCourse_modified_date() {
        return course_modified_date;
    }

    public void setCourse_modified_date(String course_modified_date) {
        this.course_modified_date = course_modified_date;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getCourse_short_desc() {
        return course_short_desc;
    }

    public void setCourse_short_desc(String course_short_desc) {
        this.course_short_desc = course_short_desc;
    }

    public String getCourse_create_by() {
        return course_create_by;
    }

    public void setCourse_create_by(String course_create_by) {
        this.course_create_by = course_create_by;
    }

    public String getCourse_modified_by() {
        return course_modified_by;
    }

    public void setCourse_modified_by(String course_modified_by) {
        this.course_modified_by = course_modified_by;
    }

    public String getCourse_img() {
        return course_img;
    }

    public void setCourse_img(String course_img) {
        this.course_img = course_img;
    }

    public Double getCourse_discount() {
        return course_discount;
    }

    public void setCourse_discount(Double course_discount) {
        this.course_discount = course_discount;
    }

    @Override
    public String toString() {
        return "Course{" + "course_id=" + course_id + ", course_name=" + course_name + ", course_description=" + course_description + ", course_price=" + course_price + ", course_create_date=" + course_create_date + ", course_modified_date=" + course_modified_date + ", category_id=" + category_id + ", supplier_id=" + supplier_id + ", course_short_desc=" + course_short_desc + ", course_create_by=" + course_create_by + ", course_modified_by=" + course_modified_by + ", course_img=" + course_img + ", course_discount=" + course_discount + '}';
    }

    
    public String getCategory_name(){
        CategoriesDAO cd = new CategoriesDAO();
        return cd.getCateById(category_id).getCategory_name();
        
    }
     public String getSupplier_name() {
        SupplierDAO s = new SupplierDAO();
        return s.getSupplierByID(supplier_id).getSupplier_name();
    }
    public static void main(String[] args) {
        String s = "trwtwrgw";
        Course c = new Course();
        c.setCourse_img("usercss/images/CourseImage/Java1.PNG");
        System.out.println(c.getCourse_img());
    }
}
