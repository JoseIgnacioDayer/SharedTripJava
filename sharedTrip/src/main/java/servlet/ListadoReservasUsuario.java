package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ReservaDAO;
import entidades.Reserva;
import entidades.Usuario;
import logic.ReservaController;


@WebServlet("/misReservas")
public class ListadoReservasUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public ListadoReservasUsuario() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReservaController reservaCtrl = new ReservaController();
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		LinkedList<Reserva> reservas = reservaCtrl.getReservasUsuario(usuario);
	
		request.getSession().setAttribute("misreservas", reservas);
		request.getRequestDispatcher("misReservas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
