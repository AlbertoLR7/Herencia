package ej7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Estudiante> lista = new ArrayList<Estudiante>();
        lista.add(new Estudiante("patri", 12, 170));
        lista.add(new Estudiante("Manuel", 43, 173));
        lista.add(new Estudiante("javier", 72, 189));
        lista.add(new Estudiante("alicia", 52, 168));
        lista.add(new Estudiante("Alberto", 35, 189));

        System.out.println("estudiantes sin ordenar:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "." + lista.get(i));
        }


        Collections.sort(lista);
        System.out.println("estudiantes ordenads:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "." + lista.get(i));
        }
    }
}
