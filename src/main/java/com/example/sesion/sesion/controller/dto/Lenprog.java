/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pablo
 */
@Getter @Setter
@Entity
public class Lenprog {
      @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
       private Long id;
       private Integer php;
       private Integer java;
       private Integer ruby;
       private Integer javascript;
       private Integer typescript;
       private Integer python;
       private Integer otros;
       private Integer persona_id;
}
