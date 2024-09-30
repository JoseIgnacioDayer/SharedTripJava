package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

import data.ReservaDAO;
import entidades.Reserva;
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
}
