package logic;

import java.util.LinkedList;

import data.*;
import entidades.*;

public class ViajeController {
	private ViajeDAO viajeDAO;
	
	public ViajeController() {
		this.viajeDAO = new ViajeDAO();
	}
	
	public LinkedList<Viaje> getAll(){
		LinkedList<Viaje>viajes = viajeDAO.getAll();
		System.out.println(viajes.size());
		return viajeDAO.getAll();
		
	}
	
	public LinkedList<Viaje> getAllBySearch(String origen, String destino, String fecha){
		LinkedList<Viaje> viajes = viajeDAO.getAllBySearch(origen, destino, fecha);
		return viajes;
	}
	
	public Viaje getOne(int id) {
		return this.viajeDAO.getByViaje(id);
	}
	
	public void actualizarCantidad(int idViaje, int cantidad) {
		Viaje viaje = this.getOne(idViaje);
		int nueva_cant = viaje.getLugares_disponibles() - (cantidad);
		this.viajeDAO.updateCantidad(idViaje, nueva_cant);
	}
	
	
	public LinkedList<Viaje> getViajesUsuario(Usuario u){
		return this.viajeDAO.getByUser(u);
		
	}
	
	public boolean cancelar(int idViaje, int idUsuario) {
		return this.viajeDAO.cancelarViaje(idViaje, idUsuario);
		
	}
	
	

}