package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entidades.Vehiculo;

public class VehiculoDAO {
	
	
	public LinkedList<Vehiculo> getAll(){
	Statement stmt=null;
	ResultSet rs=null;
	LinkedList<Vehiculo> vehiculos= new LinkedList<>();
	
	try {
		stmt= ConnectionDB.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("select patente,modelo, anio, usuario_duenio_id from vehiculos");
		
		if(rs!=null) {
			while(rs.next()) {
				Vehiculo v=new Vehiculo();
				
				v.setPatente(rs.getInt("patente"));
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
	
	return vehiculos;}

public Vehiculo getByPatente(int patente) {

	Vehiculo v=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"select patente,modelo, anio, usuario_duenio_id from vehiculos where patente=?"
				); 
		stmt.setInt(1, patente);
		
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()) {
			v=new Vehiculo();
				v.setPatente(rs.getInt("patente"));
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



public void add(Vehiculo v) {
	PreparedStatement stmt= null;
	ResultSet keyResultSet=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().
				prepareStatement(
						"insert into vehiculos(patente, modelo, anio, usuario_duenio_id) values(?,?,?,?,?,?)",
						PreparedStatement.RETURN_GENERATED_KEYS
						);
		stmt.setInt(1, v.getPatente());
		stmt.setString(2, v.getModelo());
		stmt.setInt(3, v.getAnio());
		stmt.setInt(4, v.getUsuario_duenio_id());
	

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



public void update(Vehiculo v, int patente) {
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



public void delete(Vehiculo v) {
	
	PreparedStatement stmt=null;
	try {
		stmt=ConnectionDB.getInstancia().getConn().prepareStatement(
				"delete * from vehiculos where patente=?"
				);
		stmt.setInt(1, v.getPatente());
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
	
	
	
}
