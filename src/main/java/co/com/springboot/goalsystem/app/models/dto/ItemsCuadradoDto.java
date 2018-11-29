package co.com.springboot.goalsystem.app.models.dto;

import java.io.Serializable;

public class ItemsCuadradoDto implements Serializable {
	
	
	Long codigoCuadrado;
	
	
	
	public ItemsCuadradoDto(Long codigoCuadrado) {
		super();
		this.codigoCuadrado = codigoCuadrado;
	}

	public ItemsCuadradoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getCodigoCuadrado() {
		return codigoCuadrado;
	}

	public void setCodigoCuadrado(Long codigoCuadrado) {
		this.codigoCuadrado = codigoCuadrado;
	}

	
	
}
