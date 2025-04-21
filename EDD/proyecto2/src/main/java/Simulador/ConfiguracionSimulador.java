package Simulador;

import Carteles.Cartel;
import Estructuras.TablaHash;
import Estructuras.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class ConfiguracionSimulador {

    TablaHash tablaHash = new TablaHash();
    private int tamaño = 0;
    private Scanner entrada = new Scanner(System.in);
    Cartel cartel = new Cartel();

    public void configuracionInicial() {

        this.pedirVehiculos();

    }

    public void pedirVehiculos() {

        int opcion = 0;
        do {
            opcion = 0;
            cartel.menuPedirVehiculos();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    this.pedirVehivuloManualmente();
                    break;
                case 2:

                    break;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

    public void pedirVehivuloManualmente() {

        String placa = pedirPlaca();
        System.out.println(placa + " Placa registrada");
        String tipo = pedirTipo();
        int urgencia = pedirNivelDeUrgencia();

    }

    public String pedirPlaca() {
        entrada.nextLine();
        String placa = "";
        do {

            cartel.pedirPlaca();
            placa = entrada.nextLine();
            if (placa.length() < 8) {
                cartel.pedirIngresarBienPlaca();
            } else {
                return placa;
            }
        } while (true);
    }

    public String pedirTipo() {
        entrada.nextLine();
        String tipo = "";
        do {

            cartel.pedirTipo();
            tipo = entrada.nextLine();
            if (!validarTipo(tipo)) {
                cartel.pedirIngresarUnTipoValido();
            } else {
                return tipo;
            }
        } while (true);
    }

    public boolean validarTipo(String tipo) {
        if (tipo.equals("AMBULANCIA") || tipo.equals("POLICIA") || tipo.equals("PARTICULAR") || tipo.equals("TRANSPORTE")) {
            return true;
        }
        return false;
    }

    public int pedirNivelDeUrgencia() {
        entrada.nextLine();
        int urgencia = 0;
        do {
            cartel.pedirNivelUrgencia();
            if (entrada.hasNextInt()) {
                urgencia = entrada.nextInt();
                return urgencia;
            } else {
                cartel.pedirIngresarNumeroValido();
                entrada.nextLine();
            }
        } while (true);
    }

    public int pedirTiempoEspera() {
        entrada.nextLine();
        int tiempo = 0;
        do {
            cartel.pedirTiempoEspera();
            if (entrada.hasNextInt()) {
                tiempo = entrada.nextInt();
                return tiempo;
            } else {
                cartel.pedirIngresarNumeroValido();
                entrada.nextLine();
            }
        } while (true);
    }
}
