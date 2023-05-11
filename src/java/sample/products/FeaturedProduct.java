/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.products;

public class FeaturedProduct {

    private String proId;
    private String proName;
    private float price;
    private String url;

    public FeaturedProduct() {
        this.proId = "";
        this.proName = "";
        this.price = 0;
        this.url = "";
    }

    public FeaturedProduct(String proId, String proName, float price, String url) {
        this.proId = proId;
        this.proName = proName;
        this.price = price;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
