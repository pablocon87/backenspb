/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Conoc;
import com.example.sesion.sesion.repository.IConocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
 * 
 */
@RestController
 @RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {/*MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,*/MediaType.ALL_VALUE}/*,
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE}*/)

public class ConocController {
      @Autowired
    private IConocService interCon;
    @GetMapping("/conoc/traer")
    public List<Conoc> findBydesc(){
        return interCon.findBydesc();
    }
  
       
    
    @PostMapping("/conoc/crear")
    public String createConoc(@RequestBody Conoc con){
        interCon.saveConoc(con);
        return "Success";
    }
    @DeleteMapping("/conoc/borrar/{id}")
    public String deleteConoc (@PathVariable Long id){
        interCon.deleteConoc(id);
        return "Succes";
    }

    @PutMapping("/conoc/editar/{id}")
    public Conoc editConoc(@PathVariable Long id,
            @RequestParam("personaid") Integer nuevoPersonaid,
            @RequestParam("sobre") String nuevoSobre,
            @RequestParam("de") String nuevoDe,
            @RequestParam("saber") Integer nuevoSaber
            
            ){
        
                    
            Conoc con = interCon.findConoc(id);
            con.setSobre(nuevoSobre);
            con.setDe(nuevoDe);
            con.setSaber(nuevoSaber);
            con.setPersona_id(nuevoPersonaid);
            interCon.saveConoc(con);
            return con;
            
              }
}
