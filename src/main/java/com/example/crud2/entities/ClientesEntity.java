package com.example.crud2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

import jakarta.persistence.PrePersist;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClientesEntity {

    @Id
    private UUID id;
    private String clientesnombre;
    private String clientesapellido
    private int clientesedad;

    @PrePersist
	public void generateUUID() {
		if (id == null) {
			id = UUID.randomUUID();
		}
	}

}
