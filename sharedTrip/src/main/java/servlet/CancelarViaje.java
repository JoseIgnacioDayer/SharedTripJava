package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Reserva;
import entidades.Usuario;
import entidades.Viaje;
import logic.ReservaController;
import logic.ViajeController;

/**
 * Servlet implementation class CancelarViaje
 */
@WebServlet("/cancelarViaje")
public class CancelarViaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarViaje() {
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
		ViajeController viajeCtrl = new ViajeController();
		boolean cancelada = viajeCtrl.cancelar(idViaje,u.getIdUsuario());
		if (cancelada) {
           
            LinkedList<Viaje> viajes = viajeCtrl.getViajesUsuario(u);
            session.setAttribute("misviajes", viajes);
            
            session.setAttribute("mensaje", "Viaje cancelado con éxito.");
        } else {
            session.setAttribute("mensaje", "Error al cancelar el viaje.");
        }
		response.sendRedirect("misViajes.jsp");
	}

}
