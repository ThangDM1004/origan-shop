/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.products;

public class ProductDTO {
    private String proId;
    private String proName;
    private float price;
    private String information;
    private int quantity;
    private String urlImg;
    private String decription;

    public ProductDTO() {
         this.proId = "";
        this.proName = "";
        this.price = 0;
        this.information = "";
        this.quantity = 0;
        this.urlImg = "";
        this.decription = "";
    }

    public ProductDTO(String proId, String proName, float price, String information, int quantity, String urlImg, String decription) {
        this.proId = proId;
        this.proName = proName;
        this.price = price;
        this.information = information;
        this.quantity = quantity;
        this.urlImg = urlImg;
        this.decription = decription;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
    
}
