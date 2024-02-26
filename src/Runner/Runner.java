package Runner;

//import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import java.util.Scanner;

import Controller.OfertaControl;
import Controller.PublicacionController;
import Controller.usuarioController;
import Model.Oferta;
import Model.Publicacion;
import Vista.PublicacionVista;

public class Runner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username, email, password;
		String phoneNumber, dni = "", fullName, ex;
		int idUserValid=0;
		
		// DATOS PUBLICACION
		PublicacionController publiController = new PublicacionController();
		PublicacionVista publicacionVista = new PublicacionVista(publiController);

		Date fechaIda = null;
		usuarioController usuario = new usuarioController();
		//USUARIO TEST
		usuario.crearUsuario("j", "123");
		//Objeto para numeros aleatorios
		Random rand=new Random();
		OfertaControl oferta = new OfertaControl();
		// FORMATEAR ENTRADA DATE
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		String descripcion, tamaño = "";
		boolean fragil = false; 
		int valor, opcseguro, opOffer =0 ; 

		int opc = 0, op = 2, opdni = 0, opPublicacion = 0, opMenuPrincipal = 0, opof = 0;
		int con = 0;
		double peso = 0;
		while (opc != 3) {
			opOffer = 0;
			try {
				System.out.println("Binvenido");
				System.out.println("Elige una opcion");
				System.out.println("1. para registrarse ");
				System.out.println("2. para iniciar sesion");
				System.out.println("3. para salir");
				opc = sc.nextInt();
			} catch (Exception e) {
				System.out.println("No es numero");
				sc.next();
			}
			sc.nextLine();
			switch (opc) {
				case 1:
					con = 1;
					username = "";
					email = "";
					password = "";
					while (username.equals("") || username.equals("\n")) {
						System.out.println("ingrese un nombre de usuario");
						username = sc.nextLine();
						if (username.isEmpty()) {
							System.out.println("el nombre de usuario no puede estar vacio");
						}
					}
					while (email.equals("") || email.equals("\n")) {
						System.out.println("ingrese su correo");
						email = sc.nextLine();
						if (email.isEmpty()) {
							System.out.println("el correo no puede estar vacio");

						}
					}
					while (password.equals("") || password.equals("\n")) {
						System.out.println("ingrese una contraseña");
						password = sc.nextLine();
						if (password.isEmpty()) {
							System.out.println("la contraseña no puede estar vacia");
						}
					}
					System.out.println("ingrese su numero de telefono");
					phoneNumber = sc.nextLine();
					phoneNumber.replaceAll("\n", "");
					
						try {
							System.out.println("Cual documento quiere ingresar");
							System.out.println("1. cedula ciudadania");
							System.out.println("2. pasaporte");
							System.out.println("3. cedula de extranjeria");
							System.out.println("4. no añadir");
							op = sc.nextInt();
						} catch (Exception e) {
							System.out.println("No es numero");
							sc.next();
						}
						sc.nextLine();
					
					switch (op) {
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
					
	                         
					usuario.crearUsuario(username, email, phoneNumber, dni, fullName, password, fechaIda, fechaIda);
					break;
				case 2:
					System.out.println("ingrese su nombre de usuario");
					username=sc.next();
					System.out.println("ingrese su contraseña");
					password=sc.next();
					if(usuario.verificarUsuario(username, password)) {
						System.out.print("\033[H\033[2J");
						System.out.flush();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
						for(int i=0;i<usuario.arrayListUser().size();i++)
						{
							if(username.equals(usuario.arrayListUser().get(i).getUserName())) {
								idUserValid=usuario.arrayListUser().get(i).getId();
							}
						}
			
						while (opMenuPrincipal != 5) { //MENU UNA VEZ QUE INICIA SESION.
							System.out.println("1. Crear publicacion.");
							System.out.println("2. Ver publicaciones.");
							System.out.println("3. Crear ofertas");
							System.out.println("4. editar o borrar ofertas");
							System.out.println("5. cerrar secion");
							System.out.print("Digite la opcion que desea realizar: ");
							opMenuPrincipal = sc.nextInt();
							sc.nextLine();
							switch (opMenuPrincipal) {
								case 1:// CREAR PUBLICACION.
									publicacionVista.vistaCrearPublicacion(idUserValid);
									peso = 23.0;
									break;
								case 2:
									// SE DEBEN VER LAS PUBLICACIONES EN LA APP
									for(Publicacion publicacion : publiController.listarPublicaciones()){
										System.out.println(publicacion.toString());
									}
									System.out.println("De cual publicacion desea ver ofertas");
									op=sc.nextInt();
									for(int i=0;i<oferta.verListadoOfertas().size();i++)
									{
										if(publiController.listarPublicaciones().get(op-1).getId()==oferta.verListadoOfertas().get(i).getId())
										{
											System.out.println(oferta.verListadoOfertas().get(i).toString());
										}
									}
									
									opcseguro = 0;
									System.out.println("Cual oferta quieres aceptar");
									System.out.println("0 para ninguna");
									op = sc.nextInt();
									sc.nextLine();
	
									while(opcseguro == 0) {
										System.out.println("Oferta aceptada :" + oferta.verOferta());
										System.out.println("Estas seguro 1. si / 2. no");
										opcseguro = sc.nextInt();
										switch(opcseguro ) {
										case 1:
											System.out.println("oferta aceptada");
											break;
										case 2:
											System.out.println("Oferta no aceptadas");
											break;
										default:
											System.out.println("Opcion no valida");
										}
									}
									
									break;
								case 3:
									con= 0;
									for(Publicacion pubicacion : publiController.listarPublicaciones()){
										System.out.println(pubicacion.toString());
									}
									System.out.println("a cual publicacion deseas ofertar");
									
									op=sc.nextInt();
									sc.nextLine();
									
									if(publiController.listarPublicaciones().get(op-1)!=null)
									{
										System.out.println("Ingrese la descripcion de la oferta");
										descripcion=sc.nextLine();
										while(tamaño == "") {
										System.out.println("ingrese el tamaño de su envio");
										tamaño=sc.nextLine();
										double tam = Double.parseDouble(tamaño);
										double pesoe = Double.parseDouble(publiController.listarPublicaciones().get(op-1).getPesoEquipaje());
										if(tam >= pesoe) {
											System.out.println("Tamaño no valido");
											tamaño = "";
										}else {
											System.out.println("Tamaño valido");
										}
										}
										System.out.println(tamaño);
										System.out.print("su envio es fragil 1 para si 2 para no");
										op=sc.nextInt();
										sc.nextLine();
										while(op!=1&&op!=2) {
											switch(op)
											{
											case 1:
												fragil=true;
												break;
											case 2:
												fragil=false;
												break;
											default:
												System.out.println("valor incorrecto");
											}
										}
										System.out.println("ingrese el precio de su oferta");
										valor=sc.nextInt();
										sc.nextLine();
										while (true) {
											try {
												System.out.print("Ingrese la fecha: ");
												fechaIda = dateFormat.parse(sc.nextLine());
												break;
											} catch (ParseException e) {
												System.err.println("\n" + "Digite la fecha en formato: yyyy/mm/dd.");
											}
										}
										
										while(opof !=1 && opof!=2) {
										System.out.println("You´re sure?, 1.yes, 2.delete");
										opof = sc.nextInt();
										sc.nextLine();
										switch(opof) {
										case 1:	
											if(oferta.crearOferta(descripcion, tamaño, fragil, valor, fechaIda,publiController.returnId(con),idUserValid))
											{
												System.out.println("oferta creada correctamente");
											}else {
												System.out.println("error al crear la oferta");
											}
										break;
										case 2:
											descripcion = "";
											tamaño = "";
											fragil = false;
											valor = 0;
											fechaIda = null;
										break;
										default:
											System.err.println("Valor invorrecto");
										}
										}
									}
									break;
								case 4:
									while(opOffer == 0) {
									System.out.println("what do you want to do?");
									System.out.println("1. edit offer");
									System.out.println("2. delete offer");
									opOffer = sc.nextInt();
									sc.nextLine();
									switch(opOffer) {
									case 1:
									for(int i=0;i<oferta.verListadoOfertas().size();i++)
									{
										if(idUserValid == oferta.verListadoOfertas().get(i).getId())
										{
											System.out.println(oferta.verListadoOfertas().get(i).toString());
										}
										System.out.println("Which offer do you want to edit");
										int indexOfferEdit=0;
										indexOfferEdit=sc.nextInt();
										sc.nextLine();
										if(idUserValid == oferta.verListadoOfertas().get(indexOfferEdit).getId()) {
											System.out.println("Ingrese la descripcion de la oferta");
											descripcion=sc.nextLine();
											System.out.println("ingrese el tamaño de su envio");
											tamaño=sc.nextLine();
											System.out.print("su envio es fragil 1 para si 2 para no");
											op=sc.nextInt();
											sc.nextLine();
											while(op!=1&&op!=2) {
												switch(op)
												{
												case 1:
													fragil=true;
													break;
												case 2:
													fragil=false;
													break;
												default:
													System.out.println("valor incorrecto");
												}
											}
											System.out.println("ingrese el precio de su oferta");
											valor=sc.nextInt();
											sc.nextLine();
											while (true) {
												try {
													System.out.print("Ingrese la fecha: ");
													fechaIda = dateFormat.parse(sc.nextLine());
													break;
												} catch (ParseException e) {
													System.err.println("\n" + "Digite la fecha en formato: yyyy/mm/dd.");
												}
											}
											if(oferta.editOferta(indexOfferEdit,descripcion, tamaño, fragil, valor, fechaIda,publiController.returnId(con),idUserValid))
											{
												System.out.println("oferta creada correctamente");
											}else {
												System.err.println("error al crear la oferta");
											}
										}
									}
									break;
									case 2:
										for(int i=0;i<oferta.verListadoOfertas().size();i++)
										{
											if(idUserValid == oferta.verListadoOfertas().get(i).getId())
											{
												System.out.println(oferta.verListadoOfertas().get(i).toString());
											}

											System.out.println("Which offer do you want to edit");
											int indexOfferdelet=0;
											indexOfferdelet=sc.nextInt();
											sc.nextLine();
											if(idUserValid == oferta.verListadoOfertas().get(indexOfferdelet-1).getId()) {
												oferta.borrarOferta(indexOfferdelet-1);
											}

										}
									break;
									}
									}
									break;
								case 5:
									System.exit(0);
									break;
								default:
									System.err.println(
											"La opcion \"" + opMenuPrincipal
													+ "\" no es valida. Intentelo de nuevo.");
							}
						}
					}else {
						System.out.println("ingrese correctamente su usuario o contraseña, o registrese si no tiene cuenta");
					}
					break;
				case 3:
					System.out.println("Hasta luego");
					break;
				default:
					System.out.println("opcion no valida");
			}
		}
	}

	public static boolean inusualString(String string) {
		if (string.isEmpty())
			return true;
		if (string.trim().isEmpty())
			return true;
		return false;
	}
}
