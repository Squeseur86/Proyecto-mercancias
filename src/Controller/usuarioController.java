package Controller;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.Telefono;
import Model.Usuario;

public class usuarioController {
    public Usuario crearUsuario(String id, String userName, String email, Telefono phoneNumber, String dni,
            String fullName, String password, Date createdAT, Date updateAT) {
        return new Usuario(id, userName, email, phoneNumber, dni, fullName, password, createdAT, updateAT);
    }

    public Telefono validarTelefono(int option, String telefono) {
        switch (option) {
            case 1: // +54 argentina
                if (validarTelefonoArgentina(telefono)) {
                    return new Telefono("+54","Argentina",telefono);
                }
                break;
            case 2: // +34 españa
                if (validarTelefonoEspana(telefono)) {
                    return new Telefono("+34","Espana",telefono);
                }
                break;
            case 3: // +507 panama
                if (validarTelefonoPanama(telefono)) {
                    return new Telefono("+507","Panama",telefono);
                }
                break;
            case 4: // +57 colombia
                if (validarTelefonoColombia(telefono)) {
                    return new Telefono("+57","Colombia",telefono);
                }
                break;
            case 5: // +504 honduras
                if (validarTelefonoHonduras(telefono)) {
                    return new Telefono("+504","Honduras",telefono);
                }
                break;
            case 6: // +55 brasil
                if (validarTelefonoBrasil(telefono)) {
                    return new Telefono("+55","Brasil",telefono);
                }
                break;
            case 7: // +1 estados unidos
                if (validarTelefonoEstadosUnidos(telefono)) {
                    return new Telefono("+1","Estados Unidos",telefono);
                }
                break;
            case 8: // +52 mexico
                if (validarTelefonoMexico(telefono)) {
                    return new Telefono("+52","Mexico",telefono);
                }
                break;
            case 9: // +385 croacia
                if (validarTelefonoCroacia(telefono)) {
                    return new Telefono("+385","Croacia",telefono);
                }
                break;
            case 10: // +39 italia
                if (validarTelefonoItalia(telefono)) {
                    return new Telefono("+39","Italia",telefono);
                }
                break;
            default:
                System.out.println("No se ha implementado la validación para el país.");
                return null;
        }
        return null;
    }


    //VALIDACIONES SEGUN EL FORMATO DE CADA PAIS.
    private boolean validarTelefonoArgentina(String telefono) {
        String formato = "(\\d{1,2})\\s(\\d{4}-\\d{4})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoEspana(String telefono) {
        String formato = "(\\d{1,2})\\s(\\d{9})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoColombia(String telefono) {
        String formato = "(\\d{10})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoHonduras(String telefono) {
        String formato = "(\\d{8})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoBrasil(String telefono) {
        String formato = "(\\d{10})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoEstadosUnidos(String telefono) {
        String formato = "(\\d{10})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoMexico(String telefono) {
        String formato = "(\\d{10})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoCroacia(String telefono) {
        String formato = "(\\d{9})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoItalia(String telefono) {
        String formato = "(\\d{10})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }

    private boolean validarTelefonoPanama(String telefono) {
        String formato = "(\\d{8})";
        Pattern patron = Pattern.compile(formato);
        Matcher verificarPatron = patron.matcher(telefono);
        return verificarPatron.matches();
    }
}
