package co.com.springboot.goalsystem.app.models.util;

import java.io.Serializable;

/**
 * Clase utilitaria empleada paara realizar el caltulo total de un listado de duraciones
 * */
public class DuracionTotalUtil implements Serializable{

	
	private Long hora;
	
	private Long minuto;
	
	private Long segundo;
	
	/*Metodo encargado de realizar la sumatoria de los segundos*/
	public void sumarSegundos(Long segundo) {
		if(segundo != null) {
			
			this.segundo = this.segundo + segundo;
			
			while(this.segundo >= 60) {
				sumarMinutoPorSegundo();
				this.segundo = this.segundo - 60;
			}			
			
		}
		
	}
	
	/*Metodo encargado de realizar la sumatoria de los minutos*/
	public void sumarMinutos(Long minutos) {
		if(minutos != null) {
			this.minuto = this.minuto + minutos;
			
			while(this.minuto >= 60) {
				sumarHoraPorMinuto();
			}
			
		}
	}
	
	/*Metodo encargado de realizar la sumatoria de las horas*/
	public void sumarHora(Long hora) {
		this.hora = this.hora + hora;
	}
	
	/*Metodo encargado de retornar el valor del segundo en valor String*/
	public String getSegundoString() {
		
		if(segundo.toString().length() == 2) {
			return segundo.toString();
		}
		
		return segundo.toString().concat("0");
	}
	
	/*Metodo encargado de retornar el valor del tiempo en valor String*/
	private String setDuracion(Long tiempo) {
		if(tiempo.toString().length() == 2) {
			return tiempo.toString();
		}
		
		return "0".concat(tiempo.toString());
		
	}
	
	/*Metodo encargado de retornar el valor de la duración total  en valor String*/
	public String getDuracionTotal() {
		return setDuracion(this.hora).concat(":").
				concat(setDuracion(this.minuto).concat(":")).
				concat(setDuracion(this.segundo).concat(":"));
	}
	
	/* Metodo encargado de sumar minutos y horas cuando el segundo supera los 60s */
	private void sumarMinutoPorSegundo() {
		this.minuto = this.minuto +1;
		if(this.minuto >= 60) {						
			sumarHoraPorMinuto();
		}
	}
	/* Metodo encargado de sumar minutos y horas cuando el minuto supera los 60min */
	
	private void sumarHoraPorMinuto() {
		this.minuto = this.minuto-60;
		this.hora = this.hora+1;
	}
	
	/*Constructor*/
	
	
	public DuracionTotalUtil() {
		super();
		this.hora = 0L;
		this.minuto = 0L;
		this.segundo = 0L;
		
		// TODO Auto-generated constructor stub
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/*Get and setters*/


	public Long getHora() {
		return hora;
	}





	public void setHora(Long hora) {
		this.hora = hora;
	}





	public Long getMinuto() {
		return minuto;
	}





	public void setMinuto(Long minuto) {
		this.minuto = minuto;
	}





	public Long getSegundo() {
		return segundo;
	}





	public void setSegundo(Long segundo) {
		this.segundo = segundo;
	}

	
	
	
}
