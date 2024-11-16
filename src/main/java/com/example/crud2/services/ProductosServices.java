package com.example.crud2.services;

import com.example.crud2.entities.ClientesEntity;
import com.example.crud2.entities.ProductosEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class ProductosServices {
    private List<ProductosEntity> productos;

    public ProductosServices() {
        productos = new ArrayList<>();
        productos.add(new ProductosEntity(UUID.randomUUID(), "Pestañina", "facial", 10.500,15));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Pestañina", "facial", 10_500, 15));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Labial", "labios", 8_200, 20));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Base líquida", "facial", 25_000, 10));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Rubor", "facial", 12_000, 18));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Delineador", "ojos", 9_500, 25));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Corrector", "facial", 15_300, 12));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Sombras", "ojos", 30_000, 8));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Iluminador", "facial", 20_000, 10));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Polvo compacto", "facial", 18_500, 14));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Brillo labial", "labios", 7_800, 30));
        productos.add(new ProductosEntity(UUID.randomUUID(), "Spray fijador", "facial", 22_000, 9));


    }
    public List<ProductosEntity> getAllProductos() {
        return productos;
    }

    public Optional<ProductosEntity> getProductosById(UUID id) {
        return productos.stream().filter(productos -> productos.getId().equals(id)).findFirst();
    }

    public ProductosEntity createProductos(ProductosEntity productos) {
        productos.setId(UUID.randomUUID());
        productos.add(productos);
        return productos;
    }
    public Optional<ProductosEntity> updateProductos(UUID id, ProductosEntity updatedproductos) {
        for (int i = 0; i < productos.size(); i++) {
            ProductosEntity productos = productos.get(i);
            if (productos.getId().equals(id)) {
                updatedproductos.setId(id);
                productos.set(i, updatedproductos);
                return Optional.of(updatedproductos);
            }
        }
        return Optional.empty();
    }

    public boolean deleteProductos(UUID id) {
        return productos.removeIf(productos -> productos.getId().equals(id));
    }

}
