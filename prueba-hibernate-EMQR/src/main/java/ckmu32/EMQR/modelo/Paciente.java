package ckmu32.EMQR.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Nombre")
	String Nombre;
	
	@Column(name="Genero")
	String Genero;
	
	@Column(name="Edad")
	int Edad;
	
	public Paciente() {
		
	}

	public Paciente(String nombre, String genero, int edad) {
		Nombre = nombre;
		Genero = genero;
		Edad = edad;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}
	
	@Override
	public String toString() {
		return "Paciente [ "+" Nombre: "+Nombre+" Género: "+Genero+" Edad: "+Edad+" ]";
	}

}
