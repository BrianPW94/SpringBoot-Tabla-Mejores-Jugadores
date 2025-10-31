package com.ProyectoTablaJugadores.ProyectoTablaJugadores.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios.FutbolistaServicio;

@Controller
public class InicioControlador {

	@GetMapping("/")
	public String inicio() {
		return "index";
	}
}
