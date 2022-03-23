/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Lenprog;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface ILenprogService {
    public List<Lenprog> getLenprog();
    public void saveLenprog(Lenprog lenpr);
    public void deleteLenprog(Long id);
    public Lenprog findLenprog(Long id);
}
