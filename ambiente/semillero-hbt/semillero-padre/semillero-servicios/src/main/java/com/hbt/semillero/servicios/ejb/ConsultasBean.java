package com.hbt.semillero.servicios.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.Interfaces.IConsultasBeanLocal;
/**
 * Clase Bean Que Permite hacer consultas en una sesison
 * @author camil
 *
 */
@Stateless
public class ConsultasBean implements IConsultasBeanLocal  {
	
	
	/**
	 *Manager de sesion
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Permite consultar las marcas
	 * @return lista de marcas
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {
		return entityManager.createQuery("select ma FROM Marca ma").getResultList();
	}
	/**
	 * permite consultar las lineas
	 * @param idMarca busca por marcas
	 * @return lista de lineas
	 */
	public List<Linea> consultarLineas(Long idMarca){
		return entityManager.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca")
				.setParameter("idMarca", idMarca).getResultList();
	}
	
	/**
	 * permte crear una persona
	 * @param atributos de persona
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		
		Persona persona = new Persona();
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.persist(persona);
		
		if (personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);
		}
		
		if (personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);
		}
		
	}
	
	/**
	 * permite editar una persona 
	 * @param atributos de persona  nueva
	 */
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void editarPersona(PersonaDTO personaDTO) {
		
		Persona persona = entityManager.find(Persona.class, personaDTO.getIdPersona());
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.merge(persona);
		
		if (personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.merge(comprador);
		}
		
		if (personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.merge(vendedor);
		}
		
	}
	
	/**
	 * permite consultar Personas
	 * @return lista de personas
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Persona> consultarPersonas() {
		return entityManager.createQuery("select pa FROM Persona pa").getResultList();
	}

}
