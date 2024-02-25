package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Oferta;


public class OfertaControl {
	ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		public boolean crearOferta(String descripcion, String tamaño, boolean fragil, int valor, Date fechaCreacion
			,int id){
			try {
				ofertas.add(new Oferta( descripcion,tamaño, fragil, valor, fechaCreacion,id));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		public String verOferta() {
			return ofertas.toString();
		}
		public ArrayList<Oferta> verListadoOfertas() {
			return ofertas;
		}

}
