package ui;


import java.util.Scanner;

import entidades.*;
import logic.UserController;

//HAY QUE HACER ESTO, DEJO PARA MODELO

public class Menu {
	Scanner s=null;
	UserController ctrlLogin = new UserController();

	public void start() {
		s = new Scanner(System.in);
		Usuario p = login();
		if(p == null) {
			System.out.println("Usuario inexistente y/o contraseña incorrecta");
		}else {
			
			System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
			System.out.println();
			
			String command;
			do {
				command=getCommand();
				executeCommand(command);
				System.out.println();
				
			}while(!command.equalsIgnoreCase("exit"));
			
			s.close();
		}

	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			//System.out.println(find());
			break;
		case "search":
	
			break;
		case "new":
			
			break;
		case "edit":
			
			break;
		case "delete":
			
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Usuario login() {
		Usuario u = new Usuario();
		
		System.out.print("Email: ");
		u.setCorreo(s.nextLine());

		System.out.print("password: ");
		u.setClave(s.nextLine());
		
		u=ctrlLogin.validate(u);
		
		return u;
		
	}
	
	/*private Usuario find() {
		System.out.println();
		Usuario u=new Usuario();
	
	}*/

}