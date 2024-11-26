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
import logic.ReservaController;
import logic.ViajeController;

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
		int idReserva = Integer.parseInt(request.getParameter("reservaId"));
		int idViaje = Integer.parseInt(request.getParameter("viajeId"));
		Usuario u = (Usuario) session.getAttribute("usuario");
		ViajeController viajeController = new ViajeController();
		ReservaController reservaCtrl = new ReservaController();
		boolean cancelada = reservaCtrl.cancelar(idReserva);
		
		if (cancelada) {
          
            LinkedList<Reserva> misReservas = reservaCtrl.getReservasUsuario(u);
            session.setAttribute("misreservas", misReservas);
            int cantidad = reservaCtrl.obtenerCantidad(idReserva);
            viajeController.actualizarCantidad(idViaje, cantidad * (-1));
            session.setAttribute("mensaje", "Reserva cancelada con éxito.");
        } else {
            session.setAttribute("mensaje", "Error al cancelar la reserva. Puede que no exista.");
        }
		response.sendRedirect("misReservas.jsp");
		
		
	}

}
