package com.example.crud2.services;

import com.example.crud2.entities.SucursalesEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service


public class SucursalesServices {
    private List<SucursalesEntity> sucursales;

    public SucursalesServices() {
        sucursales = new ArrayList<>();
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Bella Rosa", "Bogota", "Calle 26 N 67-32"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Bella Rosa", "Bogotá", "Calle 26 N 67-32"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Glamour Center", "Medellín", "Carrera 45 N 32-18"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Elegancia Total", "Cali", "Avenida 4 N 23-45"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Brillo y Belleza", "Barranquilla", "Calle 72 N 48-60"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Estilo Urbano", "Cartagena", "Calle del Arsenal N 10-40"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Centro Belleza", "Bucaramanga", "Carrera 27 N 52-20"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Look Perfecto", "Manizales", "Carrera 23 N 10-55"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Chic Belleza", "Pereira", "Avenida Circunvalar N 18-45"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Rosa Glam", "Santa Marta", "Carrera 5 N 24-30"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Divina Mujer", "Ibagué", "Calle 10 N 30-25"));
        sucursales.add(new SucursalesEntity(UUID.randomUUID(), "Fascinante", "Cúcuta", "Avenida Libertadores N 12-58"));

    }
    public List<SucursalesEntity> getAllSucursales() {
        return sucursales;
    }

    public Optional<SucursalesEntity> getSucursalesById(UUID id) {
        return sucursales.stream().filter(sucursales -> sucursales.getId().equals(id)).findFirst();
    }

    public SucursalesEntity createSucursales(SucursalesEntity sucursales) {
        sucursales.setId(UUID.randomUUID());
        sucursales.add(sucursales);
        return sucursales;
    }

    public Optional<SucursalesEntity> updateSucursales(UUID id, SucursalesEntity updatedsucursales) {
        for (int i = 0; i < sucursales.size(); i++) {
            SucursalesEntity sucursales = sucursales.get(i);
            if (sucursales.getId().equals(id)) {
                updateSucursales.setId(id);
                sucursales.set(i, updatedsucursales);
                return Optional.of(updateSucursales);
            }
        }
        return Optional.empty();
    }

    public boolean deletSucursales(UUID id) {
        return sucursales.removeIf(sucursales -> sucursales.getId().equals(id));
    }

}
