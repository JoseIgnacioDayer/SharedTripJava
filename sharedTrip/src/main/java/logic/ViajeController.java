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


}