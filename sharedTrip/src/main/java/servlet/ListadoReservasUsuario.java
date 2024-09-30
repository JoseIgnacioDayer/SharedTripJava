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


@WebServlet("/misReservas")
public class ListadoReservasUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public ListadoReservasUsuario() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservaDAO reservaDAO = new ReservaDAO();
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		LinkedList<Reserva> reservas = reservaDAO.getByUser(usuario);
		System.out.println("Total de reservas encontradas: " + reservas.size());
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
