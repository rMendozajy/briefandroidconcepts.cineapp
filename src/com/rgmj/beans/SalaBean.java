package com.rgmj.beans;

import java.io.Serializable;

public class SalaBean implements Serializable {
	/**
	 * Develop by Rubén Mendoza
	 */
	private static final long serialVersionUID = 2369150217013831298L;
	
	private int idSala;
	private String nomSala;
	
	public SalaBean(){
		
	}
	
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public String getNomSala() {
		return nomSala;
	}
	public void setNomSala(String nomSala) {
		this.nomSala = nomSala;
	}
	
}
