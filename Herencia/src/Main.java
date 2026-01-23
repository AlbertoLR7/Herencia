public class Main {

    public static void main(String[] args) {

        Circulo circulo = new Circulo(3);
        System.out.println("Radio del circulo: " + circulo.getRadio());
        System.out.println("Area del circulo: " + circulo.getArea());
        Cilindro cilindro = new Cilindro(3, 5);
        System.out.println("Radio del cilindro " + cilindro.getRadio());
        System.out.println("Altura del cilindro:" + cilindro.getAltura());
        System.out.println("Area de la base:" + cilindro.getArea());
        System.out.println("Volumen del cilindro:" + cilindro.getVolume());
    }
}
