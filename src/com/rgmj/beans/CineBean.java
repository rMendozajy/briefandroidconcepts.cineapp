package com.rgmj.beans;

import java.io.Serializable;

public class CineBean implements Serializable {

	/**
	 * Develop by Rubén Mendoza
	 */
	private static final long serialVersionUID = 6877500696118860093L;
	private int idCine;
	private String nombreCine;
	private String descCine;
	private String direcCine;
	
	public CineBean(){
		
	}
	public int getIdCine() {
		return idCine;
	}
	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}
	public String getNombreCine() {
		return nombreCine;
	}
	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}
	public String getDescCine() {
		return descCine;
	}
	public void setDescCine(String descCine) {
		this.descCine = descCine;
	}
	public String getDirecCine() {
		return direcCine;
	}
	public void setDirecCine(String direcCine) {
		this.direcCine = direcCine;
	}
	
	
	
}
