package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Oferta;
import Model.Publicacion;

public class PublicacionController {

	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

	public void crearPublicacion(String origen, String destino, Date fechaIda, String categoria, String pesoEquipaje,
			String espacioEquipaje, int id, int idUserValid) {
		publicaciones.add(new Publicacion(origen, destino, fechaIda, categoria, pesoEquipaje,
				espacioEquipaje, id,idUserValid));
	}

	public int returnId(int index) {
		return publicaciones.get(index).getId();
	}

	public ArrayList<Publicacion> listarPublicaciones() {
		return publicaciones;
	}

	public ArrayList<Publicacion> returnActivePublications(){
		ArrayList<Publicacion> activePublications = new ArrayList<Publicacion>();
		for(Publicacion publicacion: publicaciones){
			if(publicacion.getState() == true){
				activePublications.add(publicacion);
			}
		}
		return activePublications;
	}

	public String aceptarOferta(Oferta oferta, Publicacion publicacionModi){

		double pesoDisponiblePublicacion = Double.parseDouble(publicacionModi.getPesoEquipaje());
		double espacioDisponiblePublicacion = Double.parseDouble(publicacionModi.getEspacioEquipaje());
		double pesoOferta = Double.parseDouble(oferta.getTamaño());
		double nuevoPesoPublicacion;
		if (pesoDisponiblePublicacion == 0.0 || espacioDisponiblePublicacion == 0.0) {
			return "No hay espacio disponible.";
		}
		for (Publicacion publicacion : publicaciones) {
			if (publicacionModi.equals(publicacion)) {
				nuevoPesoPublicacion = pesoDisponiblePublicacion - pesoOferta;
				if (nuevoPesoPublicacion < 0.0) {
					return "No hay espacio suficiente";
				}
				publicacion.setPesoEquipaje(String.valueOf(nuevoPesoPublicacion));
				return "Oferta procesada correctamente";
			}
		}
		return "Publicacion inexistente";
	}

	public Publicacion retornarPorId(int idPublicacion) {
		for (Publicacion publicacion : publicaciones) {
			if (idPublicacion == publicacion.getId()) {
				return publicacion;
			}
		}
		return null;
	}

	public Publicacion retornoPorIndice(int index){
		return publicaciones.get(index-1);
	}

	public ArrayList<Publicacion> retornarPorIdUser(int idUserValid){
		ArrayList<Publicacion> publicacionesUser = new ArrayList<Publicacion>();
		for(Publicacion publicacion: publicaciones){
			if(publicacion.getUserId()==idUserValid){
				publicacionesUser.add(publicacion);
			}
		}
		return publicacionesUser;
	}

	public void editarPublicacion(Publicacion publicacionEditar, String origen, String categoria, String destino, String espacioEquipaje, String pesoEquipaje, Date fechaIda) {
		publicacionEditar.setOrigen(origen);
		publicacionEditar.setCategoria(categoria);
		publicacionEditar.setDestino(destino);
		publicacionEditar.setEspacioEquipaje(espacioEquipaje);
		publicacionEditar.setFechaIda(fechaIda);
		publicacionEditar.setPesoEquipaje(pesoEquipaje);
	}
	public void borrarOferta(int index) {
		publicaciones.remove(index);
	}
}
