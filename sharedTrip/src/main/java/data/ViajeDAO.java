package data;

import java.sql.*;
import java.util.LinkedList;

import entidades.Reserva;
import entidades.Usuario;
import entidades.Viaje;

public class ViajeDAO {

	public LinkedList<Viaje> getAll() {
		Statement stmt = null;
		ResultSet rs = null;
		LinkedList<Viaje> viajes = new LinkedList<>();

		try {
			stmt = ConnectionDB.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from viajes");

			if (rs != null) {
				while (rs.next()) {
					Viaje v = new Viaje();

					v.setIdViaje(rs.getInt("id_viaje"));
					v.setFecha(rs.getDate("fecha"));
					v.setLugares_disponibles(rs.getInt("lugares_disponibles"));
					v.setOrigen(rs.getString("origen"));
					v.setDestino(rs.getString("destino"));
					v.setPrecio_unitario(rs.getDouble("precio_unitario"));
					v.setCancelado(rs.getBoolean("cancelado"));
					v.setLugar_salida(rs.getString("lugar_salida"));
					UserDAO usuarioDAO = new UserDAO();
					Usuario conductor = usuarioDAO.getById(rs.getInt("id_conductor"));
					v.setConductor(conductor);

					viajes.add(v);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return viajes;
	}

	public LinkedList<Viaje> getAllBySearch(String origen, String destino, String fecha) { //HAY QUE VER SI EXISTE ALGUNA API PARA PROXIMIDAD
		LinkedList<Viaje> viajes = new LinkedList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
					"select id_viaje,fecha, lugares_disponibles, origen, destino,precio_unitario, cancelado, id_conductor, lugar_salida from viajes where origen=? and destino=? and fecha =?");
			stmt.setString(1, origen);
			stmt.setString(2, destino);
			stmt.setDate(3, java.sql.Date.valueOf(fecha));

			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				Viaje v = new Viaje();

				v.setIdViaje(rs.getInt("id_viaje"));
				v.setFecha(rs.getDate("fecha"));
				v.setLugares_disponibles(rs.getInt("lugares_disponibles"));
				v.setOrigen(rs.getString("origen"));
				v.setDestino(rs.getString("destino"));
				v.setPrecio_unitario(rs.getDouble("precio_unitario"));
				v.setCancelado(rs.getBoolean("cancelado"));
				v.setLugar_salida(rs.getString("lugar_salida"));

				UserDAO usuarioDAO = new UserDAO();
				Usuario conductor = usuarioDAO.getById(rs.getInt("id_conductor"));
				v.setConductor(conductor);
				viajes.add(v);
			}
			return viajes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {

				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return viajes;
	}

	public Viaje getByViaje(int id_viaje) {

		Viaje v = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
					"select id_viaje,fecha, lugares_disponibles, origen, destino,precio_unitario, cancelado, id_conductor, lugar_salida from viajes where id_viaje=?");
			stmt.setInt(1, id_viaje);

			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				v = new Viaje();

				v.setIdViaje(rs.getInt("id_viaje"));
				v.setFecha(rs.getDate("fecha"));
				v.setLugares_disponibles(rs.getInt("lugares_disponibles"));
				v.setOrigen(rs.getString("origen"));
				v.setDestino(rs.getString("destino"));
				v.setPrecio_unitario(rs.getDouble("precio_unitario"));
				v.setCancelado(rs.getBoolean("cancelado"));
				v.setLugar_salida(rs.getString("lugar_salida"));

				UserDAO usuarioDAO = new UserDAO();
				Usuario conductor = usuarioDAO.getById(rs.getInt("id_conductor"));
				v.setConductor(conductor);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return v;
	}

	public LinkedList<Viaje> getByUser(Usuario u) {

		LinkedList<Viaje> viajes = new LinkedList<>();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
					"SELECT id_viaje, fecha, lugares_disponibles, origen, destino, precio_unitario, cancelado, id_conductor, lugar_salida "
							+ "FROM viajes " + "WHERE id_conductor = ? ");
			stmt.setInt(1, u.getIdUsuario());

			rs = stmt.executeQuery();
			while (rs != null && rs.next()) {

				Viaje viaje = new Viaje();
				viaje.setIdViaje(rs.getInt("id_viaje"));
				viaje.setOrigen(rs.getString("origen"));
				viaje.setDestino(rs.getString("destino"));
				viaje.setFecha(rs.getDate("fecha"));
				viaje.setLugares_disponibles(rs.getInt("lugares_disponibles"));
				viaje.setPrecio_unitario(rs.getDouble("precio_unitario"));
				viaje.setCancelado(rs.getBoolean("cancelado"));
				viaje.setLugar_salida(rs.getString("lugar_salida"));

				viajes.add(viaje);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return viajes;
	}

	public void add(Viaje v) {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
					"insert into viajes(id_viaje,fecha, lugares_disponibles, origen, destino,precio_unitario, cancelado, id_conductor, lugar_salida) values(?,?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, v.getIdViaje());
			stmt.setDate(2, v.getFecha());
			stmt.setInt(3, v.getLugares_disponibles());
			stmt.setString(4, v.getOrigen());
			stmt.setString(5, v.getDestino());
			stmt.setDouble(6, v.getPrecio_unitario());
			stmt.setBoolean(7, v.isCancelado());

			stmt.setInt(8, v.getConductor().getIdUsuario());
			stmt.setString(9, v.getLugar_salida());

			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (keyResultSet != null)
					keyResultSet.close();
				if (stmt != null)
					stmt.close();
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateCantidad(int idViaje, int cantPasajeros) {
		PreparedStatement stmt = null;

		try {
			stmt = ConnectionDB.getInstancia().getConn()
					.prepareStatement("UPDATE viajes SET lugares_disponibles = ? where id_viaje = ? ");

			stmt.setInt(1, cantPasajeros);
			stmt.setInt(2, idViaje);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean cancelarViaje(int id_viaje, int id_usuario) {
		PreparedStatement stmt = null;
		boolean cancelada = false;

		try {
			stmt = ConnectionDB.getInstancia().getConn()
					.prepareStatement("UPDATE viajes SET cancelado = true WHERE id_viaje = ? AND id_conductor = ?");
			stmt.setInt(1, id_viaje);
			stmt.setInt(2, id_usuario);

			int rowsAffected = stmt.executeUpdate();
			cancelada = (rowsAffected > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cancelada;
	}

	public void update(Viaje v, int id_viaje) {
		PreparedStatement stmt = null;

		try {
			stmt = ConnectionDB.getInstancia().getConn().prepareStatement(
					"UPDATE viajes SET (fecha = ? , lugares_disponibles =?, origen =?, destino =?, precio_unitario =?, cancelado =?, id_conductor =?, lugar_salida =?) where id_viaje = ? ");

			stmt.setInt(1, id_viaje);
			stmt.setDate(2, v.getFecha());
			stmt.setInt(3, v.getLugares_disponibles());
			stmt.setString(4, v.getOrigen());
			stmt.setString(5, v.getDestino());
			stmt.setDouble(6, v.getPrecio_unitario());
			stmt.setBoolean(7, v.isCancelado());
			stmt.setInt(8, v.getConductor().getIdUsuario());
			stmt.setString(9, v.getLugar_salida());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Viaje v) {

		PreparedStatement stmt = null;
		try {
			stmt = ConnectionDB.getInstancia().getConn().prepareStatement("delete * from viajes where id_viaje=?");
			stmt.setInt(1, v.getIdViaje());
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 1) {
				System.out.println("Se ha borrado el viaje con el id: " + v.getIdViaje());
			} else {
				System.out.println("No se ha encontrado ningún viaje con ese id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				ConnectionDB.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}