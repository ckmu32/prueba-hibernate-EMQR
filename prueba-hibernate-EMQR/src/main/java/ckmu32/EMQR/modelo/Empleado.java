package ckmu32.EMQR.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLEADO")
public class Empleado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CURP_EMPLEADO")
	private String CURP;
	
	@Column(name="NSS")
	private String NSS;
	
	@Column(name="NOMBRE")
	private String Nombre;

	@Column(name="APELLIDOS")
	private String Apellidos;
	
	@Column(name="RFC")
	private String RFC;
	
	@Column(name="GENERO")
	private String Genero;
	
	@Column(name="ENFERMEDADES")
	private String Enfermedades;
	
	@Column(name="ESTUDIOS")
	private String Estudios;
	
	@Column(name="FECHA_NACIMIENTO")
	private LocalDate fechaNacimiento;
	
	//BIDIRECCIONAL
	/*Relación bi direccional entre TAMP y EMPLEADO. Solo para pruebas. No se debe usar
	@OneToOne(mappedBy="empleado",fetch=FetchType.LAZY)
	private TAMP tamp;
	*/
	
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
	
	//BIDIRECCIONAL
	/*Relación bi direccional entre TAMP y EMPLEADO. Solo para pruebas
	public TAMP getTAMP(){
		return tamp;
	}
	
	public void setTAMP(TAMP tamp) {
		this.tamp=tamp;
	}

	@Override
	public String toString() {
		return "Empleado[ CURP: "+CURP+" NSS: "+NSS+" Nombre: "+Nombre+" Apellidos: "+Apellidos+
				" RFC: "+RFC+" Genero: "+Genero+" Enfermedades: "+Enfermedades+" Estudios: "+
				Estudios+" Fecha de nacimiento: "+fechaNacimiento+" TAMP: "+tamp.getID()+" ]";
	}
	*/
	
	//toString() normal.
	@Override
	public String toString() {
		return "Empleado[ CURP: "+CURP+" NSS: "+NSS+" Nombre: "+Nombre+" Apellidos: "+Apellidos+
				" RFC: "+RFC+" Genero: "+Genero+" Enfermedades: "+Enfermedades+" Estudios: "+
				Estudios+" Fecha de nacimiento: "+fechaNacimiento+" ]";
	}
}
