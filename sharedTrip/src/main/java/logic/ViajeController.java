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
		return viajeDAO.getAll();
	}


}