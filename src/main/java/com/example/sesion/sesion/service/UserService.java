/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.User;
import com.example.sesion.sesion.repository.IUserService;
import com.example.sesion.sesion.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class UserService implements IUserService {
     @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUser() {
        List<User> listaUser = userRepository.findAll();
        return listaUser;
    }

    @Override
    public void saveUser(User usr) {
       userRepository.save(usr);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUser(Long id) {
        User usr = userRepository.findById(id).orElse(null);
        return usr;
    }
   
}
