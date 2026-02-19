package LinkedList;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<Album>();

        Album album1 = new Album("Divide", "Ed Sheeran");
        album1.addSong("Shape of You", 4.24);
        album1.addSong("Perfect", 4.40);
        album1.addSong("Galway Girl", 2.50);
        album1.addSong("Happier", 3.27);
        Album album2 = new Album("Thriller", "Michael Jackson");
        album2.addSong("Thriller", 5.57);
        album2.addSong("Beat It", 4.18);
        album2.addSong("Billie Jean", 4.54);
        album2.addSong("Human Nature", 4.06);

        albums.add(album1);
        albums.add(album2);

        for (int i = 0; i < albums.size(); i++) {
            Album a = albums.get(i);
            a.mostrarCanciones();
        }

        LinkedList<Cancion> playList = new LinkedList<Cancion>();
        album1.addToPlayList(1, playList);
        album1.addToPlayList(2, playList);
        album2.addToPlayList(1, playList);
        album2.addToPlayList(3, playList);
        album2.addToPlayList("Human Nature", playList);
        play(playList);
    }

    public static void printMenu() {
        System.out.println("\nMENÚ");
        System.out.println("0 – Salir");
        System.out.println("1 –Siguiente cancion");
        System.out.println("2 –Canción previa");
        System.out.println("3 – Repetir canción actual");
        System.out.println("4–Mostrar playlist");
        System.out.println("5 – Mostrar menú");
        System.out.println("6 – Eliminar canción actual");
    }

    public static void printPlayList(LinkedList<Cancion> playList) {
        System.out.println("Lista de reproduccion:");
        for (int i = 0; i < playList.size(); i++) {
            System.out.println(playList.get(i));
        }
    }

    public static void play(LinkedList<Cancion> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        boolean adelante = true;

        ListIterator<Cancion> iterator = playList.listIterator();
        if (playList.isEmpty()) {
            System.out.println("playlist vacía");
            return;
        }

        printPlayList(playList);
        printMenu();
        System.out.println("Reproduciendo: " + iterator.next());

        while (!salir) {
            if (!scanner.hasNextInt()) {
                System.out.println("Opción no válida");
                printMenu();
                scanner.next();
            }
            else {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 0:
                        salir = true;
                        break;
                    case 1:
                        if (!adelante) {
                            if (iterator.hasNext()) {
                                iterator.next();
                            }
                            adelante = true;
                        }
                        if (iterator.hasNext()) {
                            System.out.println("Reproduciendo: " + iterator.next());
                        }
                        else {
                            System.out.println("final de la lista");
                            adelante = false;
                        }
                        break;
                    case 2:
                        if (adelante) {
                            if (iterator.hasPrevious()) {
                                iterator.previous();
                            }
                            adelante = false;
                        }
                        if (iterator.hasPrevious()) {
                            System.out.println("Reproduciendo: " + iterator.previous());
                        }
                        else {
                            System.out.println("Principio de la lista");
                            adelante = true;
                        }
                        break;
                    case 3:
                        if (adelante) {
                            if (iterator.hasPrevious()) {
                                Cancion actual = iterator.previous();
                                System.out.println("Repitiendo: " + actual);
                                iterator.next();
                            }

                        } else {
                            if (iterator.hasNext()) {
                                Cancion actual = iterator.next();
                                System.out.println("Repitiendo: " + actual);
                                iterator.previous();
                            }
                        }
                        break;

                    case 4:
                        printPlayList(playList);
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6:
                        if (playList.size() > 0) {
                            iterator.remove();
                            System.out.println("Canción eliminada");

                            if (iterator.hasNext()) {
                                System.out.println("Reproduciendo: " + iterator.next());
                            }
                            else if (iterator.hasPrevious()) {
                                System.out.println("Reproduciendo: " + iterator.previous());
                            }
                            else {
                                System.out.println("Playlist vacía");
                                salir = true;
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción no válida");
                        printMenu();
                }
            }
        }
    }
}
