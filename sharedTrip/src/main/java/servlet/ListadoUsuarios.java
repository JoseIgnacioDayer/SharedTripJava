package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Rol;
import entidades.Usuario;
import logic.RolController;
import logic.UserController;

/**
 * Servlet implementation class ListadoUsuarios
 */
@WebServlet("/usuarios")
public class ListadoUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute("roles");
		request.getSession().removeAttribute("usuarios");
		
		UserController usuarioCtrl = new UserController();
		RolController rolCtrl = new RolController();
		if ("admin".equals(request.getSession().getAttribute("rol"))) {
			LinkedList<Rol> roles = rolCtrl.getAll();
			LinkedList<Usuario> usuarios = usuarioCtrl.getAll();
			request.getSession().setAttribute("roles", roles);
			request.getSession().setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("usuarios.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("mensaje", "Acceso denegado");
			response.sendRedirect(request.getContextPath() +"/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
