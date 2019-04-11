package com.hbt.semillero.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.Interfaces.IConsultasBeanLocal;

/**
 * Clase de servicios Tipo REST
 * @author camil
 *
 */
@Path("/ServiciosRest")
public class ServiciosRest {
	
	/**
	 * Bean de consultas
	 */
	@EJB
	private IConsultasBeanLocal consultasBean;
	
	
	/**
	 * servicio get para consultar marcas
	 * @return
	 */
	@GET
	@Path("/consultarMarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas(){
		List<Marca>  marcas = consultasBean.consultarMarcas();
		List<MarcaDTO> retorno = new ArrayList<>();
		for (Marca marca : marcas) {
			MarcaDTO marcaDTO = construirMarcaDTO(marca);
			retorno.add(marcaDTO);
		}
		return retorno;
	}
	
	/**
	 * servicio get para consultar lineas
	 * @param idMarca
	 * @return
	 */
	
	@GET
	@Path("/consultarLineas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLineas(@QueryParam(value = "idMarca") long idMarca){
		List<Linea> lineas = consultasBean.consultarLineas(idMarca);
		List<LineaDTO> retorno = new ArrayList<>();
		for (Linea linea : lineas) {
			LineaDTO  lineaDTO= new LineaDTO();
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setNombre(linea.getNombre());
			lineaDTO.setCilindraje(linea.getCilindraje());
			MarcaDTO marcaDTO = construirMarcaDTO(linea.getMarca());
			lineaDTO.setMarca(marcaDTO);
			retorno.add(lineaDTO);
		}
		return retorno;
	}
	
	/**
	 * servicio post para crear persona
	 * @param personaDTO
	 * @return
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.crearPersona(personaDTO);
		} catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensaje("No se pudo ingresar la persona");
		}
		
		return retorno;
	}
	
	/**
	 * constructor de marca
	 * @param marca
	 * @return
	 */
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setNombre(marca.getNombre());
		return marcaDTO;
	}
	
	/**
	 * constructor de persona
	 * @param persona
	 * @return
	 */
	private PersonaDTO construirPersonaDTO(Persona persona) {
		PersonaDTO personaDTO = new PersonaDTO();
		personaDTO.setNombres(persona.getNombres());
		personaDTO.setApellidos(persona.getApellidos());
		personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
		personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
		personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
		return personaDTO;
	}
	
	/**
	 * servicio get para consultar personas
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(){
		List<Persona> personas = consultasBean.consultarPersonas();
		List<PersonaDTO> retorno = new ArrayList<>();
		
		for (Persona persona : personas) {
			PersonaDTO personaDTO = construirPersonaDTO(persona);
			retorno.add(personaDTO);
		}
		return retorno;
	}
	
	/**
	 * servicio post para editar pesona
	 * @param personaDTO
	 * @return
	 */
	@POST
	@Path("/editarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO editarPersona(PersonaDTO personaDTO) {
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.editarPersona(personaDTO);
		} catch (Exception e) {
			retorno.setExitoso(false);
			retorno.setMensaje("No se pudo editar la persona");
		}
		
		return retorno;
	}
	
}
