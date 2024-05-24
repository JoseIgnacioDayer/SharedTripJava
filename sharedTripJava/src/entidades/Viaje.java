package entidades;

public class Viaje {
	public int idViaje;
	public String fecha;
	public int vacantes;
	public int vacantesDisponibles;
	public String origen;
	public String destino; 
	public double precioUnitario;
	public boolean baja;
	public String lugarSalida;
	public String tiempoCancelacion; //fijarse el tipo
	
	// ---------------------------------------- GETTERS AND SETTERS --------------------------------------
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getVacantes() {
		return vacantes;
	}
	public void setVacantes(int vacantes) {
		this.vacantes = vacantes;
	}
	public int getVacantesDisponibles() {
		return vacantesDisponibles;
	}
	public void setVacantesDisponibles(int vacantesDisponibles) {
		this.vacantesDisponibles = vacantesDisponibles;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public boolean isBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	public String getLugarSalida() {
		return lugarSalida;
	}
	public void setLugarSalida(String lugarSalida) {
		this.lugarSalida = lugarSalida;
	}
	public String getTiempoCancelacion() {
		return tiempoCancelacion;
	}
	public void setTiempoCancelacion(String tiempoCancelacion) {
		this.tiempoCancelacion = tiempoCancelacion;
	}
	
	// ---------------------------------------- CONSTRUCTOR --------------------------------------
	public Viaje(int idViaje, String fecha, int vacantes, int vacantesDisponibles, String origen, String destino,
			double precioUnitario, boolean baja, String lugarSalida, String tiempoCancelacion) {
		super();
		this.idViaje = idViaje;
		this.fecha = fecha;
		this.vacantes = vacantes;
		this.vacantesDisponibles = vacantesDisponibles;
		this.origen = origen;
		this.destino = destino;
		this.precioUnitario = precioUnitario;
		this.baja = baja;
		this.lugarSalida = lugarSalida;
		this.tiempoCancelacion = tiempoCancelacion;
	}

}
