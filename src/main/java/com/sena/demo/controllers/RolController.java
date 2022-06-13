package com.sena.demo.controllers;

import com.sena.demo.models.RolModel;
import com.sena.demo.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping()
    public ArrayList<RolModel> obtenerRoles() {
        return rolService.obtenerRoles();
    }

    @PostMapping()
    public RolModel guardarRol(@RequestBody RolModel rol) {
        return this.rolService.guardarRol(rol);
    }

     @GetMapping( path = "/{id}")
    public Optional<RolModel> obtenerRolPorId(@PathVariable("id") Long id) {
        return this.rolService.obtenerPorId(id);
    }


    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.rolService.eliminarRol(id);
        if (ok) {
            return "Se elimino el rol " + id;
        } else {
            return "No se pudo eliminar el rol " + id;
        }
    }


}
