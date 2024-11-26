package data;

import java.sql.*;
import java.util.LinkedList;

import entidades.*;


public class ReservaDAO {
	
	
	public LinkedList<Reserva> getAll(){
	Statement stmt=null;
	ResultSet rs=null;
	LinkedList<Reserva> reservas = new LinkedList<>();
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("select idReserva,fecha_reserva,cantidad_pasajeros_reservada,reserva_cancelada,id_viaje,id_pasajero_reserva from reservas");
		
		if(rs!=null) {
			while(rs.next()) {
				Reserva r=new Reserva();
				r.setIdReserva(rs.getInt("idReserva"));
				r.setFecha_reserva(rs.getString("fecha_reserva"));
				r.setCantidad_pasajeros_reservada(rs.getInt("cantidad_pasajeros_reservada"));
				r.setReserva_cancelada(rs.getBoolean("reserva_cancelada"));
				r.setId_pasajero_reserva(rs.getInt("id_pasajero_reserva"));
				ViajeDAO viajeDAO = new ViajeDAO();
				Viaje viaje = viajeDAO.getByViaje(rs.getInt("id_viaje"));
				r.setViaje(viaje);
				reservas.add(r);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		
		try {
			
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			ConnectionDB.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return reservas;}
	
public int obtenerCantidad(int idReserva) {
	
	PreparedStatement stmt = null;
	ResultSet rs= null;
	int cantidad = 0;
	try {
		stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
				"SELECT cantidad_pasajeros_reservada FROM reservas where idReserva =?");
		stmt.setInt(1, idReserva);
	
		
		rs = stmt.executeQuery();
		if(rs!=null && rs.next()) {
			 cantidad = rs.getInt("cantidad_pasajeros_reservada");
		}
	}catch (SQLException e) {
		e.printStackTrace(); 
	}finally {
		try {
			if(rs!=null) {rs.close();}
			if(stmt!=null) {stmt.close();}
			ConnectionDB.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return cantidad;
}
	
	

public LinkedList<Reserva> getByUser(Usuario u) {
		
		LinkedList<Reserva> rvas = new LinkedList<>();
		
		Reserva r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"SELECT idReserva, fecha_reserva, cantidad_pasajeros_reservada, reserva_cancelada, " 
				+ "v.id_viaje, v.origen, v.destino, v.fecha, v.lugares_disponibles, v.precio_unitario, "
				+ "r.id_pasajero_reserva, u.* FROM reservas r "
				+ "INNER JOIN viajes v ON r.id_viaje = v.id_viaje "
				+ "INNER JOIN usuarios u "
				+ "ON u.id_usuario = v.id_conductor "
				+ "WHERE r.id_pasajero_reserva = ? "
				+ "AND reserva_cancelada = false"
				); 
			stmt.setInt(1, u.getIdUsuario());
			
			rs=stmt.executeQuery();
			while(rs!=null && rs.next()) {
				
	            
	            Usuario conductor = new Usuario();
	            conductor.setIdUsuario(rs.getInt("id_usuario"));
	            conductor.setNombre(rs.getString("nombre"));
	            conductor.setApellido(rs.getString("apellido"));
	            conductor.setCorreo(rs.getString("correo"));
	            conductor.setTelefono(rs.getString("telefono"));
	            
	            
	            Viaje viaje = new Viaje();
	            viaje.setIdViaje(rs.getInt("id_viaje"));
	            viaje.setOrigen(rs.getString("origen"));
	            viaje.setDestino(rs.getString("destino"));
	            viaje.setFecha(rs.getDate("fecha"));
	            viaje.setLugares_disponibles(rs.getInt("lugares_disponibles"));
	            viaje.setPrecio_unitario(rs.getDouble("precio_unitario"));
	            viaje.setConductor(conductor);
				
				
				
				r=new Reserva();
				r.setFecha_reserva(rs.getString("fecha_reserva"));
				r.setCantidad_pasajeros_reservada(rs.getInt("cantidad_pasajeros_reservada"));
				r.setReserva_cancelada(rs.getBoolean("reserva_cancelada"));
				r.setIdReserva(rs.getInt("idReserva"));
				r.setId_pasajero_reserva(rs.getInt("id_pasajero_reserva"));
				r.setViaje(viaje);
				
				
				rvas.add(r);

			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rvas;
	}



public void add(Reserva r) {
	PreparedStatement stmt= null;
	ResultSet keyResultSet=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().
				prepareStatement(
						"insert into reservas(fecha_reserva,cantidad_pasajeros_reservada,reserva_cancelada,id_viaje,id_pasajero_reserva) values(?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS
						);
		stmt.setString(1, r.getFecha_reserva());
		stmt.setInt(2, r.getCantidad_pasajeros_reservada());
		stmt.setBoolean(3, r.isReserva_cancelada());
		
		stmt.setInt(4, r.getViaje().getIdViaje());
		stmt.setInt(5, r.getId_pasajero_reserva());
	

		stmt.executeUpdate();
		
		keyResultSet=stmt.getGeneratedKeys();
		
	}  catch (SQLException e) {
        e.printStackTrace();
	} finally {
        try {
            if(keyResultSet!=null)keyResultSet.close();
            if(stmt!=null)stmt.close();
            ConnectionDB.getInstancia().releaseConn();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
	}
}



public void update(Reserva r, int idReserva) {
	PreparedStatement stmt = null;
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().prepareStatement(
				"UPDATE reservas SET (cantidad_pasajeros_reservada = ?, reserva_cancelada = ? , id_viaje =?, id_pasajero_reserva=?) where idReserva = ? ");
		
		stmt.setInt(1, r.getCantidad_pasajeros_reservada());
		stmt.setBoolean(2, r.isReserva_cancelada());
		stmt.setInt(3, r.getViaje().getIdViaje());
		stmt.setInt(4, r.getId_pasajero_reserva());
		stmt.setInt(5, idReserva);

		
		stmt.executeUpdate();
		
	}catch (SQLException e) {
        e.printStackTrace();
   
    }finally {
		try {
			if(stmt!=null) {stmt.close();}
			ConnectionDB.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}

public boolean cancelarReserva(int idReserva) {
	 	PreparedStatement stmt = null;
	    boolean cancelada = false;

	    try {
	        stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
	            "UPDATE reservas SET reserva_cancelada = true WHERE idReserva = ?"
	        );
	        stmt.setInt(1, idReserva);
	        

	        int rowsAffected = stmt.executeUpdate();
	        cancelada = (rowsAffected > 0); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (stmt != null) { stmt.close(); }
	            ConnectionDB.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return cancelada;
}
	




public void delete(Reserva r) {
	
	PreparedStatement stmt=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"delete from reservas where idReserva = ?"
				);
		stmt.setInt(1, r.getIdReserva());
		int rowsAffected = stmt.executeUpdate();
		
		if(rowsAffected > 1) {
			System.out.println("Se ha borrado la reserva con la fecha: " +  r.getFecha_reserva());
		}else {
			System.out.println("No se ha encontrado ninguna reserva");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if(stmt!=null) {stmt.close();}
			ConnectionDB.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
	
	
	
}
