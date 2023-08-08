/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Dao;

import Model.Course;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author acer
 */
public class CourseDAOTest {
    
    public CourseDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCourseById method, of class CourseDAO.
     */
    

    /**
     * Test of listCourseByPaging method, of class CourseDAO.
     */
    

    /**
     * Test of courseCreate method, of class CourseDAO.
     */
    @Test
    public void testCourseCreateNullName() {
        System.out.println("courseCreate");
        String course_name = null;
        String course_description = "abc";
        String course_price = "200000";
        String course_create_date = null;
        String course_modified_date = null;
        String category_id = "1";
        String supplier_id = "1";
        String course_short_desc = null;
        String course_create_by = null;
        String course_modified_by = null;
        String course_img = null;
        String course_discount = null;
        CourseDAO instance = new CourseDAO();
        instance.courseCreate(course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testCourseCreateNameExist() {
        System.out.println("courseCreate");
        String course_name = "The Complete Java Development Bootcamp";
        String course_description = "abc";
        String course_price = "200000";
        String course_create_date = null;
        String course_modified_date = null;
        String category_id = "1";
        String supplier_id = "1";
        String course_short_desc = null;
        String course_create_by = null;
        String course_modified_by = null;
        String course_img = null;
        String course_discount = null;
        CourseDAO instance = new CourseDAO();
        instance.courseCreate(course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    @Test
    public void testCourseCreateTrueName() {
        System.out.println("courseCreate");
        String course_name = "True Name";
        String course_description = "abc";
        String course_price = "200000";
        String course_create_date = null;
        String course_modified_date = null;
        String category_id = "1";
        String supplier_id = "1";
        String course_short_desc = null;
        String course_create_by = null;
        String course_modified_by = null;
        String course_img = null;
        String course_discount = null;
        CourseDAO instance = new CourseDAO();
        instance.courseCreate(course_name, course_description, course_price, course_create_date, course_modified_date, category_id, supplier_id, course_short_desc, course_create_by, course_modified_by, course_img, course_discount);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of courseUpdate method, of class CourseDAO.
     */
    @Test
    public void testCourseUpdate() {
        System.out.println("courseUpdate");
        String course_id = "";
        String course_name = "";
        String course_description = "";
        String course_price = "";
        String course_modified_date = "";
        String category_id = "";
        String supplier_id = "";
        String course_short_desc = "";
        String course_modified_by = "";
        String course_img = "";
        String course_discount = "";
        CourseDAO instance = new CourseDAO();
        instance.courseUpdate(course_id, course_name, course_description, course_price, course_modified_date, category_id, supplier_id, course_short_desc, course_modified_by, course_img, course_discount);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    
}
