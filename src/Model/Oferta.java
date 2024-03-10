package Model;

import java.time.LocalDate;
import java.util.Date;

public class Oferta {
	private String descripcion ;
	private String pesoOfe;
	private String tamaño;
	private boolean fragil;
	private int valor;
	private LocalDate fechaCreacion;
	private int id;
	private int idUser;
	
	public Oferta(String descripcion, String pesoOfe, String tamaño,boolean fragil,int valor, LocalDate fechaCreacion, int id,int idUser)
	{
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fragil = fragil;
		this.id =id;
		this.pesoOfe = pesoOfe;
		this.tamaño =tamaño;
		this.valor = valor;
		this.idUser=idUser;
	}
	

	public String getPesoOfe() {
		return pesoOfe;
	}


	public void setPesoOfe(String pesoOfe) {
		this.pesoOfe = pesoOfe;
	}


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Oferta() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public boolean isFragil() {
		return fragil;
	}

	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Oferta [descripcion=" + descripcion + ", tamaño=" + tamaño + ", fragil=" + fragil + ", valor=" + valor
				+ ", fecha de creacion=" + fechaCreacion + "]";
	}
	
}
