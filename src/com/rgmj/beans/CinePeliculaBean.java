package com.rgmj.beans;

import java.io.Serializable;

public class CinePeliculaBean implements Serializable {

	/**
	 * Develop by Rubén Mendoza
	 */
	private static final long serialVersionUID = -7240364409995767176L;
	
	private int idcinePeli;
	private int idCine;
	private int idPelicula;
	
	public CinePeliculaBean(){
		
	}



	public int getIdcinePeli() {
		return idcinePeli;
	}



	public void setIdcinePeli(int idcinePeli) {
		this.idcinePeli = idcinePeli;
	}



	public int getIdCine() {
		return idCine;
	}



	public void setIdCine(int idCine) {
		this.idCine = idCine;
	}



	public int getIdPelicula() {
		return idPelicula;
	}



	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	

}
