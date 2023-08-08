/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author doanq
 */
public class AccountCustomer {
    private String customer_id,customer_name,customer_username,customer_password,customer_email,customer_address,customer_phone,customer_dob,customer_avatar,customer_status;

    public AccountCustomer() {
    }

    public AccountCustomer(String customer_id, String customer_name, String customer_username, String customer_password, String customer_email, String customer_address, String customer_phone, String customer_dob, String customer_avatar, String customer_status) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_username = customer_username;
        this.customer_password = customer_password;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customer_phone = customer_phone;
        this.customer_dob = customer_dob;
        this.customer_avatar = customer_avatar;
        this.customer_status = customer_status;
    }

    

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_username) {
        this.customer_username = customer_username;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_dob() {
        return customer_dob;
    }

    public void setCustomer_dob(String customer_dob) {
        this.customer_dob = customer_dob;
    }

    public String getCustomer_avatar() {
        return customer_avatar;
    }

    public void setCustomer_avatar(String customer_avatar) {
        this.customer_avatar = customer_avatar;
    }

    public String getCustomer_status() {
        return customer_status;
    }

    public void setCustomer_status(String customer_status) {
        this.customer_status = customer_status;
    }

    @Override
    public String toString() {
        return "AccountCustomer{" + "customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_username=" + customer_username + ", customer_password=" + customer_password + ", customer_email=" + customer_email + ", customer_address=" + customer_address + ", customer_phone=" + customer_phone + ", customer_dob=" + customer_dob + ", customer_avatar=" + customer_avatar + ", customer_status=" + customer_status + '}';
    }

    
    

    
    
}
