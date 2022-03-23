/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Basdat;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IBasdatService {
     public List<Basdat> getBasdat();
    public void saveBasdat(Basdat bd);
    public void deleteBasdat(Long id);
    public Basdat findBasdat(Long id);
}
