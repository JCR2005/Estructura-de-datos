package carlosrodriguez.proyecto2;

import Carteles.Cartel;
import Simulador.ConfiguracionSimulador;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Main {

    Cartel cartel = new Cartel();
    ConfiguracionSimulador configuracionSimulador = new ConfiguracionSimulador();

    public static void main(String[] args) {
        Main programa = new Main();
        programa.mostrarMenu();
    }

    public void mostrarMenu() {
        Scanner entrada = new Scanner(System.in);
        
        int opcion = 0;
        do {
            opcion = 0;
            cartel.menuPrincipal();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    configuracionSimulador.configuracionInicial();
                    break;
                case 3:
                    return;
                default:
                    throw new AssertionError();
            }

        } while (true);

    }

}
