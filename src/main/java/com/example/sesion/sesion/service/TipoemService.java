/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Tipo_empleo;
import com.example.sesion.sesion.repository.ITipoemService;
import com.example.sesion.sesion.repository.TipoempleoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class TipoemService implements ITipoemService {
     @Autowired
    private TipoempleoRepository tipoemRepository;

    @Override

    public List<Tipo_empleo> getTipo_empleo() {
        List<Tipo_empleo> listaTipoem = tipoemRepository.findAll();
        return listaTipoem;
    }

    @Override
    public void saveTipo_empleo(Tipo_empleo tipoemp) {
       tipoemRepository.save(tipoemp);
    }

    @Override
    public void deleteTipo_empleo(Long id) {
        tipoemRepository.deleteById(id);
    }

    @Override
    public Tipo_empleo findTipo_empleo(Long id) {
        Tipo_empleo tipoemp = tipoemRepository.findById(id).orElse(null);
        return tipoemp;
    }
}
