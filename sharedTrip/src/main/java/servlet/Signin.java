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
 * Servlet implementation class Signin
 */
@WebServlet({ "/signin", "/Signin", "/SIGNIN", "/SignIn", "/signIn" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
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
		// TODO Auto-generated method stub
		
		Usuario u = new Usuario();
		UserController ctrl = new UserController();
		String correo = request.getParameter("email");
		String clave = request.getParameter("password");
		
		u.setCorreo(correo);
		u.setClave(clave);
		u = ctrl.validate(u);
		
		if(u == null) {
			System.out.println("No existe el usuario");
		}else {
		
		response.getWriter().append("Nombre: ").append(u.getNombre()).append("  ").append("Apellido: ").append(u.getApellido());
		}
		
	}

}
