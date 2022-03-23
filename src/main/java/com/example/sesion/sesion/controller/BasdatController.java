/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Basdat;
import com.example.sesion.sesion.repository.IBasdatService;
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

public class BasdatController {
     
     @Autowired
    private IBasdatService interBd;
      // @CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    @GetMapping("/basdat/traer")
    public List<Basdat> getBasdat(){
        return interBd.getBasdat();
    }
  
       
    
    @PostMapping("/basdat/crear")
    public String createBasdat(@RequestBody Basdat bd){
        interBd.saveBasdat(bd);
        return "Success";
    }
    @DeleteMapping("/basdat/borrar/{id}")
    public String deleteBasdat (@PathVariable Long id){
        interBd.deleteBasdat(id);
        return "Succes";
    }
   //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    //@CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/basdat/editar/{id}")
    public Basdat editBasdat(@PathVariable Long id,
            @RequestParam("personaid") Integer nuevoPersonaid,
            @RequestParam("mysql") Integer nuevoMysql,
            @RequestParam("postgresql") Integer nuevoPostgresql,
            @RequestParam("sqlserver") Integer nuevoSqlserver,
            @RequestParam("otros") Integer nuevoOtros
            ){
        
                    
            Basdat bd = interBd.findBasdat(id);
            bd.setMysql(nuevoMysql);
            bd.setPostgresql(nuevoPostgresql);
            bd.setSqlserver(nuevoSqlserver);
            bd.setOtros(nuevoOtros);
            bd.setPersona_id(nuevoPersonaid);
            interBd.saveBasdat(bd);
            return bd;
            
              }
}
