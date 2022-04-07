/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;

import com.example.sesion.sesion.controller.dto.User;
import com.example.sesion.sesion.service.UserService;
import com.sun.jndi.toolkit.url.Uri;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pablo
 */
@Controller
@RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.PATCH,RequestMethod.TRACE},
        produces ={"text/html","text/css"}/* , 
       consumes={"text/html"}*/)
public class ControllerWeb {
    @Autowired
	UserService userService;
    @GetMapping("/")  
public String index()
{  
//returns to index.html
return "index";  
} 

@GetMapping("/viewf") 
//@ResponseBody
//@RequestMapping(value="/viewf")
public String view(Model model)
{  
baseAttributerForUserForm(model, new User(),"");   
// model.addAttribute("viewf",true);
  /*  response.addHeader("Authorization",request.getHeader("Authorization") );
    response.addHeader("Content-Type", "text/html; charset=utf-8" );
    System.out.println("este es Request " +request.getHeader("Authorization"));*/
  //return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION
			//	).body("view");
//returns to index.html
return "viewf/view";  
} 
private void baseAttributerForUserForm(Model model, User user,String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute("userList", userService.findUserr("pablocon87@gmail.com"));
		
		model.addAttribute(activeTab,"active");
	}

    @GetMapping("/Carga")  
public String carga()
{  
//returns to index.html
return "viewf/carga.html";  
} 
}
