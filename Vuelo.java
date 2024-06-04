import java.time.*;


public class Vuelo implements Comparable<Vuelo>{

    private final int id;
    private static int autoid = 1;
    private String destino; //(pais/ciudad)
    private LocalDate fecha;
    private LocalTime horario;
    private EstadoVuelo estado; //enum(programado, retrasado, cancelado, despegado)
    private TipoVuelo tipoVuelo; // enum(internacional, nacional)


    public Vuelo(String destino, LocalDate fecha,LocalTime horario, EstadoVuelo estado, TipoVuelo tipoVuelo) {
        this.destino = destino;
        this.fecha = fecha;
        this.horario = horario;
        this.estado = estado;
        this.tipoVuelo = tipoVuelo;
        this.id = autoid;
        autoid++;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getfecha() {
        return fecha;
    }

    public void setfecha(LocalDate fecha) {
        this.fecha = Vuelo.this.fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public EstadoVuelo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Vuelo otro) {
        return Integer.compare(this.id, otro.id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d || Tipo vuelo: %s || Destino: %s || fecha: " + this.fecha + " || Horario: " + this.horario + " || Estado: %s ", this.id,this.tipoVuelo,this.destino,this.estado);
    }
}
