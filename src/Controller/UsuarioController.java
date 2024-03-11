package Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import Model.Telefono;
import Model.Usuario;
import Controller.TelefonoController;

public class UsuarioController {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void crearUsuario(String userName, String password) {
        usuarios.add(new Usuario(userName, password));
    }

    public Usuario returnForId(String id){
        for(Usuario user: usuarios){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public void crearUsuario(String userName, String email,Telefono telefono, String dni, String fullName, String password, LocalDate createdAT, LocalDate updateAT) {
        String id = UUID.randomUUID().toString();
        usuarios.add(new Usuario(id, userName, email,telefono, dni, fullName, password, createdAT, updateAT));
    }

    public boolean verificarUsuario(String userName, String password) {
        if (usuarios.size() == 0) {
            return false;
        } else {
            for (Usuario usuario : usuarios) {
                if (usuario.getUserName().equals(userName) && usuario.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean existenciaUserName(String userName) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Usuario> arrayListUser() {
        return this.usuarios;
    }

}
