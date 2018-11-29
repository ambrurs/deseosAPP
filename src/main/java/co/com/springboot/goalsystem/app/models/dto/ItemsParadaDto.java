package co.com.springboot.goalsystem.app.models.dto;

import java.io.Serializable;

public class ItemsParadaDto implements Serializable {

	private String descripcion;
	private Long idParada;

	

	public ItemsParadaDto(String descripcion, Long idParada) {
		super();
		this.descripcion = descripcion;
		this.idParada = idParada;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdParada() {
		return idParada;
	}

	public void setIdParada(Long idParada) {
		this.idParada = idParada;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
