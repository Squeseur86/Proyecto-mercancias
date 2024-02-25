package Model;

import java.util.Date;

public class Oferta {
	private String descripcion ;
	private String tamaño;
	private boolean fragil;
	private int valor;
	private Date fechaCreacion;
	private int id;
	
	public Oferta(String descripcion,String tamaño,boolean fragil,int valor,Date fechaCreacion, int id)
	{
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fragil = fragil;
		this.id =id;
		this.tamaño =tamaño;
		this.valor = valor;
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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Oferta [descripcion=" + descripcion + ", tamaño=" + tamaño + ", fragil=" + fragil + ", valor=" + valor
				+ ", fecha de creacion=" + fechaCreacion + "]";
	}
	
}
