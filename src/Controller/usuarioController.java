package Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import Model.Telefono;
import Model.Usuario;
import Controller.TelefonoController;

public class usuarioController {
    private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public void crearUsuario(String userName, String password) {
        usuarios.add(new Usuario(userName, password));
    }

    public void crearUsuario(String userName, String email,int option,String phoneNumber, String dni,
            String fullName, String password, Date createdAT, Date updateAT) {
    	TelefonoController phone = new TelefonoController();
    	
        int id = generarID();
        usuarios.add(new Usuario(id, userName, email,phone.validarTelefono(option, phoneNumber), dni, fullName, password, createdAT, updateAT));
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
        return usuarios;
    }

    public int generarID() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); // NUMERO ALEATORIO DE 10000 A 99999

    }
}
