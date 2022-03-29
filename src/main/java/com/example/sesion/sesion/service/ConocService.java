/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Conoc;
import com.example.sesion.sesion.repository.ConocRepository;
import com.example.sesion.sesion.repository.IConocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class ConocService implements IConocService {
      @Autowired
    private ConocRepository conRepository;

    @Override

    public List<Conoc> getConoc() {
        List<Conoc> listabd = conRepository.findAll();
        return listabd;
    }

    @Override
    public void saveConoc(Conoc con) {
       conRepository.save(con);
    }

    @Override
    public void deleteConoc(Long id) {
        conRepository.deleteById(id);
    }

    @Override
    public Conoc findConoc(Long id) {
        Conoc con = conRepository.findById(id).orElse(null);
        return con;
    }
     @Override
    public List<Conoc> findBydesc(){
        List<Conoc> listaCon = conRepository.findBydesc();
       return listaCon;
    }
}
