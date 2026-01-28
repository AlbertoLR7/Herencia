public class MainImpresora {
    public static void main(String[] args) {
        Impresora impresora = new Impresora(50, true);

        System.out.println("Añadiendo tOner: " + impresora.añadirToner(30));
        System.out.println("Imprimiendo 10 páginas: " + impresora.imprimirPaginas(10));
        System.out.println("Paginas impresas totales: " + impresora.getPaginasImpresas());

        System.out.println("Añadiendo tóner" + impresora.añadirToner(120)); //este falla
        System.out.println("Imprimiendo 20 páginas " + impresora.imprimirPaginas(20));
        System.out.println("Páginas impresas totales:" + impresora.getPaginasImpresas());
    }
}