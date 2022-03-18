/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller.dto;

/**
 *
 * @author pablo
 */
public class User {
    private String user="pablocon87@gmail.com";
    private String password="Pipolo5323";
    private String token;
   private Integer expired;

 
    
    public User(String user, String token,Integer expired) {
        this.user = user;
        this.token = token;
        this.expired=expired;
    }

    public User() {
       this.user = user;
       this.password=password;
        this.token = token; //To change body of generated methods, choose Tools | Templates.
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
    }
}
