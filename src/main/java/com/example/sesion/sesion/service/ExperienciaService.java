/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Experiencia_laboral;
import com.example.sesion.sesion.repository.ExperienciaRepository;
import com.example.sesion.sesion.repository.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class ExperienciaService implements IExperienciaService {
    @Autowired
    private ExperienciaRepository ExperienciaRepository;
    @Override
    
    public List<Experiencia_laboral> getExperiencia_laboral(){
       List<Experiencia_laboral> listaExperiencias = ExperienciaRepository.findAll();
       return listaExperiencias;
    }
    @Override
    public void saveExperiencia_laboral(Experiencia_laboral experiencia){
        ExperienciaRepository.save(experiencia);
    }
    @Override
    public void deleteExperiencia_laboral(Long id){
        ExperienciaRepository.deleteById(id);
    }
    @Override
    public Experiencia_laboral findExperiencia_laboral(Long id){
        Experiencia_laboral experiencia = ExperienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
}
