import javax.naming.InvalidNameException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Sistema {


    private Gestion<Pasajero> gestionPasajeros;
    private Gestion<Vuelo> gestionVuelos;
    private Gestion<Reserva> gestionReservas;

    Menu menu;

    public Sistema() {
        this.menu = new Menu();
        this.gestionReservas = new Gestion<>();
        this.gestionVuelos = new Gestion<>();
        this.gestionPasajeros = new Gestion<>();
    }



    public Gestion<Reserva> getGestionReservas() {
        return gestionReservas;
    }

    public Gestion<Vuelo> getGestionVuelos() {
        return gestionVuelos;
    }

    public Gestion<Pasajero> getGestionPasajeros() {
        return gestionPasajeros;
    }



    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------




    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //PASAJEROS:|| CREACION Y AGREGACION || BUSQUEDA || ELIMINACION || MODIFICACION || CAMBIAR NOMBRE Y PASAPORTE ||
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //CREA Y AGREGA AL CONJUNTO DE PASAJEROS
    public void crearAgregarPasajero() throws NombreInvalidoExepcion, NumeroPasaporteInvalido {

        String nombreCompleto;
        int nroPasaporte;

        nombreCompleto = menu.pedirNombreCompleto();
        nroPasaporte = menu.pedirNroPasaporte();

        Pasajero pasajerito = new Pasajero(nombreCompleto, nroPasaporte);

        gestionPasajeros.agregar(pasajerito);


    }

    //BUSCA Y RETORNA NULL SI NO LO ENCUENTRA
    public Pasajero buscarPasajero() {

        int nroPasaporte = menu.pedirNroPasaporte();
        Pasajero pasajerito = null;

        for (Pasajero elemento : gestionPasajeros.getListaElementos()) {

            if (elemento.getNroPasaporte() == nroPasaporte) {

                pasajerito = elemento;
                break;
            }
        }
        return pasajerito;
    }

    public void eliminarPasajero() {

        Pasajero pasajero = buscarPasajero();

        if (pasajero != null) {
            gestionPasajeros.eliminar(pasajero);
        } else {
            System.out.println("El pasajero que queres eliminar no esta registrado");
        }


    }

    public void modificarDatosPasajero() throws InputMismatchException, ingresoNumericoInvalido {


        int eleccion = menu.modificacionDatosPasajero();
        int valor;

        if (eleccion == 1) {

            valor = cambiarNombre();

        } else {

            valor = cambiarNroPasaporte();

        }

        if (valor == 1) {
            System.out.println("Cambio Exitoso");
        } else {
            System.out.println("Cambio sin exito");
        }
    }

//AUXILIARES PARA MODIFICAR

    public int cambiarNombre() {

        int nroPasaporte = menu.pedirNroPasaporte();
        int valor = 0;

        for (Pasajero elemento : gestionPasajeros.getListaElementos()) {

            if (elemento.getNroPasaporte() == nroPasaporte) {

                String nombreCompleto = menu.pedirNombreCompleto();
                elemento.setNombreCompleto(nombreCompleto);
                valor = 1;
                break;
            }
        }
        return valor;
    }


    public int cambiarNroPasaporte() {

        int nroPasaporte = menu.pedirNroPasaporte();
        Pasajero pasajerito;
        int valor = 0;

        for (Pasajero elemento : gestionPasajeros.getListaElementos()) {

            if (elemento.getNroPasaporte() == nroPasaporte) {

                int nroPasaporteNuevo = menu.pedirNroPasaporte();
                elemento.setNroPasaporte(nroPasaporteNuevo);
                valor = 1;
                break;
            }
        }

        return valor;

    }


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //VUELOS:
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public void crearAgregarVuelo(){

    String destino;
    LocalDate fecha;
    LocalTime horario;
    EstadoVuelo estado;
    TipoVuelo tipo;

    tipo = menu.pedirTipoVuelo();
    destino = menu.pedirDestino();
    fecha = menu.pedirFecha();
    horario = menu.pedirHora();
    estado = menu.pedirEstadoVuelo();


    Vuelo vuelito = new Vuelo(destino,fecha,horario,estado,tipo);

    gestionVuelos.agregar(vuelito);

}

    public int buscarVueloPDestino(){

        String destino = menu.pedirDestino();
        int valor = 0;

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            if(Objects.equals(destino, elemento.getDestino())){

                System.out.println(elemento.toString());
                valor++;
            }
        }
        return valor;
    }

    public Vuelo buscarVueloPId(){

        int id = menu.pedirId();
        Vuelo vueloBuscado = null;

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            if(id == elemento.getId()){

                vueloBuscado = elemento;
                break;
            }
        }

        return vueloBuscado;
    }

    public void eliminarVuelo() {

        Vuelo vuelo = buscarVueloPId();

        if (vuelo != null) {
            gestionVuelos.eliminar(vuelo);
        } else {
            System.out.println("El vuelo que queres eliminar no esta registrado");
        }
    }

    public void modificarVuelo() throws ingresoNumericoInvalido{


        int eleccion = menu.modificacionDatosVuelo();
        int valor = 0;

        switch (eleccion){

            case 1:
                valor = cambiarDestino();
                break;

            case 2:
                valor = cambiarFecha();
                break;

            case 3:
                valor = cambiarHorario();
                break;

            case 4:
                valor = cambiarEstado();
                break;

            case 5:
                valor = cambiarTipoVuelo();
                break;

            default:
                System.out.println("Opcion invalida");
                break;

        }

        if(valor == 1){
        System.out.println("\nCambio exitoso");
        }
        else{
        System.out.println("\nCambio sin exito");
        }

}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//AUXILIARES
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public int cambiarDestino() {

        int id = menu.pedirId();
        int valor = 0;

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            if (elemento.getId() == id) {

                String destino = menu.pedirDestino();
                elemento.setDestino(destino);
                valor = 1;
                break;
            }
        }
        return valor;
    }

    public int cambiarEstado() {

        int id = menu.pedirId();
        int valor = 0;

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            if (elemento.getId() == id) {

                EstadoVuelo estado = menu.pedirEstadoVuelo();
                elemento.setEstado(estado);
                valor = 1;
                break;
            }
        }
        return valor;
    }

    public int cambiarTipoVuelo() {

        int id = menu.pedirId();
        int valor = 0;

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            if (elemento.getId() == id) {

                TipoVuelo tipo = menu.pedirTipoVuelo();
                elemento.setTipoVuelo(tipo);
                valor = 1;
                break;
            }
        }
        return valor;
    }

    public int cambiarFecha() {

        int id = menu.pedirId();
        int valor = 0;

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            if (elemento.getId() == id) {

                LocalDate fecha = menu.pedirFecha();
                elemento.setfecha(fecha);
                valor = 1;
                break;
            }
        }
        return valor;
    }

    public int cambiarHorario() {

        int id = menu.pedirId();
        int valor = 0;

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            if (elemento.getId() == id) {

                LocalTime horario = menu.pedirHora();
                elemento.setHorario(horario);
                valor = 1;
                break;
            }
        }
        return valor;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //RESERVAS
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public void crearAgregarReserva() throws PasajeroNoEncontradoExepcion,VueloNoEncontradoExepcion{

        Pasajero pasajero;
        Vuelo vuelo;
        ClaseAsiento claseAsiento;

        System.out.println("\nPASAJERO");
        listarNroPasaporte();
        pasajero = pedirPasajero();

        System.out.println("\nVUELO");
        listarIDVuelos();
        vuelo = pedirVuelo();

        claseAsiento = menu.pedirClaseAsiento();

        Reserva reserva = new Reserva(pasajero,vuelo,claseAsiento);

        gestionReservas.agregar(reserva);

    }

    public Reserva buscarReservaPId(){

        int id = menu.pedirId();
        Reserva reservaBuscada = null;

        for (Reserva elemento : gestionReservas.getListaElementos()) {

            if(id == elemento.getId()){

                reservaBuscada = elemento;
                break;
            }
        }

        return reservaBuscada;
    }

    public void cancelarReserva(){

        listarIDReservas();
        Reserva reserva = buscarReservaPId();


        if(reserva != null){
            gestionReservas.eliminar(reserva);
        }
        else{
            System.out.println("Reserva no encontrada");
        }

    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //AUXILIARES
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



    public Pasajero pedirPasajero() throws PasajeroNoEncontradoExepcion {

       Pasajero pasajero = buscarPasajero();

        if (pasajero == null) {
            throw new PasajeroNoEncontradoExepcion("Pasajero no encontrado.");
        }

        return pasajero;
    }

    public Vuelo pedirVuelo() throws VueloNoEncontradoExepcion {

        Vuelo vuelo = buscarVueloPId();

        if (vuelo == null) {
            throw new VueloNoEncontradoExepcion("Vuelo no encontrado.");
        }

        return vuelo;
    }


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //LISTAR
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    public void listarPasajeros(){

        for (Pasajero elemento : gestionPasajeros.getListaElementos()) {

            System.out.println(elemento.toString());
        }

    }

    public void listarVuelos(){

        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            System.out.println(elemento.toString());
        }

    }

    public void listarReservas(){

        for (Reserva elemento : gestionReservas.getListaElementos()) {

            System.out.println(elemento.toString());
        }

    }

    public void listarIDReservas(){


        for (Reserva elemento : gestionReservas.getListaElementos()) {

            System.out.println(elemento.getId());
        }
    }

    public void listarIDVuelos(){


        for (Vuelo elemento : gestionVuelos.getListaElementos()) {

            System.out.println(elemento.getId());
        }
    }

    public void listarNroPasaporte(){

        for (Pasajero elemento : gestionPasajeros.getListaElementos()) {

            System.out.println(elemento.getNroPasaporte());
        }

}


    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //PREDETERMINADOS
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void elementosPredeterminados(){

        Pasajero pasajero1 = new Pasajero("Ruben Insua",123456789);
        Pasajero pasajero2 = new Pasajero("Miguel Borja",987654321);
        Pasajero pasajero3 = new Pasajero("Santiago Quiroz",987612345);
        Pasajero pasajero4 = new Pasajero("Marcelo Santana",123459876);
        Pasajero pasajero5 = new Pasajero("Ramiro Mori",192837465);

        gestionPasajeros.agregar(pasajero1);
        gestionPasajeros.agregar(pasajero2);
        gestionPasajeros.agregar(pasajero3);
        gestionPasajeros.agregar(pasajero4);
        gestionPasajeros.agregar(pasajero5);


        Vuelo vuelo1 = new Vuelo("New York", LocalDate.of(2024, 6, 10), LocalTime.of(10, 30), EstadoVuelo.PROGRAMADO, TipoVuelo.INTERNACIONAL);
        Vuelo vuelo2 = new Vuelo("Madrid", LocalDate.of(2024, 6, 11), LocalTime.of(12, 45), EstadoVuelo.RETRASADO, TipoVuelo.INTERNACIONAL);
        Vuelo vuelo3 = new Vuelo("Chubut", LocalDate.of(2024, 6, 12), LocalTime.of(14, 00), EstadoVuelo.CANCELADO, TipoVuelo.NACIONAL);
        Vuelo vuelo4 = new Vuelo("Cordoba", LocalDate.of(2024, 6, 13), LocalTime.of(16, 15), EstadoVuelo.DESPEGADO, TipoVuelo.NACIONAL);
        Vuelo vuelo5 = new Vuelo("Moscu", LocalDate.of(2024, 6, 14), LocalTime.of(18, 30), EstadoVuelo.PROGRAMADO, TipoVuelo.INTERNACIONAL);

        gestionVuelos.agregar(vuelo1);
        gestionVuelos.agregar(vuelo2);
        gestionVuelos.agregar(vuelo3);
        gestionVuelos.agregar(vuelo4);
        gestionVuelos.agregar(vuelo5);


        Reserva reserva1 = new Reserva(pasajero1,vuelo1,ClaseAsiento.ECONOMICA);
        Reserva reserva2 = new Reserva(pasajero2,vuelo2,ClaseAsiento.NEGOCIOS);
        Reserva reserva3 = new Reserva(pasajero3,vuelo3,ClaseAsiento.ECONOMICA);
        Reserva reserva4 = new Reserva(pasajero4,vuelo4,ClaseAsiento.PRIMERA);
        Reserva reserva5 = new Reserva(pasajero5,vuelo5,ClaseAsiento.NEGOCIOS);

        gestionReservas.agregar(reserva1);
        gestionReservas.agregar(reserva2);
        gestionReservas.agregar(reserva3);
        gestionReservas.agregar(reserva4);
        gestionReservas.agregar(reserva5);


    }




    public void setGestionPasajeros() throws ingresoNumericoInvalido, NumeroPasaporteInvalido, NombreInvalidoExepcion {

        int eleccion = menu.menuGestionPasajero();
        Pasajero pasajeroBuscado;

        switch(eleccion){

            case 1:
            crearAgregarPasajero();
                break;

            case 2:
                eliminarPasajero();
                break;

            case 3:
                pasajeroBuscado = buscarPasajero();
                if(pasajeroBuscado != null){
                    System.out.println("Pasajero Buscado: " + pasajeroBuscado.toString());
                }
                break;

            case 4:
                modificarDatosPasajero();
                break;

            case 5:
                listarPasajeros();
                break;

            default:

                System.out.println("Opcion invalida");
                    break;

        }
    }

    public void setGestionReservas() throws ingresoNumericoInvalido, NumeroPasaporteInvalido, NombreInvalidoExepcion, PasajeroNoEncontradoExepcion, VueloNoEncontradoExepcion {

        int eleccion = menu.menuGestionReservas();
        Reserva reservaBuscada;

        switch(eleccion){

            case 1:
            crearAgregarReserva();
                break;

            case 2:
            cancelarReserva();
                break;

            case 3:
            reservaBuscada = buscarReservaPId();
                if(reservaBuscada != null){
                    System.out.println("Reserva Buscada: " + reservaBuscada.toString());
                }
                break;

            case 4:
            listarReservas();
                break;

            default:

                System.out.println("Opcion invalida");
                break;

        }
    }

    public void setGestionVuelos() throws ingresoNumericoInvalido, PasajeroNoEncontradoExepcion, VueloNoEncontradoExepcion {

        int eleccion = menu.menuGestionVuelos();
        int valor = 0;

        switch(eleccion){

            case 1:
                crearAgregarVuelo();
                break;

            case 2:
                valor = buscarVueloPDestino();
                if(valor == 0){
                    System.out.println("No se encontro el destino");
                }
                break;

            case 3:
                eliminarVuelo();
                break;

            case 4:
                modificarVuelo();
                break;

            case 5:
                listarVuelos();
                break;

            default:

                System.out.println("Opcion invalida");
                break;

        }
    }

    public void inciarSistemaReservas() throws ingresoNumericoInvalido, NumeroPasaporteInvalido, NombreInvalidoExepcion, PasajeroNoEncontradoExepcion, VueloNoEncontradoExepcion
    {

        elementosPredeterminados();
        int eleccion1;
        int valor = 1;

        while(valor == 1) {

            eleccion1 = menu.menuPrincipal();

            switch (eleccion1) {

                case 1:
                    setGestionReservas();
                    break;

                case 2:
                    setGestionPasajeros();
                    break;

                case 3:
                    setGestionVuelos();
                    break;

                default:

                    System.out.println("\nopcion invalida");
                    break;

            }

            valor = menu.seguirCortar();


        }
    }










}
