/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Educacion;
import com.example.sesion.sesion.repository.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
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

@RestController
//@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.POST})
 @RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        //produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})

public class EducacionController {
            @Autowired
    private IEducacionService interEducacion;
           
    //@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion(){
        return interEducacion.getEducacion();
    }
  
       
    
    @PostMapping("/educacion/crear")
    public String createEducacion(@RequestBody Educacion educ){
        interEducacion.saveEducacion(educ);
        return "Succes";
    }
    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion (@PathVariable Long id){
        interEducacion.deleteEducacion(id);
        return "Succes";
    }
 // @CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",
       //   methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE})
    //@CrossOrigin(origins ="http://localhost:4200")
  //  @RequestMapping(
 // value = "/educacion/editar/{id}", 
 // produces = "application/json",
 // method = {RequestMethod.GET, RequestMethod.PUT})
    @PutMapping("educacion/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
            @RequestParam("principal") String nuevoPrincipal,
            @RequestParam("segunda") String nuevoSegunda,
            @RequestParam("personaid") Integer nuevoPersonaid ,
            @RequestParam("urllogo") String nuevoLogo
            ){
            System.out.println("Aver estoy aca "+ nuevoPrincipal + " "+  nuevoSegunda + " "+nuevoPersonaid + " "+ id);
                    
            Educacion educ = interEducacion.findEducacion(id);
            educ.setPrincipal(nuevoPrincipal);
            educ.setSegunda(nuevoSegunda);
            educ.setUrl_logo(nuevoLogo);
            educ.setId_persona(nuevoPersonaid);
            interEducacion.saveEducacion(educ);
            return educ;
            
              }
}
