/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller;
import com.example.sesion.sesion.controller.dto.User;
import com.example.sesion.sesion.repository.IUserService;
import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import javax.swing.JOptionPane;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
//@CrossOrigin(allowedHeaders = "*",origins ="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.POST})
 @RequestMapping( method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.DELETE},
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
        //produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_FORM_URLENCODED_VALUE})

public class UserController {
        // @CrossOrigin(origins ="http://localhost:4200")
           @Autowired
    private IUserService interUser;
	@PostMapping("user")
        public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
	           System.out.println("este es user "+ username + " y este es pass " + pwd);
                   
		
		User user = new User();
               
        List<User> lista = interUser.getUser();
     for(User objPersona : lista){
        
      if(objPersona.getUser().equals(username) && objPersona.getPassword().equals(getMD5(pwd))){
          if(objPersona.getConec()==0){  
          objPersona.setConec(1);
          objPersona.setTimelim("0");
          objPersona.setAuten(1);
            interUser.saveUser(objPersona);
             String token = getJWTToken(username);
                String guardar="";
                Integer expired=getExpired();
            objPersona.setToken(token);
          objPersona.setExpired(expired);
          guardar="ok";
          return objPersona;
          }else{
              //Integer conec =objPersona.getConec();
              String token ="nada";
              objPersona.setToken(token);
              //objPersona.setConec(conec);
              return objPersona;
          }
         
      }
      if(objPersona.getUser().equals(username) && objPersona.getPassword() !=  (getMD5(pwd))){
          objPersona.setAuten(objPersona.getAuten()+1);
          interUser.saveUser(objPersona);
          if(objPersona.getAuten()>=3){
              Integer auten = objPersona.getAuten();
              Long id= objPersona.getId();
              String token ="nada";
              objPersona.setToken(token);
              objPersona.setId(id);
              objPersona.setAuten(auten);
              
              return objPersona;
          }else{
              String token ="nada";
              objPersona.setToken(token);
              Long id= objPersona.getId();
              objPersona.setId(id);
               return objPersona;
          }
      }
      
    }
      String token ="nada";
        user.setToken(token);
      return user;
               // System.out.println("este es passwor"+user.getPassword()+ "el encriptado es "+getMD5(pwd));
                /*if ((user.getUser() == null ? username == null : user.getUser().equals(username)) && (user.getPassword() == null ? pwd == null : user.getPassword().equals(getMD5(pwd)))){
		 
               System.out.println("Adentro " + token+" "+expired);
               
		user.setToken(token);
                user.setExpired(expired);
                return user;
                }else{
                    user.setUser(username);
                    user.setPassword(pwd);
                    return user;
                }*/
                
		
		
	}
      private Integer getExpired(){
          Integer expired=600000;
          return expired;
      }
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1800000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
        
         @GetMapping("/user/traer")
    public List<User> getUser(){
        return interUser.getUser();
    }
         @PostMapping("/user/crear")
    public String createUser(@RequestBody User usr){
        usr.setId(usr.getId());
        usr.setUser(usr.getUser());
         List<User> lista = interUser.getUser();
     for(User objPersona : lista){
        
      if(objPersona.getUser().equals(usr.getUser())){
       
           
          return "nSucces";
      }
      
    }
        usr.setPassword(getMD5(usr.getPassword()));
       usr.setConec(0);
       usr.setAuten(1);
        
        interUser.saveUser(usr);
    /*       List<User> lista = interUser.getUser();
     for(User objPersona : lista){
      
      
    }*/
        return "Succes";
    }
    /*	 public List<User> getUser(){
             
        return interUser.getUser();
    }*/
@PutMapping("/user/editar/{id}")
    public User editPersona(@PathVariable Long id,
            @RequestParam("user") String nuevoUser,
            @RequestParam("password") String nuevoPassword,
            @RequestParam("token") String nuevoToken,
            @RequestParam("expired") Integer nuevoExpired,
            @RequestParam("conec") Integer nuevoConec,
            @RequestParam ("auten") Integer nuevoAuten,
            @RequestParam("timelim") String nuevoTimelim,
            @RequestParam("rol") Integer nuevoRol
            ){
        
                    
            User usr = interUser.findUser(id);
            usr.setUser(usr.getUser());
            usr.setPassword(usr.getPassword());
            usr.setToken(nuevoToken);
            usr.setExpired(nuevoExpired);
            usr.setConec(nuevoConec);
            usr.setAuten(nuevoAuten);
            usr.setTimelim(nuevoTimelim);
            usr.setRol(nuevoRol);
            interUser.saveUser(usr);
            
            return usr;
            
              }		
    @PutMapping("/user/traer/{user}")
     //@RequestMapping(method = {RequestMethod.GET,RequestMethod.OPTIONS},path = "/traer")
    //@GetMapping("/user/traer")
    public User getUsers(@PathVariable String user){
        
        User usr=interUser.findUserr(user);
        usr.setUser(usr.getUser());
            usr.setPassword(usr.getPassword());
            usr.setRol(usr.getRol());
        return usr;
    }
	
    public static String getMD5(String input) {
 try {
 MessageDigest md = MessageDigest.getInstance("MD5");
 byte[] messageDigest = md.digest(input.getBytes());
 BigInteger number = new BigInteger(1, messageDigest);
 String hashtext = number.toString(16);

 while (hashtext.length() < 32) {
 hashtext = "0" + hashtext;
 }
 return hashtext;
 }
 catch (NoSuchAlgorithmException e) {
 throw new RuntimeException(e);
 }
 }
}
