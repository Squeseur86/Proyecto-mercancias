package Runner;

//import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import java.util.Scanner;

import Controller.OfertaControl;
import Controller.PublicacionController;
import Controller.TelefonoController;
import Controller.UsuarioController;
import Model.Oferta;
import Model.Publicacion;
import Vista.OfertaView;
import Vista.PublicacionVista;
import Vista.UserView;

public class Runner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String username, password;
		int idUserValid = 0;
		boolean userDelete = false;

		// DATOS PUBLICACION
		OfertaControl oferta = new OfertaControl();
		PublicacionController publiController = new PublicacionController();
		OfertaView ofertaVista = new OfertaView(sc, oferta);
		
		PublicacionVista publicacionVista = new PublicacionVista(publiController, ofertaVista);

		LocalDate fechaIda = null;
		TelefonoController telefonoController = new TelefonoController();
		UsuarioController usuarios = new UsuarioController();
		UserView userView = new UserView(usuarios, telefonoController);
		// USUARIO TEST
		usuarios.crearUsuario("j", "123");
		
		// FORMATEAR ENTRADA DATE
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		String descripcion, tamaño = "", pesoOfe = "";
		boolean fragil = false;
		int valor, opcseguro, opOffer = 0;

		// OPCIONES
		int opc = 0, op = 2, opMenuPrincipal = 0, opof = 0;
		int con = 0;
		double ancho, alto, largo;
		double volumen = 0;
		while (opc != 3) {
			opc = 0;
			opOffer = 0;
			while (opc < 1 || opc > 3) {
				try {
					System.out.println("Welcome.");
					System.out.println("Enter the number of the option you wish to perform:");
					System.out.println("1. Sing Up ");
					System.out.println("2. Login");
					System.out.println("3. Go out");
					opc = sc.nextInt();
				} catch (Exception e) {
					System.err.println("The \"" + opc + "\" option is not available");
					sc.next();
				}
				sc.nextLine();
			}
			switch (opc) {
				case 1:
					con = 1;
					userView.signUp();
					opc = 0;
					break;
				case 2:
					System.out.print("Enter your username: ");
					username = sc.next();
					System.out.print("Enter your password: ");
					password = sc.next();
					if (usuarios.verificarUsuario(username, password)) {
						System.out.print("\033[H\033[2J");
						System.out.flush();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
						for (int i = 0; i < usuarios.arrayListUser().size(); i++) {
							if (username.equals(usuarios.arrayListUser().get(i).getUserName())) {
								idUserValid = usuarios.arrayListUser().get(i).getId();
							}
						}
						opMenuPrincipal = 0;
						while (opMenuPrincipal != 6) { // MENU UNA VEZ QUE INICIA SESION.
							System.out.println("1. Create publication.");
							System.out.println("2. View posts.");
							System.out.println("3. View my posts");
							System.out.println("4. View my profile");
							System.out.println("5. View my offerts");
							System.out.println("6. Close section");

							System.out.print("Enter the number of the option you wish to perform: ");
							opMenuPrincipal = sc.nextInt();
							sc.nextLine();
							switch (opMenuPrincipal) {
								case 1:// CREAR PUBLICACION.
									publicacionVista.vistaCrearPublicacion(idUserValid);
									break;
								case 2:
									// SE DEBEN VER LAS PUBLICACIONES EN LA APP
									publicacionVista.menuPostActives(idUserValid);
									break;
								case 3:
									// MENU PARA PUBLICACIONES DEL USUARIO
									publicacionVista.userPostMenu(idUserValid, oferta);
									break;
									
							
								case 4:
									op = 0;
									while (op != 3) {
										try {
											System.out.println(usuarios.returnForId(idUserValid).toString());
											System.out.println("1. Edit user.");
											System.out.println("2. Delete user.");
											System.out.println("3. Go back.");
											op = sc.nextInt();
											sc.nextLine();
										} catch (Exception e) {
											System.err.println("The option \""+ op +"\" is not valid, please try again.");
											continue;
										}
										switch (op) {
											case 1:
												System.out.println(userView.editUser(idUserValid));
												break;
											case 2:
												System.out.println(userView.borrarUser(idUserValid));
												userDelete = true;
												break;
											case 3:
												break;
											default:
												break;
										}
										if(op == 2){
											break;
										}
									}
									op = 0;
									break;
								case 5:
									publicacionVista.myOfertasMenu(idUserValid);
									break;
								case 6:
									opc = 0;
									break;
								default:
									System.err.println(
											"The option \"" + opMenuPrincipal
													+ "\" is not valid. Try again.");
							}
							if (userDelete == true) {
								break;
							}
						}
					} else {
						System.out.println(
								"Enter your username or password correctly, or register if you do not have an account");
						opc = 0;
					}
					break;
				case 3:
					System.out.println("See you later");
					break;
				default:
					System.out.println("Invalid option");
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
