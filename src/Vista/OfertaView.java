package Vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Controller.OfertaControl;
import Model.Oferta;
import Model.Publicacion;

public class OfertaView {
    Scanner sc;
    OfertaControl ofertaControl;

    public OfertaView(Scanner sc, OfertaControl ofertaControl) {
        this.sc = sc;
        this.ofertaControl = ofertaControl;
    }

    public static boolean inusualString(String string) {
        if (string.isEmpty())
            return true;
        if (string.trim().isEmpty())
            return true;
        return false;
    }

    public void createOffer(Publicacion publicacion, int idUser) {
        String descripcion = "", espacioOferta = "", pesoOferta = "";
        boolean fragil = false;
        int valor = 0;
        LocalDate fechaDeOferta = LocalDate.now();
        descripcion = validarDescripcion();
        espacioOferta = validarVolumenEquipaje(publicacion);
        pesoOferta = validarPesoEquipaje(espacioOferta, publicacion.getPesoEquipaje());
        fragil = validarFragil();
        valor = validarPrecio();
        ofertaControl.crearOferta(descripcion, pesoOferta, espacioOferta, fragil, valor, fechaDeOferta, publicacion.getId(), idUser);
    }

    private String validarDescripcion() {
        String descripcion = "";
        while (true) {
            System.out.print("Enter the description of your offer (at least 5 words): ");
            descripcion = sc.nextLine();
            if (inusualString(descripcion)) {
                System.err.println("The entry \"" + descripcion + "\" is not valid. Please try again.");
                continue;
            }
            if (descripcion.split(" ").length < 5) {
                System.err.println("The entry \"" + descripcion
                        + "\" is not valid, your description must be at least 5 words. Please try again.");
                continue;
            }
            return descripcion;
        }
    }

    public String validarPesoEquipaje(String categoria, String pesoDisponible) {
        String pesoEquipaje = "";
        Double pesoDisponiDouble = Double.parseDouble(pesoDisponible);
        Double peso = 0.0;
        while (true) {
            try {
                System.out.print(
                        "Enter the weight of the available luggage in kilograms(The available weight of the publication is: "
                                + pesoDisponiDouble + "): ");
                pesoEquipaje = sc.nextLine();
                if (inusualString(pesoEquipaje)) {
                    System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
                    continue;
                }
                peso = Double.parseDouble(pesoEquipaje);
                if (peso > pesoDisponiDouble) {
                    System.err.println("The weight typed \"" + pesoEquipaje
                            + "\" is greater than the weight of the publication. Please try again.");
                    continue;
                }
                return pesoEquipaje;
                /*
                 * if(peso < ((Double) (pesoDisponiDouble * (0.8)))){
                 * System.err.println("The weight typed \"" + pesoEquipaje +
                 * "\" is greater than the weight of the publication. Please try again.");
                 * continue;
                 * }
                 */
            } catch (Exception e) {
                System.err.println("The entry \"" + pesoEquipaje + "\" is not valid. Please try again.");
            }

        }
    }

    public String validarVolumenEquipaje(Publicacion publicacion) {
        Double ancho = 0.0, altura = 0.0, largo = 0.0, volumen = 0.0, espacioDisponible = 0.0;
        String espacioOferta = "";
        int op = 0;
        while (true) {

            while (true) {
                try {
                    System.out.print("Enter the broad luggage(kitten 10 cm - maximum 20 cm): ");
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
                    System.out.print("Enter the long luggage(kitten 25 cm - maximum 35 cm): ");
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
                    System.out.print("Enter the high luggage (kitten 25 cm - maximum 45 cm): ");
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
            volumen = (ancho * largo * altura);
            espacioOferta = String.valueOf(volumen);
            espacioDisponible = Double.parseDouble(publicacion.getEspacioEquipaje());
            if (volumen > espacioDisponible) {
                try {
                    System.err.println(
                            "The space you request is greater than that of the publication, you wish to make the offer or modify the fields:");
                    System.out.println("1. Make offer.");
                    System.out.println("2. Modify the fields");
                    op = sc.nextInt();
                    sc.nextLine();
                    switch (op) {
                        case 1:
                            return espacioOferta;
                        case 2:
                            continue;
                        default:
                            System.err.println("The option \"" + op + "\" not available. Please try again.");
                    }
                } catch (Exception e) {
                    System.err.println("The option \"" + op + "\" not available. Please try again.");
                }

            }
        }
    }

    private Boolean validarFragil() {
        int op = 0;
        while (true) {
            try {
                System.out.println("Is your equipment fragile?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                    default:
                        System.err.println("The option \"" + op + "\" not available. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("The option \"" + op + "\" not available. Please try again.");
            }  
        }
    }

    private int validarPrecio() {
        int valor = 0;
        while (true) {
            try {
                System.out.print("Enter the value of your offer: ");
                valor = sc.nextInt();
                sc.nextLine();
                return valor;
                }
            catch (Exception e) {
                System.err.println("The valor \"" + valor + "\" not available. Please try again.");
            }
        }
    }
}
