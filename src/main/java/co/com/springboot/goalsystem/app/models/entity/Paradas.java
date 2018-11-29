package co.com.springboot.goalsystem.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Clase encargada de representar la tabla PARADAS
 * 
 * autor: Andres Marulanda
 * */
@Entity
@Table(name="PARADAS")
public class Paradas implements Serializable {

	/* Variables de la clase */
	@Id
	@Column(name="CODIGO_PARADA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigoParada;
	@Column(name="DESCRIP_PARADA")
	private String descripParada;
	@Column(name="DESCRIP_PARADA_2")
	private String descripParada2;
	@Column(name="LATITUD_WGS84")
	private String latitud;
	@Column(name="LONGITUD_WGS84")
	private String longitud;
	
	@OneToMany(mappedBy="paradaOrigen")
	private List<CuadrosSolucionesDet> cuadroSolucionOri;
	@OneToMany(mappedBy="paradaDestino")
	private List<CuadrosSolucionesDet> cuadroSolucionFin;
	
	
	
	/* Constructores */
	
	public Paradas(String descripParada, String descripParada2, String latitud, String longitud) {
		super();
		this.descripParada = descripParada;
		this.descripParada2 = descripParada2;
		this.latitud = latitud;
		this.longitud = longitud;
	}





	public Paradas() {
		super();
		// TODO Auto-generated constructor stub
	}




	/* Getter y Setter */

	public Long getCodigoParada() {
		return codigoParada;
	}





	public void setCodigoParada(Long codigoParada) {
		this.codigoParada = codigoParada;
	}





	public String getDescripParada() {
		return descripParada;
	}





	public void setDescripParada(String descripParada) {
		this.descripParada = descripParada;
	}





	public String getDescripParada2() {
		return descripParada2;
	}





	public void setDescripParada2(String descripParada2) {
		this.descripParada2 = descripParada2;
	}





	public String getLatitud() {
		return latitud;
	}





	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}





	public String getLongitud() {
		return longitud;
	}





	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	




	public List<CuadrosSolucionesDet> getCuadroSolucionOri() {
		return cuadroSolucionOri;
	}





	public void setCuadroSolucionOri(List<CuadrosSolucionesDet> cuadroSolucionOri) {
		this.cuadroSolucionOri = cuadroSolucionOri;
	}





	public List<CuadrosSolucionesDet> getCuadroSolucionFin() {
		return cuadroSolucionFin;
	}





	public void setCuadroSolucionFin(List<CuadrosSolucionesDet> cuadroSolucionFin) {
		this.cuadroSolucionFin = cuadroSolucionFin;
	}






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
}
