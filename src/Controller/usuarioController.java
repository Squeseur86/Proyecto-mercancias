package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Telefono;
import Model.Usuario;

public class usuarioController {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void crearUsuario(String userName, String password){
        usuarios.add(new Usuario(userName,password));
    }
    
    public void crearUsuario(String id, String userName, String email, String phoneNumber, String dni,
            String fullName, String password, Date createdAT, Date updateAT) {
        usuarios.add(new Usuario(id, userName, email, phoneNumber, dni, fullName, password, createdAT, updateAT));
    }

    public boolean verificarUsuario(String userName, String password){
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
    }

    public boolean existenciaUserName(String userName){
        for(Usuario usuario: usuarios){
            if(usuario.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }
    
	
}
