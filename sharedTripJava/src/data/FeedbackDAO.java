package data;

import java.sql.*;
import java.util.LinkedList;

import entidades.*;

public class FeedbackDAO {
	
	
	public LinkedList<Feedback> getAll(){
	Statement stmt=null;
	ResultSet rs=null;
	LinkedList<Feedback> feedbacks= new LinkedList<>();
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("select fecha_hora,id_usuario_calificado, puntuacion, observacion from feedback");
		
		if(rs!=null) {
			while(rs.next()) {
				Feedback f=new Feedback();
				
				f.setFecha_hora(rs.getDate("fecha_hora"));
				f.setId_usuario_calificado(rs.getInt("id_usuario_calificado"));
				f.setObservacion(rs.getString("observacion"));
				f.setPuntuacion(rs.getInt("puntuacion"));

				
				feedbacks.add(f);
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
	
	return feedbacks;
	}

public LinkedList<Feedback> getByUser(Usuario u) {
	
	LinkedList<Feedback> fs = new LinkedList<>();
	
	Feedback f=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"select fecha_hora,id_usuario_calificado, puntuacion, observacion from feedback where id_usuario_calificado=?"
				); 
		stmt.setInt(1, u.getIdUsuario());
		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			f=new Feedback();
			f.setFecha_hora(rs.getDate("fecha_hora"));
			f.setId_usuario_calificado(rs.getInt("id_usuario_calificado"));
			f.setObservacion(rs.getString("observacion"));
			f.setPuntuacion(rs.getInt("puntuacion"));
			
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
	
	return fs;
}



public void add(Feedback f) {
	PreparedStatement stmt= null;
	ResultSet keyResultSet=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().
				prepareStatement(
						"insert into feedback(fecha_hora,id_usuario_calificado, puntuacion, observacion) values(?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS
						);
		stmt.setDate(1, f.getFecha_hora());
		stmt.setInt(2, f.getId_usuario_calificado());
		stmt.setInt(3, f.getPuntuacion());
		stmt.setString(4, f.getObservacion());
	

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


/*
public void update(Feedback f, Date fh) {
	PreparedStatement stmt = null;
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().prepareStatement(
				"UPDATE vehiculos SET (modelo = ?, anio = ? , usuario_duenio_id =?) where patente = ? ");
		
		stmt.setString(1, v.getModelo());
		stmt.setInt(2, v.getAnio());
		stmt.setInt(3, v.getUsuario_duenio_id());
		stmt.setInt(4, patente);

		
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
*/

public void delete(Feedback f) {
	
	PreparedStatement stmt=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"delete * from feedback where fecha_hora=? and id_usuario_calificado=?"
				);
		stmt.setDate(1, f.getFecha_hora());
		stmt.setInt(2, f.getId_usuario_calificado());
		int rowsAffected = stmt.executeUpdate();
		
		if(rowsAffected > 1) {
			System.out.println("Se ha borrado el feedback con el id usuario: " +  f.getId_usuario_calificado() + "y la fecha: " + f.getFecha_hora());
			
		}else {
			System.out.println("No se ha encontrado ningún Feedback");
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
