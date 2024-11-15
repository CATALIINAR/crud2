package com.example.crud2.services;

import com.example.crud2.entities.EmpleadosEntity;
import com.example.crud2.repositories.EmpleadosRepository;
import java.util.Map;



import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
 
public class EmpleadosServices {
    @Autowired
	private EmpleadosRepository empleadosRepository;

    public ResponseEntity<Map<String, Object>> getAllEmpleados() {
        Map<String, Object> response = new HashMap<>();
        List<EmpleadosEntity> empleados = empleadosRepository.findAll();
        response.put("Empleados", empleados);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    public ResponseEntity<Map<String, Object>> getEmpleadosById(UUID id) {
        Map<String, Object> response = new HashMap<>();
        Optional<EmpleadosEntity> empleadosFound = empleadosRepository.findById(id);
        if (empleadosFound.isPresent()) {
            response.put("Empleados", empleadosFound.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Error", "Empleado no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    public ResponseEntity<Map<String, Object>> createEmpleados(EmpleadosEntity empleados) {
        Map<String, Object> response = new HashMap<>();
        empleados.setId(UUID.randomUUID());
        if (empleadosRepository.existsById(empleados.getId())) {
            response.put("Estado", "El empleado ya existe");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } else {
            EmpleadosEntity newEmpleados = empleadosRepository.save(empleados);
            response.put("Estado", "Empleado insertado correctamente");
            response.put("Empleados", newEmpleados);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
    }
    
    public ResponseEntity<Map<String, Object>> updateEmpleados(UUID id, EmpleadosEntity empleados) {
        Map<String, Object> response = new HashMap<>();
        Optional<EmpleadosEntity> empleadosFound = empleadosRepository.findById(id);
        if (empleadosFound.isPresent()) {
            EmpleadosEntity existingEmpleados = empleadosFound.get();
            existingEmpleados.setEmpleadosnombre(empleados.getEmpleadosnombre());
            existingEmpleados.setEmpleadosapellido(empleados.getEmpleadosapellido());
            existingEmpleados.setEmpleadosedad(empleados.getEmpleadosedad());
            existingEmpleados.setEmpleadoscargo(empleados.getEmpleadoscargo());
            empleadosRepository.save(existingEmpleados);
            response.put("Estado", "Empleado actualizado correctamente");
            response.put("Empleado Actualizado", existingEmpleados);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Estado", "Empleado no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    public ResponseEntity<Map<String, Object>> deleteEmpleados(UUID id) {
        Map<String, Object> response = new HashMap<>();
        Optional<EmpleadosEntity> empleadosFound = empleadosRepository.findById(id);
        if (empleadosFound.isPresent()) {
            empleadosRepository.deleteById(id);
            response.put("Estado", "Empleado eliminado correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("Estado", "Empleado no encontrado");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
}   
