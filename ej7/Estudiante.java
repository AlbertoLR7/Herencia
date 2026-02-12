package ej7;


public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private int edad;
    private int altura;

    public Estudiante(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAltura() {
        return altura;
    }

    @Override
    public int compareTo(Estudiante otro) {
        if (this.altura > otro.altura) {
            return -1;
        } else if (this.altura < otro.altura) {
            return 1;
        } else {
            return Integer.compare(otro.edad, this.edad);
        }
    }
    @Override
    public String toString() {
        return nombre + "-Altura: " + altura + "- edad:" + edad;
    }
}
