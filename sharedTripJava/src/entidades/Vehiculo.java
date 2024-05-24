package entidades;

public class Vehiculo {
	int patente;
	int modelo;
	int anio;
	
	public int getPatente() {
		return patente;
	}
	public void setPatente(int patente) {
		this.patente = patente;
	}
	
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public Vehiculo(int patente, int modelo, int anio) {
		super();
		this.patente = patente;
		this.modelo = modelo;
		this.anio = anio;
	}
	
}
