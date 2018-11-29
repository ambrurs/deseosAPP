package co.com.springboot.goalsystem.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Clase encargada de representar la tabla TIPOS_EVENTOS
 * Autor : Andres Marulanda
 * */
@Entity
@Table(name="TIPOS_EVENTOS")
public class TiposEventos implements Serializable {
	
	/* Variables de la clase */
	@Id
	@Column(name="CODIGO_TIPO_EVENTO")
	private Integer codigoTipoEvento;
	@Column(name="DESCRIPCION")
	private String descripcion;
	@Column(name="DESCRIP_CORTA")
	private String descipCorta;
	
	@OneToMany(mappedBy="cuadroSolucionesDetIdentity.codigoTrayecto")
	private List<CuadrosSolucionesDet> cuadroSolucionesDet;
	
	/* Constructores*/
	
	public TiposEventos(String descripcion, String descipCorta) {
		super();
		this.descripcion = descripcion;
		this.descipCorta = descipCorta;
	}




	public TiposEventos() {
		super();
		// TODO Auto-generated constructor stub
	}


	/*Getters y Setters*/

	public Integer getCodigoTipoEvento() {
		return codigoTipoEvento;
	}




	public void setCodigoTipoEvento(Integer codigoTipoEvento) {
		this.codigoTipoEvento = codigoTipoEvento;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getDescipCorta() {
		return descipCorta;
	}




	public void setDescipCorta(String descipCorta) {
		this.descipCorta = descipCorta;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
}
