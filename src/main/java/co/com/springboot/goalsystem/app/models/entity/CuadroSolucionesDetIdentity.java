package co.com.springboot.goalsystem.app.models.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Clase encargada de representar la primary key de la tabla CUADROS_SOLUCIONES_DET
 * 
 * @author  Andres Marulanda
 * */

@Embeddable
public class CuadroSolucionesDetIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Variables que representan la primary key
	 * */
	
	@NotNull
	@Column(name="CODIGO_CUADRO")
	private Long codigoCuadro;
	@NotNull
	@Column(name="CODIGO_TRAYECTO")
	@Size(max=10)
	private String codigoTrayecto;
	@NotNull
	@Column(name="NUMERO_SOLUCION")
	private Integer numeroSolucion;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CODIGO_TIPO_EVENTO")
	private TiposEventos tiposEventos;
	@NotNull
	@Column(name="EVENTO")
	private Long evento;
	
	
	
	/* Constructores */
	
	public CuadroSolucionesDetIdentity(@NotNull @Size(max = 10) String codigoTrayecto, @NotNull Integer numeroSolucion,
			@NotNull TiposEventos tiposEventos, @NotNull Long evento) {
		super();
		this.codigoTrayecto = codigoTrayecto;
		this.numeroSolucion = numeroSolucion;
		this.tiposEventos = tiposEventos;
		this.evento = evento;
	}
	
	public CuadroSolucionesDetIdentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* Getter y Setters */
	
	public Long getCodigoCuadro() {
		return codigoCuadro;
	}
	public void setCodigoCuadro(Long codigoCuadro) {
		this.codigoCuadro = codigoCuadro;
	}
	public String getCodigoTrayecto() {
		return codigoTrayecto;
	}
	public void setCodigoTrayecto(String codigoTrayecto) {
		this.codigoTrayecto = codigoTrayecto;
	}
	public Integer getNumeroSolucion() {
		return numeroSolucion;
	}
	public void setNumeroSolucion(Integer numeroSolucion) {
		this.numeroSolucion = numeroSolucion;
	}
	public TiposEventos getTiposEventos() {
		return tiposEventos;
	}
	public void setTiposEventos(TiposEventos tiposEventos) {
		this.tiposEventos = tiposEventos;
	}
	public Long getEvento() {
		return evento;
	}
	public void setEvento(Long evento) {
		this.evento = evento;
	}
	
	
	
	
}
