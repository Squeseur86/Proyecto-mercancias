package Runner;

import java.rmi.server.UID;
import java.util.Scanner;

import Controller.usuarioController;

public class Runner {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String username, email, password;
    	String phoneNumber, dni, fullName, ex;
    	int opc = 0, op =2, opdni = 0;
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
				while(op != 0) {
				try {
				System.out.println("Cual es la extension de correo");
				System.out.println("1. @gmail.com");
				System.out.println("2. @Outlook.com");
				System.out.println("3. @uptc.edu.co");
				op = sc.nextInt();
				}catch(Exception e) {
					System.out.println("No es numero");
					sc.next();
				}
				sc.nextLine();
				switch(op){
				case 1:
					ex ="@gmail.com";
					email = email+ ex;
					op =0 ;
				break;
				case 2:
					ex ="@outlook.com";
					email = email+ ex;
					op =0;
				break;
				case 3:
					ex ="@uptc.edu.co";
					email = email+ ex;
					op = 0;
				break;
				default:
					System.out.println("No hay mas opcion para extension");
				}
				}
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
			while(opdni != 4) {
				try {
				System.out.println("Cual documento quiere ingresar");
				System.out.println("1. cedula ciudadania");
				System.out.println("2. pasaporte");
				System.out.println("3. cedula de extranjeria");
				System.out.println("4. no añadir");
				op = sc.nextInt();
				}catch(Exception e) {
					System.out.println("No es numero");
					sc.next();
				}
				sc.nextLine();
			}
			switch(opdni) {
			case 1:
				System.out.println("ingrese el numero de su cedula de identidad");
				dni = sc.nextLine();
				
			break;
			case 2: 
				System.out.println("ingrese el numero de su cedula de identidad");
				dni = sc.nextLine();
			break;
			case 3:
				System.out.println("ingrese el numero de su cedula de identidad");
				dni = sc.nextLine();
			break;
			case 4:
				dni.replaceAll("\n", "");
			break;
			default:
				System.out.println("no es opcion valida");
			}

			System.out.println("ingrese su nombre completo");
			fullName = sc.nextLine();
			fullName.replaceAll("\n", "");
		break;
		case 2:
			
			
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
