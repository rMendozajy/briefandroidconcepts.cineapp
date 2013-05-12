package com.rgmj.beans;

import java.io.Serializable;

public class HorarioCinePBean implements Serializable {

	/**
	 * Develop by Rubén Mendoza
	 */
	private static final long serialVersionUID = -378133375111551555L;
	
	private int idHoracp;
	private int idHorario;
	private int idcinePeli;
	
	public HorarioCinePBean(){
		
	}
	
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public int getIdHoracp() {
		return idHoracp;
	}

	public void setIdHoracp(int idHoracp) {
		this.idHoracp = idHoracp;
	}

	public int getIdcinePeli() {
		return idcinePeli;
	}

	public void setIdcinePeli(int idcinePeli) {
		this.idcinePeli = idcinePeli;
	}
	
	
}
