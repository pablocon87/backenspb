/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Sisop;
import com.example.sesion.sesion.repository.ISisopService;
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
 */
@RestController
//@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.POST})
 @RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        //produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})

public class SisopController {
     @Autowired
    private ISisopService interSip;
      // @CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    @GetMapping("/sisop/traer")
    public List<Sisop> getSisop(){
        return interSip.getSisop();
    }
  
       
    
    @PostMapping("/sisop/crear")
    public String createSisop(@RequestBody Sisop sisp){
        interSip.saveSisop(sisp);
        return "Success";
    }
    @DeleteMapping("/sisop/borrar/{id}")
    public String deleteSisop (@PathVariable Long id){
        interSip.deleteSisop(id);
        return "Succes";
    }
   //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    //@CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/sisop/editar/{id}")
    public Sisop editSisop(@PathVariable Long id,
            @RequestParam("personaid") Integer nuevoPersonaid,
            @RequestParam("windows") Integer nuevoWindows,
            @RequestParam("linux") Integer nuevoLinux,
            @RequestParam("macos") Integer nuevoMacos,
            @RequestParam("otros") Integer nuevoOtros
            ){
        
                    
            Sisop sisp = interSip.findSisop(id);
            sisp.setWindows(nuevoWindows);
            sisp.setLinux(nuevoLinux);
            sisp.setMacos(nuevoMacos);
            sisp.setOtros(nuevoOtros);
            sisp.setPersona_id(nuevoPersonaid);
            interSip.saveSisop(sisp);
            return sisp;
            
              }
}
