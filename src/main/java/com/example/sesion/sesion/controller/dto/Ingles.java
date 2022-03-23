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
public class Ingles {
       @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
       private Long id;
       private Integer inescrip;
       private Integer inoral;
       private Integer intecnico;
       private Integer inbasico;
       private Integer inavanzado;
       private Integer persona_id;
}
