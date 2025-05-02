package carlosrodriguez.proyecto2;

import Carteles.Cartel;
import Estructuras.ArbolAVL;
import Estructuras.MatrizOrtogonal;
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

        MatrizOrtogonal matriz = new MatrizOrtogonal();

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
                case 1 ->
                    configuracionSimulador.configuracionInicial();
                case 2 -> {
                    Reportes reportes = new Reportes(configuracionSimulador.getTablaHash(), configuracionSimulador.getPlacas(), configuracionSimulador.getPila(), configuracionSimulador.getArbol());
                    reportes.verReportes();
                    return;
                }
                case 3 -> {
                    return;
                }
                default ->
                    System.out.println("");
            }

        } while (true);

    }

}
