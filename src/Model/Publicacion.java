package Model;

import java.util.Date;

public class Publicacion {
	private String origen;
	private String destino;
	private Date fechaIda;
	private String categoria;
	private String pesoEquipaje;
	private String EspacioEquipaje;
	private int id;
	private int idUser;
	public Publicacion(String origen, String destino, Date fechaIda, String categoria, String pesoEquipaje,
			String espacioEquipaje, int id, int idUser) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.fechaIda = fechaIda;
		this.categoria = categoria;
		this.pesoEquipaje = pesoEquipaje;
		this.EspacioEquipaje = espacioEquipaje;
		this.id = id;
		this.idUser = idUser;
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
	public Date getFechaIda() {
		return fechaIda;
	}
	public void setFechaIda(Date fechaIda) {
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
	public String getEspacioEquipaje() {
		return EspacioEquipaje;
	}
	public void setEspacioEquipaje(String espacioEquipaje) {
		EspacioEquipaje = espacioEquipaje;
	}

	public int getUserId(){
		return idUser;
	}
	public void setUserId(int userId){
		this.idUser = userId;
	}
	@Override
	public String toString() {
		return "Publicacion [origen=" + origen + ", destino=" + destino + ", fechaIda=" + fechaIda + ", categoria="
				+ categoria + ", pesoEquipaje=" + pesoEquipaje + ", EspacioEquipaje=" + EspacioEquipaje + "]";
	}
	public Publicacion() {
		// TODO Auto-generated constructor stub
	}
	
}
