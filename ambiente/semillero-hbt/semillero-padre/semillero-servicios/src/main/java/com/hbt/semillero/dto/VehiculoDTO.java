package com.hbt.semillero.dto;


import java.io.Serializable;

import com.hbt.semillero.entidades.Linea;

/**
 * Objeto de transferencia que mapea los atributos de la entidad Vehiculo
 * @author camil
 *
 */
public class VehiculoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * atributo id
	 */
	private Long idVehiculo;

	/**
	 * atributo modelo
	 */
	private int modelo;

	/**
	 * atributo placa
	 */
	private String placa;

	/**
	 * atributo linea
	 */
	private Linea linea;

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}


	
	
}
