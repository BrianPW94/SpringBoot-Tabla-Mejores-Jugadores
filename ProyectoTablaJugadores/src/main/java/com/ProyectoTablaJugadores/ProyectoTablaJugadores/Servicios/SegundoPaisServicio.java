package com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Repo.SegundoPaisRepo;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.SegundoPais;


@Service
public class SegundoPaisServicio {

	@Autowired
	private  SegundoPaisRepo segundoPaisRepo;

	//Servicios
	
	//listar
	public List<SegundoPais> obtenerSegundoPais(){
		
	return segundoPaisRepo.findAll();	
	
	}
	
	
}
