/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;


import com.example.sesion.sesion.controller.dto.Sisop;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface ISisopService {
      public List<Sisop> getSisop();
    public void saveSisop(Sisop sisop);
    public void deleteSisop(Long id);
    public Sisop findSisop(Long id);
}
