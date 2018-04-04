package ckmu32.EMQR.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CURP")
	private String CURP;
	
	@Column(name="NSS")
	private String NSS;
	
	@Column(name="Nombre")
	private String Nombre;

	@Column(name="Apellidos")
	private String Apellidos;
	
	@Column(name="RFC")
	private String RFC;
	
	@Column(name="Genero")
	private String Genero;
	
	@Column(name="Enfermedades")
	private String Enfermedades;
	
	@Column(name="Estudios")
	private String Estudios;
	
	@Column(name="fechaNacimiento")
	private LocalDate fechaNacimiento;
	
	public Empleado() {
		
	}
	
	public Empleado(String cURP, String nSS, String nombre, String apellidos, String rFC, String genero,
			String enfermedades, String estudios, LocalDate fechaNacimiento) {
		CURP = cURP;
		NSS = nSS;
		Nombre = nombre;
		Apellidos = apellidos;
		RFC = rFC;
		Genero = genero;
		Enfermedades = enfermedades;
		Estudios = estudios;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCURP() {
		return CURP;
	}

	public void setCURP(String cURP) {
		CURP = cURP;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getEnfermedades() {
		return Enfermedades;
	}

	public void setEnfermedades(String enfermedades) {
		Enfermedades = enfermedades;
	}

	public String getEstudios() {
		return Estudios;
	}

	public void setEstudios(String estudios) {
		Estudios = estudios;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Empleado[ CURP: "+CURP+" NSS: "+NSS+" Nombre: "+Nombre+" Apellidos: "+Apellidos+
				" RFC: "+RFC+" Genero: "+Genero+" Enfermedades: "+Enfermedades+" Estudios: "+
				Estudios+" Fecha de nacimiento: "+fechaNacimiento+" ]";
	}
}
