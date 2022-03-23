/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Ingles;
import com.example.sesion.sesion.repository.IInglesService;
import com.example.sesion.sesion.repository.InglesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class InglesService implements IInglesService{
    @Autowired
    private InglesRepository ingRepository;

    @Override

    public List<Ingles> getIngles() {
        List<Ingles> listaIng = ingRepository.findAll();
        return listaIng;
    }

    @Override
    public void saveIngles(Ingles ingl) {
       ingRepository.save(ingl);
    }

    @Override
    public void deleteIngles(Long id) {
        ingRepository.deleteById(id);
    }

    @Override
    public Ingles findIngles(Long id) {
        Ingles ingl = ingRepository.findById(id).orElse(null);
        return ingl;
    }
    
}
