package Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    private static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {
        CuerpoCeleste cuerpo;
        cuerpo = new Planeta("Mercurio", 88);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo); planetas.add(cuerpo);

        cuerpo = new Planeta("Venus", 225);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);

        cuerpo = new Planeta("Tierra", 365);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);

        cuerpo = new Planeta("Marte", 687);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);

        cuerpo = new Planeta("Jupiter", 4332);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);


        cuerpo = new Planeta("Saturno", 10759);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);

        cuerpo = new Planeta("Urano", 30660);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);

        cuerpo = new Planeta("Neptuno", 165);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);

        cuerpo = new Planeta("Pluton", 248);
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        planetas.add(cuerpo);



        CuerpoCeleste luna = new Luna("Luna", 27);
        sistemaSolar.put(luna.getNombre(), luna);
        sistemaSolar.get("Tierra").addSatelite(luna);


        CuerpoCeleste deimos = new Luna("Deimos", 1.3);
        CuerpoCeleste phobos = new Luna("Phobos", 0.3);
        sistemaSolar.put(deimos.getNombre(), deimos);
        sistemaSolar.put(phobos.getNombre(), phobos);
        sistemaSolar.get("Marte").addSatelite(deimos);
        sistemaSolar.get("Marte").addSatelite(phobos);



        CuerpoCeleste io = new Luna("Io", 1.8);
        CuerpoCeleste europa = new Luna("Europa", 3.5);
        CuerpoCeleste ganymede = new Luna("Ganymede", 7.1);
        CuerpoCeleste callisto = new Luna("Callisto", 16.7);

        sistemaSolar.put(io.getNombre(), io);
        sistemaSolar.put(europa.getNombre(), europa);
        sistemaSolar.put(ganymede.getNombre(), ganymede);
        sistemaSolar.put(callisto.getNombre(), callisto);
        sistemaSolar.get("Jupiter").addSatelite(io);
        sistemaSolar.get("Jupiter").addSatelite(europa);
        sistemaSolar.get("Jupiter").addSatelite(ganymede);
        sistemaSolar.get("Jupiter").addSatelite(callisto);


        System.out.println("planetas:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta.getNombre());
        }
        System.out.println("Lunas demarte:");
        CuerpoCeleste marte = sistemaSolar.get("Marte");
        for (CuerpoCeleste satelite : marte.getSatelites()) {
            System.out.println(satelite.getNombre());
        }


        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste planeta : planetas) {
            lunas.addAll(planeta.getSatelites());
        }
        System.out.println("todas las lunas:");
        for (CuerpoCeleste satelite : lunas) {
            System.out.println(satelite.getNombre());
        }

        CuerpoCeleste pluton2 = new Planeta("Pluton", 884);
        planetas.add(pluton2);
        System.out.println("planetas con toString:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta);
        }
    }
}

/*
Se agrega el nuevo Plutón al Set?
no, porque el hashSet los considera el mismo objeto y no lo añade

Qué pasa si lo creamos como PlanetaEnano?
sí se añadiría
CuerpoCeleste pluton3 = new PlanetaEnano("Pluton", 884);
planetas.add(pluton3);


Utiliza la diferencia y la intersección de Set utilizando el código.

intersección:
Set<CuerpoCeleste> interseccion = new HashSet<>(planetas);
interseccion.retainAll(lunas);

resultado: vacío
porque ningún planeta es una luna

diferencia:
Set<CuerpoCeleste> diferencia = new HashSet<>(planetas);
diferencia.removeAll(lunas);

resultado: todos los planetas
porque eliminamos las lunas
 */