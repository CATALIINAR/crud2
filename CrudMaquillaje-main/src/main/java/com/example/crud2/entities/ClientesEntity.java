package com.example.crud2.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor

public class ClientesEntity {
    private UUID id;
    private String nombre;
    private String apellido
    private int edad;

    public ClientesEntity(UUID id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;

    }
}

