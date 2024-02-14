package Controller;

import java.util.Date;

import Model.Oferta;
import co.edu.uptc.model.Contacto;

public class OfertaControl {
	Oferta of;
	Oferta[] listaOfertas;
	Oferta[] aux;
	
	public OfertaControl(){
		listaOfertas = new Oferta[1];
		aux = new Oferta[1];
	}
	public boolean crearOferta(String descripcion, String tamaño, boolean fragil, int valor, Date fechaCreacion) {
		of = new Oferta();
		try {
			of.setDescripcion(descripcion);
			of.setTamaño(tamaño);
			of.setFragil(fragil);
			of.setValor(valor);
			of.setFechaCreacion(fechaCreacion);
			listaOfertas[listaOfertas.length -1] = of;
			aux = listaOfertas;
			listaOfertas= new Oferta[aux.length +1];
			for(int i=0; i<aux.length; i++) {
			listaOfertas[i] = aux[i];
			}
			return true;
			}catch(Exception e) {
				return false;
			
		}
	}
		public String verOferta() {
			return of.toString();
		}
		public Oferta[] verListadoOfertas() {
			return listaOfertas;
		}

}
