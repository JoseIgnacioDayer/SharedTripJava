package servlet;

import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ViajeDAO;
import entidades.Usuario;
import entidades.Viaje;
import logic.ReservaController;
import logic.ViajeController;


@WebServlet("/reservar")
public class reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public reservar() {
        super();

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

        if (request.getSession().getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        ViajeController viajeCtrl = new ViajeController();
        ReservaController reservaController = new ReservaController();
        
        int viajeId = Integer.parseInt(request.getParameter("viajeId"));
        
        Viaje viaje = viajeCtrl.getOne(viajeId);
        
        int cantPasajeros = Integer.parseInt(request.getParameter("cantPasajeros"));
        
        Usuario user = (Usuario) request.getSession().getAttribute("usuario");
        int idUsuario = user.getIdUsuario();
        
        Date fecha = new Date();
        boolean reservaCancelada = false;
        
        reservaController.nuevaReserva(viaje, cantPasajeros, idUsuario, fecha, reservaCancelada);
        
        viajeCtrl.actualizarCantidad(viajeId, cantPasajeros);

        response.sendRedirect(request.getContextPath()+"/?reservado=true");
		
	}

}
