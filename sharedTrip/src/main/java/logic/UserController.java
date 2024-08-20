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
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 * md5 creo q es una opcion tamb
		 */
		return usuarioDAO.getByUser(u);
	}

	public LinkedList<Usuario> getAll(){
		return usuarioDAO.getAll();
	}
	
	public void addUser(Usuario u) {
		usuarioDAO.add(u);
	}


}