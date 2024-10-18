package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }

    /**
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
     */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /**
     * Descripcion: Solicita al usuario la informacion necesaria para registrar
     * un Project en un Pillar en el sistema
     */
    public void registerProject() {
        reader.nextLine(); //buffer cleaning
        System.out.println("Ingrese el tipo de pilar al cual se asociara el proyecto (1.Biodiversidad, 2.Agua, 3.Tratamiento de Basuras, 4.Energia): ");
        int pillarType = reader.nextInt();
        reader.nextLine(); //buffer cleaning
        System.out.println("Ingrese el ID del Proyecto: ");
        String id = reader.nextLine();
        System.out.println("Ingrese el nombre del Proyecto: ");
        String name = reader.nextLine();
        System.out.println("Ingrese la descripcion del Proyecto: ");
        String description = reader.nextLine();
        System.out.println("Ingrese el estado del Proyecto (activo:true/inactivo:false): ");
        String statusInput;
        boolean status = false;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Ingrese el estado del Proyecto (activo/inactivo): ");
            statusInput = reader.nextLine().trim().toLowerCase();

            if (statusInput.equals("activo")) {
                status = true;
                validInput = true;
            } else if (statusInput.equals("inactivo")) {
                status = false;
                validInput = true;
            } else {
                System.out.println("Entrada invalida. Por favor ingrese 'activo' o 'inactivo'.");
            }
        }
        boolean valid = control.registerProjectInPillar(pillarType, id, name, description, status);
        if (valid) {
            System.out.println("Proyecto registrado exitosamente!");
        } else {
            System.out.println("Error al registrar el proyecto. Intente nuevamente");
        }
    }

    /**
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar
     */
    public void showProjectsByPillar() {
        System.out.println("Ingrese el tipo de pilar del cual desea consultar los proyectos \n(1:Biodiversidad, \n2:Agua, \n3:Tratamiento de Basuras, \n4:Energia): ");
        int pillarType = reader.nextInt();
        reader.nextLine(); // buffer cleaning
        System.out.println(control.queryProjectsByPillar(pillarType));

    }

}
