package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Rol;
import entidades.Usuario;
import logic.RolController;
import logic.UserController;


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
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");
        
        u.setUsuario(usuario);
        u.setClave(clave);
        u = ctrl.validate(u);
        
        if (u == null) {
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
        	
        	RolController rolCtrl = new RolController();
        	Rol rol = rolCtrl.getOne(u.getRol());
        	
            request.getSession().setAttribute("usuario", u);
            request.getSession().setAttribute("nombre", u.getNombre());
            request.getSession().setAttribute("apellido", u.getApellido());
            request.getSession().setAttribute("rol", rol.getNombre());
           
            
            response.sendRedirect(request.getContextPath() +"/");
        }
	}
}
