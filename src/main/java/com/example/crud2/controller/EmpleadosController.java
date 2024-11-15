package com.example.crud2.controller;

import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.crud2.services.EmpleadosServices;
import com.example.crud2.entities.EmpleadosEntity;

@RestController
@RequestMapping("/api/v1/empleados")

public class EmpleadosController {

    @Autowired
	private EmpleadosServices empleadosServices;
	
	//Método para obtener todos los empleados 
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllEmpleados() {
		return empleadosServices.getAllEmpleados();
	}
	
	@GetMapping("/{id}")
	//Método para obtener un empleado por id

	public ResponseEntity<?> getEmpleados(@PathVariable UUID id){
		return empleadosServices.getEmpleadosById(id);
	}
	
	@PostMapping
	//Método para crear un empleados
	public ResponseEntity<?> createEmpleaos(@RequestBody EmpleadosEntity empleados){
		return empleadosService.createEmpleados(empleados);
	}
	
	@PutMapping("/{id}")
	//Método para actualizar un empleado
	public ResponseEntity<Map<String, Object>> updateEmpleados(
			@PathVariable UUID id, @RequestBody EmpleadosEntity empleados) {
		return empleadosService.updateEmpleados(id, empleados);
	}
	
	@DeleteMapping("/{id}")
	//Método para eliminar un empleados
	public ResponseEntity<Map<String, Object>> deleteEmpleados(@PathVariable UUID id){
		return empleadosServices.deleteEmpleados(id);
	}
}