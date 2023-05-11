/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.users;

public class UserDTO {

    private String name;
    private String email;
    private String pass;
    private String role;

    public UserDTO() {
        this.name = "";
        this.email = "";
        this.pass = "";
        this.role = "";
    }

    public UserDTO(String name, String email, String pass, String role) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
