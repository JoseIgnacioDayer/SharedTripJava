package entidades;

public class Vehiculo {
	private int patente;
	public String modelo;
	public int anio;
	public int usuario_duenio_id;
	
	public int getPatente() {
		return patente;
	}
	public void setPatente(int patente) {
		this.patente = patente;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getUsuario_duenio_id() {
		return usuario_duenio_id;
	}
	public void setUsuario_duenio_id(int usuario_duenio_id) {
		this.usuario_duenio_id = usuario_duenio_id;
	}
	
	public Vehiculo() {
		
	}
	
	public Vehiculo(int patente, String modelo, int anio, int usuario_duenio_id) {
		super();
		this.patente = patente;
		this.modelo = modelo;
		this.anio = anio;
		this.usuario_duenio_id = usuario_duenio_id;
	}
	
}
