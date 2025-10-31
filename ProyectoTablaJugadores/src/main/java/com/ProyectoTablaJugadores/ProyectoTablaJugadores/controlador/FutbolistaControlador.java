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
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios.FutbolistaServicio;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios.PaisServicio;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios.PuestoServicio;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios.SegundoPaisServicio;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.Futbolista;

@Controller
@RequestMapping("/futbolistas")
public class FutbolistaControlador {

	//Todos los servicios necesarios pwara el select
	@Autowired
	private FutbolistaServicio futbolistaServicio;
	
	@Autowired
	private PaisServicio paisServicio;
		
	@Autowired
	private EquipoServicio equipoServicio;
	
	@Autowired
	private SegundoPaisServicio segundoPaisServicio;
	
	@Autowired
	private PuestoServicio puestoServicio;
	
	@GetMapping("/lista")
 public String listarFutbolistas(Model model) {
	 model.addAttribute("futbolistas", futbolistaServicio.obtenerTodosLosFutbolista());
	return"futbolista.html"; 
 }
	@GetMapping("/nuevo")
	public String nuevoFutbolista(Model model) {
		
		model.addAttribute("futbolista", new Futbolista());
		model.addAttribute("equipos", equipoServicio.obtenerTodoslosEquipos());
		
		model.addAttribute("paises", paisServicio.obtenerPaises());
		
		model.addAttribute("segundosPaises", segundoPaisServicio.obtenerSegundoPais());
		
		model.addAttribute("puestos", puestoServicio.obtenerPuesto());
		
		return "futbolistaPlanilla.html";
	}
	
	@PostMapping("/guardar")
	public String guardarFutbolista(@ModelAttribute("futbolistaAAgregar")Futbolista futbolista, RedirectAttributes redirectAtts) {
		
		futbolistaServicio.guardarFutbolista(futbolista);
		redirectAtts.addFlashAttribute("guardadoCorrecto", "Jugador guardado");
		return "redirect:/futbolistas/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String EditarFutbolista(@PathVariable Long id, Model model) {
		Futbolista futbolista = futbolistaServicio.obtenerFutbolista(id).orElseThrow(() -> new RuntimeException("No se encontró el futbolista con ID: " + id));
		
		model.addAttribute("futbolista" , futbolista);
		model.addAttribute("equipos", equipoServicio.obtenerTodoslosEquipos());
		model.addAttribute("paises", paisServicio.obtenerPaises());
		model.addAttribute("segundosPaises", segundoPaisServicio.obtenerSegundoPais());	
		model.addAttribute("puestos", puestoServicio.obtenerPuesto());
		return "futbolistaPlanilla.html";
	}
	
	@PostMapping("/actualizar")
	public String actualizarFutbolista(@ModelAttribute("futbolista")Futbolista futbolista, RedirectAttributes redirectAtts) {
		
		futbolistaServicio.guardarFutbolista(futbolista);
		redirectAtts.addFlashAttribute("guardadoCorrecto", "Futbolista actualizado correctamente");
		return "redirect:/futbolistas/lista";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrarFutbolista(@PathVariable Long id, RedirectAttributes redirectAtts) {
		futbolistaServicio.BorrarFutbolista(id);
		redirectAtts.addFlashAttribute("BorradoCorrecto", "Futbolista borrado correctamente");
		
		return "redirect:/futbolistas/lista";
	}
	
	//Goleadores
	@GetMapping("/goleadores")
	public String mostrarGoleadores(Model model) {
		model.addAttribute("goleadores", futbolistaServicio.mostrarGoleadores());
		
		return "goleadores.html";
	}
	
	@GetMapping("/asistidores")
	public String mostrarAsistidores(Model model) {
		model.addAttribute("asistidores", futbolistaServicio.mostrarAsistidores());
		
		return "asistidores.html";
	}
	
	@GetMapping("/amonestados")
	public String obtenerAmonestados(Model model) {
		model.addAttribute("amonestados", futbolistaServicio.obtenerAmonestados());
		
		return "amonestados.html";
	}
	
	@GetMapping("/arqueros")
	public String mostrarArqueros(Model model){
		model.addAttribute("arqueros", futbolistaServicio.obtenerArqueros());
		return "arqueros.html";
	}
}
