package com.example.crud2.controller;

import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crud2.services.ProductosServices;
import com.example.crud2.entities.ProductosEntity;

@RestController
@RequestMapping("/api/v1/productos")

public class ProductosController {

    @Autowired
    private ProductosServices productosServices;

    // Método para obtener todos los productos
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProductos() {
        return productosServices.getAllProductos();
    }

    @GetMapping("/{id}")
    // Método para obtener un producto por id
    public ResponseEntity<?> getProducto(@PathVariable UUID id) {
        return productosServices.getProductosById(id);
    }

    @PostMapping
    // Método para crear un producto
    public ResponseEntity<?> createProducto(@RequestBody ProductosEntity productos) {
        return productosServices.createProductos(productos);
    }

    @PutMapping("/{id}")
    // Método para actualizar un producto
    public ResponseEntity<Map<String, Object>> updateProductos(
            @PathVariable UUID id, @RequestBody ProductosEntity productos) {
        return productosServices.updateProductos(id, productos);
    }

    @DeleteMapping("/{id}")
    // Método para eliminar un producto
    public ResponseEntity<Map<String, Object>> deleteProductos(@PathVariable UUID id) {
        return productosServices.deleteProductos(id);
    }
    
}