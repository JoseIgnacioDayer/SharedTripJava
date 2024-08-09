package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Direccion;
import entidades.Usuario;

public class DireccionDAO {
	
	public LinkedList<Direccion> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Direccion> direcciones= new LinkedList<>();
		
		try {
			stmt= ConnectionDB.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery(
					"SELECT dir.usuario_direccion ,user.nombre, user.apellido, dir.calle, dir.altura, dir.localidad FROM direcciones dir INNER JOIN usuarios user ON dir.usuario_direccion = user.id_usuario"
					);
			
			if(rs!=null) {
				while(rs.next()) {
					Direccion d=new Direccion();
					
					d.setUsuario_direccion(rs.getInt("dir.usuario_direccion"));
					d.setCalle(rs.getString("dir.calle"));
					d.setAltura(rs.getInt("dir.altura"));
					d.setLocalidad(rs.getString("dir.localidad"));
					//AGREGAR NOMBRE Y APELLIDO DE LA PERSONA QUE VIVE AHI A LA ENTITY?
					
					direcciones.add(d);
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
		
		return direcciones;
	}
	
	public LinkedList<Direccion> getByUser(Usuario user) {
		
		LinkedList<Direccion> direcciones= new LinkedList<>();

		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement("SELECT calle, altura, localidad FROM direcciones WHERE usuario_direccion=?");
			
			stmt.setInt(1, user.getIdUsuario());
			rs = stmt.executeQuery();
			
			if(rs!=null && rs.next()) {
				Direccion d=new Direccion();
				
				d.setUsuario_direccion(user.getIdUsuario());
				d.setCalle(rs.getString("calle"));
				d.setAltura(rs.getInt("altura"));
				d.setLocalidad(rs.getString("localidad"));
				
				direcciones.add(d);

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
		
		return direcciones;
	}
	

	
	public void add(Direccion dire, Usuario u) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=ConnectionDB.getInstancia().getConn().
					prepareStatement(
							"insert into direcciones(calle, altura, localidad, usuario_direccion) values(?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, dire.getCalle());
			stmt.setInt(2, dire.getAltura());
			stmt.setString(3, dire.getLocalidad());
			stmt.setInt(4, u.getIdUsuario());


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
	
	
	
	public void update(Direccion dire, Usuario u) {
		PreparedStatement stmt = null;
		//HAY QUE CAMBIARLA DEBIDO A QUE NECESITO LAS DOS DIRECCIONES LA NUEVA Y LA VIEJA, O ELIMINAR EL UPDATE Y QUE SOLO HAGA DELETE Y ADD
		try {
			stmt= ConnectionDB.getInstancia().getConn().prepareStatement(
					"UPDATE direcciones SET (calle = ?, altura = ? , localidad =?) where usuario_direccion = ? ");
			
			stmt.setString(1, dire.getCalle());
			stmt.setInt(2, dire.getAltura());
			stmt.setString(3, dire.getLocalidad());
			stmt.setInt(4, u.getIdUsuario());

			
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
	
	
	
	public void delete(Direccion direc) {
		
		PreparedStatement stmt=null;
		try {
			stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
					"delete * from direcciones where usuario_direccion=? and calle=? and altura=?"
					);
			stmt.setInt(1, direc.getUsuario_direccion());
			stmt.setString(2, direc.getCalle());
			stmt.setInt(3, direc.getAltura());
			int rowsAffected = stmt.executeUpdate();
			
			if(rowsAffected > 1) {
				System.out.println("Se ha borrado la direccion en calle: " +  direc.getCalle() + " y altura: " + direc.getAltura() );
			}else {
				System.out.println("No se ha encontrado ningún usuario");
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


