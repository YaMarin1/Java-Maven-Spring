package com.sena.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.demo.models.UsuarioModel;
import com.sena.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorDocumento(Long documento){
        //return usuarioRepository.findByDocumento(documento);
        return usuarioRepository.findById(documento);
    }

    public ArrayList<UsuarioModel> obtenerPorRol(Integer rol){
        return usuarioRepository.findByRol(rol);
    }

    public boolean eliminarUsuario(Long documento){
        try {
            //usuarioRepository.deleteByDocumento(documento);
            usuarioRepository.deleteById(documento);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
