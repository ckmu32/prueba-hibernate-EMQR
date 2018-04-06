package ckmu32.EMQR.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEDICAMENTO")
public class Medicamento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private int ID;
	
	@Column(name="NOMBRE")
	private String Nombre;
	
	@Column(name="CADUCIDAD")
	private LocalDate Caducidad;
	
	@Column(name="CANTIDAD")
	private String Cantidad;
	
	@Column(name="TIPO_DE_APLICACION")
	private String tipoDeAplicacion;

	public Medicamento() {
		
	}
	
	public Medicamento(int iD, String nombre, LocalDate caducidad, String cantidad, String tipoDeAplicacion) {
		ID = iD;
		Nombre = nombre;
		Caducidad = caducidad;
		Cantidad = cantidad;
		this.tipoDeAplicacion = tipoDeAplicacion;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public LocalDate getCaducidad() {
		return Caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		Caducidad = caducidad;
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public String getTipoDeAplicacion() {
		return tipoDeAplicacion;
	}

	public void setTipoDeAplicacion(String tipoDeAplicacion) {
		this.tipoDeAplicacion = tipoDeAplicacion;
	}
	
	@Override
	public String toString() {
		return "Medicamento [ ID: "+ID+" Nombre: "+Nombre+" Caducidad: "+Caducidad+" Cantidad: "+Cantidad+
				" Tipo de aplicación: "+tipoDeAplicacion+" ]";
		
	}
	
}
