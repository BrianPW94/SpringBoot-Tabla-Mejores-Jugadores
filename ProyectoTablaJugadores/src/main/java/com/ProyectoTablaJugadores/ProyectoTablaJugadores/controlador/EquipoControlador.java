package com.ProyectoTablaJugadores.ProyectoTablaJugadores.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios.EquipoServicio;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.Equipo;

@Controller
@RequestMapping("/equipos")
public class EquipoControlador {

	@Autowired
	private EquipoServicio equipoServicio;
	
	
	@GetMapping("/lista")
	public String listarEquipos(Model model) {
		
	
		model.addAttribute("equipos", equipoServicio.obtenerTodoslosEquipos());
		
		model.addAttribute("equipoAAgregar", new Equipo());
		
		return "equipos.html";
	}
	
	@PostMapping("/guardar")
	public String guardarEquipo(@ModelAttribute("equipoAAgregar")Equipo equipo, RedirectAttributes redirectAtts) {
		
		equipoServicio.guardarEquipo(equipo);
		redirectAtts.addFlashAttribute("guardadoCorrecto", "Equipo Guardado");
		
		
		return "redirect:/equipos/lista";
		
	}
	
	@GetMapping("/editar/{id}")
	public String Editar (@PathVariable Long id,  Model model) {
		
		Equipo equipo = equipoServicio.obtenerEquipo(id).orElseThrow(() -> new RuntimeException("No se encontró el equipo con ID: " + id));
		
		model.addAttribute("equipo", equipo);
		return "equipoPlanilla.html";
		
	}
	
		@PostMapping("/actualizar")
		public String actualizarEquipo(@ModelAttribute("equipo") Equipo equipo, 
		                               RedirectAttributes redirectAtts) {
		    equipoServicio.guardarEquipo(equipo); 
		    redirectAtts.addFlashAttribute("guardadoCorrecto", "Equipo actualizado correctamente");
		    return "redirect:/equipos/lista";
		
	}
		
		@GetMapping("/borrar/{id}")
		public String borrarEquipo(@PathVariable Long id, RedirectAttributes redirectAtts) {
		    equipoServicio.BorrarEquipo(id);
		    redirectAtts.addFlashAttribute("GuardadoCorrecto", "Equipo borrado correctamente");
		    return "redirect:/equipos/lista";
		}
}
