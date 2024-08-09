package data;
import java.sql.*;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/shared_trip";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "admin";
    private static ConnectionDB instancia;
    private int conectados = 0;
    private Connection conn = null;

    
	private ConnectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionDB getInstancia() {
		if (instancia == null) {
			instancia = new ConnectionDB();
		}
		return instancia;
	}
	
	public Connection getConn() {
		try {
			if(conn==null || conn.isClosed()) {
				conn=DriverManager.getConnection(URL, USUARIO, CONTRASENA);
				conectados=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conectados++;
		return conn;
	}
	
	public void releaseConn() {
		conectados--;
		try {
			if (conectados<=0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


