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
 @RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {/*MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,*/MediaType.ALL_VALUE}/*,
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE}*/)

public class EducacionController {
            @Autowired
    private IEducacionService interEducacion;
           
    @GetMapping("/educacion/traer")
    public List<Educacion> getEducacion(){
        return interEducacion.findEducaciondate();
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

    @PutMapping("educacion/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id,
            @RequestParam("principal") String nuevoPrincipal,
            @RequestParam("segunda") String nuevoSegunda,
            @RequestParam("personaid") Integer nuevoPersonaid ,
            @RequestParam("urllogo") String nuevoLogo,
            @RequestParam("urlinst") String nuevoUrlinst,
            @RequestParam("anoinic") String nuevoAnoinic,
            @RequestParam("anofin") String nuevoAnofin,
            @RequestParam("titulo") String nuevoTitulo,
            @RequestParam("persona_id") Long nuevoPersona_id
            ){
            System.out.println("Aver estoy aca "+ nuevoPrincipal + " "+  nuevoSegunda + " "+nuevoPersonaid + " "+ id);
                    
            Educacion educ = interEducacion.findEducacion(id);
            educ.setPrincipal(nuevoPrincipal);
            educ.setSegunda(nuevoSegunda);
            educ.setUrl_logo(nuevoLogo);
            educ.setId_persona(nuevoPersonaid);
            educ.setUrlinst(nuevoUrlinst);
            educ.setAnoinic(nuevoAnoinic);
            educ.setAnofin(nuevoAnofin);
            educ.setTitulo(nuevoTitulo);
            educ.setPersona_id(nuevoPersona_id);
            interEducacion.saveEducacion(educ);
            return educ;
            
              }
}
