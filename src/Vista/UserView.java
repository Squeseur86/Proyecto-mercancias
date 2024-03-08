package Vista;

import java.util.Date;
import java.util.Scanner;

import Controller.TelefonoController;
import Controller.UsuarioController;
import Model.Telefono;

public class UserView {
    private Scanner sc = new Scanner(System.in);
    private UsuarioController usuariosController;
    private TelefonoController telController;

    public UserView(UsuarioController usuariosController, TelefonoController telController) {
        this.usuariosController = usuariosController;
        this.telController = telController;
    }

    public static boolean inusualString(String string) {
        if (string.isEmpty())
            return true;
        if (string.trim().isEmpty())
            return true;
        return false;
    }

    

    public void signUp() {
        String userName = "", email = "", password = "", phoneNumber = "", dni = "", fullName = "";
        Date fechaIda = null;
        Telefono telefono;

        userName = validarUserName(userName);
        email = validarEmail(email);
        password = validarPassword(password);
        telefono = validarNumeroTelefono(phoneNumber);
        dni = validarDocumento(dni);
        fullName = validarNombreCompleto(fullName);
        usuariosController.crearUsuario(userName, email, telefono, dni, fullName,password, fechaIda, fechaIda);
    }

    private String validarNombreCompleto(String nombreCompleto){
        while (inusualString(nombreCompleto)) {
            System.out.print("Enter the full name: ");
            nombreCompleto = sc.nextLine();
            if (inusualString(nombreCompleto)) {
                System.err.println("The entry \"" + nombreCompleto + "\" is not valid. Please try again.");
            }
        }
        return nombreCompleto;
    }

    private String validarDocumento(String dni) {
        int opDni = 0;
        while (true) {
            try {
                System.out.println("Add document.");
                System.out.println("1. Identification card");
                System.out.println("2. Passport");
                System.out.println("3. Immigration card");
                System.out.println("4. Do not add");
                System.out.println("Enter the option number of the document you wish to enter: ");
                opDni = sc.nextInt();
                sc.nextLine();
                switch (opDni) {
                    case 1:
                        System.out.print("Enter your identification card number: ");
                        dni = sc.nextLine();
                        if (inusualString(dni)) {
                            System.err.println(
                                    "The identification card  \"" + dni + "\" is not valid, please try again.");
                        } else {
                            return dni;
                        }
                        break;
                    case 2:
                        System.out.print("Enter your passport number: ");
                        dni = sc.nextLine();
                        if (inusualString(dni)) {
                            System.err.println(
                                    "The passport  \"" + dni + "\" is not valid, please try again.");
                        } else {
                            return dni;
                        }
                        break;
                    case 3:
                        System.out.print("Enter your immigration card number: ");
                        dni = sc.nextLine();
                        if (inusualString(dni)) {
                            System.err.println(
                                    "The immigration card  \"" + dni + "\" is not valid, please try again.");
                        } else {
                            return dni;
                        }
                    case 4:
                        return "Not added";
                    default:
                        System.err.println("The option  \"" + opDni + "\" is not valid, please try again.");
                }
            } catch (Exception e) {
                System.err.println("The option \"" + opDni + "\" is not valid, please try again.");
            }
        }
    }

    private Telefono validarNumeroTelefono(String phoneNumber) {
        int opExtension = 0;
        Telefono telefono;
        while (true) {
            try {
                System.out.println("List of extensions(countries) allowed for the phone number: ");
                System.out.println("1. +54 Argentina");
                System.out.println("2. +34 Spain");
                System.out.println("3. +507 Panama");
                System.out.println("4. +57 Colombia");
                System.out.println("5. +504 Honduras");
                System.out.println("6. +55 Brasil");
                System.out.println("7. +54 United States");
                System.out.println("8. +52 Mexico");
                System.out.println("9. +385 Croacia");
                System.out.println("10. +39 Italy");
                System.out.println("11. Dont add");
                System.out.print("Enter the number next to your phone extension (country): ");
                opExtension = sc.nextInt();
                sc.nextLine();
                if (opExtension < 1 || opExtension > 11) {
                    System.err.println("The option  \"" + opExtension + "\" is not valid, please try again.");
                    continue;
                }
                if (opExtension == 11) {
                    return null;
                }
                System.out.print("Enter your phone number: ");
                phoneNumber = sc.nextLine();
                telefono = telController.validarTelefono(opExtension, phoneNumber);
                if (telefono == null) {
                    System.err.println("The phone number \"" + phoneNumber + "\" is not valid, please try again.");
                } else {
                    return telefono;
                }
            } catch (Exception e) {
                System.err.println("The option \"" + opExtension + "\" is not valid, please try again.");
            }
        }
    }

    private String validarPassword(String password) {
        while (true) {
            System.out.println("Your password must contain:\n"+
            "-A capital letter\n"+
            "-A lowercase\n"+
            "-At least 2 numbers\n"+
            "-A special character");
            System.out.print("Enter your password: ");
            password = sc.nextLine();
            if (inusualString(password)) {
                System.err.println("The password \"" + password + "\" is not valid. Please try again.");
                continue;
            }
            if (verificarPassword(password)) {
                return password;
            } else {
                System.err.println("The password \"" + password + "\" is not valid. Please try again.");
            }
        }
    }

    public static boolean verificarPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean mayuscula = false;
        boolean minuscula = false;
        int countNumeros = 0;
        boolean tieneEspecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                mayuscula = true;
            } else if (Character.isLowerCase(c)) {
                minuscula = true;
            } else if (Character.isDigit(c)) {
                countNumeros++;
            } else {
                tieneEspecial = true;
            }
        }
        return mayuscula && minuscula && countNumeros >= 2 && tieneEspecial;
    }

    private String validarEmail(String email) {
        while (true) {
            System.out.println("Allowed email extensions: ");
            System.out.println("@gmail.com");
            System.out.println("@outlook.com");
            System.out.println("@uptc.edu.co");
            System.out.print("Enter your email: ");
            email = sc.nextLine();
            if (inusualString(email)) {
                if (inusualString(email)) {
                    System.err.println("The email \"" + email + "\" is not valid. Please try again.");
                }
            }
            if (email.endsWith("@gmail.com") || email.endsWith("@outlook.com") || email.endsWith("@uptc.edu.co")) {
                return email;
            } else {
                System.err.println("The email \"" + email + "\" is not valid. Please try again.");
            }

        }

    }

    public String validarUserName(String userName) {
        while (true) {
            System.out.print("\nEnter a username: ");
            userName = sc.nextLine();
            if (inusualString(userName)) {
                System.err.println("The user name \"" + userName + "\" is not valid. Please try again.");
                continue;
            }
            if(usuariosController.existenciaUserName(userName)){
                System.err.println("The user name \"" + userName + "\" it already exists. Please try again.");
            }else{
                return userName;
            }
        }  
    }
}
