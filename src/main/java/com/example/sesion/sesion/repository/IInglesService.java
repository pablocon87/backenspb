/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Ingles;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IInglesService {
    public List<Ingles> getIngles();
    public void saveIngles(Ingles ingl);
    public void deleteIngles(Long id);
    public Ingles findIngles(Long id);
}
