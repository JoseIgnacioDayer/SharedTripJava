package entidades;
import java.sql.Date;

public class Reserva {
	public Date fecha_reserva;
	public int cantidad_pasajeros_reservada;
	public boolean reserva_cancelada;
	public int id_viaje;
	public int id_pasajero_reserva;
	
	
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	public int getCantidad_pasajeros_reservada() {
		return cantidad_pasajeros_reservada;
	}
	public void setCantidad_pasajeros_reservada(int cantidad_pasajeros_reservada) {
		this.cantidad_pasajeros_reservada = cantidad_pasajeros_reservada;
	}
	public boolean isReserva_cancelada() {
		return reserva_cancelada;
	}
	public void setReserva_cancelada(boolean reserva_cancelada) {
		this.reserva_cancelada = reserva_cancelada;
	}
	public int getId_viaje() {
		return id_viaje;
	}
	public void setId_viaje(int id_viaje) {
		this.id_viaje = id_viaje;
	}
	public int getId_pasajero_reserva() {
		return id_pasajero_reserva;
	}
	public void setId_pasajero_reserva(int id_pasajero_reserva) {
		this.id_pasajero_reserva = id_pasajero_reserva;
	}
	
	
	public Reserva(Date fecha_reserva, int cantidad_pasajeros_reservada, boolean reserva_cancelada, int id_viaje,
			int id_pasajero_reserva) {
		super();
		this.fecha_reserva = fecha_reserva;
		this.cantidad_pasajeros_reservada = cantidad_pasajeros_reservada;
		this.reserva_cancelada = reserva_cancelada;
		this.id_viaje = id_viaje;
		this.id_pasajero_reserva = id_pasajero_reserva;
	}
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
