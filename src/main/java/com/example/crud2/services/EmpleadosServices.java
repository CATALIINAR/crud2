package com.example.crud2.services;

import com.example.crud2.entities.EmpleadosEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class EmpleadosServices {
    private List<EmpleadosEntity> empleados;

    public EmpleadosServices() {
        empleados = new ArrayList<>();
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Carlos", "Florez", 25, "cajero"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Carlos", "Florez", 25, "cajero"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "María", "Gómez", 30, "supervisor"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Juan", "Pérez", 28, "vendedor"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Ana", "López", 32, "gerente"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Luis", "Ramírez", 24, "auxiliar"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Sofía", "Martínez", 29, "cajero"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "José", "Hernández", 26, "vendedor"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Elena", "Vargas", 35, "supervisor"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Andrés", "Ortiz", 27, "cajero"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Lucía", "Castro", 31, "gerente"));
        empleados.add(new EmpleadosEntity(UUID.randomUUID(), "Fernando", "Silva", 33, "auxiliar"));


    }
    public List<EmpleadosEntity> getAllEmpleados() {
        return empleados;
    }

    public Optional<EmpleadosEntity> getEmpleadosById(UUID id) {
        return empleados.stream().filter(empleados -> empleados.getId().equals(id)).findFirst();
    }

    public EmpleadosEntity createEmpleados(EmpleadosEntity empleados) {
        empleados.setId(UUID.randomUUID());
        empleados.add(empleados);
        return empleados;
    }
    public Optional<EmpleadosEntity> updateEmpleados(UUID id, EmpleadosEntity updatedEmpleados) {
        for (int i = 0; i < empleados.size(); i++) {
            EmpleadosEntity empleados = empleados.get(i);
            if (empleados.getId().equals(id)) {
                empleados.setId(id);
                empleados.set(i, updatedEmpleados);
                return Optional.of(updatedEmpleados);
            }
        }
        return Optional.empty();
    }

    public boolean deleteEmpleados(UUID id) {
        return empleados.removeIf(empleados -> empleados.getId().equals(id));
    }
}
