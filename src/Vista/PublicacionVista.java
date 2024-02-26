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

    public void vistaCrearPublicacion() {
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
            System.out.print("\nIngrese el origen del viaje: ");
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
            peso = Double.parseDouble(pesoEquipaje);
            while(peso> 24.0) {
            	System.out.println("peso no valido");
                pesoEquipaje = sc.nextLine();
                if (inusualString(pesoEquipaje)) {
                    System.err.println(
                            "La entrada \"" + pesoEquipaje
                                    + "\" no es valida. Intentelo de nuevo.");
                }
                peso = Double.parseDouble(pesoEquipaje);
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

        // FIN CREAR PUBLICACION
        // CONFIRMACION:
        while (true) {
            System.out.print("Desea realizar la publicacion (Si: Digite 1. No: Digite 2.): ");
            opPublicacion = sc.nextInt();
            sc.nextLine();
            if (opPublicacion == 1 || opPublicacion == 2) {
                switch (opPublicacion) {
                    case 1:
                        // Generar un número aleatorio de 4 dígitos
                        int idRandom = random.nextInt(9000) + 1000;
                        publicacionController.crearPublicacion(origen, destino, fechaIda, categoria,
                                pesoEquipaje, espacioEquipaje, idRandom);

                        System.out.println("Publicacion realizada con exito.");
                        break;
                    case 2:
                        System.out.println("Publicacion cancelada.");
                        break;
                }
                break; // SALIR WHILE
            } else {
                System.err.println("La opcion \"" + opPublicacion + "\" no es valida. Intentelo de nuevo.");
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
            System.out.print("\nIngrese el origen del viaje: ");
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

        // FIN EDICION PUBLICACION
        // CONFIRMACION:
        while (true) {
            System.out.print("Desea realizar la edicion (Si: Digite 1. No: Digite 2.): ");
            opPublicacion = sc.nextInt();
            sc.nextLine();
            switch (opPublicacion) {
                case 1:
                    publicacionController.editarPublicacion(publicacion, origen, categoria, destino, espacioEquipaje,
                            pesoEquipaje, fechaIda);
                    System.out.println("Edicion realizada con exito realizada con exito.");
                    // REINICIAMOS VALORES
                    origen = "";
                    destino = "";
                    categoria = "";
                    pesoEquipaje = "";
                    espacioEquipaje = "";
                    fechaIda = null;
                    return true;
                case 2:
                    // REINICIAMOS VALORES
                    origen = "";
                    destino = "";
                    categoria = "";
                    pesoEquipaje = "";
                    espacioEquipaje = "";
                    fechaIda = null;
                    System.out.println("Edicion cancelada.");
                    return false;
                default:
                    System.err.println("La opcion \"" + opPublicacion + "\" no es valida. Intentelo de nuevo.");
                    break;
            }
        }
    }
}

