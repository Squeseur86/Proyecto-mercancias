package Vista;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void verPublicacionesDelUsuario(int idUserValid){
        for(Publicacion publicacion: publicacionController.retornarPorIdUser(idUserValid)){
            System.out.println(publicacion.toString());
        }
        System.out.println("\n");
    }

    public void vistaCrearPublicacion(int idUserValid) {
        // DATOS PUBLICACION
        String origen = "", destino = "", categoria = "", pesoEquipaje = "", espacioEquipaje = "";
        Date fechaIda = null;
        // OBJECTO RANDOM
        Random random = new Random();
        // MENU
        int opPublicacion = 0;
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
            try {
                System.out.print("Enter the available luggage weight: ");
                pesoEquipaje = sc.nextLine();
                if (inusualString(pesoEquipaje)) {
                    System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
                }
                peso = Double.parseDouble(pesoEquipaje);
                while (peso > 24.0) {
                    System.out.println("Invalid weight");
                    pesoEquipaje = sc.nextLine();
                    peso = Double.parseDouble(pesoEquipaje);
                    if (inusualString(pesoEquipaje)) {
                        System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
                    }
                }
            } catch (Exception e) {
                System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
            }

        }
        while (inusualString(espacioEquipaje)) {
            System.out.print("Enter the available luggage space: ");
            espacioEquipaje = sc.nextLine();
            if (inusualString(espacioEquipaje)) {
                System.err.println(
                        "The entry \"" + espacioEquipaje
                                + "\" is not valid. Please try again.");
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
        // REINICIAMOS VALORES
        origen = "";
        destino = "";
        categoria = "";
        pesoEquipaje = "";
        espacioEquipaje = "";
        fechaIda = null;

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

    public boolean vistaEditarPublicacion(Publicacion publicacion) {
        // DATOS EDICION PUBLICACION
        String origen = "", destino = "", categoria = "", pesoEquipaje = "", espacioEquipaje = "";
        Date fechaIda = null;
        // MENU
        int opPublicacion = 0;
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
