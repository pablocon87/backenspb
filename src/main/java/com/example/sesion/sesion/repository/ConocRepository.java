/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Conoc;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author pablo
 */
public interface ConocRepository extends JpaRepository<Conoc,Long> {
     @Query(value = "SELECT * FROM conoc ORDER BY sobre ASC", nativeQuery = true)
   List<Conoc> findBydesc();
}
