package entidades;

public class Direccion {
	public int usuario_direccion; 
	public String calle;
	public int altura;
	public String localidad;
	
	// ---------------------------------------- GETTERS AND SETTERS --------------------------------------

	public String getCalle() {
		return calle;
	}
	public int getUsuario_direccion() {
		return usuario_direccion;
	}
	public void setUsuario_direccion(int usuario_direccion) {
		this.usuario_direccion = usuario_direccion;
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
	public Direccion() {
		
	}
	
	
	public Direccion(int usuario_direccion, String calle, int altura, String localidad) {
		super();
		this.usuario_direccion = usuario_direccion;
		this.calle = calle;
		this.altura = altura;
		this.localidad = localidad;
		}
}
