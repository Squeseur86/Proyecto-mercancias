package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Oferta;
import Model.Publicacion;


public class OfertaControl {
	Oferta of = new Oferta();
	ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		public boolean crearOferta(String descripcion, String tamaño, boolean fragil, int valor, Date fechaCreacion
			,int id,int idUser){
			try {
				ofertas.add(new Oferta( descripcion,tamaño, fragil, valor, fechaCreacion,id,idUser));
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

		public boolean editOferta(int index,String descripcion, String tamaño, boolean fragil, int valor, Date fechaCreacion
				,int id,int idUser){
				try {
					ofertas.set(index, (new Oferta( descripcion,tamaño, fragil, valor, fechaCreacion,id,idUser)));
					return true;
				} catch (Exception e) {
					return false;
				}
			}

		public Oferta tamaño(String tamaño) {
			of.setTamaño(tamaño);
			return of;
		}
		

}
