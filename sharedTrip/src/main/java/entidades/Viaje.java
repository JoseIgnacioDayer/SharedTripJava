package entidades;
import java.sql.Date;

public class Viaje {
	private int idViaje;
	public Date fecha;
	public int lugares_disponibles;
	public String origen;
	public String destino; 
	public double precio_unitario;
	public boolean cancelado;
	public String lugar_salida;
	public String tiempo_cancelacion; //fijarse el tipo
	private Usuario conductor;
	
	
	public Usuario getConductor() {
		return conductor;
	}
	public void setConductor(Usuario conductor) {
		this.conductor = conductor;
	}
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getLugares_disponibles() {
		return lugares_disponibles;
	}
	public void setLugares_disponibles(int lugares_disponibles) {
		this.lugares_disponibles = lugares_disponibles;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	public boolean isCancelado() {
		return cancelado;
	}
	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	public String getLugar_salida() {
		return lugar_salida;
	}
	public void setLugar_salida(String lugar_salida) {
		this.lugar_salida = lugar_salida;
	}
	public String getTiempo_cancelacion() {
		return tiempo_cancelacion;
	}
	public void setTiempo_cancelacion(String tiempo_cancelacion) {
		this.tiempo_cancelacion = tiempo_cancelacion;
	}

	

	
	public Viaje(int idViaje, Date fecha, int lugares_disponibles, String origen, String destino,
			double precio_unitario, boolean cancelado, String lugar_salida, String tiempo_cancelacion, Usuario conductor) {
		super();
		this.idViaje = idViaje;
		this.fecha = fecha;
		this.lugares_disponibles = lugares_disponibles;
		this.origen = origen;
		this.destino = destino;
		this.precio_unitario = precio_unitario;
		this.cancelado = cancelado;
		this.lugar_salida = lugar_salida;
		this.tiempo_cancelacion = tiempo_cancelacion;
		this.conductor = conductor;
	}
	public Viaje() {
		// TODO Auto-generated constructor stub
	}
	
}
