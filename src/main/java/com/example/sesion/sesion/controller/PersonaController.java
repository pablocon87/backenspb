/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Persona;
import com.example.sesion.sesion.repository.IPersonaService;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pablo
 */
//@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class })
@RestController
 
@RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = /*MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,*/MediaType.ALL_VALUE)
        /*produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})*/

public class PersonaController  {
   
    @Autowired
    private IPersonaService interPersona;
   
     
    @GetMapping("/personas/traer")
    @JsonCreator
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
  
       
    
    @PostMapping("/personas/crear")
    public String createStudent(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("domicilio") String nuevoDomicilio,
            @RequestParam("fechanac") String nuevaFecha,
            @RequestParam("telefono") String nuevoTelefono,
            @RequestParam ("correo") String nuevoCorreo,
            @RequestParam ("sobre_mi") String nuevoSobremi,
            @RequestParam ("url_foto") String nuevoUrlfoto,
            @RequestParam ("acerca_de") String nuevoAcercade,
            @RequestParam ("facebook") String nuevoFacebook,
            @RequestParam("twiter") String nuevoTwiter,
            @RequestParam("instagram") String nuevoInstagram,
            @RequestParam("infcont") String nuevoInfcont
            ){
        System.out.println("AVER ID  "+ id);
                    
            Persona perso = interPersona.findPersona(id);
            perso.setApellido(nuevoApellido);
            perso.setNombre(nuevoNombre);
              perso.setDomicilio(nuevoDomicilio);
            perso.setFechanac(nuevaFecha);
              perso.setTelefono(nuevoTelefono);
                perso.setCorreo(nuevoCorreo);
                  perso.setSobre_mi(nuevoSobremi);
               perso.setUrl_foto(nuevoUrlfoto);
               perso.setAcerca_de(nuevoAcercade);
               perso.setFacebook(nuevoFacebook);
               perso.setTwiter(nuevoTwiter);
               perso.setInstagram(nuevoInstagram);
               perso.setInfcont(nuevoInfcont);
            interPersona.savePersona(perso);
            
            return perso;
            
              }
            
}
