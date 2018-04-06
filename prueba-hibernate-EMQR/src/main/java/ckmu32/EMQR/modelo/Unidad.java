package ckmu32.EMQR.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UNIDAD")
public class Unidad implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String ID;
	
	@Column(name="NUMERO_SERIE_MOTOR")
	private String numeroSerieMotor;
	
	@Column(name="PLACAS")
	private String Placas;
	
	@Column(name="MODELO")
	private String Modelo;
	
	@Column(name="TIPO")
	private String Tipo;
	
	@Column(name="YEAR")//Se pone year para evitar poner "año".
	private int Year;
	
	public Unidad() {
		
	}

	public Unidad(String iD, String numeroSerieMotor, String placas, String modelo, String tipo, int year) {
		ID = iD;
		this.numeroSerieMotor = numeroSerieMotor;
		Placas = placas;
		Modelo = modelo;
		Tipo = tipo;
		Year = year;
	}
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNumeroSerieMotor() {
		return numeroSerieMotor;
	}

	public void setNumeroSerieMotor(String numeroSerieMotor) {
		this.numeroSerieMotor = numeroSerieMotor;
	}

	public String getPlacas() {
		return Placas;
	}

	public void setPlacas(String placas) {
		Placas = placas;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	@Override
	public String toString() {
		return "Unidad [ "+"ID: "+ID+" Número de serie de motor: "+numeroSerieMotor+" Placas: "+Placas+
				" Modelo: "+Modelo+" Tipo: "+Tipo+" Año: "+Year+" ]";
	}
	
}
