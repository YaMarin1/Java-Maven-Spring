package com.sena.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.demo.models.UsuarioModel;
import com.sena.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path = "/{documento}")
    public Optional<UsuarioModel> obtenerUsuarioPorDocumento(@PathVariable("documento") Long documento){
        return this.usuarioService.obtenerPorDocumento(documento);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorRol(@RequestParam("rol") Integer rol){
        return this.usuarioService.obtenerPorRol(rol);
    }

    @DeleteMapping( path = "/{documento}")
    public String eliminarPorDocumento(@PathVariable("documento") Long documento){
        boolean ok = this.usuarioService.eliminarUsuario(documento);
        if (ok) {
            return "Se eliminó el usuario con documento " + documento;
        } else {
            return "No se pudo eliminar el usuacio con documento " + documento;
        }
    }

}
