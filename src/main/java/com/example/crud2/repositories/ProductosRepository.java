package com.example.crud2.repositories;

import com.example.crud2.entities.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, UUID>{

}



