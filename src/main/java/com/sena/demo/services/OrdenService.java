package com.sena.demo.services;

import com.sena.demo.models.OrdenModel;
import com.sena.demo.repositories.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service

public class OrdenService {

    @Autowired
    OrdenRepository ordenRepository;

    public ArrayList<OrdenModel> obtenerOrdenes(){
        return (ArrayList<OrdenModel>) ordenRepository.findAll();

    }

    public OrdenModel guardarOrden(OrdenModel orden){
        return ordenRepository.save(orden);
    }

    public Optional<OrdenModel> obtenerPorId(Long id){
        return ordenRepository.findById(id);
    }


    public ArrayList<OrdenModel> obtenerPorDocumento(Long documento){
        return ordenRepository.findByDocumento(documento);
    }

    public boolean eliminarOrden(Long id){
        try {
            ordenRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
