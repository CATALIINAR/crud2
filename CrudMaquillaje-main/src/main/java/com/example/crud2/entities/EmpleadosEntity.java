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

public class EmpleadosEntity {
    private UUID id;
    private String nombre;
    private String apellido
    private int edad;
    private  String cargo;

    public EmpleadosEntity(UUID id, String nombre, String apellido, int edad, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cargo = cargo;

    }
}
