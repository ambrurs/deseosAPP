package co.com.springboot.goalsystem.app.models.dto;

import java.io.Serializable;

public class KmsDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long distancia;

	
	
	
	public KmsDto(Long distancia) {
		super();
		this.distancia = distancia;
	}

	public KmsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDuracion() {
		return distancia;
	}

	public void setDuracion(Long distancia) {
		this.distancia = distancia;
	}
	
	
	
	

}
