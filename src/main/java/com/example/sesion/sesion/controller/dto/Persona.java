/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.controller.dto;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity

public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
       private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String fechanac;
    private String telefono;
    private String correo;
    private String sobre_mi;
    private String url_foto;
    private String acerca_de;
}
