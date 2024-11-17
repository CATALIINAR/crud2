package com.example.crud2.controller;

import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.crud2.services.SucursalesServices;
import com.example.crud2.entities.SucursalesEntity; 


@RestController
@RequestMapping("/api/v1/sucursales")

public class SucursalesController {

    @Autowired
    private SucursalesServices sucursalesServices;

    // Método para obtener todas las sucursales
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllSucursales() {
        return sucursalesServices.getAllSucursales();
    }

    @GetMapping("/{id}")
    // Método para obtener una sucursal por id
    public ResponseEntity<?> getSucursales(@PathVariable UUID id) {
        return sucursalesServices.getSucursalesById(id);
    }

    @PostMapping
    // Método para crear una sucursal
    public ResponseEntity<?> createSucursales(@RequestBody SucursalesEntity sucursales) {
        return sucursalesServices.createSucursales(sucursales);
    }

    @PutMapping("/{id}")
    // Método para actualizar una sucursal
    public ResponseEntity<Map<String, Object>> updateSucursales(
            @PathVariable UUID id, @RequestBody SucursalesEntity sucursales) {
        return sucursalesServices.updateSucursales(id, sucursales);
    }

    @DeleteMapping("/{id}")
    // Método para eliminar una sucursal
    public ResponseEntity<Map<String, Object>> deleteSucursales(@PathVariable UUID id) {
        return sucursalesServices.deleteSucursales(id);
    }

}
