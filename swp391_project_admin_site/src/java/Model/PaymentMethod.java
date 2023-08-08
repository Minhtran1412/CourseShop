/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author doanq
 */
public class PaymentMethod {
    private String payment_id,payment_name;

    public PaymentMethod() {
    }

    public PaymentMethod(String payment_id, String payment_name) {
        this.payment_id = payment_id;
        this.payment_name = payment_name;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_name() {
        return payment_name;
    }

    public void setPayment_name(String payment_name) {
        this.payment_name = payment_name;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" + "payment_id=" + payment_id + ", payment_name=" + payment_name + '}';
    }
    
}
