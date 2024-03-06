package Vista;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

import Controller.PublicacionController;
import Model.Publicacion;

public class PublicacionVista {
    private Scanner sc = new Scanner(System.in);
    private PublicacionController publicacionController;

    public PublicacionVista(PublicacionController publicacionController) {
        this.publicacionController = publicacionController;
    }

    public static boolean inusualString(String string) {
        if (string.isEmpty())
            return true;
        if (string.trim().isEmpty())
            return true;
        return false;
    }

    public boolean editarPublicacion(int idPublicacion) {
        Publicacion publicacionEditar = publicacionController.retornarPorId(idPublicacion);
        if (publicacionEditar == null) {
            return false;
        } else {
            return vistaEditarPublicacion(publicacionEditar);
        }

    }

    public void verPublicacionesDelUsuario(int idUserValid) {
        for (Publicacion publicacion : publicacionController.retornarPorIdUser(idUserValid)) {
            System.out.println(publicacion.toString());
        }
        System.out.println("\n");
    }

    // PRINT'S

    public void vistaCrearPublicacion(int idUserValid) {
        // DATOS PUBLICACION
        String origen = "", destino = "", categoria = "", pesoEquipaje = "", espacioEquipaje = "";
        Date fechaIda = null;
        // CALENDAR PARA VELIDAR FECHAS
        Calendar fechaDeIda = Calendar.getInstance();
        Calendar fechaDeLlegada = Calendar.getInstance();
        int year = 0;
        // OBJECTO RANDOM
        Random random = new Random();
        // MENU
        int opPublicacion = 0, opCat = 0;
        double largo = 0.0, ancho = 0.0, altura = 0.0, volumen = 0.0, voluOcu = 0.0;
        double peso;
        // FORMATEAR ENTRADA DATE
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        // CREAR PUBLICACION.
        while (inusualString(origen)) {
            System.out.print("\nEnter the origin of the trip: ");
            origen = sc.nextLine();
            if (inusualString(origen)) {
                System.err.println("The entry \"" + origen + "\" is not valid. Please try again.");
            }
        }

        while (inusualString(destino)) {
            System.out.print("Enter the destination of the trip: ");
            destino = sc.nextLine();
            if (inusualString(destino)) {
                System.err.println("The entry \"" + destino + "\" is not valid. Please try again.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter the flight departure date: ");
                fechaIda = dateFormat.parse(sc.nextLine());
                fechaDeIda.setTime(fechaIda);
                year = fechaDeIda.get(Calendar.YEAR);
                if (year < 2024) {
                    throw new Exception("The year cannot be less than the current one.");
                }
                break;
            } catch (ParseException e) {
                System.err.println("\n" + "Enter the date in format: yyyy/mm/dd.");
            } catch (Exception e) {
                System.out.print((e.getMessage()));
            }
        }

        while (opCat < 1 || opCat > 2) {
            try {
                System.out.print("Category: ");
                System.out.println("1. Cabin\n 2. Store");
                System.out.println("Enter the category of the trip: ");
                opCat = sc.nextInt();
                sc.nextLine();
                switch (opCat) {
                    case 1:
                        categoria = "Cabin";
                        break;
                    case 2:
                        categoria = "Store";
                        break;
                    default:
                        System.err.println("The option \"" + opCat + "\" not available. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("The option \"" + opCat + "\" not available. Please try again.");
            }
        }

        while (inusualString(pesoEquipaje)) {
            try {
                System.out.print("Enter the weight of the available luggage in kilograms: ");
                pesoEquipaje = sc.nextLine();
                if (inusualString(pesoEquipaje)) {
                    System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
                    continue;
                }
                peso = Double.parseDouble(pesoEquipaje);
                switch (categoria) {
                    case "Cabin":
                        if (peso > 16.0 || peso < 10.0) {
                            System.err.println(
                                    "The weight in the cabin cannot be greater than 16 kg or less than 10 kg. Try again");
                            continue;
                        }
                        break;
                    case "Store":
                        if (peso > 32.0 || peso < 20.0) {
                            System.err.println(
                                    "The weight in the store cannot be greater than 32 kg or less than 20 kg. Try again");
                            continue;
                        }
                        break;
                }
            } catch (Exception e) {
                System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
            }

        }
        while (inusualString(espacioEquipaje)) {
            switch (categoria) {

                case "Cabin":

                    while (true) {
                        try {
                            System.out.print("Enter the broad luggage: ");
                            ancho = sc.nextDouble();
                            sc.nextLine();
                            if (ancho > 20 || ancho < 10) {
                                throw new Exception(
                                        "The width of the luggage cannot be greater than 20 cm and less than 10 cm. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The broad luggage \"" + ancho + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("Enter the long luggage: ");
                            largo = sc.nextDouble();
                            sc.nextLine();
                            if (largo > 35 || largo < 25) {
                                throw new Exception(
                                        "The length of the luggage cannot be greater than 35 cm and less than 25 cm. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The lenght luggage \"" + largo + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("Enter the high luggage: ");
                            altura = sc.nextDouble();
                            sc.nextLine();
                            if (altura > 45 || altura < 25) {
                                throw new Exception(
                                        "The high of the luggage cannot be greater than 45 cm and less than 25 cm. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The high luggage \"" + altura + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    // DEFINIR VOLUMEN
                    volumen = (ancho * largo * altura);

                    while (true) {
                        try {
                            System.out.println("Enter the occupied volume");
                            voluOcu = sc.nextDouble();
                            if (voluOcu > (volumen * (8 / 10)) || voluOcu < (volumen * (1 / 10))) {
                                throw new Exception(
                                        "The volume of occupied baggage cannot be less than 10% of the total volume nor more than 80% of the total volume. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The volume of baggage occupied \"" + voluOcu
                                    + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    // REDEFINIMOS EL VOLUMEN
                    volumen = volumen - voluOcu;
                    espacioEquipaje = String.valueOf(volumen);
                    break;
                case "Store":
                    while (true) {
                        try {
                            System.out.print("Enter the broad luggage: ");
                            ancho = sc.nextDouble();
                            sc.nextLine();
                            if (ancho > 36 || ancho < 20) {
                                throw new Exception(
                                        "The width of the luggage cannot be greater than 36 cm and less than 20 cm. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The broad luggage \"" + ancho + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("Enter the long luggage: ");
                            largo = sc.nextDouble();
                            sc.nextLine();
                            if (largo > 47 || largo < 30) {
                                throw new Exception(
                                        "The length of the luggage cannot be greater than 47 cm and less than 30 cm. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The lenght luggage \"" + largo + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    while (true) {
                        try {
                            System.out.print("Enter the high luggage: ");
                            altura = sc.nextDouble();
                            sc.nextLine();
                            if (altura > 75 || altura < 60) {
                                throw new Exception(
                                        "The high of the luggage cannot be greater than 75 cm and less than 60 cm. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The high luggage \"" + altura + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    // DEFINIR VOLUMEN
                    volumen = (ancho * largo * altura);

                    while (true) {
                        try {
                            System.out.println("Enter the occupied volume");
                            voluOcu = sc.nextDouble();
                            if (voluOcu > (volumen * (8 / 10)) || voluOcu < (volumen * (1 / 10))) {
                                throw new Exception(
                                        "The volume of occupied baggage cannot be less than 10% of the total volume nor more than 80% of the total volume. Please try again.");
                            }
                            break;
                        } catch (InputMismatchException eMismatch) {
                            System.err.println("The volume of baggage occupied \"" + voluOcu
                                    + "\" is not valid. Please try again.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    // REDEFINIMOS EL VOLUMEN
                    volumen = volumen - voluOcu;
                    espacioEquipaje = String.valueOf(volumen);
                    break;
            }
        }
        // FIN CREAR PUBLICACION
        // CONFIRMACION:
        while (true) {
            System.out.print("Do you want to post (Yes: Enter 1. No: Enter 2.): ");
            opPublicacion = sc.nextInt();
            sc.nextLine();
            if (opPublicacion == 1 || opPublicacion == 2) {
                switch (opPublicacion) {
                    case 1:
                        // Generate a 4-digit random number
                        int idRandom = random.nextInt(9000) + 1000;
                        publicacionController.crearPublicacion(origen, destino, fechaIda, categoria, pesoEquipaje,
                                espacioEquipaje, idRandom, idUserValid);

                        System.out.println("Post successfully created.");
                        break;
                    case 2:
                        System.out.println("Post canceled.");
                        break;
                }
                break; // EXIT WHILE
            } else {
                System.err.println("The option \"" + opPublicacion + "\" is not valid. Please try again.");
            }
        }
    }

    public boolean vistaEditarPublicacion(Publicacion publicacion) {
        // DATOS EDICION PUBLICACION
        String origen = "", destino = "", categoria = "", pesoEquipaje = "", espacioEquipaje = "";
        Date fechaIda = null;
        // MENU
        int opPublicacion = 0;
        // FORMATEAR ENTRADA DATE
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        // EDITAR PUBLICACION.
        while (inusualString(origen)) {
            System.out.print("\nEnter the origin of the trip: ");
            origen = sc.nextLine();
            if (inusualString(origen)) {
                System.err.println("The entry \"" + origen + "\" is not valid. Please try again.");
            }
        }
        while (inusualString(destino)) {
            System.out.print("Enter the destination of the trip: ");
            destino = sc.nextLine();
            if (inusualString(destino)) {
                System.err.println("The entry \"" + destino + "\" is not valid. Please try again.");
            }
        }
        while (true) {
            try {
                System.out.print("Enter the date: ");
                fechaIda = dateFormat.parse(sc.nextLine());
                break;
            } catch (ParseException e) {
                System.err.println("\n" + "Enter the date in format: yyyy/mm/dd.");
            }
        }
        while (inusualString(categoria)) {
            System.out.print("Enter the category of the trip: ");
            categoria = sc.nextLine();
            if (inusualString(destino)) {
                System.err.println("The entry \"" + categoria + "\" is not valid. Please try again.");
            }
        }
        while (inusualString(pesoEquipaje)) {
            System.out.print("Enter the available luggage weight: ");
            pesoEquipaje = sc.nextLine();
            if (inusualString(pesoEquipaje)) {
                System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
            }
        }
        while (inusualString(espacioEquipaje)) {
            System.out.print("Enter the available luggage space: ");
            espacioEquipaje = sc.nextLine();
            if (inusualString(espacioEquipaje)) {
                System.err.println("The entry \"" + espacioEquipaje + "\" is not valid. Please try again.");
            }
        }

        // FIN EDICION PUBLICACION
        // CONFIRMACION:
        while (true) {
            System.out.print("Do you want to edit (Yes: Enter 1. No: Enter 2.): ");
            opPublicacion = sc.nextInt();
            sc.nextLine();
            switch (opPublicacion) {
                case 1:
                    publicacionController.editarPublicacion(publicacion, origen, categoria, destino, espacioEquipaje,
                            pesoEquipaje, fechaIda);
                    System.out.println("Edition successfully completed.");
                    // RESET VALUES
                    origen = "";
                    destino = "";
                    categoria = "";
                    pesoEquipaje = "";
                    espacioEquipaje = "";
                    fechaIda = null;
                    return true;
                case 2:
                    // RESET VALUES
                    origen = "";
                    destino = "";
                    categoria = "";
                    pesoEquipaje = "";
                    espacioEquipaje = "";
                    fechaIda = null;
                    System.out.println("Edition canceled.");
                    return false;
                default:
                    System.err.println("The option \"" + opPublicacion + "\" is not valid. Please try again.");
                    break;
            }

        }

    }

}
