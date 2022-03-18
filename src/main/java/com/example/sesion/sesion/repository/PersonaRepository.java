/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

//import com.example.jpaDemo.jpaDemo.model.Persona;
import com.example.sesion.sesion.controller.dto.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pablo
 */
@Repository
@Configuration

public interface PersonaRepository extends JpaRepository<Persona,Long> {
    
}
