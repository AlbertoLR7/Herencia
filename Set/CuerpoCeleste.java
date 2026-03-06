package Set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {
    public enum TipoCuerpoCeleste {
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;
    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        this.satelites = new HashSet<>();
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return new HashSet<>(satelites);
    }

    public boolean addSatelite(CuerpoCeleste satelite) {
        return this.satelites.add(satelite);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        } if (obj == null) {
            return false;
        } if (getClass() != obj.getClass()) {
            return false;
        }
        CuerpoCeleste otro = (CuerpoCeleste) obj;
        if (!this.nombre.equals(otro.nombre)) {
            return false;
        } if (this.tipoCuerpo != otro.tipoCuerpo) {
            return false;
        } return true;
    }

    @Override
    public int hashCode() {
        return this.nombre.hashCode() + this.tipoCuerpo.hashCode() + 57;
    }

    @Override
    public String toString() {
        return nombre + ": " + tipoCuerpo + ", " + periodoOrbital;
    }
}
