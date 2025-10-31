package com.ProyectoTablaJugadores.ProyectoTablaJugadores.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.Repo.FutbolistaRepo;
import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.Futbolista;


@Service
public class FutbolistaServicio {

	@Autowired
private FutbolistaRepo futbolistaRepo;

	//Servicios
	
	
	//Guardar o agregar
	public Futbolista guardarFutbolista(Futbolista futbolista) {
		return futbolistaRepo.save(futbolista);
	}
	
	
	//listar Se hace con el query sql que se puso en el repo pues se va a mostrar paises y equipos con su respectivo nombre
	public List<Object[]> obtenerTodosLosFutbolista(){
	return futbolistaRepo.encontrarTodosLosFutbolistas();	
	}
	
	
	//obtener
	
	public Optional<Futbolista>obtenerFutbolista(Long id){
		return futbolistaRepo.findById(id);
	}
	
	
	//borrar
	
	public void BorrarFutbolista(Long id) {
		futbolistaRepo.deleteById(id);
	}
	
	//ENCONTRAR GOLEADORES No se hace un servicio nuevo pues los goleadores se muestran en base a la lista e jugadores
	
//se usa el metodo con el query puesto en el repo
	public List<Object[]> mostrarGoleadores(){
		return futbolistaRepo.Goleadores();
	}
	
	public List<Object[]> mostrarAsistidores(){
		return futbolistaRepo.Asistidores();
	}
	
	public List<Object[]> obtenerAmonestados(){
		return futbolistaRepo.Amonestados();
	}
	
	public List<Object[]> obtenerArqueros(){
		return futbolistaRepo.Arqueros();
	}
}
