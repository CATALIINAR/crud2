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

public class SucursalesEntity {
    private UUID id;
    private String nombre;
    private String ciudad;
    private String direccion;

    public SucursalesEntity(UUID id, String nombre, String ciudad, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;

    }
}
