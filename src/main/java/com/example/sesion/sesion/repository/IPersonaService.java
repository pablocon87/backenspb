/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sesion.sesion.repository;

//import com.example.jpaDemo.jpaDemo.model.Persona;
import com.example.sesion.sesion.controller.dto.Persona;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona perso);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
}
