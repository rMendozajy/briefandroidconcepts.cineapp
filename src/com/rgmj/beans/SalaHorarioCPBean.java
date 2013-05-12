package com.rgmj.beans;

import java.io.Serializable;

public class SalaHorarioCPBean implements Serializable{

	/**
	 * 	Develop by Rubén Mendoza
	 */
	private static final long serialVersionUID = -7095973992493627488L;
	
	private int idSalahcp;
	private int idHoracp;
	private int idSala;
	
	public SalaHorarioCPBean (){
		
	}

	public int getIdSalahcp() {
		return idSalahcp;
	}

	public void setIdSalahcp(int idSalahcp) {
		this.idSalahcp = idSalahcp;
	}

	public int getIdHoracp() {
		return idHoracp;
	}

	public void setIdHoracp(int idHoracp) {
		this.idHoracp = idHoracp;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
	
}
