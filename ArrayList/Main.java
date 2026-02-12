package ArrayList;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static TelefonoMovil telefono = new TelefonoMovil("77");
    public static void main(String[] args) {
        boolean salir = false;
        printMenu();

        while (!salir) {

            System.out.print("Elige una opcion:");
            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 0) {
                    salir = true;
                }
                else if (opcion == 1) {
                    telefono.printContacts();
                }
                else if (opcion == 2) {
                    addContact();
                }
                else if (opcion == 3) {
                    updateContact();
                }
                else if (opcion == 4) {
                    removeContact();
                }
                else if (opcion == 5) {
                    queryContact();
                }
                else if (opcion == 6) {
                    printMenu();
                }
                else {
                    System.out.println("opción no valida");
                }
            }
            else {
                System.out.println("tienes que introducir un número");
                scanner.nextLine();
            }
        }

        System.out.println("Programa finalizado");
    }

    private static void printMenu() {

        System.out.println("0 -Salir");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Agregar nuevo contacto");
        System.out.println("3 -Actualizar contacto existente");
        System.out.println("4 -Eliminar contacto");
        System.out.println("5 - Buscar contacto");
        System.out.println("6- Mostrar menú");
    }

    private static void addContact() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("telefono: ");
        String phone = scanner.nextLine();

        Contacto contacto = Contacto.createContact(name, phone);
        if (telefono.addNewContact(contacto)) {
            System.out.println("Contacto añadido");
        }
        else {
            System.out.println("Error, el contacto ya existe");
        }
    }

    private static void updateContact() {
        System.out.print("Nombre del contacto para actualizar: ");
        String name = scanner.nextLine();

        Contacto oldContact = telefono.queryContact(name);
        if (oldContact == null) {
            System.out.println("Error el contacto no existe");
        }
        else {
            System.out.print("nombre nuevo: ");
            String newName = scanner.nextLine();

            System.out.print("telefono nuevo: ");
            String newPhone = scanner.nextLine();

            Contacto newContact = Contacto.createContact(newName, newPhone);
            if (telefono.updateContact(oldContact, newContact)) {
                System.out.println("Contacto actualizado");
            }
            else {
                System.out.println("ya existe un contacto con ese nombre");
            }
        }
    }

    private static void removeContact() {

        System.out.print("Nombre del contacto para eliminar: ");
        String name = scanner.nextLine();

        Contacto contacto = telefono.queryContact(name);
        if (contacto == null) {
            System.out.println("el contacto no existe.");
        }
        else {

            if (telefono.removeContact(contacto)) {
                System.out.println("Contacto eliminado");
            }
            else {
                System.out.println("Error al eliminar");
            }
        }
    }

    private static void queryContact() {
        System.out.print("Nombrepara buscar: ");
        String name = scanner.nextLine();

        Contacto contacto = telefono.queryContact(name);
        if (contacto == null) {
            System.out.println("el contacto no existe.");
        }
        else {
            System.out.println("Nombre: " + contacto.getName());
            System.out.println("Teléfono: " + contacto.getPhoneNumber());
        }
    }
}
