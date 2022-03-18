/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Persona;
import com.example.sesion.sesion.repository.IPersonaService;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pablo
 */
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//@CrossOrigin
@RestController
@RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        //produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//@RequestMapping("/personas")
//@CrossOrigin(origins ="*",allowedHeaders = "*",allowCredentials = "true",)
public class PersonaController  {
   
    @Autowired
    private IPersonaService interPersona;
        
    //@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
  //  @RequestMapping(
 // value = "/personas/traer",
 // produces = "application/json",
 // headers = {"Access-Control-Allow-Origin = http://localhost:4200","Access-Control-Allow-Headers= Origin, Content-Type, Authorization"},
 // method = {RequestMethod.GET, RequestMethod.PUT})
  //@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    
    @GetMapping("/personas/traer")
     //@RequestMapping(method = {RequestMethod.GET,RequestMethod.OPTIONS},path = "/traer")
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
   //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    //@CrossOrigin(origins ="http://localhost:4200")
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
            @RequestParam ("acerca_de") String nuevoAcercade
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
            interPersona.savePersona(perso);
            
            return perso;
            
              }
            
}
