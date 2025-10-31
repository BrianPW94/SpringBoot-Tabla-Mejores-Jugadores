package com.ProyectoTablaJugadores.ProyectoTablaJugadores.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name ="Futbolistas")
public class Futbolista {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_futbolista")
	private Long id;
	
	@Column (name = "Nombre_Futbolista", length = 200, nullable =  false)
	private String nombre;
	
	@Column (name = "Apellido_Futbolista", length = 200, nullable =  false)
	private String apellido;
	
	@Column (nullable =  false)
	private Integer edad;
	
	private Integer goles;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Puesto")
	private Puesto puesto;
	
	private Integer asistencias;
	
	@Column (name = "tarj_Amarillas")
	private Integer tarjetasAmarillas;
	
	@Column (name = "tarj_Rojas")
	private Integer tarjetasRojas;
	
	
	@Column (nullable =  false)
	private Integer partidos;
	
	//Solo arqueros
	@Column(name = "Total_Atajadas", nullable = true)
	private Integer totalAtajadas;
	
	@Column(name = "Porteria_A_Cero", nullable = true)
	private Integer porteriaACero;
	
	@Column(name = "Goles_En_Contra", nullable = true)
	private Integer golesEnContra;
	
	@Column(name = "Penales_Tapados", nullable = true)
	private Integer penalesTapados;
	//
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_equipo")
	private Equipo equipo;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais")
	private Pais pais;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_segundo_pais")
	private SegundoPais segundoPais;

	//CONSTRUCTOR
	public Futbolista() {
		
	}

	//METODOS
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public Integer getGoles() {
		return goles;
	}

	public void setGoles(Integer goles) {
		this.goles = goles;
	}

	public Integer getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Integer asistencias) {
		this.asistencias = asistencias;
	}

	public Integer getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	public void setTarjetasAmarillas(Integer tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	public Integer getTarjetasRojas() {
		return tarjetasRojas;
	}

	public void setTarjetasRojas(Integer tarjetasRojas) {
		this.tarjetasRojas = tarjetasRojas;
	}

	public Integer getPartidos() {
		return partidos;
	}

	public void setPartidos(Integer partidos) {
		this.partidos = partidos;
	}
	
	public Integer getTotalAtajadas() {
		return totalAtajadas;
	}

	public void setTotalAtajadas(Integer totalAtajadas) {
		this.totalAtajadas = totalAtajadas;
	}

	public Integer getPorteriaACero() {
		return porteriaACero;
	}

	public void setPorteriaACero(Integer porteriaACero) {
		this.porteriaACero = porteriaACero;
	}

	public Integer getGolesEnContra() {
		return golesEnContra;
	}

	public void setGolesEnContra(Integer golesEnContra) {
		this.golesEnContra = golesEnContra;
	}

	public Integer getPenalesTapados() {
		return penalesTapados;
	}

	public void setPenalesTapados(Integer penalesTapados) {
		this.penalesTapados = penalesTapados;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public SegundoPais getSegundoPais() {
		return segundoPais;
	}

	public void setSegundoPais(SegundoPais segundoPais) {
		this.segundoPais = segundoPais;
	}
	
	
	
}
