/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.products;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {
    private Map<String,Integer> proID;
    
    private Map<String, List<ProductDTO>> product;

    public Map<String, Integer> getProID() {
        return proID;
    }
    
    public Map<String, List<ProductDTO>> getProduct() {
        return product;
    }

    public void AddProID(String proID) {
        if(this.proID == null){
            this.proID = new HashMap<>();
        }
        this.proID.put(proID, 0);
    }
    
    
    public void AddProduct(String proId) {
        ProductDAO dao = new ProductDAO();
        if (this.product == null) {
            this.product = new HashMap<String, List<ProductDTO>>();
        }
        this.product.put(proId, dao.getTypeProduct(proId));
    }
    
    public void removeProduct(String proId){
        if(this.product == null){
            return;
        }
        if(this.product.containsKey(proId)){
            this.product.remove(proId);
            if(this.product.isEmpty()){
                this.product = null;
            }
        }
    }
    public void removeProID(String proId){
        if(this.proID == null){
            return;
        }
        if(this.proID.containsKey(proId)){
            this.proID.remove(proId);
            if(this.proID.isEmpty()){
                this.proID = null;
            }
        }
    }

}
