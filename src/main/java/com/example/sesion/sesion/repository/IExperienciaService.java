/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

import com.example.sesion.sesion.controller.dto.Experiencia_laboral;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IExperienciaService {
        public List<Experiencia_laboral> getExperiencia_laboral();
    public void saveExperiencia_laboral(Experiencia_laboral experiencia);
    public void deleteExperiencia_laboral(Long id);
    public Experiencia_laboral findExperiencia_laboral(Long id);
    public List<Experiencia_laboral> findExperiencia_laboraldate();
}
