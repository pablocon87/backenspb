/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sesion.sesion.service;

import com.example.sesion.sesion.controller.dto.Basdat;
import com.example.sesion.sesion.repository.BasdatRepository;
import com.example.sesion.sesion.repository.IBasdatService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */
@Service
public class BasdatService implements IBasdatService {
    @Autowired
    private BasdatRepository bdRepository;

    @Override

    public List<Basdat> getBasdat() {
        List<Basdat> listabd = bdRepository.findAll();
        return listabd;
    }

    @Override
    public void saveBasdat(Basdat bd) {
       bdRepository.save(bd);
    }

    @Override
    public void deleteBasdat(Long id) {
        bdRepository.deleteById(id);
    }

    @Override
    public Basdat findBasdat(Long id) {
        Basdat bd = bdRepository.findById(id).orElse(null);
        return bd;
    }
}
