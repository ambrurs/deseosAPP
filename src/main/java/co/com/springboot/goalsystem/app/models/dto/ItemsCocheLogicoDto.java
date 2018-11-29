package co.com.springboot.goalsystem.app.models.dto;

import java.io.Serializable;

public class ItemsCocheLogicoDto implements Serializable {

	private Long cocheLogico;
	

	
	
	public ItemsCocheLogicoDto(Long cocheLogico) {
		super();
		this.cocheLogico = cocheLogico;
	}




	public Long getCocheLogico() {
		return cocheLogico;
	}




	public void setCocheLogico(Long cocheLogico) {
		this.cocheLogico = cocheLogico;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
