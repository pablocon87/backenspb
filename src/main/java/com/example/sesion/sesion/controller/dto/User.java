/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pablo
 */
@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
       private Long id;
    private String user;
    private String password;
    private String token;
   private Integer expired;
   private Integer conec;
   private Integer auten;
   private String timelim;
   private Integer rol;
    /*
    public User(String user, String token,Integer expired) {
        this.user = user;
        this.token = token;
        this.expired=expired;
    }

    public User() {
       this.user = user;
       this.password=password;
        this.token = token; 
    }
 public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
       public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }*/
}
