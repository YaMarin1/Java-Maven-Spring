package com.sena.demo.controllers;

import com.sena.demo.models.OrdenModel;
import com.sena.demo.services.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/orden")
public class OrdenController {

    @Autowired
    OrdenService ordenService;


    @GetMapping()
    public ArrayList<OrdenModel> obtenerOrdenes(){
        return ordenService.obtenerOrdenes();
    }


    @PostMapping()
    public OrdenModel guardarOrden(@RequestBody OrdenModel orden){
        return this.ordenService.guardarOrden(orden);
    }


    //Recibe la id enviada para mostrar la informacion
    @GetMapping( path = "/{id}")
    public Optional<OrdenModel> obtenerOrdenPorId(@PathVariable("id") Long id){
        return this.ordenService.obtenerPorId(id);
    }


    @GetMapping("/query")
    public ArrayList<OrdenModel> obtenerOrdenPorDocumento(@RequestParam("documento") Long documento){
        return this.ordenService.obtenerPorDocumento(documento);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.ordenService.eliminarOrden(id);
        if (ok) {
            return "Se eliminó la orden con id " + id;
        } else {
            return "No se pudo eliminar la orden con id " + id;
        }
    }


}
