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

import com.example.crud2.services.ProductosServices;
import com.example.crud2.entities.ProductosEntity;

@RestController
@RequestMapping("/api/v1/productos")

public class ProductosController {
    private final ProductosServices productosServices;

    @Autowired
    public ProductosController( ProductosServices productosServices) {
        this.productosServices = productosServices;
    }

    //Método para obtener todos los empleado
    @GetMapping
    public List<ProductosEntity> getCountries(){
        return productosServices.getAllCountries();
    }

    //Método para obtener un empleado por id
    @GetMapping("/{id}")
    public Optional<ProductosEntity> getCountry(@PathVariable UUID id){
        return productosServices.getCountryById(id);
    }

    //Método para crear un empleado
    @PostMapping
    public String createCountry(){

        return "POST COUNTRY";
    }

    ////Método para actualizar un empleado
    @PutMapping("/{id}")
    public String updateCountry(@PathVariable UUID id){
        productosServices.updateCountry(id);
        return "PUT COUNTRY";
    }

    //Método para eliminar un empleado
    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable UUID id){
        productosServices.deleteCountry(id);
        return "DELETE COUNTRY";
    }
}
