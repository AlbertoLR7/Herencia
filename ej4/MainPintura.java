package ej4;

public class MainPintura {

    public static void main(String[] args) {
        Pintura pintura = new Pintura(250);
        Forma rectangulo = new Rectangulo(20, 35);
        Forma esfera = new esfera(15);
        Forma cilindro = new Cilindro(10, 30);

        System.out.println(rectangulo + ": " + pintura.calcularPintura(rectangulo));
        System.out.println(esfera + ": " + pintura.calcularPintura(esfera));
        System.out.println(cilindro + ": " + pintura.calcularPintura(cilindro));
    }
}
