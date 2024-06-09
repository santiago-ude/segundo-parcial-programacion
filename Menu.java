

jdjdjdj


import java.lang.*;
import java.time.LocalTime;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;


    public Menu() {
        this.scanner = new Scanner(System.in);
    }


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //MENUS
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int menuPrincipal() throws ingresoNumericoInvalido{

        while(true){

            try{

                System.out.println("\n1.Gestion de reservas");
                System.out.println("\n2.Gestion de pasajeros");
                System.out.println("\n3.Gestion de vuelos");
                System.out.println("\nInserte una opcion: ");
                int eleccion = scanner.nextInt();
                scanner.nextLine();

                if(eleccion < 1 || eleccion > 3){
                    throw new ingresoNumericoInvalido("Opcion invalida, intente de nuevo");
                }
                return eleccion;
            }
            catch (InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();
            }
            catch (ingresoNumericoInvalido e){
                System.out.println(e.getMessage());

            }

        }
    }


    public int menuGestionPasajero() throws ingresoNumericoInvalido{

    while(true){

        try{

            System.out.println("\n1.Crear Pasajero");
            System.out.println("\n2.Eliminar Pasajero");
            System.out.println("\n3.Buscar Pasajero");
            System.out.println("\n4.Modificar datos pasajero");
            System.out.println("\n5.Listar Pasajeros");
            System.out.println("\nInserte una opcion: ");
            int eleccion = scanner.nextInt();
            scanner.nextLine();

            if(eleccion < 1 || eleccion > 5){

                throw new ingresoNumericoInvalido("Opcion invalida, intente denuevo");

            }

            return eleccion;

        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.nextLine();

        }
        catch(ingresoNumericoInvalido e){

            System.out.println(e.getMessage());

        }
    }
}


    public int menuGestionReservas() throws ingresoNumericoInvalido{

        while(true){

            try{

                System.out.println("\n1.Crear Reserva");
                System.out.println("\n2.Cancelar Reserva");
                System.out.println("\n3.Buscar Reserva");
                System.out.println("\n4.Listar Reservas");
                System.out.println("\nInserte una opcion: ");
                int eleccion = scanner.nextInt();
                scanner.nextLine();

                if(eleccion < 1 || eleccion > 4){

                    throw new ingresoNumericoInvalido("Opcion invalida, intente denuevo");

                }

                return eleccion;

            }
            catch(InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();

            }
            catch(ingresoNumericoInvalido e){

                System.out.println(e.getMessage());

            }
        }
    }


    public int menuGestionVuelos() throws ingresoNumericoInvalido{

        while(true){

            try{

                System.out.println("\n1.Crear Vuelo");
                System.out.println("\n2.Buscar Vuelo");
                System.out.println("\n3.Eliminar Vuelo");
                System.out.println("\n4.Modificar Datos del vuelo");
                System.out.println("\n5.Listar Vuelos");
                System.out.println("\nInserte una opcion: ");
                int eleccion = scanner.nextInt();
                scanner.nextLine();

                if(eleccion < 1 || eleccion > 5){

                    throw new ingresoNumericoInvalido("Opcion invalida, intente denuevo");

                }

                return eleccion;

            }
            catch(InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();

            }
            catch(ingresoNumericoInvalido e){

                System.out.println(e.getMessage());

            }
        }
    }


    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //PEDIDO DE VALORES SCANEADOS
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int pedirId() {
        int id = 0;

        while (true) {
            try {
                System.out.println("Ingrese el ID (solo números): ");
                String idStr = scanner.nextLine();

                // Verificar que la cadena contiene solo dígitos
                if (!idStr.matches("\\d+")) {
                    throw new NumberFormatException("El ID debe contener solo números.");
                }

                // Convertir la cadena a un entero
                id = Integer.parseInt(idStr);
                break; // Salir del bucle si el ID es válido
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. " + e.getMessage());
            }
        }

        return id;
    }

    public int seguirCortar(){

        while(true){

            try{

                System.out.println("\n1.Seguir");
                System.out.println("\n2.Cortar");
                int eleccion = scanner.nextInt();
                scanner.nextLine();

                if(eleccion != 1 && eleccion != 2){
                    throw new ingresoNumericoInvalido("Opcion invalida, intente de nuevo");
                }
                return eleccion;
            }
            catch (InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();
            }
            catch (ingresoNumericoInvalido e){
                System.out.println(e.getMessage());

            }

        }


    }


    //PASAJEROS
    public int modificacionDatosPasajero() throws ingresoNumericoInvalido{

        while(true){

            try{

                System.out.println("\n1.Nombre completo");
                System.out.println("\n2.Numero de pasaporte");
                int eleccion = scanner.nextInt();
                scanner.nextLine();

                if(eleccion != 1 && eleccion != 2){

                    throw new ingresoNumericoInvalido("Opcion invalida, intente denuevo");
                }
                return eleccion;

            }
            catch(InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();

            }
            catch(ingresoNumericoInvalido e){

                System.out.println(e.getMessage());

            }

        }

    }

    public int pedirNroPasaporte(){


        System.out.println("\nNumero de pasaporte: ");
        int nroBusqueda = scanner.nextInt();
        scanner.nextLine();

        return nroBusqueda;

    }

    public String pedirNombreCompleto(){


        while (true) {

            try {

                System.out.println("\nNombre Completo: ");
                String nombreCompleto = scanner.nextLine();

                if (!nombreCompleto.matches("[a-zA-Z\\s]+")) {

                    throw new NombreInvalidoExepcion("El nombre completo solo puede contener Letras");
                }
                return nombreCompleto;

            } catch (NombreInvalidoExepcion e) {

                System.out.println(e.getMessage());
            }

        }


    }




    //VUELOS

    public String pedirDestino(){


        System.out.println("\nDestino del vuelo: ");
        String destino = scanner.nextLine();

        return destino;

    }

    public LocalDate pedirFecha() {
        LocalDate fecha = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                System.out.println("Ingresar fecha (dd/MM/yyyy): ");
                String fechaStr = scanner.nextLine();
                fecha = LocalDate.parse(fechaStr, formatter);
                break; // Salir del bucle si la fecha es válida
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
            }
        }

        return fecha;
    }

    public LocalTime pedirHora() {
        LocalTime hora = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {
            try {
                System.out.println("Ingrese la hora (HH:mm): ");
                String horaStr = scanner.nextLine();
                hora = LocalTime.parse(horaStr, formatter);
                break; // Salir del bucle si la hora es válida
            } catch (DateTimeParseException e) {
                System.out.println("Formato de hora inválido. Por favor, intente de nuevo.");
            }
        }

        return hora;
    }

    public EstadoVuelo pedirEstadoVuelo() {
        EstadoVuelo estadoVuelo = null;

        while (true) {
            try {
                System.out.println("Ingrese el estado del vuelo (PROGRAMADO, RETRASADO, CANCELADO, DESPEGADO): ");

                String estado = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas para comparar

                estadoVuelo = EstadoVuelo.valueOf(estado);
                break; // Salir del bucle si se ingresa un valor válido
            } catch (IllegalArgumentException e) {
                System.out.println("Estado de vuelo no válido. Por favor, intente de nuevo.");
            }
        }

        return estadoVuelo;
    }

    public TipoVuelo pedirTipoVuelo() {
        TipoVuelo tipoVuelo = null;

        while (true) {
            try {
                System.out.println("Ingrese el tipo del vuelo (NACIONAL, INTERNACIONAL): ");

                String tipo = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas para comparar

                tipoVuelo = TipoVuelo.valueOf(tipo);
                break; // Salir del bucle si se ingresa un valor válido
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de vuelo no válido. Por favor, intente de nuevo.");
            }
        }

        return tipoVuelo;
    }

    public int modificacionDatosVuelo() throws ingresoNumericoInvalido{

        while(true){

            try{

                System.out.println("\n1.Destino");
                System.out.println("\n2.Fecha");
                System.out.println("\n3.Horario");
                System.out.println("\n4.Estado");
                System.out.println("\n5.Tipo de Vuelo");
                int eleccion = scanner.nextInt();
                scanner.nextLine();

                if(eleccion < 1 && eleccion > 5){

                    throw new ingresoNumericoInvalido("Opcion invalida, intente denuevo");
                }
                return eleccion;

            }
            catch(InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine();

            }
            catch(ingresoNumericoInvalido e){

                System.out.println(e.getMessage());

            }

        }

    }


    //RESERVAS


    public ClaseAsiento pedirClaseAsiento() {
        ClaseAsiento claseAsiento = null;

        while (true) {
            try {
                System.out.println("Ingrese la clase del asiento (ECONOMICA, NEGOCIOS, PRIMERA): ");

                String clase = scanner.nextLine().toUpperCase(); // Convertir a mayúsculas para comparar

                claseAsiento = ClaseAsiento.valueOf(clase);
                break; // Salir del bucle si se ingresa un valor válido
            } catch (IllegalArgumentException e) {
                System.out.println("Clase de asiento no válida. Por favor, intente de nuevo.");
            }
        }

        return claseAsiento;
    }



}





















