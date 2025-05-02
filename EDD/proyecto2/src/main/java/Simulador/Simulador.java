package Simulador;

import Carteles.Cartel;
import Estructuras.ArbolAVL;
import Estructuras.ColaAutos;
import Estructuras.MatrizOrtogonal;
import Estructuras.Pila;
import Estructuras.TablaHash;
import Estructuras.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Simulador {

    private Cartel cartel = new Cartel();

    private Scanner entrada = new Scanner(System.in);
    MatrizOrtogonal matrizOrtogonal;
    private Pila pila = new Pila();
    int filas = 0;
    int colimnas = 0;
    private ArbolAVL arbolAVL;
    TablaHash tab;

    public Simulador(MatrizOrtogonal matrizOrtogonal, int fil, int col, ArbolAVL arbol, TablaHash tab) {
        this.colimnas = col;
        this.filas = fil;
        this.arbolAVL = arbol;
        this.matrizOrtogonal = matrizOrtogonal;
        this.tab = tab;
    }

    public void iniciarSimulador() {
        int opcion = 0;
        do {
            cartel.limpiarConsola();
            matrizOrtogonal.mostrarMatriz();
            cartel.menuSimulacion();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1 ->
                    obtenerNodoIformacion();
                case 2 -> {
                    MatrizOrtogonal m = getPila().desapilar();
                    if (m == null) {
                        System.out.println(" No se han hecho movimientos nuevos");
                    } else {
                        matrizOrtogonal = m;
                    }
                }
                case 3 -> {
                    buscarAuto();

                }
                case 4 -> {
                    getPila().apilar(new MatrizOrtogonal(matrizOrtogonal));
                    moverAutos();
                    getArbolAVL().rebalancear();
                }
                case 5 -> {
                    cartel.limpiarConsola();
                     getArbolAVL().rebalancear();
                    getArbolAVL().imprimirArbol();
                    System.out.println("");
                    System.out.println("Presione enter para continuar");
                    entrada.nextLine();
                    entrada.nextLine();
                }
                case 6 -> {

                }
                default ->
                    System.out.println("                       ");
            }

        } while (opcion != 6);
    }

    public void buscarAuto() {

        entrada.nextLine();
        String placa = "";
        do {

            cartel.pedirPlacaBusqueda();
            placa = entrada.nextLine();
            if (placa.length() < 8) {
                cartel.pedirIngresarBienPlaca();
            } else {
                Vehiculo vehiculo = tab.obtenerVehiculo(placa);
                cartel.limpiarConsola();
                System.err.println(" Vehiculo: " + vehiculo.getSimbolo());
                System.out.println(" Tipo: " + vehiculo.getTipo());
                System.out.println(" Placa: " + vehiculo.getPlaca());
                System.out.println(" Prioridad: " + vehiculo.getNivelUrgencia());
                System.out.println(" Destino: " + vehiculo.getFiladestino() + "," + vehiculo.getColdestino());
                System.out.println(" Tiempo de Espera: " + vehiculo.getTiempoEspera());
                System.out.println("____________________________");
                System.out.println("Presione enter para continuar");
                entrada.nextLine();
                entrada.nextLine();
                return;
            }
        } while (true);
    }

    public void obtenerNodoIformacion() {
          entrada.nextLine();
        cartel.limpiarConsola();
        matrizOrtogonal.mostrarMatriz();
        cartel.menuSeleccionInterseecion();
        String coordenada = entrada.nextLine();
        MatrizOrtogonal.Nodo nodo = obtenerNodo(obtenerFila(coordenada), obtenerColumna(coordenada));
        interaccionInterseccion(nodo, coordenada);
    }

    public void interaccionInterseccion(MatrizOrtogonal.Nodo nodo, String cordenada) {
        int opcion;

        do {
            cartel.menuInteraccionInterseccion(nodo.getValor(), nodo.getAtras().getValor(), nodo.getAdelante().getValor(), cordenada, calcularComplejidadInter(nodo), nodo.isSemafor(), nodo.isVerde());
            cartel.menuInterseccion();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1 -> {
                    mostrarColas(nodo);
                }
                case 2 -> {
                    ponerSemafor(nodo);
                }
                case 4 -> {

                }
                default ->
                    System.out.println("                       ");
            }

        } while (opcion != 4);
    }

    public void ponerSemafor(MatrizOrtogonal.Nodo nodo) {

        nodo.setSemafor(true);

    }

    public void mostrarColas(MatrizOrtogonal.Nodo nodo) {
        int cont = 0;
        ColaAutos[] colas = new ColaAutos[4];
        String[] nombreColas = new String[4];
        if (nodo.getColaArriba() != null) {
            colas[cont] = nodo.getColaArriba();
            nombreColas[cont] = "Cola hacia arriba";
            cont++;

            System.out.println("1");
        }
        if (nodo.getColaAbajo() != null) {
            colas[cont] = nodo.getColaAbajo();
            nombreColas[cont] = "Cola hacia abajo";
            cont++;
            System.out.println("2");
        }
        if (nodo.getColaDerecha() != null) {
            colas[cont] = nodo.getColaDerecha();
            nombreColas[cont] = "Cola hacia derecha";
            cont++;
            System.out.println("3");
        }
        if (nodo.getColaIzquierda() != null) {
            colas[cont] = nodo.getColaIzquierda();
            nombreColas[cont] = "Cola hacia izquierda";
            System.out.println("4");
            cont++;
        }

        mostrarColasIntersecciones(colas, nombreColas, cont);
    }

    public int calcularComplejidadInter(MatrizOrtogonal.Nodo nodo) {
        int cont = 0;
        int complejidad = 0;
        if (nodo.getColaArriba() != null) {
            cont++;
            complejidad += nodo.getColaArriba().getComplejidad();
        }
        if (nodo.getColaAbajo() != null) {
            cont++;
            complejidad += nodo.getColaAbajo().getComplejidad();
        }
        if (nodo.getColaDerecha() != null) {
            cont++;
            complejidad += nodo.getColaDerecha().getComplejidad();
        }
        if (nodo.getColaIzquierda() != null) {
            cont++;
            complejidad += nodo.getColaIzquierda().getComplejidad();
        }
        if (cont != 0) {
            if ((complejidad / cont) == 0) {
                return 1;
            }
            return complejidad / cont;
        } else {

            return 1;
        }

    }

    public void mostrarColasIntersecciones(ColaAutos colaAutos[], String nombres[], int cont) {
        int opcion = 0;
        do {
            cartel.menuColas();
            for (int i = 0; i < cont; i++) {
                if (colaAutos[i] != null) {
                    System.out.println("                       " + (i + 1) + "." + nombres[i]);
                }

            }
            System.out.println("                       " + (cont + 1) + ".Regresar");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.println("Ingrese aqui: ");

            opcion = entrada.nextInt();

            if (opcion < cont + 1) {
                mostrarCola(colaAutos[opcion - 1], nombres[opcion - 1]);
            } else {

            }
        } while (opcion != cont + 1);

    }

    public void mostrarCola(ColaAutos cola, String nombre) {
        int opcion = 0;
        do {
            cartel.menuCola(nombre, cola.getComplejidad(), "");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    cola.ordenarBurbujaSenal();
                    cartel.mostrarVehiculos();
                    cola.mostrar();
                    cartel.mostrarVehiculosp2();
                    break;
                default:
                    System.out.println("                       ");
            }
        } while (opcion != 5);

    }

    public int obtenerFila(String nodo) {
        int fila = nodo.charAt(0);
        System.out.println("fila_  :" + ((fila + 1) - 'A'));
        return (fila + 1) - 'A';
    }

    public int obtenerColumna(String nodo) {
        String numeroStr = nodo.substring(1);
        System.out.println("cols_: " + numeroStr);
        return Integer.parseInt(numeroStr);
    }

    public MatrizOrtogonal.Nodo obtenerNodo(int f, int c) {

        int cont = 0;
        int cont2 = 0;
        for (int i = 2; i < (filas); i += 6) {
            cont++;
            cont2 = 0;
            System.out.println("i : " + i);
            System.out.println("cont: " + cont);
            for (int j = 1; j < (colimnas * 2); j += 2) {
                cont2++;
                System.out.println("j : " + j);
                System.out.println("cont2: " + cont2);
                if (cont == f && cont2 == c) {
                    return matrizOrtogonal.buscarNodo(i, j);
                }
            }

        }
        return null;
    }

    public void moverAutos() {

        for (int i = 2; i < (filas); i += 6) {

            for (int j = 1; j < (colimnas * 2); j += 2) {

                definirInter(matrizOrtogonal.buscarNodo(i, j));

            }

        }
    }

    public void definirInter(MatrizOrtogonal.Nodo nodo) {

        if (nodo.getValor().equals(" ║  ╔  ═ ")) {
            definirMovEsq1(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals(" ║  ╚  ═ ")) {
            definirMovEsq3(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals(" ═  ╗  ║ ")) {
            definirMovEsq2(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals("   ═╝  ║ ")) {
            definirMovEsq4(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals(" ═  ╦  ═ ")) {
            definirMovTsuperior(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals(" ═  ╩  ═ ")) {
            definirMovTInferior(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals(" ║  ╠    ")) {
            definirMovTIzq(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals("    ╣  ║ ")) {
            definirMovTDer(nodo.getFila(), nodo.getColumna());
        } else if (nodo.getValor().equals(" ═     ═ ")) {
            definirMovInterc(nodo.getFila(), nodo.getColumna());

        }
    }

    public void definirMovEsq1(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }

        for (int i = 0; i < cont; i++) {
            if (matrizOrtogonal.buscarNodo(f, c).getColaArriba().obtenerFrente() != null) {
                Vehiculo vehiculo = matrizOrtogonal.buscarNodo(f, c).getColaArriba().obtenerFrente();
                if (!(vehiculo.getFiladestino() == matrizOrtogonal.buscarNodo(f, c).getCalle() && vehiculo.getColdestino() == matrizOrtogonal.buscarNodo(f, c).getAvenida())) {
                    matrizOrtogonal.buscarNodo(f, c).getColaArriba().desencolar();
                    matrizOrtogonal.buscarNodo(f, c).getColaArriba().aumetarTiempo();
                    vehiculo.setTiempoEspera(0);
                    vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                    matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                    matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
                } else if (vehiculo != null) {
                    matrizOrtogonal.buscarNodo(f, c).getColaArriba().desencolar();
                    vehiculo.setTiempoEspera(0);

                }

            }
        }
    }

    public void definirMovEsq2(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }
        for (int i = 0; i < cont; i++) {
            if (matrizOrtogonal.buscarNodo(f, c).getColaArriba() != null) {
                if (matrizOrtogonal.buscarNodo(f, c).getColaArriba().obtenerFrente() != null) {
                    Vehiculo vehiculo = matrizOrtogonal.buscarNodo(f, c).getColaArriba().obtenerFrente();
                    if (!(vehiculo.getFiladestino() == matrizOrtogonal.buscarNodo(f, c).getCalle() && vehiculo.getColdestino() == matrizOrtogonal.buscarNodo(f, c).getAvenida())) {
                        matrizOrtogonal.buscarNodo(f, c).getColaArriba().desencolar();
                        matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                        matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
                    } else if (vehiculo != null) {
                        matrizOrtogonal.buscarNodo(f, c).getColaArriba().desencolar();
                    }
                }
            } else {
                if (matrizOrtogonal.buscarNodo(f, c).getColaDerecha().obtenerFrente() != null) {
                    Vehiculo vehiculo = matrizOrtogonal.buscarNodo(f, c).getColaDerecha().obtenerFrente();
                    if (!(vehiculo.getFiladestino() == matrizOrtogonal.buscarNodo(f, c).getCalle() && vehiculo.getColdestino() == matrizOrtogonal.buscarNodo(f, c).getAvenida())) {
                        matrizOrtogonal.buscarNodo(f, c).getColaDerecha().desencolar();
                        matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                        matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
                    } else if (vehiculo != null) {
                        matrizOrtogonal.buscarNodo(f, c).getColaDerecha().desencolar();
                    }
                }
            }
        }
    }

    public void definirMovEsq3(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 4) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }
        for (int i = 0; i < cont; i++) {
            if (matrizOrtogonal.buscarNodo(f, c).getColaIzquierda().obtenerFrente() != null) {
                Vehiculo vehiculo = matrizOrtogonal.buscarNodo(f, c).getColaIzquierda().obtenerFrente();
                if (!(vehiculo.getFiladestino() == matrizOrtogonal.buscarNodo(f, c).getCalle() && vehiculo.getColdestino() == matrizOrtogonal.buscarNodo(f, c).getAvenida())) {
                    matrizOrtogonal.buscarNodo(f, c).getColaIzquierda().desencolar();
                    matrizOrtogonal.buscarNodo(f, c).getColaIzquierda().aumetarTiempo();
                    vehiculo.setTiempoEspera(0);
                    vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                    matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                    matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
                } else if (vehiculo != null) {
                    matrizOrtogonal.buscarNodo(f, c).getColaIzquierda().desencolar();
                }

            }
        }
    }

    public void definirMovEsq4(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }
        for (int i = 0; i < cont; i++) {
            if (matrizOrtogonal.buscarNodo(f, c).getColaAbajo() != null) {
                if (matrizOrtogonal.buscarNodo(f, c).getColaAbajo().obtenerFrente() != null) {
                    Vehiculo vehiculo = matrizOrtogonal.buscarNodo(f, c).getColaAbajo().obtenerFrente();
                    if (!(vehiculo.getFiladestino() == matrizOrtogonal.buscarNodo(f, c).getCalle() && vehiculo.getColdestino() == matrizOrtogonal.buscarNodo(f, c).getAvenida())) {
                        matrizOrtogonal.buscarNodo(f, c).getColaAbajo().desencolar();
                        matrizOrtogonal.buscarNodo(f, c).getColaAbajo().aumetarTiempo();
                        vehiculo.setTiempoEspera(0);
                        vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                        matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                        matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
                    } else if (vehiculo != null) {
                        matrizOrtogonal.buscarNodo(f, c).getColaAbajo().desencolar();
                    }
                }
            } else {
                if (matrizOrtogonal.buscarNodo(f, c).getColaDerecha().obtenerFrente() != null) {
                    Vehiculo vehiculo = matrizOrtogonal.buscarNodo(f, c).getColaDerecha().obtenerFrente();
                    if (!(vehiculo.getFiladestino() == matrizOrtogonal.buscarNodo(f, c).getCalle() && vehiculo.getColdestino() == matrizOrtogonal.buscarNodo(f, c).getAvenida())) {
                        matrizOrtogonal.buscarNodo(f, c).getColaDerecha().desencolar();

                        matrizOrtogonal.buscarNodo(f, c).getColaDerecha().aumetarTiempo();
                        vehiculo.setTiempoEspera(0);
                        vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                        matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                        matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
                    } else if (vehiculo != null) {
                        matrizOrtogonal.buscarNodo(f, c).getColaDerecha().desencolar();
                    }
                }
            }
        }
    }

    public void definirMovTsuperior(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }

        for (int i = 0; i < cont; i++) {
            if (matrizOrtogonal.buscarNodo(f, c).getColaArriba() != null) {
                movColaTsuperior(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaArriba());
            }
            movColaTsuperior(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaDerecha());
            movColaTsuperior(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaIzquierda());
        }

    }

    public void movColaTsuperior(MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        Vehiculo vehiculo = cola.obtenerFrente();
        if (vehiculo != null && !(vehiculo.getFiladestino() == nodo.getCalle() && vehiculo.getColdestino() == nodo.getAvenida())) {
            int ca = nodo.getAvenida();
            int fa = nodo.getCalle();
            if (!cola.estaVacia()) {
                int cd = cola.obtenerFrente().getColdestino();
                int fd = cola.obtenerFrente().getFiladestino();

                if (ca > cd && fa == fd) {
                    Caso8Tsuperior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca > cd && fa < fd) {
                    Caso7Tsuperior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca == cd && fa < fd) {

                    Caso6Tsuperior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa < fd) {
                    Caso5Tsuperior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa == fd) {

                    Caso4Tsuperior(nodo.getFila(), nodo.getColumna(), nodo, cola);
                }
            }
        } else if (vehiculo != null) {
            cola.desencolar();
        }
    }

    public void Caso4Tsuperior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c + 2).getValor().equals(" ═  ╗  ║ ")) {
            if (cola.obtenerFrente() != null) {
                if (nodo.getColaArriba() != null) {
                    Vehiculo vehiculo = cola.obtenerFrente();
                    cola.desencolar();
                    cola.aumetarTiempo();
                    vehiculo.setTiempoEspera(0);
                    vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                    matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                    matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
                } else {
                    Vehiculo vehiculo = cola.obtenerFrente();
                    cola.desencolar();
                    cola.desencolar();
                    cola.aumetarTiempo();
                    vehiculo.setTiempoEspera(0);
                    vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                    matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                    matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
                }
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso8Tsuperior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c - 2).getValor().equals(" ║  ╔  ═ ")) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso7Tsuperior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c).getColaArriba() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso5Tsuperior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c).getColaArriba() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso6Tsuperior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c).getColaArriba() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
            }
        }
    }

    public void definirMovTInferior(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }
        for (int i = 0; i < cont; i++) {
            if (matrizOrtogonal.buscarNodo(f, c).getColaAbajo() != null) {
                movColaTinferior(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaAbajo());
            }
            movColaTinferior(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaDerecha());
            movColaTinferior(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaIzquierda());
        }

    }

    public void movColaTinferior(MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        Vehiculo vehiculo = cola.obtenerFrente();
        if (vehiculo != null && !(vehiculo.getFiladestino() == nodo.getCalle() && vehiculo.getColdestino() == nodo.getAvenida())) {
            int ca = nodo.getAvenida();
            int fa = nodo.getCalle();
            if (!cola.estaVacia()) {
                int cd = cola.obtenerFrente().getColdestino();
                int fd = cola.obtenerFrente().getFiladestino();

                if (ca > cd && fa == fd) {
                    Caso8Tinferior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca > cd && fa > fd) {
                    Caso1Tinferior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca == cd && fa > fd) {

                    Caso2Tinferior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa > fd) {
                    Caso3Tinferior(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa == fd) {

                    Caso4Tinferior(nodo.getFila(), nodo.getColumna(), nodo, cola);
                }
            }
        } else if (vehiculo != null) {
            cola.desencolar();
        }

    }

    public void Caso8Tinferior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
        }

    }

    public void Caso1Tinferior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c).getColaAbajo() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso3Tinferior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c).getColaAbajo() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso2Tinferior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c).getColaAbajo() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaDerecha().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);

                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso4Tinferior(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (matrizOrtogonal.buscarNodo(f, c + 2).getValor().equals("   ═╝  ║ ")) {
            if (cola.obtenerFrente() != null) {
                if (nodo.getColaAbajo() != null) {
                    Vehiculo vehiculo = cola.obtenerFrente();
                    cola.desencolar();
                    cola.desencolar();
                    cola.aumetarTiempo();
                    vehiculo.setTiempoEspera(0);
                    vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                    matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                    matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
                } else {
                    Vehiculo vehiculo = cola.obtenerFrente();
                    cola.desencolar();
                    cola.desencolar();
                    cola.aumetarTiempo();
                    vehiculo.setTiempoEspera(0);
                    vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                    matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                    matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
                }
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
            }
        }
    }

    public void definirMovTIzq(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }

        for (int i = 0; i < cont; i++) {

            movColaTIzq(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaArriba());
            movColaTIzq(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaIzquierda());
        }

    }

    public void movColaTIzq(MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        Vehiculo vehiculo = cola.obtenerFrente();
        if (vehiculo != null && !(vehiculo.getFiladestino() == nodo.getCalle() && vehiculo.getColdestino() == nodo.getAvenida())) {
            int ca = nodo.getAvenida();
            int fa = nodo.getCalle();
            if (!cola.estaVacia()) {
                int cd = cola.obtenerFrente().getColdestino();
                int fd = cola.obtenerFrente().getFiladestino();

                if (ca == cd && fa > fd) {
                    Caso2TIzq(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa < fd) {
                    Caso5TIzq(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca == cd && fa < fd) {

                    Caso6TIzq(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa > fd) {
                    Caso3TIzq(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca > cd && fa == fd) {

                    Caso4TIzq(nodo.getFila(), nodo.getColumna(), nodo, cola);
                }
            }
        } else if (vehiculo != null) {
            cola.desencolar();
        }

    }

    public void Caso2TIzq(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
        }

    }

    public void Caso5TIzq(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
        }
    }

    public void Caso3TIzq(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
        }

    }

    public void Caso6TIzq(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
        }

    }

    public void Caso4TIzq(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
        }

    }

    public void definirMovTDer(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }

        for (int i = 0; i < cont; i++) {

            if (matrizOrtogonal.buscarNodo(f, c).getColaAbajo() != null) {
                movColaTDer(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaAbajo());
            } else {
                movColaTDer(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaArriba());
            }
            movColaTDer(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaDerecha());
        }

    }

    public void movColaTDer(MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        Vehiculo vehiculo = cola.obtenerFrente();
        if (vehiculo != null && !(vehiculo.getFiladestino() == nodo.getCalle() && vehiculo.getColdestino() == nodo.getAvenida())) {
            int ca = nodo.getAvenida();
            int fa = nodo.getCalle();
            if (!cola.estaVacia()) {
                int cd = cola.obtenerFrente().getColdestino();
                int fd = cola.obtenerFrente().getFiladestino();

                if (ca == cd && fa > fd) {
                    Caso2TDer(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca > cd && fa > fd) {
                    Caso2TDer(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca == cd && fa < fd) {

                    Caso6TDer(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca > cd && fa < fd) {
                    Caso6TDer(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa == fd) {

                    Caso8TDer(nodo.getFila(), nodo.getColumna(), nodo, cola);
                }
            }
        } else if (vehiculo != null) {
            cola.desencolar();
        }
    }

    public void Caso2TDer(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        if (nodo.getColaArriba() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
            }
        }

    }

    public void Caso6TDer(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (nodo.getColaAbajo() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
            }
        } else {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
            }
        }

    }

    public void Caso8TDer(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
        }

    }

    public void definirMovInterc(int f, int c) {

        int cont = definirCuantosAutosPorColaLiberar(matrizOrtogonal.buscarNodo(f, c).getId());
        if (matrizOrtogonal.buscarNodo(f, c).isSemafor()) {
            cont = 4;
            int tiempo = matrizOrtogonal.buscarNodo(f, c).getTiempoSemaforo() + 1;
            matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(tiempo);

            if (tiempo >= 3) {
                matrizOrtogonal.buscarNodo(f, c).setVerde(!matrizOrtogonal.buscarNodo(f, c).isVerde());
                matrizOrtogonal.buscarNodo(f, c).setTiempoSemaforo(0);
            }
            if (!matrizOrtogonal.buscarNodo(f, c).isVerde()) {
                return;
            }
        }

        for (int i = 0; i < cont; i++) {

            if (matrizOrtogonal.buscarNodo(f, c).getColaArriba() != null) {
                movColaInter(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaArriba());
            } else {
                movColaInter(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaAbajo());
            }
            movColaInter(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaDerecha());
            movColaInter(matrizOrtogonal.buscarNodo(f, c), matrizOrtogonal.buscarNodo(f, c).getColaIzquierda());
        }

    }

    public void movColaInter(MatrizOrtogonal.Nodo nodo, ColaAutos cola) {
        Vehiculo vehiculo = cola.obtenerFrente();
        if (vehiculo != null && !(vehiculo.getFiladestino() == nodo.getCalle() && vehiculo.getColdestino() == nodo.getAvenida())) {

            int ca = nodo.getAvenida();
            int fa = nodo.getCalle();

            if (!cola.estaVacia()) {
                int cd = cola.obtenerFrente().getColdestino();
                int fd = cola.obtenerFrente().getFiladestino();

                if (ca > cd && fa > fd) {
                    Caso1Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca == cd && fa > fd) {
                    Caso1Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa > fd) {
                    Caso3Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa == fd) {
                    Caso4Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca < cd && fa < fd) {
                    Caso5Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca == cd && fa < fd) {
                    Caso5Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca > cd && fa < fd) {
                    Caso7Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                } else if (ca > cd && fa == fd) {
                    Caso8Inter(nodo.getFila(), nodo.getColumna(), nodo, cola);

                }
            }
        } else if (vehiculo != null) {
            cola.desencolar();
        }
    }

    public void Caso1Inter(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (nodo.getColaArriba() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
            }
        } else {

            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso3Inter(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (nodo.getColaArriba() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f - 6, c).getColaArriba().ordenarBurbujaSenal();
            }
        } else {

            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso4Inter(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();
        }
    }

    public void Caso5Inter(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (nodo.getColaAbajo() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();

            }
        } else {

            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c + 2).getColaDerecha().ordenarBurbujaSenal();

            }
        }
    }

    public void Caso7Inter(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (nodo.getColaAbajo() != null) {
            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f + 6, c).getColaAbajo().ordenarBurbujaSenal();
            }
        } else {

            if (cola.obtenerFrente() != null) {
                Vehiculo vehiculo = cola.obtenerFrente();
                cola.desencolar();
                cola.desencolar();
                cola.aumetarTiempo();
                vehiculo.setTiempoEspera(0);
                vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
                matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
            }
        }
    }

    public void Caso8Inter(int f, int c, MatrizOrtogonal.Nodo nodo, ColaAutos cola) {

        if (cola.obtenerFrente() != null) {
            Vehiculo vehiculo = cola.obtenerFrente();
            cola.desencolar();
            cola.desencolar();
            cola.aumetarTiempo();
            vehiculo.setTiempoEspera(0);
            vehiculo.setInterseccionesPasadas(vehiculo.getInterseccionesPasadas() + 1);
            matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().encolar(vehiculo);
            matrizOrtogonal.buscarNodo(f, c - 2).getColaIzquierda().ordenarBurbujaSenal();
        }
    }

    public Simulador() {
    }

    public int definirCuantosAutosPorColaLiberar(int id) {

        if (getArbolAVL().buscarPorID(id).getConplejidad() < 4 && getArbolAVL().buscarPorID(id).getConplejidad() > 0) {
            return 1;
        } else if (getArbolAVL().buscarPorID(id).getConplejidad() < 7) {
            return 2;
        } else if (getArbolAVL().buscarPorID(id).getConplejidad() >= 7) {
            return 3;
        }
        return 0;
    }

    /**
     * @return the arbolAVL
     */
    public ArbolAVL getArbolAVL() {
        return arbolAVL;
    }

    /**
     * @param arbolAVL the arbolAVL to set
     */
    public void setArbolAVL(ArbolAVL arbolAVL) {
        this.arbolAVL = arbolAVL;
    }

    /**
     * @return the pila
     */
    public Pila getPila() {
        return pila;
    }

    /**
     * @param pila the pila to set
     */
    public void setPila(Pila pila) {
        this.pila = pila;
    }
}
