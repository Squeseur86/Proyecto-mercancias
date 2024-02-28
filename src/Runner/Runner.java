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
		int idUserValid = 0;

		// DATOS PUBLICACION
		PublicacionController publiController = new PublicacionController();
		PublicacionVista publicacionVista = new PublicacionVista(publiController);

		Date fechaIda = null;
		usuarioController usuario = new usuarioController();
		// USUARIO TEST
		usuario.crearUsuario("j", "123");
		// Objeto para numeros aleatorios
		Random rand = new Random();
		OfertaControl oferta = new OfertaControl();
		// FORMATEAR ENTRADA DATE
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		String descripcion, tamaño = "", pesoOfe = "";
		boolean fragil = false;
		int valor, opcseguro, opOffer = 0;

		// OPCIONES
		int opc = 0, op = 2, opdni = 0, opPublicacion = 0, opMenuPrincipal = 0, opof = 0;
		int con = 0, optionMenuMyPost = 0, postEdit = 0;
		double peso = 0, volumen = 0;
		while (opc != 3) {
			opOffer = 0;
			while (opc < 1 || opc > 3) {
				try {
					System.out.println("Welcome.");
					System.out.println("Enter the number of the option you wish to perform:");
					System.out.println("1. Login ");
					System.out.println("2. Sign up");
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
					username = "";
					email = "";
					password = "";
					while (username.equals("") || username.equals("\n")) {
						System.out.print("\nEnter a username: ");
						username = sc.nextLine();
						if (username.isEmpty()) {
							System.out.println("Username cannot be empty");
						}
					}
					while (email.equals("") || email.equals("\n")) {
						System.out.print("Enter your email: ");
						email = sc.nextLine();
						if (email.isEmpty()) {
							System.out.println("Email cannot be empty");

						}
					}
					while (password.equals("") || password.equals("\n")) {
						System.out.print("Enter a password: ");
						password = sc.nextLine();
						if (password.isEmpty()) {
							System.out.println("The password cannot be empty");
						}
					}
					System.out.println("Enter your phone number");
					phoneNumber = sc.nextLine();
					phoneNumber.replaceAll("\n", "");
					while (op < 1 || op > 4) {
						try {
							System.out.println("Enter the option number of the document you wish to enter.");
							System.out.println("1. Identity card");
							System.out.println("2. Passport");
							System.out.println("3. Immigration card");
							System.out.println("4. Do not add");
							op = sc.nextInt();
						} catch (Exception e) {
							System.err.println("The \"" + op + "\" option is not available.");
							sc.next();
						}
						sc.nextLine();
					}
					switch (op) {
						case 1:
							System.out.print("Enter your identity card number: ");
							dni = sc.nextLine();
							break;
						case 2:
							System.out.print("Enter your passport number: ");
							dni = sc.nextLine();
							break;
						case 3:
							System.out.print("Enter your immigration card ID: ");
							dni = sc.nextLine();
							break;
						case 4:
							dni.replaceAll("\n", "");
							break;
					}

					System.out.print("Enter your full name: ");
					fullName = sc.nextLine();


					usuario.crearUsuario(username, email, phoneNumber, dni, fullName, password, fechaIda, fechaIda);

					break;
				case 2:
					System.out.print("Enter your username: ");
					username = sc.next();
					System.out.print("Enter your password: ");
					password = sc.next();
					if (usuario.verificarUsuario(username, password)) {
						System.out.print("\033[H\033[2J");
						System.out.flush();
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
						for (int i = 0; i < usuario.arrayListUser().size(); i++) {
							if (username.equals(usuario.arrayListUser().get(i).getUserName())) {
								idUserValid = usuario.arrayListUser().get(i).getId();
							}
						}
						while (opMenuPrincipal != 5) { // MENU UNA VEZ QUE INICIA SESION.
							System.out.println("1. Create publication.");
							System.out.println("2. View posts.");
							System.out.println("3. View my posts");
							System.out.println("4. Create offers");
							System.out.println("5. Edit or delete offers");
							System.out.println("6. Close section");

							System.out.print("Enter the number of the option you wish to perform: ");
							opMenuPrincipal = sc.nextInt();
							sc.nextLine();
							switch (opMenuPrincipal) {
								case 1:// CREAR PUBLICACION.
									publicacionVista.vistaCrearPublicacion(idUserValid);
									peso = 23.0;
									break;
								case 2:
									// SE DEBEN VER LAS PUBLICACIONES EN LA APP
									for (Publicacion publicacion : publiController.returnActivePublications()) {
										System.out.println(publicacion.toString());
									} // GESTIONAR POR SI RETORNA NULL
									System.out.println("De cual publicacion desea ver ofertas");
									op = sc.nextInt();
									for (int i = 0; i < oferta.verListadoOfertas().size(); i++) {
										if (publiController.returnActivePublications().get(op - 1).getId() == oferta
												.verListadoOfertas().get(i).getId()) {
											System.out.println(oferta.verListadoOfertas().get(i).toString());
										}
									}

									opcseguro = 0;
									System.out.println("Cual oferta quieres aceptar");
									System.out.println("0 para ninguna");
									op = sc.nextInt();
									sc.nextLine();

									while (opcseguro == 0) {
										System.out.println("Oferta aceptada :" + oferta.verOferta());
										System.out.println("Estas seguro 1. si / 2. no");
										opcseguro = sc.nextInt();
										switch (opcseguro) {
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
									publicacionVista.verPublicacionesDelUsuario(idUserValid);
									while (optionMenuMyPost < 1 || optionMenuMyPost > 3) {
										try {
											System.out.println("1. View offers for a publication.");
											System.out.println("2. Edit a publication.");
											System.out.println("3. Delete a post.");
											System.out.println("Enter the number of the option you wish to perform:");
											optionMenuMyPost = sc.nextInt();
											sc.nextLine();
										} catch (Exception e) {
											System.err.println(
													"The \"" + optionMenuMyPost + "\" option is not available.\n");
										}
									}
									switch (optionMenuMyPost) {
										case 1: // VER OFERTAS
											publicacionVista.verPublicacionesDelUsuario(idUserValid);
											// MENU PARA PROCESAR OFERTAS
											System.out.print(
													"Enter the number of the publication for which you want to see the offers: ");
											op = sc.nextInt();
											sc.nextLine();
											for (int i = 0; i < oferta.verListadoOfertas().size(); i++) {
												if (publiController.retornarPorIdUser(idUserValid).get(op - 1)
														.getId() == oferta
																.verListadoOfertas().get(i).getId()) {
													System.out.println(
															oferta.verListadoOfertas().get(i).toString());
												}
											}//ARREGLAR EN CONTROLLER PARA RETORNAR SOLO LOS DE UNA PUBLIACION ESPECIFICA
											switch (op) {
												case 1:

													break;
												case 2:
													break;
												default:
													break;
											}
											break;
										case 2: // EDITAR PUBLICACION
											System.out.print("Enter the publication number to edit: ");// TRY/IF POR SI
																										// DIGITA UN
																										// NUMERO <1
											postEdit = sc.nextInt();
											sc.nextLine();
											publicacionVista.editarPublicacion(
													publiController.retornoPorIndice(postEdit - 1).getId());// IF POR SI
																											// RETORNA
																											// FALSE/ALTERNAR
																											// POR
																											// STRING
											// REVISAR METODO RETORNAR POR ID, INNECESARIO
											break;
										case 3:// BORRAR PUBLICACION

											break;
										default:
											break;
									}
									break;
								case 4:
									con = 0;
									for (Publicacion pubicacion : publiController.listarPublicaciones()) {
										System.out.println(pubicacion.toString());
									}
									System.out.println("a cual publicacion deseas ofertar");

									op = sc.nextInt();
									sc.nextLine();

									if (publiController.listarPublicaciones().get(op - 1) != null) {
										System.out.println("Ingrese la descripcion de la oferta");
										descripcion = sc.nextLine();
										while (pesoOfe == "") {
											System.out.println("ingrese el tamaño de su envio");
											pesoOfe = sc.nextLine();
											double psOf = Double.parseDouble(pesoOfe);
											double pesoe = Double.parseDouble(publiController.listarPublicaciones()
													.get(op - 1).getPesoEquipaje());
											if (psOf >= pesoe) {
												System.out.println("Peso no valido");
												pesoOfe = "";
											} else {
												System.out.println("peso valido");
											}
										}
										while (tamaño == "") {
											System.out.println("ingrese el tamaño de su envio");
											tamaño = sc.nextLine();
											double tam = Double.parseDouble(tamaño);
											double volPub = Double.parseDouble(publiController.listarPublicaciones()
													.get(op - 1).getEspacioEquipaje());
											if (tam >= volPub) {
												System.out.println("Tamaño no valido");
												tamaño = "";
											} else {
												System.out.println("Tamaño valido");
											}
										}
										System.out.print("su envio es fragil 1 para si 2 para no");
										op = sc.nextInt();
										sc.nextLine();
										while (op != 1 && op != 2) {
											switch (op) {
												case 1:
													fragil = true;
													break;
												case 2:
													fragil = false;
													break;
												default:
													System.out.println("valor incorrecto");
											}
										}
										System.out.println("ingrese el precio de su oferta");
										valor = sc.nextInt();
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

										while (opof != 1 && opof != 2) {
											System.out.println("You´re sure?, 1.yes, 2.delete");
											opof = sc.nextInt();
											sc.nextLine();
											switch (opof) {
												case 1:
													if (oferta.crearOferta(descripcion, pesoOfe, fragil, valor,
															fechaIda,
															publiController.returnId(con), idUserValid)) {
														System.out.println("oferta creada correctamente");
													} else {
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
								case 5:
									while (opOffer == 0) {
										System.out.println("what do you want to do?");
										System.out.println("1. edit offer");
										System.out.println("2. delete offer");
										opOffer = sc.nextInt();
										sc.nextLine();
										switch (opOffer) {
											case 1:
												for (int i = 0; i < oferta.verListadoOfertas().size(); i++) {
													if (idUserValid == oferta.verListadoOfertas().get(i).getId()) {
														System.out
																.println(oferta.verListadoOfertas().get(i).toString());
													}
													System.out.println("Which offer do you want to edit");
													int indexOfferEdit = 0;
													indexOfferEdit = sc.nextInt();
													sc.nextLine();
													if (idUserValid == oferta.verListadoOfertas().get(indexOfferEdit)
															.getId()) {
														System.out.println("Ingrese la descripcion de la oferta");
														descripcion = sc.nextLine();
														System.out.println("ingrese el tamaño de su envio");
														tamaño = sc.nextLine();
														System.out.print("su envio es fragil 1 para si 2 para no");
														op = sc.nextInt();
														sc.nextLine();
														while (op != 1 && op != 2) {
															switch (op) {
																case 1:
																	fragil = true;
																	break;
																case 2:
																	fragil = false;
																	break;
																default:
																	System.out.println("valor incorrecto");
															}
														}
														System.out.println("ingrese el precio de su oferta");
														valor = sc.nextInt();
														sc.nextLine();
														while (true) {
															try {
																System.out.print("Ingrese la fecha: ");
																fechaIda = dateFormat.parse(sc.nextLine());
																break;
															} catch (ParseException e) {
																System.err.println("\n"
																		+ "Digite la fecha en formato: yyyy/mm/dd.");
															}
														}
														if (oferta.editOferta(indexOfferEdit, descripcion, pesoOfe,
																
																fragil, valor, fechaIda, publiController.returnId(con),
																idUserValid)) {
															System.out.println("oferta creada correctamente");
														} else {
															System.err.println("error al crear la oferta");
														}
													}
												}
												break;
											case 2:
												for (int i = 0; i < oferta.verListadoOfertas().size(); i++) {
													if (idUserValid == oferta.verListadoOfertas().get(i).getId()) {
														System.out
																.println(oferta.verListadoOfertas().get(i).toString());
													}

													System.out.println("Which offer do you want to edit");
													int indexOfferdelet = 0;
													indexOfferdelet = sc.nextInt();
													sc.nextLine();
													if (idUserValid == oferta.verListadoOfertas()
															.get(indexOfferdelet - 1).getId()) {
														oferta.borrarOferta(indexOfferdelet - 1);
													}

												}
												break;
										}
									}
									break;
								case 6:
									System.exit(0);
									break;
								default:
									System.err.println(
											"La opcion \"" + opMenuPrincipal
													+ "\" no es valida. Intentelo de nuevo.");
							}
						}
					} else {
						System.out.println(
								"ingrese correctamente su usuario o contraseña, o registrese si no tiene cuenta");
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
