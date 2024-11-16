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

import com.example.crud2.services.ClientesServices;
import com.example.crud2.entities.ClientesEntity;

@RestController
@RequestMapping("/api/v1/clientes")

public class ClientesController {

    @Autowired
	private ClientesServices clientesService;
	
	//Método para obtener todos los clientes
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllClientes() {
		return clientesService.getAllClientes();
	}
	
	@GetMapping("/{id}")
	//Método para obtener un cliente por id

	public ResponseEntity<?> getClientes(@PathVariable UUID id){
		return clientesService.getClientesById(id);
	}
	
	@PostMapping
	//Método para crear un cliente
	public ResponseEntity<?> createClientes(@RequestBody ClientesEntity clientes){
		return clientesService.createClientes(clientes);
	}
	
	@PutMapping("/{id}")
	//Método para actualizar un cliente
	public ResponseEntity<Map<String, Object>> updateClientes(
			@PathVariable UUID id, @RequestBody ClientesEntity clientes) {
		return clientesService.updateClientesy(id, clientes);
	}
	
	@DeleteMapping("/{id}")
	//Método para eliminar un cliente
	public ResponseEntity<Map<String, Object>> deletelientes(@PathVariable UUID id){
		return clientesService.deleteClientes(id);
	}
}
