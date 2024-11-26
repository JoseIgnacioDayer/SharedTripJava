package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Usuario;
import logic.UserController;


@WebServlet("/BajaUsuarioAdmin")
public class BajaUsuarioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaUsuarioAdmin() {
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
		HttpSession session = request.getSession();
		UserController userController  = new UserController();
		if(userController.deleteUser(Integer.parseInt(request.getParameter("id_usuario")))){
			LinkedList<Usuario> usuarios = userController.getAll();
			session.setAttribute("usuarios", usuarios);
			session.setAttribute("mensaje", "Usuario dado de baja con éxito.");
		}else {
			session.setAttribute("mensaje", "Error al dar de baja el usuario.");
		}
		response.sendRedirect("usuarios.jsp");
		
		
		
		
	}

}
