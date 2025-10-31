package com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Repo.EquipoRepo;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.Equipo;


@Service
public class EquipoServicio {

	@Autowired
	private EquipoRepo equipoRepo;
	
	//Servicios
	
	//guardar o agregar
	public Equipo guardarEquipo(Equipo equipo) {
		return equipoRepo.save(equipo);
	}
	//listar
	
	public List<Equipo> obtenerTodoslosEquipos()
	{
		return equipoRepo.findAll();
	}
	
	//obtener
	public Optional<Equipo>obtenerEquipo(Long id){
		return equipoRepo.findById(id);
	}
	
	//borrar
	
	public void BorrarEquipo(Long id) {
		equipoRepo.deleteById(id);
	}
	
	
}
