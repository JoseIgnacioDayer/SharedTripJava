package entidades;

public class Direccion {
	public int idDireccion; 
	public String calle;
	public int altura;
	public String localidad;
	
	// ---------------------------------------- GETTERS AND SETTERS --------------------------------------
	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	// ---------------------------------------- CONSTRUCTOR --------------------------------------
	public Direccion(int idDireccion, String calle, int altura, String localidad) {
		super();
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.altura = altura;
		this.localidad = localidad;
	}
	
}
