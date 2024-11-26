package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Usuario;
import logic.UserController;

/**
 * Servlet implementation class RegistrarUsuarioAdmin
 */
@WebServlet("/RegistrarUsuarioAdmin")
public class RegistrarUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUsuarioAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		UserController ctrl = new UserController();
		u.setNombre(request.getParameter("nombre"));
		u.setApellido(request.getParameter("apellido"));
		u.setCorreo(request.getParameter("correo"));
		u.setUsuario(request.getParameter("usuario"));
		u.setClave(request.getParameter("clave"));
		u.setTelefono(request.getParameter("telefono"));
		u.setRol(Integer.parseInt(request.getParameter("rol")));
		
		ctrl.addUser(u);
		
		response.sendRedirect(request.getContextPath() + "/usuarios");
	}

}
