package Runner;

import java.rmi.server.UID;
import java.util.Scanner;

import Controller.usuarioController;

public class Runner {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String username, email, password;
    	String phoneNumber, dni, fullName;
    	int opc = 0;
    	int con = 0;
    	while(opc != 3) {
    		try {
        System.out.println("Binvenido");
        System.out.println("Elige una opcion");
        System.out.println("1. para registrarse ");
        System.out.println("2. para iniciar sesion");
        System.out.println("3. para salir");
    	opc= sc.nextInt();
		}catch(Exception e) {
			System.out.println("No es numero");
			sc.next();
		}
		sc.nextLine();
		switch(opc) {
		case 1:
			con = 1;
			username = "";
			email  = "";
			password= "";
			while(username.equals("") || username.equals("\n") ){
				System.out.println("ingrese un nombre de usuario");
				username = sc.nextLine();
				if(username.isEmpty()) {
					System.out.println("el nombre de usuario no puede estar vacio");
				}
				}
			while(email.equals("") || email.equals("\n") ){
				System.out.println("ingrese su correo");
				email = sc.nextLine();
				if(email.isEmpty()) {
					System.out.println("el correo no puede estar vacio");
				}
				}
			while(password.equals("") || password.equals("\n") ){
				System.out.println("ingrese una contraseña");
				password = sc.nextLine();
				if(password.isEmpty()) {
					System.out.println("la contraseña no puede estar vacia");
				}
				}
			System.out.println("ingrese su numero de telefono");
			phoneNumber = sc.nextLine();
			phoneNumber.replaceAll("\n", "");
			System.out.println("ingrese el numero de su documento de identidad");
			dni = sc.nextLine();
			dni.replaceAll("\n", "");
			System.out.println("ingrese su nombre completo");
			fullName = sc.nextLine();
			fullName.replaceAll("\n", "");
		break;
		case 2:
			if(con == 0) {
				System.out.println("no hay cuentas creadas, crea una cuenta");
				opc = 0;
			}else {
			System.out.println("holi");
			}
		break;
		case 3:
			System.out.println("Hasta luego");
		break;
		default:
			System.out.println("opcion no valida");
		}
		if(opc ==1 || opc == 2) {
			System.out.println("holi");
		}
    	}
    }
}
