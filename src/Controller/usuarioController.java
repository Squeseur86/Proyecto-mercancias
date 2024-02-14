package Controller;

import java.util.Date;

import Model.Telefono;
import Model.Usuario;

public class usuarioController {
    public Usuario crearUsuario(String id, String userName, String email, Telefono phoneNumber, String dni,
            String fullName, String password, Date createdAT, Date updateAT) {
        return new Usuario(id, userName, email, phoneNumber, dni, fullName, password, createdAT, updateAT);
    }
}
