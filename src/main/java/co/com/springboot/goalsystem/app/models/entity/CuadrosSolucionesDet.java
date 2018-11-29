package co.com.springboot.goalsystem.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/*
 * Clase encargada de representar la tabla CUADROS_SOLUCIONES_DET
 * 
 * @author  Andres Marulanda
 * */
@Entity
@Table(name="CUADROS_SOLUCIONES_DET")
public class CuadrosSolucionesDet implements Serializable {

	
	/* Primary key */
	@EmbeddedId
	CuadroSolucionesDetIdentity cuadroSolucionesDetIdentity;
	
	/* Variables de la clase */

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARADA_ORIGEN")
	private Paradas paradaOrigen;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARADA_DESTINO")
	private Paradas paradaDestino;
	
	@Column(name="COCHE_LOGICO")
	private Long cocheLogico;
	
	
	@Column(name="TURNO_SERVICIO")
	private Long numeroServicio;
	
	@Column(name="PORCENTAJE_OCUPACION")
	private Integer porcentajeOcupacion;
	
	@Column(name="HORA_INICIO")
	private String horaInicio;
	
	@Column(name="HORA_FIN")
	@Size(max=9)
	private String horaFin;
	
	@Column(name="SENTIDO")
	@Size(max=9)
	private Integer sentido;
	
	@Column(name="KMS")
	private Long kms;
	
	@Column(name="CODIGO_TIPO_BUS")
	private Long codigoTipoBus;
	
	@Column(name="COCHE_INFORMES")
	private Long cocheInformes;
	
	@Column(name="DESCRIP_CAMINO")
	@Size(max=200)
	private String descipCamino;
	
	@Column(name="BUS_EMT")
	private Long busEmt;
	
	@Column(name="DURACION")
	@Size(max=9)
	private String duracion;
	
	@Column(name="FRECUENCIA")
	@Size(max=9)
	private String frecuencia;
	
	@Column(name="VIAJE_ACUM")
	private Long viajeAcum;
	
	@Column(name="TRAMO")
	private Long tramo;
	
	@Column(name="CODIGO_TIPO_TURNO")
	private Long codigoTipoTurno;
	
	@Column(name="DESCRIPCION_EVENTO")
	@Size(max = 50)
	private String descripcionEvento;
	
	@Column(name="CODIGO_TIPO_VIAJE")
	private Long codigoTipoViaje;
	
	@Column(name="CODIGO_OPERADOR")
	private Long codigoOperador;
	
	@Column(name="CODIGO_SUBTIPO_EVENTO")
	private Integer codigoSubTipoEvento;
	
	
	


	
	/* Constructores */

	public CuadrosSolucionesDet(CuadroSolucionesDetIdentity cuadroSolucionesDetIdentity, Paradas paradaOrigen,
			Paradas paradaDestino, Long cocheLogico, Long numeroServicio, Integer porcentajeOcupacion, String horaInicio,
			@Size(max = 9) String horaFin, @Size(max = 9) Integer sentido, Long kms, Long codigoTipoBus,
			Long cocheInformes, @Size(max = 200) String descipCamino, Long busEmt, @Size(max = 9) String duracion,
			@Size(max = 9) String frecuencia, Long viajeAcum, Long tramo, Long codigoTipoTurno,
			@Size(max = 50) String descripcionEvento, Long codigoTipoViaje, Long codigoOperador,
			Integer codigoSubTipoEvento) {
		super();
		this.cuadroSolucionesDetIdentity = cuadroSolucionesDetIdentity;
		this.paradaOrigen = paradaOrigen;
		this.paradaDestino = paradaDestino;
		this.cocheLogico = cocheLogico;
		this.numeroServicio = numeroServicio;
		this.porcentajeOcupacion = porcentajeOcupacion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.sentido = sentido;
		this.kms = kms;
		this.codigoTipoBus = codigoTipoBus;
		this.cocheInformes = cocheInformes;
		this.descipCamino = descipCamino;
		this.busEmt = busEmt;
		this.duracion = duracion;
		this.frecuencia = frecuencia;
		this.viajeAcum = viajeAcum;
		this.tramo = tramo;
		this.codigoTipoTurno = codigoTipoTurno;
		this.descripcionEvento = descripcionEvento;
		this.codigoTipoViaje = codigoTipoViaje;
		this.codigoOperador = codigoOperador;
		this.codigoSubTipoEvento = codigoSubTipoEvento;
	}






	public CuadrosSolucionesDet(CuadroSolucionesDetIdentity cuadroSolucionesDetIdentity) {
		super();
		this.cuadroSolucionesDetIdentity = cuadroSolucionesDetIdentity;
	}






	public CuadrosSolucionesDet() {
		super();
		// TODO Auto-generated constructor stub
	}




	/* Getter y Setter */

	public CuadroSolucionesDetIdentity getCuadroSolucionesDetIdentity() {
		return cuadroSolucionesDetIdentity;
	}






	public void setCuadroSolucionesDetIdentity(CuadroSolucionesDetIdentity cuadroSolucionesDetIdentity) {
		this.cuadroSolucionesDetIdentity = cuadroSolucionesDetIdentity;
	}

	public Long getCocheLogico() {
		return cocheLogico;
	}






	public void setCocheLogico(Long cocheLogico) {
		this.cocheLogico = cocheLogico;
	}






	public Long getNumeroServicio() {
		return numeroServicio;
	}






	public void setNumeroServicio(Long numeroServicio) {
		this.numeroServicio = numeroServicio;
	}






	public Integer getPorcentajeOcupacion() {
		return porcentajeOcupacion;
	}






	public void setPorcentajeOcupacion(Integer porcentajeOcupacion) {
		this.porcentajeOcupacion = porcentajeOcupacion;
	}






	public String getHoraInicio() {
		return horaInicio;
	}






	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}






	public String getHoraFin() {
		return horaFin;
	}






	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}






	public Integer getSentido() {
		return sentido;
	}






	public void setSentido(Integer sentido) {
		this.sentido = sentido;
	}






	public Long getKms() {
		return kms;
	}






	public void setKms(Long kms) {
		this.kms = kms;
	}






	public Long getCodigoTipoBus() {
		return codigoTipoBus;
	}






	public void setCodigoTipoBus(Long codigoTipoBus) {
		this.codigoTipoBus = codigoTipoBus;
	}






	public Long getCocheInformes() {
		return cocheInformes;
	}






	public void setCocheInformes(Long cocheInformes) {
		this.cocheInformes = cocheInformes;
	}






	public String getDescipCamino() {
		return descipCamino;
	}






	public void setDescipCamino(String descipCamino) {
		this.descipCamino = descipCamino;
	}






	public Long getBusEmt() {
		return busEmt;
	}






	public void setBusEmt(Long busEmt) {
		this.busEmt = busEmt;
	}






	public String getDuracion() {
		return duracion;
	}






	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}






	public String getFrecuencia() {
		return frecuencia;
	}






	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}






	public Long getViajeAcum() {
		return viajeAcum;
	}






	public void setViajeAcum(Long viajeAcum) {
		this.viajeAcum = viajeAcum;
	}






	public Long getTramo() {
		return tramo;
	}






	public void setTramo(Long tramo) {
		this.tramo = tramo;
	}






	public Long getCodigoTipoTurno() {
		return codigoTipoTurno;
	}






	public void setCodigoTipoTurno(Long codigoTipoTurno) {
		this.codigoTipoTurno = codigoTipoTurno;
	}






	public String getDescripcionEvento() {
		return descripcionEvento;
	}






	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}






	public Long getCodigoTipoViaje() {
		return codigoTipoViaje;
	}






	public void setCodigoTipoViaje(Long codigoTipoViaje) {
		this.codigoTipoViaje = codigoTipoViaje;
	}






	public Long getCodigoOperador() {
		return codigoOperador;
	}






	public void setCodigoOperador(Long codigoOperador) {
		this.codigoOperador = codigoOperador;
	}






	public Integer getCodigoSubTipoEvento() {
		return codigoSubTipoEvento;
	}






	public void setCodigoSubTipoEvento(Integer codigoSubTipoEvento) {
		this.codigoSubTipoEvento = codigoSubTipoEvento;
	}



	


	public Paradas getParadaOrigen() {
		return paradaOrigen;
	}






	public void setParadaOrigen(Paradas paradaOrigen) {
		this.paradaOrigen = paradaOrigen;
	}






	public Paradas getParadaDestino() {
		return paradaDestino;
	}






	public void setParadaDestino(Paradas paradaDestino) {
		this.paradaDestino = paradaDestino;
	}






	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
}
