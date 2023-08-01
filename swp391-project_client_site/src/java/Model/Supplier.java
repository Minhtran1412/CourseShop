/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author doanq
 */
public class Supplier {
    private String supplier_id,supplier_name,supplier_address,supplier_phone,supplier_email,supplier_desc;

    public Supplier() {
    }

    public Supplier(String supplier_id, String supplier_name, String supplier_address, String supplier_phone, String supplier_email, String supplier_desc) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.supplier_address = supplier_address;
        this.supplier_phone = supplier_phone;
        this.supplier_email = supplier_email;
        this.supplier_desc = supplier_desc;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }

    public String getSupplier_phone() {
        return supplier_phone;
    }

    public void setSupplier_phone(String supplier_phone) {
        this.supplier_phone = supplier_phone;
    }

    public String getSupplier_email() {
        return supplier_email;
    }

    public void setSupplier_email(String supplier_email) {
        this.supplier_email = supplier_email;
    }

    public String getSupplier_desc() {
        return supplier_desc;
    }

    public void setSupplier_desc(String supplier_desc) {
        this.supplier_desc = supplier_desc;
    }

    @Override
    public String toString() {
        return "Supplier{" + "supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + ", supplier_address=" + supplier_address + ", supplier_phone=" + supplier_phone + ", supplier_email=" + supplier_email + ", supplier_desc=" + supplier_desc + '}';
    }
    
}
