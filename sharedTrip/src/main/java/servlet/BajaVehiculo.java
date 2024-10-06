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
import entidades.Vehiculo;
import logic.VehiculoController;



/**
 * Servlet implementation class BajaVehiculo
 */
@WebServlet({ "/BajaVehiculo", "/bajaVehiculo" })
public class BajaVehiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaVehiculo() {
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
			
		HttpSession session = request.getSession();
		int id_vehiculo = Integer.parseInt(request.getParameter("id_vehiculo"));
		Usuario u = (Usuario) session.getAttribute("usuario");
		VehiculoController vehiculoCtrl = new VehiculoController();
		boolean baja = vehiculoCtrl.eliminarVehiculo(id_vehiculo);
		if (baja) {
           
            LinkedList<Vehiculo> vehiculos = vehiculoCtrl.getVehiculosUsuario(u);
            session.setAttribute("misvehiculos", vehiculos);
            
            session.setAttribute("mensaje", "Vehiculo dado de baja con éxito.");
        } else {
            session.setAttribute("mensaje", "Error al dar de baja el vehiculo.");
        }
		response.sendRedirect("misVehiculos.jsp");
	}

}
