package com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Repo.PaisRepo;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.Pais;


@Service
public class PaisServicio {

	@Autowired
	private PaisRepo paisRepo;

	//Servicios
	
	
	//listar 
	
	//Solo es para en un select tener la lista completa con los paises No es necesario otro metodos pues no se va a agregar ni borrar

	
public List<Pais> obtenerPaises(){
	return paisRepo.findAll();
}
	

}
