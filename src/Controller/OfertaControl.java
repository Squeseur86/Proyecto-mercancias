package Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Model.Oferta;
import Model.Publicacion;


public class OfertaControl {
	Oferta of = new Oferta();
	ArrayList<Oferta> ofertas = new ArrayList<Oferta>();
		public boolean crearOferta(String descripcion,String pesoOfe, String tamaño, boolean fragil, int valor, LocalDate fechaCreacion
			,int id,int idUser){
			try {
				ofertas.add(new Oferta( descripcion,pesoOfe, tamaño, fragil, valor, fechaCreacion,id,idUser));
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

		public boolean editOferta(int index,String descripcion,String pesoOfe, String tamaño, boolean fragil, int valor, LocalDate fechaCreacion
				,int id,int idUser){
				try {
					ofertas.set(index, (new Oferta( descripcion,pesoOfe, tamaño, fragil, valor, fechaCreacion,id,idUser)));
					return true;
				} catch (Exception e) {
					return false;
				}
			}

		public Oferta tamaño(String tamaño) {
			of.setTamaño(tamaño);
			return of;
		}
		public void borrarOferta(int n) {
			ofertas.remove(n);	
			}
		public ArrayList<Oferta> returnForID(int id){
			ArrayList<Oferta> ofertaPublicacion = new ArrayList<Oferta>();
			for(Oferta oferta: ofertas){
				if(oferta.getId() == id){
					ofertaPublicacion.add(oferta);
				}
			}
			return ofertaPublicacion;
		}
		

}
