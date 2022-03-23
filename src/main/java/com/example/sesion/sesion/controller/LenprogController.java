/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Lenprog;
import com.example.sesion.sesion.repository.ILenprogService;
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

public class LenprogController {
     @Autowired
    private ILenprogService interLenp;
      // @CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    @GetMapping("/lenprog/traer")
    public List<Lenprog> getLenprog(){
        return interLenp.getLenprog();
    }
  
       
    
    @PostMapping("/lenprog/crear")
    public String createLenprog(@RequestBody Lenprog lenp){
        interLenp.saveLenprog(lenp);
        return "Success";
    }
    @DeleteMapping("/lenprog/borrar/{id}")
    public String deleteLenprog (@PathVariable Long id){
        interLenp.deleteLenprog(id);
        return "Succes";
    }
   //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    //@CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/lenprog/editar/{id}")
    public Lenprog editLenprog(@PathVariable Long id,
            @RequestParam("personaid") Integer nuevoPersonaid,
            @RequestParam("php") Integer nuevoPhp,
            @RequestParam("java") Integer nuevoJava,
            @RequestParam("ruby") Integer nuevoRuby,
            @RequestParam("javascript") Integer nuevoJavascript,
            @RequestParam("typescript") Integer nuevoTypescript,
            @RequestParam("python") Integer nuevoPython,
            @RequestParam("otros") Integer nuevoOtros
            ){
        
                    
            Lenprog lenp = interLenp.findLenprog(id);
            lenp.setPhp(nuevoPhp);
            lenp.setJava(nuevoJava);
            lenp.setRuby(nuevoRuby);
            lenp.setJavascript(nuevoJavascript);
            lenp.setTypescript(nuevoTypescript);
            lenp.setPython(nuevoPython);
            lenp.setOtros(nuevoOtros);
            lenp.setPersona_id(nuevoPersonaid);
          interLenp.saveLenprog(lenp);
            return lenp;
            
              }
}
