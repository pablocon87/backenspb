/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Lenprog;
import com.example.sesion.sesion.repository.ILenprogService;
import com.example.sesion.sesion.repository.LenprogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class LenprogService implements ILenprogService{
     @Autowired
    private LenprogRepository lenpRepository;

    @Override

    public List<Lenprog> getLenprog() {
        List<Lenprog> listaLen = lenpRepository.findAll();
        return listaLen;
    }

    @Override
    public void saveLenprog(Lenprog lengp) {
       lenpRepository.save(lengp);
    }

    @Override
    public void deleteLenprog(Long id) {
        lenpRepository.deleteById(id);
    }

    @Override
    public Lenprog findLenprog(Long id) {
        Lenprog lenp = lenpRepository.findById(id).orElse(null);
        return lenp;
    }
}
