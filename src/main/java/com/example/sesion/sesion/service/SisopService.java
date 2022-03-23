/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Sisop;
import com.example.sesion.sesion.repository.ISisopService;
import com.example.sesion.sesion.repository.SisopRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class SisopService implements ISisopService{
     @Autowired
    private SisopRepository sisopRepository;

    @Override

    public List<Sisop> getSisop() {
        List<Sisop> listasisop = sisopRepository.findAll();
        return listasisop;
    }

    @Override
    public void saveSisop(Sisop sisp) {
        sisopRepository.save(sisp);
    }

    @Override
    public void deleteSisop(Long id) {
        sisopRepository.deleteById(id);
    }

    @Override
    public Sisop findSisop(Long id) {
        Sisop sisp = sisopRepository.findById(id).orElse(null);
        return sisp;
    }
}
