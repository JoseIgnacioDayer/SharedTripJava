package entidades;
import java.util.Date;

public class Feedback {
	public int puntuacion;
	public String observacion;
	public Date fecha_hora;
	public int id_usuario_calificado;
	
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Date getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public int getId_usuario_calificado() {
		return id_usuario_calificado;
	}
	public void setId_usuario_calificado(int id_usuario_calificado) {
		this.id_usuario_calificado = id_usuario_calificado;
	}
	
	public Feedback(int puntuacion, String observacion, Date fecha_hora, int id_usuario_calificado) {
		super();
		this.puntuacion = puntuacion;
		this.observacion = observacion;
		this.fecha_hora = fecha_hora;
		this.id_usuario_calificado = id_usuario_calificado;
	}
	
}
