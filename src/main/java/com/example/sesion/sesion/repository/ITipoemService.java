/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Tipo_empleo;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface ITipoemService {
      public List<Tipo_empleo> getTipo_empleo();
    public void saveTipo_empleo(Tipo_empleo tipoempl);
    public void deleteTipo_empleo(Long id);
    public Tipo_empleo findTipo_empleo(Long id);
}
