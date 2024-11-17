package com.example.crud2.entities;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class ProductosEntity {

    @Id
    private UUID id;
    private String productosnombre;
    private String productoscategoria;
    private double productosprecio;
    private  int productoscantidad;

    @PrePersist
	public void generateUUID() {
		if (id == null) {
			id = UUID.randomUUID();
		}
	}


}
