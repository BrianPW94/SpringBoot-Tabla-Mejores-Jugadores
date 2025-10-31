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
@Table (name = "Paises")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_pais")
	private Long id;
	
	@Column(name = "codigo_Pais", length = 2)
	private String codigoPais;
	
	@Column (name = "Nombre_Pais", length = 200, nullable =  false)
	private String nombre;

	@OneToMany (mappedBy = "pais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Futbolista>Futbolistas;
	public Pais() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getCodigoPais() {
		return codigoPais;
	}


	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Futbolista> getFutbolista() {
		return Futbolistas;
	}


	public void setFutbolista(List<Futbolista> futbolista) {
		Futbolistas = futbolista;
	}
	
	
	
	
}
