package com.ProyectoTablaJugadores.ProyectoTablaJugadores.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ProyectoTablaJugadores.ProyectoTablaJugadores.model.Futbolista;



public interface FutbolistaRepo extends JpaRepository <Futbolista, Long>{
	
	
	//QUERY CON LA LISTA DE JUGADORES CON NOMBRE PARA EQUIPOS Y PAISES
	
	@Query(value = """
		    SELECT 
		        f.id_futbolista AS id,
		        f.Nombre_Futbolista AS Nombre,
		        f.Apellido_Futbolista AS Apellido,
		        f.goles AS Goles,
		        f.asistencias AS Asistencias,
		        f.tarj_amarillas, 
		        f.tarj_rojas, 
		        f.partidos AS Partidos,
		        f.edad AS Edad,		       
		        pp.nombre_puesto as puesto,
		        e.Nombre_Equipo AS Equipo,
		        p.Nombre_Pais AS Pais,
		        sp.Nombre_Segundo_Pais AS SegundoPais,
		        p.codigo_pais AS codigoPais,
			  	sp.codigo_segundo_pais AS codigoSegundoPais
		    FROM Futbolistas f
		    LEFT JOIN Equipos e ON e.id_equipo = f.id_equipo
		    LEFT JOIN Paises p ON p.id_pais = f.id_pais
		    LEFT JOIN Segundo_Pais sp ON sp.id_segundo_pais = f.id_segundo_pais
		    left join puesto pp on f.id_puesto = pp.id_puesto 
		   
		    """, nativeQuery = true)
		List<Object[]> encontrarTodosLosFutbolistas();
		
		
	//QUERY CON EL SELECT ESPECIFICO PARA LOS GOLEADORES
	
	@Query(value = """
	       select 
	       f.nombre_futbolista, 
	       f.apellido_futbolista, 
	       f.goles, 
	       f.partidos, 
	       f.edad, 
	       pp.nombre_puesto as puesto,
	       e.nombre_equipo, 
	       p.nombre_pais , 
	       sp.nombre_segundo_pais,
	       p.codigo_pais AS codigoPais,
		   sp.codigo_segundo_pais AS codigoSegundoPais  
	       from futbolistas f 
	       left join equipos e on e.id_equipo = f.id_equipo 
left join paises p on p.id_pais = f.id_pais 
left join segundo_pais sp on sp.id_segundo_pais = f.id_segundo_pais 
left join puesto pp on f.id_puesto = pp.id_puesto 
WHERE f.goles > 0 
ORDER BY f.goles desc
	       """, nativeQuery = true)
    List<Object[]> Goleadores();
	    
	    

	
	
	//Asistidores
	    
	    
    @Query(value = """
 	       select 
 	       f.nombre_futbolista, 
 	       f.apellido_futbolista, 
 	       f.asistencias AS Asistencias,
 	       f.partidos, 
 	       f.edad, 
 	       pp.nombre_puesto as puesto,
 	       e.nombre_equipo, 
 	       p.nombre_pais, 
 	       sp.nombre_segundo_pais,
 	       p.codigo_pais AS codigoPais,
           sp.codigo_segundo_pais AS codigoSegundoPais
 	       from futbolistas f 
 	       left join equipos e on e.id_equipo = f.id_equipo 
 left join paises p on p.id_pais = f.id_pais 
 left join segundo_pais sp on sp.id_segundo_pais = f.id_segundo_pais 
 left join proyectotablajugadores.puesto pp on f.id_puesto = pp.id_puesto 
 WHERE f.asistencias > 0 
 ORDER BY f.asistencias desc
 	       """, nativeQuery = true)
List<Object[]> Asistidores();


//Amonestados

@Query(value = """
		select 
		f.nombre_futbolista, 
		f.apellido_futbolista, 
		pp.nombre_puesto as puesto,
		f.tarj_amarillas, 
		f.tarj_rojas, 
		(f.tarj_amarillas + f.tarj_rojas ) as Total_Tarjetas, 
		f.partidos, 
		f.edad, 
		e.nombre_equipo, 
		p.nombre_pais, 
		sp.nombre_segundo_pais,
		p.codigo_pais AS codigoPais,
        sp.codigo_segundo_pais AS codigoSegundoPais  
		from futbolistas f 
		left join equipos e on e.id_equipo = f.id_equipo 
		left join paises p on p.id_pais = f.id_pais 
		left join segundo_pais sp on sp.id_segundo_pais = f.id_segundo_pais 
		left join proyectotablajugadores.puesto pp on f.id_puesto = pp.id_puesto 
		where f.tarj_amarillas > 0 OR f.tarj_rojas > 0
		 ORDER BY total_tarjetas desc
		 """, nativeQuery = true)
List<Object[]> Amonestados();

//Arqueros

@Query(value = """

select f.nombre_futbolista, 
f.apellido_futbolista, 
f.edad, 
f.total_atajadas, 
f.partidos, 
ROUND(f.total_atajadas / f.partidos, 2)  as Tapadas_Partido, 
f.porteria_a_cero, 
round(f.porteria_a_cero /f.partidos, 2 ) as Porteria_A_Cero_Por_Cotejo, 
f.goles_en_contra, 
round(f.goles_en_contra / f.partidos, 2) as Goles_Encajados_Partido, 
f.penales_tapados, 
e.nombre_equipo, 
p.nombre_pais, 
sp.nombre_segundo_pais,
p.codigo_pais AS codigoPais,
sp.codigo_segundo_pais AS codigoSegundoPais  
from futbolistas f 
left join equipos e on e.id_equipo = f.id_equipo 
left join paises p on p.id_pais = f.id_pais 
left join segundo_pais sp on sp.id_segundo_pais = f.id_segundo_pais 
left join puesto pp on f.id_puesto = pp.id_puesto 
where pp.nombre_puesto  = 'Arquero'
order  by f.porteria_a_cero desc
 """, nativeQuery = true)
List<Object[]> Arqueros();
	
}