package ckmu32.EMQR.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TAMP")
public class TAMP implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TAMP")
	private int ID;
	
	@Column(name="NIVEL")
	private String Nivel;
	
	@Column(name="CEDULA")
	private String Cedula;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="CURP_EMPLEADO")
	private Empleado empleado;
	
	public TAMP() {
		
	}
	
	public TAMP(int iD, String nivel, String cedula) {
		ID = iD;
		Nivel = nivel;
		Cedula = cedula;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNivel() {
		return Nivel;
	}

	public void setNivel(String nivel) {
		Nivel = nivel;
	}

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	@Override
	public String toString() {
		return "TAMP [ ID: "+ID+" Nivel: "+Nivel+" Cédula: "+Cedula+" Empleado: "+empleado+" ]";
	}
	
}
