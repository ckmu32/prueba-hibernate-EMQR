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
@Table(name="ADMINISTRATIVO")
public class Administrativo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_ADMINISTRATIVO")
	private int ID;
	
	@Column(name="AREA")
	private String Area;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="CURP_EMPLEADO")
	private Empleado empleado;
	
	public Administrativo() {
		
	}

	public Administrativo(int iD, String area) {
		ID = iD;
		Area = area;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	@Override
	public String toString() {
		return "Administrativo [ ID: "+ID+" Área: "+Area+" Empleado: "+empleado+" ]";
	}

}
