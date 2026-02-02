package ej4;

public class esfera extends Forma {
    private double radio;

    public esfera(double radio) {
        super("esfera");
        this.radio = radio;
    }

    @Override
    public double area() {
        return 4 * Math.PI * radio * radio;
    }
}
