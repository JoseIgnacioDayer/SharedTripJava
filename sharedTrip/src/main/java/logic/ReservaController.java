package logic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import data.ReservaDAO;
import entidades.Reserva;
import entidades.Usuario;
import entidades.Viaje;

public class ReservaController {
	private ReservaDAO reservaDAO;
	
	public ReservaController() {
		this.reservaDAO = new ReservaDAO();
	}
	
	public void nuevaReserva(Viaje viaje, int cantPasajeros, int idUsuario, Date fecha, boolean cancelado) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fechaString = sdf.format(fecha);
		
		Reserva r = new Reserva(fechaString, cantPasajeros, cancelado, viaje, idUsuario);
		
		this.reservaDAO.add(r);
	}
	
	public LinkedList<Reserva> getReservasUsuario(Usuario u){
		LinkedList<Reserva> reservas = this.reservaDAO.getByUser(u);
		return reservas;
	}
	
	
	public boolean cancelar(int idReserva) {
		return this.reservaDAO.cancelarReserva(idReserva);
	}
	
	public int obtenerCantidad(int idReserva) {
		return this.reservaDAO.obtenerCantidad(idReserva);
	}
}
