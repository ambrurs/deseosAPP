package co.com.springboot.goalsystem.app.models.util;

public class CustomErrorMsg {

	private String mensajeError;

	
	
	public CustomErrorMsg(String mensajeError) {
		super();
		this.mensajeError = mensajeError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
}
