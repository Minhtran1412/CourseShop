/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author Admin
 */
public class Customer {
    String cusID;
    String cusName;
    String cusUserName;
    String cusPassword;
    String cusEmail;
    String cusAddress;
    String phone;
    String cusDob;
    String cusAvatar;
    String cusStatus;

    public Customer() {
    }

    public Customer(String cusID, String cusName, String cusUserName, String cusPassword, String cusEmail, String cusAddress, String phone, String cusDob, String cusAvatar, String cusStatus) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusUserName = cusUserName;
        this.cusPassword = cusPassword;
        this.cusEmail = cusEmail;
        this.cusAddress = cusAddress;
        this.phone = phone;
        this.cusDob = cusDob;
        this.cusAvatar = cusAvatar;
        this.cusStatus = cusStatus;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusUserName() {
        return cusUserName;
    }

    public void setCusUserName(String cusUserName) {
        this.cusUserName = cusUserName;
    }

    public String getCusPassword() {
        return cusPassword;
    }

    public void setCusPassword(String cusPassword) {
        this.cusPassword = cusPassword;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCusDob() {
        return cusDob;
    }

    public void setCusDob(String cusDob) {
        this.cusDob = cusDob;
    }

    public String getCusAvatar() {
        return cusAvatar;
    }

    public void setCusAvatar(String cusAvatar) {
        this.cusAvatar = cusAvatar;
    }

    public String getCusStatus() {
        if(cusStatus.equals("0")){
            cusStatus = "Active";
        }
        if(cusStatus.equals("1")){
            cusStatus = "Deactive";
        }
        return cusStatus;
    }

    public void setCusStatus(String cusStatus) {
        this.cusStatus = cusStatus;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusID=" + cusID + ", cusName=" + cusName + ", cusUserName=" + cusUserName + ", cusPassword=" + cusPassword + ", cusEmail=" + cusEmail + ", cusAddress=" + cusAddress + ", phone=" + phone + ", cusDob=" + cusDob + ", cusAvatar=" + cusAvatar + ", cusStatus=" + cusStatus + '}';
    }

   
    
    
    
}
