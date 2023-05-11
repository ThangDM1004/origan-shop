/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.users;

/**
 *
 * @author MSI AD
 */
public class UserError {
     private String name;
    private String email;
    private String pass;
    private String confirm;

    public UserError() {
        this.name = "";
        this.email = "";
        this.pass = "";
        this.confirm = "";
    }

    public UserError(String name, String email, String pass, String confirm) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.confirm = confirm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    
}
