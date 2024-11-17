package com.example.crud2.controller;

import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
		return clientesService.updateClientes(id, clientes);
	}
	
	@DeleteMapping("/{id}")
	//Método para eliminar un cliente
	public ResponseEntity<Map<String, Object>> deleteClientes(@PathVariable UUID id){
		return clientesService.deleteClientes(id);
	}
}
