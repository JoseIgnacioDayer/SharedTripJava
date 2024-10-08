package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ReservaDAO;
import data.ViajeDAO;
import entidades.Reserva;
import entidades.Usuario;
import entidades.Viaje;
import logic.ViajeController;

/**
 * Servlet implementation class ListadoViajesUsuario
 */
@WebServlet("/misViajes")
public class ListadoViajesUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoViajesUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViajeController viajeCtrl = new ViajeController();
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		LinkedList<Viaje> viajes = viajeCtrl.getViajesUsuario(usuario);
		request.getSession().setAttribute("misviajes", viajes);
		request.getRequestDispatcher("misViajes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
