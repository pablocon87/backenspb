/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.User;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pablo
 */
@Repository
@Configuration
public interface UserRepository extends JpaRepository<User,Long> {
  @Query(value = "SELECT * FROM user WHERE user = :user", nativeQuery = true)
  User findByEmailAddress(@Param("user") String emailAddress);
  @Query(value = "SELECT * FROM user WHERE conec ="+ 1, nativeQuery = true)
  List<User> findByConec();
  
}
