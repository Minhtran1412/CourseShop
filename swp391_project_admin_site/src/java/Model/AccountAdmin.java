/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author doanq
 */
public class AccountAdmin {
    private String account_id,account_name,account_username,account_password,account_role,account_email,account_phone,account_avatar;

    public AccountAdmin() {
    }

    public AccountAdmin(String account_id, String account_name, String account_username, String account_password, String account_role, String account_email, String account_phone, String account_avatar) {
        this.account_id = account_id;
        this.account_name = account_name;
        this.account_username = account_username;
        this.account_password = account_password;
        this.account_role = account_role;
        this.account_email = account_email;
        this.account_phone = account_phone;
        this.account_avatar = account_avatar;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_username() {
        return account_username;
    }

    public void setAccount_username(String account_username) {
        this.account_username = account_username;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public String getAccount_role() {
        return account_role;
    }

    public void setAccount_role(String account_role) {
        this.account_role = account_role;
    }

    public String getAccount_email() {
        return account_email;
    }

    public void setAccount_email(String account_email) {
        this.account_email = account_email;
    }

    public String getAccount_phone() {
        return account_phone;
    }

    public void setAccount_phone(String account_phone) {
        this.account_phone = account_phone;
    }

    public String getAccount_avatar() {
        return account_avatar;
    }

    public void setAccount_avatar(String account_avatar) {
        this.account_avatar = account_avatar;
    }

    @Override
    public String toString() {
        return "Account{" + "account_id=" + account_id + ", account_name=" + account_name + ", account_username=" + account_username + ", account_password=" + account_password + ", account_role=" + account_role + ", account_email=" + account_email + ", account_phone=" + account_phone + ", account_avatar=" + account_avatar + '}';
    }
    
}
