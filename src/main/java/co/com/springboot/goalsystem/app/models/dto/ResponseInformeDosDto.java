package co.com.springboot.goalsystem.app.models.dto;

import java.io.Serializable;

public class ResponseInformeDosDto implements Serializable {

	private Long cocheLogico;
	private Long kmsComercial;
	private Long kmsVacio;

	
	
	
	
	public ResponseInformeDosDto() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Long getCocheLogico() {
		return cocheLogico;
	}





	public void setCocheLogico(Long cocheLogico) {
		this.cocheLogico = cocheLogico;
	}





	public Long getKmsComercial() {
		return kmsComercial;
	}





	public void setKmsComercial(Long kmsComercial) {
		this.kmsComercial = kmsComercial;
	}





	public Long getKmsVacio() {
		return kmsVacio;
	}





	public void setKmsVacio(Long kmsVacio) {
		this.kmsVacio = kmsVacio;
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
