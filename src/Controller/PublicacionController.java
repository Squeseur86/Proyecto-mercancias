package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Oferta;
import Model.Publicacion;

public class PublicacionController {

	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
	public void crearPublicacion(String origen, String destino, Date fechaIda, String categoria, String pesoEquipaje,
			String espacioEquipaje,int id) {
		publicaciones.add(new Publicacion(origen, destino, fechaIda, categoria, pesoEquipaje,
				espacioEquipaje,id));
	}
	
	public int returnId(int index) {
		return publicaciones.get(index).getId();
	}

	public ArrayList<Publicacion> listarPublicaciones() {
		return publicaciones;
	}

	public String aceptarOferta(Oferta oferta, Publicacion publicacionModi){
		double pesoDisponiblePublicacion = Double.parseDouble(publicacionModi.getPesoEquipaje());
		double espacioDisponiblePublicacion = Double.parseDouble(publicacionModi.getEspacioEquipaje());
		double pesoOferta = Double.parseDouble(oferta.getTamaño());
		double nuevoPesoPublicacion;
		if(pesoDisponiblePublicacion == 0.0 || espacioDisponiblePublicacion == 0.0){
			return "No hay espacio disponible."; 
		}
		for(Publicacion publicacion : publicaciones){
			if(publicacionModi.equals(publicacion)){
				nuevoPesoPublicacion = pesoDisponiblePublicacion - pesoOferta;
				if(nuevoPesoPublicacion < 0.0){
					return "No hay espacio suficiente";
				}
				publicacion.setPesoEquipaje(String.valueOf(nuevoPesoPublicacion)); 
				return "Oferta procesada correctamente";
			}
		}
		return "Publicacion inexistente";
	}
}
