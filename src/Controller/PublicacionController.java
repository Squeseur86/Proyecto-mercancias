package Controller;

import java.util.Date;

import Model.Publicacion;

public class PublicacionController {
	
	public Publicacion CrearPublicacion(String origen, String destino, Date fechaIda, String categoria, String pesoEquipaje,
			String espacioEquipaje){
		return new Publicacion(origen, destino, fechaIda, categoria,pesoEquipaje,
				espacioEquipaje);
	}
}
