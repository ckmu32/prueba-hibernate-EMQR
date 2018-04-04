package ckmu32.EMQR.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medicamento")
public class Medicamento implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	int ID;
	
	@Column(name="Nombre")
	String Nombre;
	
	@Column(name="Caducidad")
	LocalDate Caducidad;
	
	@Column(name="Cantidad")
	String Cantidad;
	
	@Column(name="tipoDeAplicacion")
	String tipoDeAplicacion;

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
