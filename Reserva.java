import java.nio.channels.ClosedSelectorException;

public class Reserva implements Comparable<Reserva>{

    private final int id;
    private static int autoid = 1;

    private Pasajero pasajero;
    private Vuelo vuelo;
    private ClaseAsiento claseAsiento; // enum(economica, negocios, primera)


    public Reserva(Pasajero pasajero, Vuelo vuelo, ClaseAsiento claseAsiento) {

        if(pasajero == null || vuelo == null || claseAsiento == null){
            throw new IllegalArgumentException("El pasajero, el vuelo y la clase no puede ser un elemento nulo");
        }

        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.claseAsiento = claseAsiento;
        this.id = autoid;
        autoid++;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public ClaseAsiento getClaseAsiento() {
        return claseAsiento;
    }

    public void setClaseAsiento(ClaseAsiento claseAsiento) {
        this.claseAsiento = claseAsiento;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Reserva otraReserva) {
        return Integer.compare(this.id, otraReserva.id);
    }


    @Override
    public String toString() {
        return String.format("\nID Reserva: %d || Clase: %s\nPASAJERO: " + this.pasajero.toString() +  "\nVUELO: " + this.vuelo.toString() ,this.id,this.claseAsiento);
    }
}
