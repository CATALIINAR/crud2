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

    //Método para obtener todos los producto
    @GetMapping
    public List<ProductosEntity> getProductos(){
        return productosServices.getAllProductos();
    }

    //Método para obtener un producto por id
    @GetMapping("/{id}")
    public Optional<ProductosEntity> getProductoss(@PathVariable UUID id){
        return productosServices.getProductosById(id);
    }

    //Método para crear un producto
    @PostMapping
    public ProductosEntity createProductos(@RequestBody ProductosEntity productos){

        return (ProductosEntity) ProductosEntity.createProductos(productos);
    }

    ////Método para actualizar un producto
    @PutMapping("/{id}")
    publicOptional<ProductosEntity> updateProductos(@PathVariable UUID id, ProductosEntity productos){
        return  productosServices.updateProductos(id, productos);
        
    }

    //Método para eliminar un productos
    @DeleteMapping("/{id}")
    public String deleteProductos(@PathVariable UUID id){
        boolean isDeleted = productosServices.deleteProductos(id);
        if (isDeleted) {
            return "Producto eliminada exitosamente";
        } else {
            return "Producto no encontrada";
        }
    }
}