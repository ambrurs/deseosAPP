package co.com.springboot.goalsystem.app.models.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clase encargada de retornar la información del reporte uno al apirest
 * */
public class ResponseInformeUnoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Variables de la clase
	 * */
	private List<InformeUnoDto> informeUnoDto;
	private String duracionTotal;
	
	
	/**
	 * Constructor
	 * */
	
	public ResponseInformeUnoDto(List<InformeUnoDto> informeUnoDto, String duracionTotal) {
		super();
		this.informeUnoDto = informeUnoDto;
		this.duracionTotal = duracionTotal;
	}
	
	
	
	public ResponseInformeUnoDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	/*Getters y Setters */

	public List<InformeUnoDto> getInformeUnoDto() {
		return informeUnoDto;
	}
	public void setInformeUnoDto(List<InformeUnoDto> informeUnoDto) {
		this.informeUnoDto = informeUnoDto;
	}
	public String getDuracionTotal() {
		return duracionTotal;
	}
	public void setDuracionTotal(String duracionTotal) {
		this.duracionTotal = duracionTotal;
	}
	
	
	
	
}
