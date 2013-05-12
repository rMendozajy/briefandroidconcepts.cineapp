package com.rgmj.beans;

import java.io.Serializable;

public class HorariosBean implements Serializable {
	
	/**
	 * Develop by Rubén Mendoza
	 */
	private static final long serialVersionUID = -1631604428491629759L;
	
	private int idHorario;
	private String comienzoHorario;
	private String finHorario;
	
	public HorariosBean(){
		
	}
	
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getComienzoHorario() {
		return comienzoHorario;
	}
	public void setComienzoHorario(String comienzoHorario) {
		this.comienzoHorario = comienzoHorario;
	}
	public String getFinHora() {
		return finHorario;
	}
	public void setFinHora(String finHorario) {
		this.finHorario = finHorario;
	}
	
	

}
