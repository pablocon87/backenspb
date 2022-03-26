/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.User;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IUserService {
    public List<User> getUser();
    public void saveUser(User usr);
    public void deleteUser(Long id);
    public User findUser(Long id);
     public User findUserr(String user);
}
