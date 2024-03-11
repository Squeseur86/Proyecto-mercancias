package Model;

import java.time.LocalDate;

public class Publicacion {
	private String origen;
	private String destino;
	private LocalDate fechaIda;
	private LocalDate fechaLlegada;
	private String categoria;
	private String pesoEquipaje;
	private String EspacioEquipaje;
	private int id;
	private String idUser;
	private boolean isActive;
	public Publicacion(String origen, String destino, LocalDate fechaIda, LocalDate fechaLlegada, String categoria, String pesoEquipaje,
			String espacioEquipaje, int id, String idUser) {
		this.origen = origen;
		this.destino = destino;
		this.fechaIda = fechaIda;
		this.fechaLlegada = fechaLlegada;
		this.categoria = categoria;
		this.pesoEquipaje = pesoEquipaje;
		this.EspacioEquipaje = espacioEquipaje;
		this.id = id;
		this.idUser = idUser;
		this.isActive = true;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public LocalDate getFechaIda() {
		return fechaIda;
	}
	public void setFechaIda(LocalDate fechaIda) {
		this.fechaIda = fechaIda;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPesoEquipaje() {
		return pesoEquipaje;
	}
	public void setPesoEquipaje(String pesoEquipaje) {
		this.pesoEquipaje = pesoEquipaje;
	}
	
	public LocalDate getFechaLlegada(){
		return fechaLlegada;	
	}
	public void setFechaLlegada(LocalDate fechaLlegada){
		this.fechaLlegada = fechaLlegada;
	}

	public String getEspacioEquipaje() {
		return EspacioEquipaje;
	}
	public void setEspacioEquipaje(String espacioEquipaje) {
		EspacioEquipaje = espacioEquipaje;
	}

	public String getUserId(){
		return idUser;
	}
	public void setUserId(String userId){
		this.idUser = userId;
	}

	public boolean getState(){
		return isActive;
	}
	public void setState(boolean isActive){
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Origin =" + origen + ", Destination =" + destino + ", Takeoff date=" + fechaIda + ", Category ="
				+ categoria + ", Luggage weight =" + pesoEquipaje + ", Luggage space=" + EspacioEquipaje;
	}
	public Publicacion() {
	}
	
}
