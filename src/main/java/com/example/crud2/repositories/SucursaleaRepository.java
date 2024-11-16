package com.example.crud2.repositories;

import com.example.crud2.entities.SucursalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SucursaleaRepository extends JpaRepository<SucursalesEntity, UUID>{

}

