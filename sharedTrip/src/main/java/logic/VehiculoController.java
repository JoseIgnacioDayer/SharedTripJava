package logic;

import java.util.LinkedList;

import data.*;
import entidades.*;

public class VehiculoController {

private VehiculoDAO vehiculoDAO;
	
	public VehiculoController() {
		this.vehiculoDAO = new VehiculoDAO();
	}
	
	public LinkedList<Vehiculo> getAll(){
		LinkedList<Vehiculo>vehiculos= vehiculoDAO.getAll();
		System.out.println(vehiculos.size());
		return vehiculoDAO.getAll();
		
	}
	
	public Vehiculo getOne(int id_vehiculo) {
		return this.vehiculoDAO.getById_vehiculo(id_vehiculo);
	}
	
	public Vehiculo getByPatente(String patente) {
		return this.vehiculoDAO.getByPatente(patente);
	}
	
	public LinkedList<Vehiculo> getVehiculosUsuario(Usuario u){
		return this.vehiculoDAO.getByUser(u);
		
	}
	
	public boolean eliminarVehiculo(int id_vehiculo) {
		return this.vehiculoDAO.eliminarVehiculo(id_vehiculo);
		
	}
	
	public void altaVehiculo(Vehiculo vehiculo) {
		vehiculoDAO.altaVehiculo(vehiculo);
		
	}
	
}
