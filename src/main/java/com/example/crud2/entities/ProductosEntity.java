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

public class ProductosEntity {
    private UUID id;
    private String productosnombre;
    private String categoria;
    private double precio;
    private  int cantidad;

    public ProductosEntity(UUID id, String nombre, String categoria, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;

    }
}
