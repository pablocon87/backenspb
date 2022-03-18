/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Educacion;
import com.example.sesion.sesion.repository.EducacionRepository;
import com.example.sesion.sesion.repository.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
      @Autowired
    private EducacionRepository eduRepository;

    @Override

    public List<Educacion> getEducacion() {
        List<Educacion> listaEduc = eduRepository.findAll();
        return listaEduc;
    }

    @Override
    public void saveEducacion(Educacion educ) {
       eduRepository.save(educ);
    }

    @Override
    public void deleteEducacion(Long id) {
        eduRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educ = eduRepository.findById(id).orElse(null);
        return educ;
    }
}
