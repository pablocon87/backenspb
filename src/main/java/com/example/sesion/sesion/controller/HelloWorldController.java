/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins ="http;//localhost:4200")
public class HelloWorldController {
    
        //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",allowedHeaders = "*",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS})
       //@CrossOrigin(allowCredentials = "true",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS})
	@RequestMapping("/hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
            System.out.println("Estoy en holaaa");
		return "Hello "+name+"!!";
	}
}
