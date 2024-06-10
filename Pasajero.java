pasdjfkdsjfkl
    pasdjfkdsjfkl
    pasdjfkdsjfkl
    

import java.util.Comparator;
import java.util.Objects;

public class Pasajero implements Comparable<Pasajero>{

    private String nombreCompleto;
    private int nroPasaporte;

    public Pasajero(String nombreCompleto, int nroPasaporte) {
        this.nombreCompleto = nombreCompleto;
        this.nroPasaporte = nroPasaporte;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getNroPasaporte() {
        return nroPasaporte;
    }

    public void setNroPasaporte(int nroPasaporte) {
        this.nroPasaporte = nroPasaporte;
    }

    @Override
    public int compareTo(Pasajero otro) {
        return Integer.compare(this.nroPasaporte,otro.nroPasaporte);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pasajero pasajero = (Pasajero) o;
        return nroPasaporte == pasajero.nroPasaporte && Objects.equals(nombreCompleto, pasajero.nombreCompleto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCompleto, nroPasaporte);
    }

    @Override
    public String toString() {
        return String.format("Nombre completo: " + this.nombreCompleto +" || numero pasaporte: " + this.nroPasaporte);
    }


}
