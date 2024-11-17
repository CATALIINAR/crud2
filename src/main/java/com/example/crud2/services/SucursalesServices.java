package com.example.crud2.services;

import java.util.*;
import com.example.crud2.entities.SucursalesEntity;
import com.example.crud2.repositories.SucursaleaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service


public class SucursalesServices {

    @Autowired
    private SucursaleaRepository sucursalesRepository;

    public ResponseEntity<Map<String, Object>> getAllSucursales() {
        Map<String, Object> response = new HashMap<>();
        List<SucursalesEntity> sucursales = sucursalesRepository.findAll();
        response.put("Sucursales", sucursales);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> getSucursalesById(UUID id) {
        Map<String, Object> response = new HashMap<>();
        Optional<SucursalesEntity> sucursalesFound = sucursalesRepository.findById(id);
        if (sucursalesFound.isPresent()) {
            response.put("Sucursales", sucursalesFound.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Error", "Sucursal no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Map<String, Object>> createSucursales(SucursalesEntity sucursales) {
        Map<String, Object> response = new HashMap<>();
        sucursales.setId(UUID.randomUUID());
        if (sucursalesRepository.existsById(sucursales.getId())) {
            response.put("Estado", "La sucursal ya existe");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            SucursalesEntity newSucursales = sucursalesRepository.save(sucursales);
            response.put("Estado", "Sucursal insertada correctamente");
            response.put("Sucursales", newSucursales);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Map<String, Object>> updateSucursales(UUID id, SucursalesEntity sucursales) {
        Map<String, Object> response = new HashMap<>();
        Optional<SucursalesEntity> sucursalesFound = sucursalesRepository.findById(id);
        if (sucursalesFound.isPresent()) {
            SucursalesEntity existingSucursales = sucursalesFound.get();
            existingSucursales.setSucursalesnombre(sucursales.getSucursalesnombre());
            existingSucursales.setSucursalesciudad(sucursales.getSucursalesciudad());
            existingSucursales.setSucursalesdireccion(sucursales.getSucursalesdireccion());
            sucursalesRepository.save(existingSucursales);
            response.put("Estado", "Sucursal actualizada correctamente");
            response.put("Sucursal Actualizada", existingSucursales);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Estado", "Sucursal no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Map<String, Object>> deleteSucursales(UUID id) {
        Map<String, Object> response = new HashMap<>();
        Optional<SucursalesEntity> sucursalesFound = sucursalesRepository.findById(id);
        if (sucursalesFound.isPresent()) {
            sucursalesRepository.deleteById(id);
            response.put("Estado", "Sucursal eliminada correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Estado", "Sucursal no encontrada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    

}
