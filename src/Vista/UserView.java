package Vista;

import java.util.Date;
import java.util.Scanner;

import Controller.TelefonoController;
import Controller.UsuarioController;
import Model.Telefono;
import Model.Usuario;

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

        userName = validarUserName(userName, false);
        email = validarEmail(email, false);
        password = validarPassword(password, false);
        telefono = validarNumeroTelefono(phoneNumber);
        dni = validarDocumento(dni);
        fullName = validarNombreCompleto(fullName, false);
        usuariosController.crearUsuario(userName, email, telefono, dni, fullName, password, fechaIda, fechaIda);
    }

    public String borrarUser(int idUser) {
        int op = 0;
        while (true) {
            System.out.println("Are you sure you want to delete your account:\r\n" +
                    "1. Yes\r\n" +
                    "2. no");
            System.out.print("Enter the number of the option you want to perform: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    usuariosController.arrayListUser().removeIf(user -> user.getId() == idUser);
                    return "User deleted successfully";
                case 2:
                    return "Operation cancelled";

                default:
                    System.err.println("The option \"" + op + "\" is not valid, please try again");
                    break;
            }
        }
    }

    public String editUser(int idUser) {
        int op = 0;
        String userName = "", email = "", password = "", phoneNumber = "", dni = "", fullName = "";
        Date fechaIda = null;
        Telefono telefono;
        userName = validarUserName(userName, true);
        email = validarEmail(email, true);
        password = validarPassword(password, true);
        telefono = validarNumeroTelefono(phoneNumber);
        dni = validarDocumento(dni);
        fullName = validarNombreCompleto(fullName, true);

        while (true) {
            System.out.println("Are you sure you want to edit your account:\r\n" +
                    "1. Yes\r\n" +
                    "2. no");
            System.out.print("Enter the number of the option you want to perform: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    for (Usuario user : usuariosController.arrayListUser()) {
                        if (user.getId() == idUser) {
                            user.setDni(dni);
                            user.setPhoneNumber(telefono);
                            user.setEmail(email);
                            user.setFullName(fullName);
                            user.setPassword(password);
                            user.setUpdateAT(fechaIda);
                            return "User successfully updated";
                        }
                    }
                case 2:
                    return "Operation cancelled";
                default:
                    System.err.println("The option \"" + op + "\" is not valid, please try again");
                    break;
            }
        }
    }

    // Validaciones para signUp \/
    private String validarNombreCompleto(String nombreCompleto, boolean edit) {
        while (inusualString(nombreCompleto)) {
            if (edit == false) {
                System.out.print("Enter the full name: ");
            } else {
                System.out.print("Enter the full name(if you want to keep the current name, press enter): ");
            }
            nombreCompleto = sc.nextLine();
            if (nombreCompleto.isEmpty() && edit == true) {
                return "";
            }
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
                		int c = 0; 
                    	while(dni.length()!=10) {
                    		if(c >0) {
                    			System.err.println("needs 10 characters(numbers)");
                    		}
                            System.out.print("Enter your identification card number: ");
                            dni = sc.nextLine();
                            for (int i = 0; i < dni.length(); i++)
                            {
                                char d = dni.charAt(i);
                                if (d < '0' || d > '9') {
                                	dni = "2";
                                }else {
                                }

                            }              
                        c++;
                    	}
                        
                        if (inusualString(dni)) {
                            System.err.println(
                                    "The identification card  \"" + dni + "\" is not valid, please try again.");
                        } else {
                            return dni;
                        }
                        break;
                    case 2:
                		int cp = 0; 
                    	while(dni.length()!=8) {
                    		if(cp >0) {
                    			System.err.println("needs 8 characters(2 letter and 6 numbers)");
                    		}
                            System.out.print("Enter your passport number: ");
                            dni = sc.nextLine();
                            for (int i = 0; i < dni.length()-6; i++)  {
                                char d = dni.charAt(i);
                                if (d < 'A' || d > 'Z') {
                                	dni = "2";
                                }
                            }    
                            for (int i = 2; i < dni.length(); i++)  {
                                char d = dni.charAt(i);
                                if (d < '0' || d > '9') {
                                	dni = "2";
                                }
                            }    
                            
                        cp++;
                    	}

                        if (inusualString(dni)) {
                            System.err.println(
                                    "The passport  \"" + dni + "\" is not valid, please try again.");
                        } else {
                            return dni;
                        }
                        break;
                    case 3:
                		int e = 0; 
                    	while(dni.length()!=6) {
                    		if(e >0) {
                    			System.err.println("needs 6 characters(numbers)");
                    		}
                            System.out.print("Enter your immigration card number: ");
                            dni = sc.nextLine();
                            for (int i = 0; i < dni.length(); i++)
                            {
                                char d = dni.charAt(i);
                                if (d < '0' || d > '9') {
                                	dni = "2";
                                }else {
                                }

                            }              
                        e++;
                    	}
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

    private String validarPassword(String password, boolean edit) {
        while (true) {
            System.out.println("Your password must contain:\n" +
                    "-A capital letter\n" +
                    "-A lowercase\n" +
                    "-At least 2 numbers\n" +
                    "-A special character");
            if (edit == false) {
                System.out.print("Enter your password: ");
            } else {
                System.out.print("Enter your password(if you want to keep your current password, press enter): ");
            }
            password = sc.nextLine();
            if (password.isEmpty() && edit == true) {
                return "";
            }
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

    private String validarEmail(String email, boolean edit) {
        while (true) {
            System.out.println("Allowed email extensions: ");
            System.out.println("@gmail.com");
            System.out.println("@outlook.com");
            System.out.println("@uptc.edu.co");
            System.out.print("Enter your email: ");
            if (edit == false) {
                System.out.print("Enter your email: ");
            } else {
                System.out.print("Enter your email(if you want to keep your current email, press enter): ");
            }
            email = sc.nextLine();
            if (email.isEmpty() && edit == true) {
                return "";
            }
            if (inusualString(email)) {
                System.err.println("The email \"" + email + "\" is not valid. Please try again.");
                continue;
            }
            if(!email.contains("@")){
                System.err.println("The email \"" + email + "\" is not valid. Please try again.");
                continue;
            }
            String[] emailParts = email.split("@");
            if(emailParts.length>2 || emailParts.length<2){
                System.err.println("The email \"" + email + "\" is not valid. Please try again.");
                continue;
            }
            if(inusualString(emailParts[0])){
                System.err.println("The email \"" + email + "\" is not valid. Please try again.");
                continue;
            }
            if (email.endsWith("@gmail.com") || email.endsWith("@outlook.com") || email.endsWith("@uptc.edu.co")) {
                return email;
            } else {
                System.err.println("The email \"" + email + "\" is not valid. Please try again.");
            }

        }

    }

    public String validarUserName(String userName, boolean edit) {
        while (true) {
    		int c = 0; 
        	while(userName.length()<5) {
        		if(c >0) {
        			System.err.println("minimum 5 characters");
        		}
        		if (edit == false) {
        			System.out.print("Enter a username: ");
        		} else {
        			System.out.print("Enter a username(if you want to keep your current password, press enter): ");
        		}
            userName = sc.nextLine();
            c++;
        	}
            if (userName.isEmpty() && edit == true ) {
                return "";
            }
            if (inusualString(userName)) {
                System.err.println("The user name \"" + userName + "\" is not valid. Please try again.");
                continue;
            }
            if (usuariosController.existenciaUserName(userName)) {
                System.err.println("The user name \"" + userName + "\" it already exists. Please try again.");
            } else {
                return userName;
            }
        }
    }
}
