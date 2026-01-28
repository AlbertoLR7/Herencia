public class Impresora {
    private int nivelToner;
    private int paginasImpresas;
    private boolean esDobleCara;

    public Impresora(int nivelToner, boolean esDobleCara) {
        this.nivelToner = nivelToner;
        this.esDobleCara = esDobleCara;
        this.paginasImpresas = 0;
    }

    public int añadirToner(int cantidad) {
        if (cantidad < 0 || cantidad > 100) {
            return -1;
        }
        if (this.nivelToner + cantidad > 100) {
            return -1;
        }
        this.nivelToner += cantidad;
        return this.nivelToner;
    }

    public int imprimirPaginas(int paginas) {
        int paginasReales = paginas;
        if (esDobleCara) {
            paginasReales = (paginas + 1) / 2;
        }
        if (this.nivelToner < paginasReales) {
            return -1;
        }
        this.nivelToner -= paginasReales;
        this.paginasImpresas += paginasReales;
        return paginasReales;
    }

    public int getPaginasImpresas() {
        return this.paginasImpresas;
    }
}
