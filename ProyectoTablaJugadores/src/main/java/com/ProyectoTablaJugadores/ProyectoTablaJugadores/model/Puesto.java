package com.ProyectoTablaJugadores.ProyectoTablaJugadores.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Puesto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_Puesto")
	private Long id;
	
	@Column(name = "Nombre_Puesto", length = 150)
	private String nombre;

	
	public Puesto() {
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
