package data;

import entidades.*;

import java.sql.*;
import java.util.LinkedList;

public class UserDAO {
	
	public LinkedList<Usuario> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		
		LinkedList<Usuario> users= new LinkedList<>();
		
		try {
			stmt= ConnectionDB.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id_usuario,usuario,nombre,apellido,correo,telefono, id_rol from usuarios");
			
			
			if(rs!=null) {
				while(rs.next()) {
					Usuario u=new Usuario();
					
					u.setIdUsuario(rs.getInt("id_usuario"));
					u.setUsuario(rs.getString("usuario"));
					u.setNombre(rs.getString("nombre"));
					u.setApellido(rs.getString("apellido"));
					u.setCorreo(rs.getString("correo"));
					u.setTelefono(rs.getString("telefono"));
					u.setRol(rs.getInt("id_rol"));
					
					users.add(u);
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
		
		return users;
	}
	
	public Usuario getByUser(Usuario user) {

		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
					"select id_usuario,usuario,nombre,apellido,correo,telefono, id_rol from usuarios where usuario=? and clave=?"
					);
			stmt.setString(1, user.getUsuario());
			stmt.setString(2, user.getClave());
			rs=stmt.executeQuery();
			
			
			if(rs!=null && rs.next()) {
				u=new Usuario();
				
				u.setIdUsuario(rs.getInt("id_usuario"));
				u.setUsuario(rs.getString("usuario"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setCorreo(rs.getString("correo"));
				u.setTelefono(rs.getString("telefono"));
				u.setRol(rs.getInt("id_rol"));

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
		
		return u;
	}
	
	public Usuario getById(int id_usuario) {

		Usuario u=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
					"select id_usuario,usuario,nombre,apellido,correo,telefono, id_rol from usuarios where id_usuario = ?"
					);
			stmt.setInt(1, id_usuario);
			
			rs=stmt.executeQuery();
			
			
			if(rs!=null && rs.next()) {
				u=new Usuario();
				
				u.setIdUsuario(rs.getInt("id_usuario"));
				u.setUsuario(rs.getString("usuario"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				u.setCorreo(rs.getString("correo"));
				u.setTelefono(rs.getString("telefono"));
				u.setRol(rs.getInt("id_rol"));
				
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
		
		return u;
	}
	
	

	
	public void add(Usuario u) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=ConnectionDB.getInstancia().getConn().
					prepareStatement(
							"insert into usuarios(usuario, clave, nombre, apellido, correo, telefono, id_rol) values(?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, u.getUsuario());
			stmt.setString(2, u.getClave());
			stmt.setString(3, u.getNombre());
			stmt.setString(4, u.getApellido());
			stmt.setString(5, u.getCorreo());
			stmt.setString(6, u.getTelefono());
			stmt.setInt(7, u.getRol());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                u.setIdUsuario(keyResultSet.getInt(1));
            }

			
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
	
	
	
	public void update(Usuario u, String email) {
		PreparedStatement stmt = null;
		
		try {
			stmt= ConnectionDB.getInstancia().getConn().prepareStatement(
					"UPDATE usuarios SET (usuario = ?, nombre = ? , apellido =? , correo =?, telefono =?) where correo = ? ");
			
			stmt.setString(1, u.getUsuario());
			stmt.setString(2, u.getNombre());
			stmt.setString(3, u.getApellido());
			stmt.setString(4, u.getCorreo());
			stmt.setString(5, u.getTelefono());
			stmt.setString(6, email);
			
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
	
	
	
	public boolean eliminarUsuario(int idUsuario) {
		
		PreparedStatement stmt=null;
		try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
					"delete from usuarios where id_usuario=?"
					);
			stmt.setInt(1, idUsuario);
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 0) {
				System.out.println("Se ha borrado el usuario con el ID: " +  idUsuario);
				return true;
			}else {
				System.out.println("No se ha encontrado ningún usuario");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
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