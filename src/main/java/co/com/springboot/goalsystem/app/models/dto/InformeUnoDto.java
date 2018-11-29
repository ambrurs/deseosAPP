package co.com.springboot.goalsystem.app.models.dto;

import java.io.Serializable;
import java.util.List;

/*
 * Clase encargada de diligenciar las paradas y horas de un coche logico para ser devueltas al apirest
 * */
public class InformeUnoDto implements Serializable {

	/* Variables de la clase*/
	private Long cocheLogico;
	private String paradaOrigen;
	private String paradaDestino;
	private String horaInicio;
	private String horaFin;
	private String duracion;


	
	/*Constructores*/

	public InformeUnoDto(Long cocheLogico, String paradaOrigen, String paradaDestino, String horaInicio, String horaFin, String duracion) {
		super();
		this.cocheLogico = cocheLogico;
		this.paradaOrigen = paradaOrigen;
		this.paradaDestino = paradaDestino;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = duracion;
	}




	public InformeUnoDto() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/* Getters y Setters */

	public Long getCocheLogico() {
		return cocheLogico;
	}




	public void setCocheLogico(Long cocheLogico) {
		this.cocheLogico = cocheLogico;
	}




	public String getParadaOrigen() {
		return paradaOrigen;
	}




	public void setParadaOrigen(String paradaOrigen) {
		this.paradaOrigen = paradaOrigen;
	}




	public String getParadaDestino() {
		return paradaDestino;
	}




	public void setParadaDestino(String paradaDestino) {
		this.paradaDestino = paradaDestino;
	}




	public String getHoraInicio() {
		return horaInicio;
	}




	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}




	public String getHoraFin() {
		return horaFin;
	}




	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public String getDuracion() {
		return duracion;
	}




	public void setDuracion(String duracion) {
		this.duracion = duracion;
	} 
	
	
	
}
