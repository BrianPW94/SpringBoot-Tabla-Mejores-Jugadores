package com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Repo.PuestoRepo;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.Puesto;

@Service
public class PuestoServicio {

	@Autowired
	private PuestoRepo puestoRepo;
	
	public List<Puesto> obtenerPuesto(){
		return puestoRepo.findAll();
	}
}
