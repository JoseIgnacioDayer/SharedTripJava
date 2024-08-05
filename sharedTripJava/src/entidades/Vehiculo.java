package entidades;

public class Vehiculo {
	private int patente;
	public int modelo;
	public int anio;
	public int usuario_dueño_id;
	
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
	public int getUsuario_dueño_id() {
		return usuario_dueño_id;
	}
	public void setUsuario_dueño_id(int usuario_dueño_id) {
		this.usuario_dueño_id = usuario_dueño_id;
	}
	
	
	public Vehiculo(int patente, int modelo, int anio, int usuario_dueño_id) {
		super();
		this.patente = patente;
		this.modelo = modelo;
		this.anio = anio;
		this.usuario_dueño_id = usuario_dueño_id;
	}
	
}
