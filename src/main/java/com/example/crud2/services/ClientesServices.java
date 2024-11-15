package com.example.crud2.services;

import com.example.crud2.entities.ClientesEntity;
import com.example.crud2.repositories.ClientesRepository;
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
public class ClientesServices {

    @Autowired
private ClientesRepository clientesRepository;

public ResponseEntity<Map<String, Object>> getAllClientes() {
    Map<String, Object> response = new HashMap<>();
    List<ClientesEntity> clientes = clientesRepository.findAll();
    response.put("Clientes", clientes);
    return new ResponseEntity<>(response, HttpStatus.OK);
}

public ResponseEntity<Map<String, Object>> getClientesById(UUID id) {
    Map<String, Object> response = new HashMap<>();
    Optional<ClientesEntity> clientesFound = clientesRepository.findById(id);
    if (clientesFound.isPresent()) {
        response.put("Clientes", clientesFound.get());
        return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
        response.put("Error", "Cliente no encontrado");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

public ResponseEntity<Map<String, Object>> createClientes(ClientesEntity clientes) {
    Map<String, Object> response = new HashMap<>();
    clientes.setId(UUID.randomUUID());
    if (clientesRepository.existsById(clientes.getId())) {
        response.put("Estado", "El cliente ya existe");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    } else {
        ClientesEntity newClientes = clientesRepository.save(clientes);
        response.put("Estado", "Cliente insertado correctamente");
        response.put("Clientes", newClientes);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

public ResponseEntity<Map<String, Object>> updateClientes(UUID id, ClientesEntity clientes) {
    Map<String, Object> response = new HashMap<>();
    Optional<ClientesEntity> clientesFound = clientesRepository.findById(id);
    if (clientesFound.isPresent()) {
        ClientesEntity existingClientes = clientesFound.get();
        existingClientes.setClientesnombre(clientes.getClientesnombre());
        existingClientes.setClientesapellido(clientes.getClientesapellido());
        existingClientes.setClientesedad(clientes.getClientesedad());
        clientesRepository.save(existingClientes);
        response.put("Estado", "Cliente actualizado correctamente");
        response.put("Cliente Actualizado", existingClientes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
        response.put("Estado", "Cliente no encontrado");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

public ResponseEntity<Map<String, Object>> deleteClientes(UUID id) {
    Map<String, Object> response = new HashMap<>();
    Optional<ClientesEntity> clientesFound = clientesRepository.findById(id);
    if (clientesFound.isPresent()) {
        clientesRepository.deleteById(id);
        response.put("Estado", "Cliente eliminado correctamente");
        return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
        response.put("Estado", "Cliente no encontrado");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
}