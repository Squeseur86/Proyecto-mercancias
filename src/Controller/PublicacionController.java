package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Publicacion;
import Model.Usuario;

public class PublicacionController {
	
	//private ArrayList<Publicacion> publicaciones;
	Publicacion publicacion;
	Publicacion[] publicaciones;
	Publicacion[] aux;
	
	public PublicacionController()
	{
		publicaciones= new Publicacion[1];
		aux=new Publicacion[1];
	}
	
	public void CrearPublicacion(String origen, String destino, Date fechaIda, String categoria, String pesoEquipaje,
			String espacioEquipaje){
		/* publicaciones.add(new Publicacion(origen, destino, fechaIda, categoria,pesoEquipaje,
				espacioEquipaje));*/
		publicacion=new Publicacion();
		publicacion.setOrigen(origen);
		publicacion.setDestino(destino);
		publicacion.setFechaIda(fechaIda);
		publicacion.setCategoria(categoria);
		publicacion.setPesoEquipaje(pesoEquipaje);
		publicacion.setEspacioEquipaje(espacioEquipaje);
		
		publicaciones[publicaciones.length-1]=publicacion;
		aux=publicaciones;
		publicaciones=new Publicacion[aux.length+1];
		
		for(int i=0;i<aux.length;i++)
		{
			publicaciones[i]=aux[i];
		}
	}
	
	public Publicacion[] listarPublicaciones() {
		return publicaciones;
	}
}
