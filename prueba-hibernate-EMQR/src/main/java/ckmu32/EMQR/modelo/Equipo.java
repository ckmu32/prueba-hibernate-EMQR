package ckmu32.EMQR.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	int ID;
	
	@Column(name="Nombre")
	String Nombre;
	
	@Column(name="tipoDeEquipo")
	String tipoDeEquipo;
	
	@Column(name="fechaDeCompra")
	LocalDate fechaDeCompra;
	
	public Equipo() {
		
	}

	public Equipo(int iD, String nombre, String tipoDeEquipo, LocalDate fechaDeCompra) {
		ID = iD;
		Nombre = nombre;
		this.tipoDeEquipo = tipoDeEquipo;
		this.fechaDeCompra = fechaDeCompra;
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

	public String getTipoDeEquipo() {
		return tipoDeEquipo;
	}

	public void setTipoDeEquipo(String tipoDeEquipo) {
		this.tipoDeEquipo = tipoDeEquipo;
	}

	public LocalDate getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(LocalDate fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}
	
	@Override
	public String toString() {
		return "Equipo [ "+" ID: "+ID+ " Nombre: "+Nombre+" Tipo de equipo: "+tipoDeEquipo+
				" Fecha de compra: "+fechaDeCompra+" ]";
	}
	
}
