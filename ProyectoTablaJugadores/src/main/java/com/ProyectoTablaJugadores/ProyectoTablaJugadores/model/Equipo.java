package com.ProyectoTablaJugadores.ProyectoTablaJugadores.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Equipos")
public class Equipo {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_equipo")
	private Long idEquipo;
	
	@Column (name = "Nombre_Equipo", length = 200, nullable =  false)
	private String nombreEquipo;
	
	@OneToMany (mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Futbolista>Futbolistas;
	
	
	//CONTRUCTOR
	public Equipo() {
		
	}

	
	//METODOS
	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public List<Futbolista> getFutbolistas() {
		return Futbolistas;
	}

	public void setFutbolistas(List<Futbolista> futbolistas) {
		Futbolistas = futbolistas;
	}

	
	
}
