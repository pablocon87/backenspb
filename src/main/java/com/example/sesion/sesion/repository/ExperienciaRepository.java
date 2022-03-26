/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Experiencia_laboral;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
public interface ExperienciaRepository extends JpaRepository<Experiencia_laboral,Long> {
    @Query(value = "SELECT * FROM experiencia_laboral ORDER BY fechainicio ASC", nativeQuery = true)
   List<Experiencia_laboral> findBydate();
}
