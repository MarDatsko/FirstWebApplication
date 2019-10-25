/*package com.example.mushrooms.domain;


import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String city;
    private String email;
    private String password;

    public UserInfo(){
    }

    public UserInfo(String name, String surname, String city, String mail, String password) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.email = mail;
        this.password = password;
    }


    public String getMail() {
        return email;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) { this.password = password; }
}
*/