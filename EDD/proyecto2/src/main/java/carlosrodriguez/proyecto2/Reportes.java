package carlosrodriguez.proyecto2;

import Carteles.Cartel;
import Estructuras.ArbolAVL;
import Estructuras.MatrizOrtogonal;
import Estructuras.Pila;
import Estructuras.TablaHash;
import Estructuras.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Reportes {

    Scanner entrada = new Scanner(System.in);
    Cartel cartel = new Cartel();
    TablaHash tablaHash;
    String[] placa;
    Pila pila;
    ArbolAVL arbolAVL;

    public Reportes(TablaHash tablaHash, String[] placa, Pila pila, ArbolAVL arbolAVL) {
        this.tablaHash = tablaHash;
        this.placa = placa;
        this.pila = pila;
        this.arbolAVL = arbolAVL;
    }

    public void verReportes() {
        int opcion = 0;
        do {

            cartel.menuReportes();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    verReportePorPromedioTiempoPorInterseccion();
                    entrada.nextLine();
                    entrada.nextLine();
                    break;

                case 2:

                    verReportePorPrioridad();
                    System.out.println("Precione enter para continuar");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;

                case 3:

                    verReportePorTiempoEsperado();
                    System.out.println("Precione enter para continuar");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;
                case 4:
                    verPlacasHasDuplicada();
                    System.out.println("Precione enter para continuar");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;
                case 5:
                    arbolAVL.imprimirArbol();
                    System.out.println("Precione enter para continuar");
                    entrada.nextLine();
                    entrada.nextLine();
                    break;
                case 6:
                    mostraUltimos20Movs();

                    break;

                case 7:

                    break;
                default:
                    throw new AssertionError();
            }

        } while (opcion != 7);

    }

    public void mostraUltimos20Movs() {

        for (int i = 0; i < 20; i++) {
            if (pila.desapilar() != null) {

                MatrizOrtogonal matrizOrtogonal = pila.desapilar();
                matrizOrtogonal.mostrarMatriz();
                System.out.println("");
                System.out.println("Precione enter para continuar");
                entrada.nextLine();
            }
        }

    }

    public void verPlacasHasDuplicada() {

        tablaHash.imprimirListas();
        System.out.println("");
        System.out.println("Precione enter para continuar");
        entrada.nextLine();

    }

    public void verReportePorPrioridad() {
        int n = placa.length;
        Vehiculo[] vehiculos = new Vehiculo[n];
        for (int i = 0; i < n; i++) {
            vehiculos[i] = tablaHash.obtenerVehiculo(placa[i]);
        }
        boolean cambiado = true;
        int inicio = 0;
        int fin = n - 1;
        while (cambiado) {
            cambiado = false;
            for (int i = inicio; i < fin; i++) {
                if (vehiculos[i].getNivelUrgencia() < vehiculos[i + 1].getNivelUrgencia()) {
                    Vehiculo temp = vehiculos[i];
                    vehiculos[i] = vehiculos[i + 1];
                    vehiculos[i + 1] = temp;
                    cambiado = true;
                }
            }
            if (!cambiado) {
                break;
            }
            cambiado = false;
            fin--;
            for (int i = fin - 1; i >= inicio; i--) {
                if (vehiculos[i].getNivelUrgencia() < vehiculos[i + 1].getNivelUrgencia()) {
                    Vehiculo temp = vehiculos[i];
                    vehiculos[i] = vehiculos[i + 1];
                    vehiculos[i + 1] = temp;
                    cambiado = true;
                }
            }
            inicio++;
        }
        System.out.println("REPORTE ORDENADO POR PRIORIDAD (Urgencia):");
        for (int i = 0; i < vehiculos.length; i++) {
            Vehiculo v = vehiculos[i];
            System.out.println("Tipo: " + v.getTipo() + " - Nivel Urgencia: " + v.getNivelUrgencia());
        }

    }

    public void verReportePorTiempoEsperado() {
        Vehiculo[] vehiculos = new Vehiculo[placa.length];
        for (int i = 0; i < placa.length; i++) {
            vehiculos[i] = tablaHash.obtenerVehiculo(placa[i]);
        }
        for (int i = 1; i < vehiculos.length; i++) {
            Vehiculo actual = vehiculos[i];
            int j = i - 1;

            while (j >= 0 && vehiculos[j].getTimeposperados() > actual.getTimeposperados()) {
                vehiculos[j + 1] = vehiculos[j];
                j--;
            }
            vehiculos[j + 1] = actual;
        }
        for (int i = 0; i < vehiculos.length; i++) {
            Vehiculo v = vehiculos[i];
            if (v != null) {
                System.out.println("Tipo: " + v.getTipo() + " - Tiempo Esperado: " + v.getTimeposperados());
            }
        }
    }

    public void verReportePorPromedioTiempoPorInterseccion() {
        Vehiculo[] vehiculos = new Vehiculo[placa.length];

        for (int i = 0; i < placa.length; i++) {
            vehiculos[i] = tablaHash.obtenerVehiculo(placa[i]);
        }

        quickSortPrPromedio(vehiculos, 0, vehiculos.length - 1);

        System.out.println("REPORTE POR PROMEDIO TIEMPO / INTERSECCIÓN:");
        for (Vehiculo v : vehiculos) {
            if (v != null) {
                int inters = v.getInterseccionesPasadas();
                int tiempo = v.getTimeposperados();
                if (inters > 0) {
                    double promedio = (double) tiempo / inters;
                    System.out.println("Tipo: " + v.getTipo() + " - Promedio Tiempo/Intersección: " + promedio);
                } else {
                    System.out.println("Tipo: " + v.getTipo() + " - SIN intersecciones pasadas");
                }
            }
        }
    }

    private void quickSortPrPromedio(Vehiculo[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int pivoteIdx = dividirPorPromedio(arr, inicio, fin);
            quickSortPrPromedio(arr, inicio, pivoteIdx - 1);
            quickSortPrPromedio(arr, pivoteIdx + 1, fin);
        }
    }

    private int dividirPorPromedio(Vehiculo[] arr, int inicio, int fin) {
        Vehiculo pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (compararVehiculos(arr[j], pivote)) {
                i++;
                Vehiculo temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Vehiculo temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    private boolean compararVehiculos(Vehiculo a, Vehiculo b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return true;
        }

        double promedioA = a.getInterseccionesPasadas() == 0 ? Double.MAX_VALUE
                : (double) a.getTimeposperados() / a.getInterseccionesPasadas();

        double promedioB = b.getInterseccionesPasadas() == 0 ? Double.MAX_VALUE
                : (double) b.getTimeposperados() / b.getInterseccionesPasadas();

        return promedioA <= promedioB;
    }

}
