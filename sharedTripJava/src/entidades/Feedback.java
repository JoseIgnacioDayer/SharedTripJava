package entidades;

public class Feedback {
	int puntuacion;
	String descripcion;
	
	int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Feedback(int puntuacion, String descripcion) {
		super();
		this.puntuacion = puntuacion;
		this.descripcion = descripcion;
	}
	
	
}
