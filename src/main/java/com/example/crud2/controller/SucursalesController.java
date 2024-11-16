package com.example.crud2.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.crud2.services.SucursalesServices;
import com.example.crud2.entities.SucursalesEntity; 


@RestController
@RequestMapping("/api/v1/sucursales")

public class SucursalesController {
    private final SucursalesServices sucursalesServices;

    @Autowired
    public SucursalesController( SucursalesServices SucursalesServices) {
        this.sucursalesServices = SucursalesServices;
    }

    //Método para obtener todos las sucursales
    @GetMapping
    public List<SucursalesEntity> getSucursales(){
        return sucursalesServices.getAllSucursales();
    }

    //Método para obtener un sucursal por id
    @GetMapping("/{id}")
    public Optional<SucursalesEntity> getSucursales(@PathVariable UUID id){
        return sucursalesServices.getSucursalesById(id);
    }

    //Método para crear un sucursal
    @PostMapping
    public SucursalesEntity createSucursales(@RequestBody SucursalesEntity sucursales){

        return (SucursalesEntity) SucursalesEntity.createSucursales(sucursales);
    }

    ////Método para actualizar un sucursal
    @PutMapping("/{id}")
    publicOptional<SucursalesEntity> updateSucursales(@PathVariable UUID id, SucursalesEntity sucursales){
        return  SucursalesServices.updateSucursales(id, sucursales);
        
    }

    //Método para eliminar un productos
    @DeleteMapping("/{id}")
    public String deleteSucursales(@PathVariable UUID id){
        boolean isDeleted = SucursalesServices.deleteSucursales(id);
        if (isDeleted) {
            return "Sucursal eliminada exitosamente";
        } else {
            return "Sucursal no encontrada";
        }
    }
}
