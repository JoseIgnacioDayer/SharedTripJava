package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Rol;


public class RolDAO {
	
	
	public LinkedList<Rol> getAll() {
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Rol> roles = new LinkedList<>();
		
		try {
			stmt= ConnectionDB.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id, nombre from roles");
			
			if(rs!=null) {
				while(rs.next()) {
					Rol r=new Rol();
					
					r.setIdRol(rs.getInt("id"));
					r.setNombre(rs.getString("nombre"));
					roles.add(r);
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
		
		return roles;
		}

	public Rol getById(int id_rol) {
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Rol rol = null;
	    
	    try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
					"select id, nombre from roles where id=?"
					); 
			stmt.setInt(1, id_rol);
			rs= stmt.executeQuery();
		
	        if (rs != null && rs.next()) {
	            rol = new Rol();
	            rol.setIdRol(rs.getInt("id"));
	            rol.setNombre(rs.getString("nombre"));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    } finally {
	        try {
	            if (rs != null) { rs.close(); }
	            if (stmt != null) { stmt.close(); }
	            ConnectionDB.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return rol;}
	
	public void add(Rol r) {
	    PreparedStatement stmt = null;
	    ResultSet keyResultSet = null;
	    
	    try {
	        stmt = ConnectionDB.getInstancia().getConn().
	                prepareStatement(
	                        "INSERT INTO roles(nombre) VALUES(?)",
	                        PreparedStatement.RETURN_GENERATED_KEYS
	                );
	        stmt.setString(1, r.getNombre());

	        stmt.executeUpdate();
	        
	        keyResultSet = stmt.getGeneratedKeys();
	        if (keyResultSet != null && keyResultSet.next()) {
	        	r.setIdRol(keyResultSet.getInt(1)); 
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    } finally {
	        try {
	            if (keyResultSet != null) { keyResultSet.close(); }
	            if (stmt != null) { stmt.close(); }
	            ConnectionDB.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
