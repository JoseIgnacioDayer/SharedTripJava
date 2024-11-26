package logic;

import java.util.LinkedList;

import data.RolDAO;
import entidades.Rol;

public class RolController {
	
	private RolDAO rolDAO;
	
	public Rol getOne (int id_rol) {
		return rolDAO.getById(id_rol);
		
	}
	
	public LinkedList<Rol> getAll() {
		return rolDAO.getAll();
	}
	
	public void add(Rol rol) {
		rolDAO.add(rol);
	}
	
	public void delete(int id_rol) {
	
		//falta desarrollar
	}

	public RolController() {
		super();
		this.rolDAO = new RolDAO();
	}

	
	
	
}
