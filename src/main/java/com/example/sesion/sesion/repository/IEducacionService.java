/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Educacion;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IEducacionService {
        public List<Educacion> getEducacion();
    public void saveEducacion(Educacion educ);
    public void deleteEducacion(Long id);
    public Educacion findEducacion(Long id);
    public List<Educacion> findEducaciondate();
}
