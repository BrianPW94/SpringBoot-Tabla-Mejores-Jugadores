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
@Table(name = "SegundoPais")
public class SegundoPais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_segundo_pais")
	private Long id;
	
	@Column(length = 2)
	private String codigoSegundoPais;
	
	@Column (name = "Nombre_Segundo_Pais", length = 200, nullable =  false)
	private String nombre;

	@OneToMany (mappedBy = "segundoPais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Futbolista>Futbolistas;
	
	
	public SegundoPais() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoSegundoPais() {
		return codigoSegundoPais;
	}


	public void setCodigoSegundoPais(String codigoSegundoPais) {
		this.codigoSegundoPais = codigoSegundoPais;
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
