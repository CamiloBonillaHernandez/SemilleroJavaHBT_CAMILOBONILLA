package com.hbt.semillero.servicios.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;

@Stateless
public class ConsultasBean {
	
	
	/**
	 *
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {
		return entityManager.createQuery("select ma FROM Marca ma").getResultList();
	}
	/**
	 * 
	 * @param idMarca
	 * @return
	 */
	public List<Linea> consultarLineas(Long idMarca){
		return entityManager.createQuery("select ln FROM Linea ln where ln.marca.idLinea =:ID_LINEA")
				.setParameter("ID_LINEA", idMarca).getResultList();
	}

}
