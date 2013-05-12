package com.rgmj.beans;

import java.io.Serializable;

public class PeliculaBean  implements Serializable {	
		/**
	 * Develop by Rubén Mendoza
	 */
	private static final long serialVersionUID = -4517444864643117365L;
	
		private int idPelicula;
		private String nombrePelicula;
		private String generoPelicula;
		private String directorPelicula;
		private String descripcionPelicula;
		private int esCartelera;
		
		public PeliculaBean(){
			
		}
		
		public int getIdPelicula() {
			return idPelicula;
		}
		public void setIdPelicula(int idPelicula) {
			this.idPelicula = idPelicula;
		}
		public String getNombrePelicula() {
			return nombrePelicula;
		}
		public void setNombrePelicula(String nombrePelicula) {
			this.nombrePelicula = nombrePelicula;
		}
		public String getGeneroPelicula() {
			return generoPelicula;
		}
		public void setGeneroPelicula(String generoPelicula) {
			this.generoPelicula = generoPelicula;
		}
		public String getDirectorPelicula() {
			return directorPelicula;
		}
		public void setDirectorPelicula(String directorPelicula) {
			this.directorPelicula = directorPelicula;
		}
		public String getDescripcionPelicula() {
			return descripcionPelicula;
		}
		public void setDescripcionPelicula(String descripcionPelicula) {
			this.descripcionPelicula = descripcionPelicula;
		}

		public int getEsCartelera() {
			return esCartelera;
		}

		public void setEsCartelera(int esCartelera) {
			this.esCartelera = esCartelera;
		}
		
		
}
