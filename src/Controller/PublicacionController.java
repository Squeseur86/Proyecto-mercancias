package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Publicacion;
import Model.Usuario;

public class PublicacionController {
	
	private ArrayList<Publicacion> publicaciones;
	
	public void CrearPublicacion(String origen, String destino, Date fechaIda, String categoria, String pesoEquipaje,
			String espacioEquipaje){
		 publicaciones.add(new Publicacion(origen, destino, fechaIda, categoria,pesoEquipaje,
				espacioEquipaje));
	}
	
	public void listarPublicaciones() {
		for(Publicacion publicacion: publicaciones)
		{
			System.out.println( publicaciones.toString());
		}
	}
}
