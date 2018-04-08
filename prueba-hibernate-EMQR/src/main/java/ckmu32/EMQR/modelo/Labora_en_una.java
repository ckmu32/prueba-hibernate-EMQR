package ckmu32.EMQR.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="LABORA_EN_UNA")
public class Labora_en_una implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Primary Key, ya que Hibernate ocupa una por cada Entity
	@Id
	@Column(name="FOLIO")
	private int Folio;
	
	@Column(name="FECHA_HORA_INICIO")
	private LocalDateTime fechaHoraInicio;
	
	@Column(name="FECHA_HORA_FIN")
	private LocalDateTime fechaHoraFin;
	
	/*Depende de que haya un TAMP creado. Primero se tiene el empleado y cuando se crea el labora se 
	 * relaciona con esta tabla*/ 
	@OneToOne()
	@JoinColumn(name="ID_TAMP")
	private TAMP tamp;
	
	@OneToOne
	@JoinColumn(name="ID_UNIDAD")
	private Unidad unidad;
	
	public Labora_en_una() {
		
	}

	public Labora_en_una(int folio, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
		Folio = folio;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
	}

	public int getFolio() {
		return Folio;
	}

	public void setFolio(int folio) {
		Folio = folio;
	}

	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public LocalDateTime getFechaHoraFin() {
		return fechaHoraFin;
	}

	public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}

	public TAMP getTamp() {
		return tamp;
	}

	public void setTamp(TAMP tamp) {
		this.tamp = tamp;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	@Override
	public String toString() {
		return "Labora en una [ Folio: "+Folio+" Fecha y hora de inicio: "+fechaHoraInicio+
				" Fecha y hora de término: "+fechaHoraFin+" TAMP: "+tamp+" Unidad: "+unidad+" ]";
	}

}
