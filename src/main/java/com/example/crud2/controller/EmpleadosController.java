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

import com.example.crud2.services.EmpleadosServices;
import com.example.crud2.entities.EmpleadosEntity;

@RestController
@RequestMapping("/api/v1/empleados")

public class EmpleadosController {
    private final EmpleadosServices empleadosServices;

    @Autowired
    public EmpleadosController( EmpleadosServices empleadosServices) {
        this.empleadosServices = empleadosServices;
    }

    //Método para obtener todos los empleado
    @GetMapping
    public List<EmpleadosEntity> getEmpleados(){
        return empleadosServices.getAllEmpleados();
    }

    //Método para obtener un empleado por id
    @GetMapping("/{id}")
    public Optional<EmpleadosEntity> getEmpleados(@PathVariable UUID id){
        return empleadosServices.getEmpleadosById(id);
    }

    //Método para crear un empleado
    @PostMapping
    public EmpleadosEntity createEmpleados(@RequestBody EmpleadosEntity empleados){

        return (EmpleadosEntity) EmpleadosEntity.createEmpleados(empleados);
    }

    ////Método para actualizar un empleado
    @PutMapping("/{id}")
    publicOptional<EmpleadosEntity> updateEmpleados(@PathVariable UUID id, EmpleadosEntity empleados){
        return empleadosServices.updateEmpleados(id, empleados);
        
    }

    //Método para eliminar un empleado
    @DeleteMapping("/{id}")
    public String deleteEmpleados(@PathVariable UUID id){
        boolean isDeleted = empleadosServices.deleteEmpleados(id);
        if (isDeleted) {
            return "Empleado eliminada exitosamente";
        } else {
            return "Empleado no encontrada";
        }
    }
}

