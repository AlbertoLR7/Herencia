package ej4;

public class Pintura {
    private double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }
    public double calcularPintura(Forma forma) {
        return forma.area() / cobertura;
    }
    /* aquí yace el polimorfismo,
       el metodo recibe el objeto forma
       pero puede ser cualquier figura
    */
}


