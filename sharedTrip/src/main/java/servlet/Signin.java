package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Usuario;
import entidades.Viaje;
import logic.UserController;
import logic.ViajeController;

@WebServlet({ "/signin", "/Signin", "/SIGNIN", "/SignIn", "/signIn" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Signin() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		Usuario u = new Usuario();
		UserController ctrl = new UserController();
		String correo = request.getParameter("email");
		String clave = request.getParameter("password");
		u.setCorreo(correo);
		u.setClave(clave);
		u = ctrl.validate(u);
		
		ViajeController ctrlViaje = new ViajeController();
		LinkedList<Viaje> viajes = ctrlViaje.getAll();
		
		request.getSession().setAttribute("usuario", u);
		request.setAttribute("viajes", viajes);
		
		request.getRequestDispatcher("WEB-INF/viajes.jsp").forward(request, response);
		
	}

}
