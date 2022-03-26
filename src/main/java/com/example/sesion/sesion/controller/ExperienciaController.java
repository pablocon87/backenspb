/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.Experiencia_laboral;
import com.example.sesion.sesion.repository.IExperienciaService;
import com.cedarsoftware.util.io.*;
import java.util.List;
import static org.eclipse.persistence.annotations.Convert.JSON;
import org.json.*;

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
@RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        //produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
public class ExperienciaController {
     @Autowired
    private IExperienciaService interExperiencia;
     @CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    @GetMapping("/experiencia/traer")
    public List<Experiencia_laboral> getExperiencia_laboral(){
        return interExperiencia.findExperiencia_laboraldate();
    }
  
       
    
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia_laboral experiencia){
        interExperiencia.saveExperiencia_laboral(experiencia);
       String s="Succes";
        return s;
    }
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        interExperiencia.deleteExperiencia_laboral(id);
        
        
        
       /* String str = "{ \"name\": \"Succes\" }";
        JSONObject obj = new JSONObject(str);
        String n = obj.getString("name");*/
        String s="Succes";
          

        return s ;
    }
  // @CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT})
    //@CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("experiencia/editar/{id}")
    public Experiencia_laboral editPersona(@PathVariable Long id,
            @RequestParam("nombreEmpresa") String nuevoNombreEmpresa,
            @RequestParam("estrabajoactual") Integer nuevoEstrabajoactual,
            @RequestParam("fechainicio") String nuevoFechainicio,
            @RequestParam("fechafin") String nuevaFechafin,
            @RequestParam("descripcion") String nuevoDescripcion,
            @RequestParam ("persona_id") Integer nuevoPersonaid,
            @RequestParam ("tipo_empleo_id") Integer nuevoTipoemid
            
            
            ){
   
                    
            Experiencia_laboral experiencia = interExperiencia.findExperiencia_laboral(id);
            experiencia.setNombreEmpresa(nuevoNombreEmpresa);
            experiencia.setEstrabajoactual(nuevoEstrabajoactual);
              experiencia.setFechainicio(nuevoFechainicio);
            experiencia.setFechafin(nuevaFechafin);
            experiencia.setDescripcion(nuevoDescripcion);
              experiencia.setPersona_id(nuevoPersonaid);
                experiencia.setTipo_empleo_id(nuevoTipoemid);
                 
               
            interExperiencia.saveExperiencia_laboral(experiencia);
            
            return experiencia;
            
              }
}
