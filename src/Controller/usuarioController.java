package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Telefono;
import Model.Usuario;

public class usuarioController {
	
	Usuario usuario;
	Usuario[] usuarios;
	Usuario[] aux;
	
	public usuarioController()
	{
		usuarios=new Usuario[1];
		aux=new Usuario[1];
		
	}
	
	public void crearUsuario(String id, String userName, String email, String phoneNumber, String dni,
            String fullName, String password, Date createdAT, Date updateAT) {
		
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setUserName(userName);
		usuario.setEmail(email);
		usuario.setPhoneNumber(phoneNumber);
		usuario.setDni(dni);
		usuario.setFullName(fullName);
		usuario.setPassword(password);
		usuario.setCreatedAT(createdAT);
		usuario.setUpdateAT(updateAT);
		
		usuarios[usuarios.length-1]=usuario;
		aux=usuarios;
		usuarios=new Usuario[aux.length+1];
		for(int i=0;i<aux.length;i++)
		{
			usuarios[i]=aux[i];
		}
	}
	public boolean verificarUsuario(String userName, String password){
		for(int i=0;i<usuarios.length;i++){
            if(usuario.getUserName().equals(userName) && usuario.getPassword().equals(password)){
                return true;
            }
        }
        return false;
	}
	
	

    //private ArrayList<Usuario> usuarios;
    
   /* public void crearUsuario(String id, String userName, String email, String phoneNumber, String dni,
            String fullName, String password, Date createdAT, Date updateAT) {
        //usuarios.add(new Usuario(id, userName, email, phoneNumber, dni, fullName, password, createdAT, updateAT));
    }*/

    /*public boolean verificarUsuario(String userName, String password){
        if(usuarios.size() == 0) {
            return false;
        }else{
            for(Usuario usuario: usuarios){
                if(usuario.getUserName().equals(userName) && usuario.getPassword().equals(password)){
                    return true;
                }
            }
            return false;
        }
    }*/

   /* public boolean existenciaUserName(String userName){
        for(Usuario usuario: usuarios){
            if(usuario.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }
    */
	
}
