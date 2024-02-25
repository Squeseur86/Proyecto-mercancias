package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Publicacion;
import Model.Usuario;

public class PublicacionController {

	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
	public void crearPublicacion(String origen, String destino, Date fechaIda, String categoria, String pesoEquipaje,
			String espacioEquipaje) {
		publicaciones.add(new Publicacion(origen, destino, fechaIda, categoria, pesoEquipaje,
				espacioEquipaje));
	}

	public ArrayList<Publicacion> listarPublicaciones() {
		return publicaciones;
	}
}
