/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.products;

/**
 *
 * @author MSI AD
 */
public class ProductPayment {

    private String email;
    private String proName;
    private float price;
    private int quantity;
    private float total;
    private String status;

    public ProductPayment() {
    }

    public ProductPayment(String email, String proName, float price, int quantity, float total,String status) {
        this.email = email;
        this.proName = proName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
