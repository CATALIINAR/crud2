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

import com.example.crud2.services.ClientesServices;
import com.example.crud2.entities.ClientesEntity;

@RestController
@RequestMapping("/api/v1/clientes")

public class ClientesController {
    private final ClientesServices clientesServices;

    @Autowired
    public ClientesController( ClientesServices clientesServices) {
        this.clientesServices = clientesServices;
    }

    
    //Método para obtener todos los clientes
    @GetMapping
    public List<ClientesEntit> getCountries(){
        return clientesServices.getAllCountries();
    }

    //Método para obtener un cliente por id
    @GetMapping("/{id}")
    public Optional<ClientesEntity> getCountry(@PathVariable UUID id){
        return clientesServices.getCountryById(id);
    }

    //Método para crear un cliente
    @PostMapping
    public ClientesEntity createCountry(@RequestBody ClientesEntity clientes){

        return (ClientesServices) clientesServices.createCountry(clientes);
    }

    ////Método para actualizar un cliente
    @PutMapping("/{id}")
    public Optional<ClientesEntity> updateCountry(@PathVariable UUID id, @RequestBody ClientesEntity clientes){
        
        return clientesServices.updateCountry(id, clientes);
    }

    //Método para eliminar un cliente
    @DeleteMapping("/{id}")
    public String deleteCountry(@PathVariable UUID id){
        boolean isDeleted = clientesServices.deleteCategory(id);
        if (isDeleted) {
            return "Cliente eliminada exitosamente";
        } else {
            return "Cliente no encontrada";
        }
    }
}
