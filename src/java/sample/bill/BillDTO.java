/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.bill;

/**
 *
 * @author MSI AD
 */
public class BillDTO {
    private String email;
    private String first;
    private String last;
    private String phone;
    private String city;
    private String distrist;
    private String ward;
    private String address;
    private String note;
    private String payment;

    public BillDTO() {
    }

    public BillDTO(String email, String first, String last, String phone, String city, String distrist, String ward, String address, String note, String payment) {
        this.email = email;
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.city = city;
        this.distrist = distrist;
        this.ward = ward;
        this.address = address;
        this.note = note;
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrist() {
        return distrist;
    }

    public void setDistrist(String distrist) {
        this.distrist = distrist;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
    
}
