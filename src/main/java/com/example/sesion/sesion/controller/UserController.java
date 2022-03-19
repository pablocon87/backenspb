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
//import javax.swing.JOptionPane;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
        // @CrossOrigin(origins ="http://localhost:4200")
           @Autowired
    private IUserService interUser;
	@PostMapping("user")
        public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
	           System.out.println("este es user "+ username + " y este es pass " + pwd);
		String token = getJWTToken(username);
                Integer expired=getExpired();
		User user = new User();
                if ((user.getUser() == null ? username == null : user.getUser().equals(username)) && (user.getPassword() == null ? pwd == null : getMD5(user.getPassword()).equals(getMD5(pwd)))){
		                  System.out.println("Adentro " + token+" "+expired);
               
		user.setToken(token);
                user.setExpired(expired);
                return user;
                }else{
                    user.setUser(username);
                    user.setPassword(pwd);
                    return user;
                }
                
		
		
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
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
         @PostMapping("/user/crear")
    public String createUser(@RequestBody User usr){
        interUser.saveUser(usr);
        return "Succes";
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
