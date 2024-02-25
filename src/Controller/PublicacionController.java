package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Publicacion;
import Model.Usuario;

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
}
