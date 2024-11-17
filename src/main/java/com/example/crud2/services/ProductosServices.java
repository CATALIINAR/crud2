package com.example.crud2.services;

import java.util.*;
import com.example.crud2.entities.ProductosEntity;
import com.example.crud2.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class ProductosServices {
    
    @Autowired
    private ProductosRepository productosRepository;

    public ResponseEntity<Map<String, Object>> getAllProductos() {
        Map<String, Object> response = new HashMap<>();
        List<ProductosEntity> productos = productosRepository.findAll();
        response.put("Productos", productos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getProductosById(UUID id) {
        Map<String, Object> response = new HashMap<>();
        Optional<ProductosEntity> productosFound = productosRepository.findById(id);
        if (productosFound.isPresent()) {
            response.put("Productos", productosFound.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Error", "Producto no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Map<String, Object>> createProductos(ProductosEntity productos) {
        Map<String, Object> response = new HashMap<>();
        productos.setId(UUID.randomUUID());
        if (productosRepository.existsById(productos.getId())) {
            response.put("Estado", "El producto ya existe");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            ProductosEntity newProductos = productosRepository.save(productos);
            response.put("Estado", "Producto insertado correctamente");
            response.put("Productos", newProductos);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Map<String, Object>> updateProductos(UUID id, ProductosEntity productos) {
        Map<String, Object> response = new HashMap<>();
        Optional<ProductosEntity> productosFound = productosRepository.findById(id);
        if (productosFound.isPresent()) {
            ProductosEntity existingProductos = productosFound.get();
            existingProductos.setProductosnombre(productos.getProductosnombre());
            existingProductos.setProductoscategoria(productos.getProductoscategoria());
            existingProductos.setProductoscantidad(productos.getProductoscantidad());
            existingProductos.setProductosprecio(productos.getProductosprecio());
            productosRepository.save(existingProductos);
            response.put("Estado", "Producto actualizado correctamente");
            response.put("Producto Actualizado", existingProductos);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Estado", "Producto no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Map<String, Object>> deleteProductos(UUID id) {
        Map<String, Object> response = new HashMap<>();
        Optional<ProductosEntity> productosFound = productosRepository.findById(id);
        if (productosFound.isPresent()) {
            productosRepository.deleteById(id);
            response.put("Estado", "Producto eliminado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Estado", "Producto no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}
