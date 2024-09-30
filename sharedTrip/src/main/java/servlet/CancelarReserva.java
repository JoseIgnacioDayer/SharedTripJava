package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.ReservaDAO;
import entidades.Reserva;
import entidades.Usuario;

/**
 * Servlet implementation class CancelarReserva
 */
@WebServlet("/cancelarReserva")
public class CancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarReserva() {
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
		int idViaje = Integer.parseInt(request.getParameter("viajeId"));
		Usuario u = (Usuario) session.getAttribute("usuario");
		ReservaDAO reservaDAO = new ReservaDAO();
		boolean cancelada = reservaDAO.cancelarReserva(idViaje, u.getIdUsuario());
		if (cancelada) {
            
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            LinkedList<Reserva> misReservas = reservaDAO.getByUser(usuario);
            session.setAttribute("misreservas", misReservas);
            
            session.setAttribute("mensaje", "Reserva cancelada con éxito.");
        } else {
            session.setAttribute("mensaje", "Error al cancelar la reserva. Puede que no exista.");
        }
		response.sendRedirect("misReservas.jsp");
		
		
	}

}
