package ej4;

public class Cilindro extends Forma {
    private double radio;
    private double altura;
    public Cilindro(double radio, double altura) {
        super("cilndro");
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double area() {
        return Math.PI * radio * radio * altura;
    }
}
