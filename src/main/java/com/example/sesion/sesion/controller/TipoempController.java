/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Tipo_empleo;
import com.example.sesion.sesion.repository.ITipoemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pablo
 */
@RestController
//@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
public class TipoempController {
        @Autowired
    private ITipoemService interTipoemp;
       @CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    @GetMapping("/tipoem/traer")
    public List<Tipo_empleo> getTipo_empleo(){
        return interTipoemp.getTipo_empleo();
    }
  
       
    
    @PostMapping("/tipoemp/crear")
    public String createStudent(@RequestBody Tipo_empleo tipoemp){
        interTipoemp.saveTipo_empleo(tipoemp);
        return "La persona fue creada correctamente";
    }
    @DeleteMapping("/tipoemp/borrar/{id}")
    public String deleteTipo_empleo (@PathVariable Long id){
        interTipoemp.deleteTipo_empleo(id);
        return "La persona fue eliminada correctamente";
    }
   //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    //@CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("tipoemp/editar/{id}")
    public Tipo_empleo editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombretip
            
            
            ){
        
                    
            Tipo_empleo perso = interTipoemp.findTipo_empleo(id);
            perso.setNombre_tipo(nuevoNombretip);
            
            
            return perso;
            
              }
}
