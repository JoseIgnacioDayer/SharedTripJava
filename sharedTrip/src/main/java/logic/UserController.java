package logic;

import java.util.LinkedList;

import data.*;
import entidades.*;

public class UserController {
	private UserDAO usuarioDAO;
	
	public UserController() {
		this.usuarioDAO = new UserDAO();
	}
	
	public Usuario validate(Usuario u) {

		return usuarioDAO.getByUser(u);
	}

	public LinkedList<Usuario> getAll(){
		return usuarioDAO.getAll();
	}
	
	public void addUser(Usuario u) {
		usuarioDAO.add(u);
	}
	
	public boolean deleteUser(int idUsuario) {
		return this.usuarioDAO.eliminarUsuario(idUsuario);
	}
	
	

}