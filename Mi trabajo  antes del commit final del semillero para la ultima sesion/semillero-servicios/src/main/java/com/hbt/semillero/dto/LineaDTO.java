package com.hbt.semillero.dto;


import java.io.Serializable;

import javax.ejb.Local;

import com.hbt.semillero.entidades.Marca;

@Local
public class LineaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idLinea;

	private String nombre;

	private int cilindraje;

	private MarcaDTO marca;

	public Long getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(Long idLinea) {
		this.idLinea = idLinea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	
	

}
