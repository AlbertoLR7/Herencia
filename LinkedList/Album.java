package LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<Cancion>();
    }

    private Cancion findSong(String titulo) {
        for (int i = 0; i < canciones.size(); i++) {
            Cancion c = canciones.get(i);
            if (c.getTitulo().equals(titulo)) {
                return c;
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion) {
        if (findSong(titulo) == null) {
            canciones.add(new Cancion(titulo, duracion));
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlayList(int numeroPista, LinkedList<Cancion> playList) {
        int indice = numeroPista - 1;

        if (indice >= 0 && indice < canciones.size()) {
            Cancion cancion = canciones.get(indice);
            playList.add(cancion);
            return true;
        } else {
            return false;
        }
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playList) {
        Cancion cancion = findSong(titulo);
        if (cancion != null) {
            playList.add(cancion);
            return true;
        } else {
            return false;
        }
    }

    public void mostrarCanciones() {
        System.out.println("Álbum: " + nombre + " - Artista: " + artista);
        for (int i = 0; i < canciones.size(); i++) {
            System.out.println((i + 1) + ". " + canciones.get(i));
        }
    }
}
