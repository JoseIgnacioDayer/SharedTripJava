package data;

import java.sql.*;
import java.util.LinkedList;

import entidades.*;
import sun.security.action.GetBooleanAction;

public class ReservaDAO {
	
	
	public LinkedList<Reserva> getAll(){
	Statement stmt=null;
	ResultSet rs=null;
	LinkedList<Reserva> reservas = new LinkedList<>();
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("select fecha_reserva,cantidad_pasajeros_reservada,reserva_cancelada,id_viaje,id_pasajero_reserva from reservas");
		
		if(rs!=null) {
			while(rs.next()) {
				Reserva r=new Reserva();
				
				r.setFecha_reserva(rs.getDate("fecha_reserva"));
				r.setCantidad_pasajeros_reservada(rs.getInt("cantidad_pasajeros_reservada"));
				r.setReserva_cancelada(rs.getBoolean("reserva_cancelada"));
				r.setId_viaje(rs.getInt("id_viaje"));
				r.setId_pasajero_reserva(rs.getInt("id_pasajero_reserva"));
				
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

	public LinkedList<Reserva> getByUser(Usuario u) {
		
		LinkedList<Reserva> rvas = new LinkedList<>();
		
		Reserva r=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
					"select fecha_reserva,cantidad_pasajeros_reservada,reserva_cancelada,id_viaje,id_pasajero_reserva from reservas where id_pasajero_reserva=?"
					); 
			stmt.setInt(1, u.getIdUsuario());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				r=new Reserva();
				r.setFecha_reserva(rs.getDate("fecha_reserva"));
				r.setCantidad_pasajeros_reservada(rs.getInt("cantidad_pasajeros_reservada"));
				r.setReserva_cancelada(rs.getBoolean("reserva_cancelada"));
				r.setId_viaje(rs.getInt("id_viaje"));
				r.setId_pasajero_reserva(rs.getInt("id_pasajero_reserva"));
				
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
		stmt.setDate(1, r.getFecha_reserva());
		stmt.setInt(2, r.getCantidad_pasajeros_reservada());
		stmt.setBoolean(3, r.isReserva_cancelada());
		stmt.setInt(4, r.getId_viaje());
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



public void update(Reserva r, Date fDate) {
	PreparedStatement stmt = null;
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().prepareStatement(
				"UPDATE reservas SET (cantidad_pasajeros_reservada = ?, reserva_cancelada = ? , id_viaje =?, id_pasajero_reserva=?) where fecha_reserva = ? ");
		
		stmt.setInt(1, r.getCantidad_pasajeros_reservada());
		stmt.setBoolean(2, r.isReserva_cancelada());
		stmt.setInt(3, r.getId_viaje());
		stmt.setInt(4, r.getId_pasajero_reserva());
		stmt.setDate(5, fDate);

		
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



public void delete(Reserva r) {
	
	PreparedStatement stmt=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"delete * from reservas where fecha_reserva=?"
				);
		stmt.setDate(1, r.getFecha_reserva());
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
