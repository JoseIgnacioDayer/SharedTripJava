package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Usuario;
import entidades.Vehiculo;

public class VehiculoDAO {
	
	
	public LinkedList<Vehiculo> getAll(){
	Statement stmt=null;
	ResultSet rs=null;
	LinkedList<Vehiculo> vehiculos= new LinkedList<>();
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("select id_vehiculo,patente,modelo, anio, usuario_duenio_id from vehiculos");
		
		if(rs!=null) {
			while(rs.next()) {
				Vehiculo v=new Vehiculo();
				
				v.setId_vehiculo(rs.getInt("id_vehiculo"));
				v.setPatente(rs.getString("patente"));
				v.setModelo(rs.getString("modelo"));
				v.setAnio(rs.getInt("anio"));
				v.setUsuario_duenio_id(rs.getInt("usuario_duenio_id"));

				
				vehiculos.add(v);
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
	
	return vehiculos;
	}

public Vehiculo getById_vehiculo(int id_vehiculo) {

	Vehiculo v=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"select id_vehiculo, patente, modelo, anio, usuario_duenio_id from vehiculos where id_vehiculo=?"
				); 
		stmt.setInt(1, id_vehiculo);
		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			v=new Vehiculo();	
				v.setId_vehiculo(rs.getInt("id_vehiculo"));
				v.setPatente(rs.getString("patente"));
				v.setModelo(rs.getString("modelo"));
				v.setAnio(rs.getInt("anio"));
				v.setUsuario_duenio_id(rs.getInt("usuario_duenio_id"));
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
	
	return v;
}

public Vehiculo getByPatente(String patente) {

	Vehiculo v=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"select id_vehiculo, patente,modelo, anio, usuario_duenio_id from vehiculos where patente=? "
				); 
		stmt.setString(2, patente);
		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			v=new Vehiculo();	
				v.setId_vehiculo(rs.getInt("id_vehiculo"));
				v.setPatente(rs.getString("patente"));
				v.setModelo(rs.getString("modelo"));
				v.setAnio(rs.getInt("anio"));
				v.setUsuario_duenio_id(rs.getInt("usuario_duenio_id"));
				
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
	
	return v;
}


public void altaVehiculo(Vehiculo v) {
	PreparedStatement stmt= null;
	ResultSet keyResultSet=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().
				prepareStatement(
						"insert into vehiculos(patente, modelo, anio, usuario_duenio_id) values(?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS
						);
		stmt.setString(1, v.getPatente());
		stmt.setString(2, v.getModelo());
		stmt.setInt(3, v.getAnio());
		stmt.setInt(4, v.getUsuario_duenio_id());
		
	

		stmt.executeUpdate();
		
		keyResultSet=stmt.getGeneratedKeys();
		if(keyResultSet!=null && keyResultSet.next()){
            v.setId_vehiculo(keyResultSet.getInt(1));
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



public void update(Vehiculo v, int id_vehiculo) {
	PreparedStatement stmt = null;
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().prepareStatement(
				"update vehiculos set (patente = ?, modelo = ?, anio = ? , usuario_duenio_id =?) where id_vehiculo = ? ");
		
		stmt.setString(1, v.getPatente());
		stmt.setString(2, v.getModelo());
		stmt.setInt(3, v.getAnio());
		stmt.setInt(4, v.getUsuario_duenio_id());
		stmt.setInt(5, id_vehiculo);

		
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

public LinkedList<Vehiculo> getByUser(Usuario u) {
	
	LinkedList<Vehiculo> vehiculos = new LinkedList<>();
	
	
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
			"SELECT id_vehiculo, patente, modelo, anio "
			+ "FROM vehiculos "
			+ "WHERE usuario_duenio_id = ?"
			); 
		stmt.setInt(1, u.getIdUsuario());
		
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()) {
			

            
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setId_vehiculo(rs.getInt("id_vehiculo"));
            vehiculo.setPatente(rs.getString("patente"));
            vehiculo.setModelo(rs.getString("modelo"));
            vehiculo.setAnio(rs.getInt("anio"));
           
            
            vehiculos.add(vehiculo);
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
	
	return vehiculos;
}

public void delete(Vehiculo v) {
	
	PreparedStatement stmt=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"delete * from vehiculos where id_vehiculo=?"
				);
		stmt.setInt(1, v.getId_vehiculo());
		int rowsAffected = stmt.executeUpdate();
		
		if(rowsAffected > 1) {
			System.out.println("Se ha borrado el vehiculo con la patente: " +  v.getPatente());
		}else {
			System.out.println("No se ha encontrado ningún vehiculo");
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
	
public boolean eliminarVehiculo(int id_vehiculo) {
 	PreparedStatement stmt = null;

    try {
        stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
            "delete from vehiculos where id_vehiculo = ?"
        );
        stmt.setInt(1, id_vehiculo);

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;  
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (stmt != null) { stmt.close(); }
            ConnectionDB.getInstancia().releaseConn();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

    
}	
	
}
