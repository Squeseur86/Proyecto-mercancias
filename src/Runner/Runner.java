package Runner;

//import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Controller.OfertaControl;
import Controller.PublicacionController;
import Controller.usuarioController;

public class Runner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username, email, password;
		String phoneNumber, dni = "", fullName, ex;

		// DATOS PUBLICACION
		String origen = "", destino = "", categoria = "", pesoEquipaje = "", espacioEquipaje = "";
		Date fechaIda = null;
		PublicacionController publiController = new PublicacionController();
		usuarioController usuario = new usuarioController();
		OfertaControl oferta = new OfertaControl();
		// FORMATEAR ENTRADA DATE
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		String descripcion, tamaño;
		boolean fragil = false; 
		int valor; 

		int opc = 0, op = 2, opdni = 0, opPublicacion = 0, opMenuPrincipal = 0;
		int con = 0;
		while (opc != 3) {
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
						while (op != 0) {
							try {
								System.out.println("Cual es la extension de correo");
								System.out.println("1. @gmail.com");
								System.out.println("2. @Outlook.com");
								System.out.println("3. @uptc.edu.co");
								op = sc.nextInt();
							} catch (Exception e) {
								System.out.println("No es numero");
								sc.next();
							}
							sc.nextLine();
							switch (op) {
								case 1:
									ex = "@gmail.com";
									email = email + ex;
									op = 0;
									break;
								case 2:
									ex = "@outlook.com";
									email = email + ex;
									op = 0;
									break;
								case 3:
									ex = "@uptc.edu.co";
									email = email + ex;
									op = 0;
									break;
								default:
									System.out.println("No hay mas opcion para extension");
							}
						}
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
					usuario.crearUsuario("0", username, email, phoneNumber, dni, fullName, password, fechaIda, fechaIda);
					break;
				case 2:
					System.out.println("ingrese su nombre de usuario");
					username=sc.next();
					System.out.println("ingrese su contraseña");
					password=sc.next();
					if(usuario.verificarUsuario(username, password)) {

						while (opMenuPrincipal != 4) { //MENU UNA VEZ QUE INICIA SESION.
							System.out.println("1. Crear publicacion.");
							System.out.println("2. Ver publicaciones.");
							System.out.println("3. Crear ofertas");
							System.out.println("4.cerrar secion");
							System.out.print("Digite la opcion que desea realizar: ");
							opMenuPrincipal = sc.nextInt();
							sc.nextLine();
							switch (opMenuPrincipal) {
								case 1:
									// CREAR PUBLICACION.
									while (inusualString(origen)) {
										System.out.print("Ingrese el origen del viaje: ");
										origen = sc.nextLine();
										if (inusualString(origen)) {
											System.err
													.println("La entrada \"" + origen
															+ "\" no es valida. Intentelo de nuevo.");
										}
									}
									while (inusualString(destino)) {
										System.out.print("Ingrese el destino del viaje: ");
										destino = sc.nextLine();
										if (inusualString(destino)) {
											System.err.println(
													"La entrada \"" + destino + "\" no es valida. Intentelo de nuevo.");
										}
									}
									while (true) {
										try {
											System.out.print("Ingrese la fecha: ");
											fechaIda = dateFormat.parse(sc.nextLine());
											break;
										} catch (ParseException e) {
											System.err.println("\n" + "Digite la fecha en formato: yyyy/mm/dd.");
										}
									}
									while (inusualString(categoria)) {
										System.out.print("Ingrese la categoria del viaje: ");
										categoria = sc.nextLine();
										if (inusualString(destino)) {
											System.err.println(
													"La entrada \"" + categoria + "\" no es valida. Intentelo de nuevo.");
										}
									}
									while (inusualString(pesoEquipaje)) {
										System.out.print("Ingrese el peso de equipaje disponible: ");
										pesoEquipaje = sc.nextLine();
										if (inusualString(pesoEquipaje)) {
											System.err.println(
													"La entrada \"" + pesoEquipaje
															+ "\" no es valida. Intentelo de nuevo.");
										}
									}
									while (inusualString(espacioEquipaje)) {
										System.out.print("Ingrese el espacio de equipaje disponible: ");
										espacioEquipaje = sc.nextLine();
										if (inusualString(espacioEquipaje)) {
											System.err.println(
													"La entrada \"" + espacioEquipaje
															+ "\" no es valida. Intentelo de nuevo.");
										}
									}
									opPublicacion=0;
									while (opPublicacion!=1&&opPublicacion!=2) {
										System.out.print("Desea realizar la publicacion: ");
										System.out.print("1 si ");
										System.out.print("2 no ");

										opPublicacion = sc.nextInt();
										sc.nextLine();
										switch (opPublicacion) {
											case 1:
												publiController.CrearPublicacion(origen, destino, fechaIda, categoria, pesoEquipaje, espacioEquipaje);

												//REINICIAMOS VALORES
												origen = ""; destino = ""; fechaIda = null; categoria = ""; pesoEquipaje = "";
												espacioEquipaje = "";

												System.out.println("Publicacion realizada con exito.");
												break;
											case 2:
												System.out.println("Publicacion cancelada.");
												break;
											default:
												System.err.println(
														"La opcion \"" + opPublicacion
																+ "\" no es valida. Intentelo de nuevo.");
										}
									}
									break;
								case 2:
									// SE DEBEN VER LAS PUBLICACIONES EN LA APP
									for(int i=0;i<publiController.listarPublicaciones().length;i++) {
										System.out.println((i+1)+" "+publiController.listarPublicaciones()[i]);
									}
									System.out.println("De cual publicacion desea ver ofertas");
									op=sc.nextInt();
									System.out.println(oferta.verListadoOfertas()[op]);
									// LISTA DE OFERTAS EN LA PUBLICACION
									for(int i=0;i< oferta.verListadoOfertas().length;i++) {
										if(oferta.verListadoOfertas()!= null) {
									System.out.println("informacion del contacto"+ i);
						        	System.out.println(oferta.verListadoOfertas()[i]);
										}
									}
									break;
								case 3:
									for(int i=0;i<publiController.listarPublicaciones().length;i++) {
										if(publiController.listarPublicaciones()!=null) {
										System.out.println((i+1)+" "+publiController.listarPublicaciones()[i]);
										}
									}
									System.out.println("a cual publicacion deseas ofertar");
									
									op=sc.nextInt();
									sc.nextLine();
									
									if(publiController.listarPublicaciones()[op-1]!=null)
									{
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
										if(oferta.crearOferta(descripcion, tamaño, fragil, valor, fechaIda,op))
										{
											System.out.println("oferta creada correctamente");
										}else {
											System.out.println("error al crear la oferta");
										}
									}
									break;
								case 4:
									System.exit(0);
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
