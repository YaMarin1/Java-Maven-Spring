package com.sena.demo.services;

import com.sena.demo.models.RolModel;
import com.sena.demo.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public ArrayList<RolModel> obtenerRoles(){ return (ArrayList<RolModel>) rolRepository.findAll(); }

    public RolModel guardarRol(RolModel roles){
        return rolRepository.save(roles);
    }

    public Optional<RolModel> obtenerPorId(Long id){ return rolRepository.findById(id); }

    /*
    public ArrayList<RolModel> obtenerPorNombrerol(String nombrerol){
        return rolRepository.finByNombrerol(nombrerol);
    }
     */

    public boolean eliminarRol(Long id){
        try{
            rolRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
