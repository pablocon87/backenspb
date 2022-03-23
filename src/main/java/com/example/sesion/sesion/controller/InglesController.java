/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;


import com.example.sesion.sesion.controller.dto.Ingles;
import com.example.sesion.sesion.repository.IInglesService;
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
@RestController
//@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.POST})
 @RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        //produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})

public class InglesController {
    
     @Autowired
    private IInglesService interIngles;
      // @CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    @GetMapping("/ingles/traer")
    public List<Ingles> getIngles(){
        return interIngles.getIngles();
    }
  
       
    
    @PostMapping("/ingles/crear")
    public String createIngles(@RequestBody Ingles ingl){
        interIngles.saveIngles(ingl);
        return "Success";
    }
    @DeleteMapping("/ingles/borrar/{id}")
    public String deleteIngles (@PathVariable Long id){
        interIngles.deleteIngles(id);
        return "Succes";
    }
   //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    //@CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/ingles/editar/{id}")
    public Ingles editIngles(@PathVariable Long id,
            @RequestParam("personaid") Integer nuevoPersonaid,
            @RequestParam("inescrip") Integer nuevoInescrip,
            @RequestParam("inoral") Integer nuevoInoral,
            @RequestParam("intecnico") Integer nuevoIntecnico,
            @RequestParam("inbasico") Integer nuevoInbasico,
            @RequestParam("inavanzado") Integer nuevoInavanzado
            ){
        
                    
            Ingles ingl = interIngles.findIngles(id);
            ingl.setInescrip(nuevoInescrip);
            ingl.setInoral(nuevoInoral);
            ingl.setIntecnico(nuevoIntecnico);
            ingl.setInbasico(nuevoInbasico);
            ingl.setInavanzado(nuevoInavanzado);
            ingl.setPersona_id(nuevoPersonaid);
            interIngles.saveIngles(ingl);
            return ingl;
            
              }
    
}
