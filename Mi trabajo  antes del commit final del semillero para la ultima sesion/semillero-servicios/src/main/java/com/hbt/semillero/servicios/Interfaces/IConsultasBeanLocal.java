package com.hbt.semillero.servicios.Interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;

/**
 * Interfaz que permite la implementacion de los metodos para consultas
 */
@Local
public interface IConsultasBeanLocal {
	
	/**
	 * Permite consultar las Marcas
	 * @return lista de marcas
 	 */
	public List<Marca> consultarMarcas();
	/**
	 * Permite consultar las lineas
	 * @param idMarca busqueda por marca
	 * @return lista de lineas
	 */
	public List<Linea> consultarLineas(Long idMarca);
	/**
	 * Permite crear una persona
	 * @param personaDTO
	 */
	public void crearPersona(PersonaDTO personaDTO);
	/**
	 * Permite consultar las personas
	 * @return lista de personas
	 */
	public List<Persona> consultarPersonas();
	/**
	 * Permite editar una persona
	 * @param personaDTO
	 */
	public void editarPersona(PersonaDTO personaDTO);
}
