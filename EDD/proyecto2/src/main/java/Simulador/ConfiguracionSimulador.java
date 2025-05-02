package Simulador;

import Carteles.Cartel;
import Estructuras.ArbolAVL;
import Estructuras.ColaAutos;
import Estructuras.MatrizOrtogonal;
import Estructuras.Pila;
import Estructuras.TablaHash;
import Estructuras.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class ConfiguracionSimulador {

    /**
     * @return the tablaHash
     */
    public TablaHash getTablaHash() {
        return tablaHash;
    }

    /**
     * @param tablaHash the tablaHash to set
     */
    public void setTablaHash(TablaHash tablaHash) {
        this.tablaHash = tablaHash;
    }

    /**
     * @return the placas
     */
    public String[] getPlacas() {
        return placas;
    }

    /**
     * @param placas the placas to set
     */
    public void setPlacas(String[] placas) {
        this.placas = placas;
    }

    Simulador simulador;
    MatrizOrtogonal matrizOrtogonal = new MatrizOrtogonal();
    private TablaHash tablaHash = new TablaHash();
    private String[] placas = new String[0];
    private Pila pila;

    int mayorFila = 10;
    int mayorCol = 10;
    int filas;
    private Scanner entrada = new Scanner(System.in);
    Cartel cartel = new Cartel();
    private ArbolAVL arbol = new ArbolAVL();

    public void configuracionInicial() {

        this.pedirVehiculos();
        this.crearciudad();

        this.colocarAutosEnColas();
        this.añadirAArbol();

        this.simulador = new Simulador(matrizOrtogonal, filas, mayorCol, getArbol(), getTablaHash());
        this.simulador.iniciarSimulador();
        this.pila = simulador.getPila();

    }

    public void colocarAutosEnColas() {
        for (int i = 0; i < getPlacas().length; i++) {
            System.out.println(getPlacas()[i]);
            System.out.println(getTablaHash().obtenerVehiculo(getPlacas()[i]).getSimbolo());
            Vehiculo vehiculo = getTablaHash().obtenerVehiculo(getPlacas()[i]);
            MatrizOrtogonal.Nodo nodo = obtenerNodo(vehiculo.getFilaorigen(), vehiculo.getColorigen());
            if (colocarAutosEsquinas(vehiculo, nodo)) {
            } else if (colocarAutosEnTs(vehiculo, nodo)) {
            } else if (colocarAutosEnInters(vehiculo, nodo)) {
            }
        }
    }

    public boolean colocarAutosEsquinas(Vehiculo vehiculo, MatrizOrtogonal.Nodo nodo) {

        if (nodo.getValor().equals(" ║  ╔  ═ ")) {
            nodo.getColaArriba().encolar(vehiculo);
            return true;
        } else if (nodo.getValor().equals(" ║  ╚  ═ ")) {
            nodo.getColaIzquierda().encolar(vehiculo);
            return true;
        } else if (nodo.getValor().equals(" ═  ╗  ║ ")) {
            if (nodo.getColaDerecha() != null) {
                nodo.getColaDerecha().encolar(vehiculo);
            } else {
                nodo.getColaArriba().encolar(vehiculo);
            }
            return true;
        } else if (nodo.getValor().equals("   ═╝  ║ ")) {
            if (nodo.getColaDerecha() != null) {
                nodo.getColaDerecha().encolar(vehiculo);
            } else {
                nodo.getColaAbajo().encolar(vehiculo);
            }
            return true;
        }
        return false;
    }

    public boolean colocarAutosEnTs(Vehiculo vehiculo, MatrizOrtogonal.Nodo nodo) {
        String valor = nodo.getValor();
        if (valor.equals(" ═  ╦  ═ ") || valor.equals(" ║  ╠    ") || valor.equals("    ╣  ║ ") || valor.equals(" ═  ╩  ═ ")) {
            if (nodo.getColaArriba() != null) {
                nodo.getColaArriba().encolar(vehiculo);
            } else if (nodo.getColaAbajo() != null) {
                nodo.getColaAbajo().encolar(vehiculo);
            } else if (nodo.getColaIzquierda() != null) {
                nodo.getColaIzquierda().encolar(vehiculo);
            } else if (nodo.getColaDerecha() != null) {
                nodo.getColaDerecha().encolar(vehiculo);
            }
            return true;
        }
        return false;
    }

    public boolean colocarAutosEnInters(Vehiculo vehiculo, MatrizOrtogonal.Nodo nodo) {
        String valor = nodo.getValor();
        if (valor.equals(" ═     ═ ")) {
            if (nodo.getColaArriba() != null) {
                nodo.getColaArriba().encolar(vehiculo);
            } else if (nodo.getColaAbajo() != null) {
                nodo.getColaAbajo().encolar(vehiculo);
            }
            return true;
        }
        return false;
    }

    public MatrizOrtogonal.Nodo obtenerNodo(int f, int c) {
        int cont = 0;
        int cont2 = 0;
        for (int i = 2; i < (filas); i += 6) {
            cont++;
            cont2 = 0;
            System.out.println("i : " + i);
            System.out.println("cont: " + cont);
            for (int j = 1; j < (mayorCol * 2); j += 2) {
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

    public void añadirAArbol() {
        for (int i = 2; i < (filas); i += 6) {
            for (int j = 1; j < (mayorCol * 2); j += 2) {
                matrizOrtogonal.calcularComplejidadInter(matrizOrtogonal.buscarNodo(i, j));
                getArbol().insertar(matrizOrtogonal.buscarNodo(i, j));

            }
        }
    }

    public void crearciudad() {
        int filuser = mayorFila + (mayorFila - 1);
        int coluser = mayorCol;
        int filas = (filuser * 3);
        while (filas % 2 == 0 || filas % 3 != 0) {
            filas++;
        }
        this.filas = filas;
        crearEncabezados(coluser, filas);
        crearAvenidas(coluser, filuser);
        crearTs(coluser, filas);
        crearEsquinas(coluser, filas);
        crearInteriosres(coluser, filas);

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
                    return;
                case 2:
                    leerArchivo();
                    return;
                default:
                    throw new AssertionError();
            }
        } while (true);

    }

    public void leerArchivo() {

        do {
            entrada.nextLine();
            cartel.pedirRutaArchivo();
            String ruta = entrada.nextLine();
            File archivo = new File(ruta);

            if (archivo.exists()) {
                try (Scanner lector = new Scanner(archivo)) {
                  
                    if (lector.hasNextLine()) {
                        lector.nextLine();
                    }

                    while (lector.hasNextLine()) {
                        String linea = lector.nextLine();
                        obtnerVehiculosArchivo(linea);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("No se pudo leer el archivo: " + e.getMessage());
                }
                break;
            } else {
                cartel.pedirIngresarDeNuevoRuta();
            }
        } while (true);
    }

    public void obtnerVehiculosArchivo(String linea) {
        String datos[] = linea.split(",");

        Vehiculo vehiculo = new Vehiculo(datos[0], datos[1], datos[2], datos[3], Integer.parseInt(datos[4].trim()), Integer.parseInt(datos[5].trim()));
        this.placas = agregarPlaca(placas, datos[1]);
        if (vehiculo.obtenerColunma(datos[3]) > mayorCol) {
            mayorCol = vehiculo.obtenerColunma(datos[3]);
        } else if (vehiculo.obtenerColunma(datos[2]) > mayorCol) {
            mayorCol = vehiculo.obtenerColunma(datos[2]);
        }
        if (vehiculo.obtenerFila(datos[3]) > mayorFila) {
            mayorFila = vehiculo.obtenerFila(datos[3]);
        } else if (vehiculo.obtenerFila(datos[2]) > mayorFila) {
            mayorFila = vehiculo.obtenerFila(datos[2]);
        }

        getTablaHash().agregarActualizarVehiculo(datos[1], vehiculo);

    }

    public static String[] agregarPlaca(String[] placas, String nuevaPlaca) {
        String[] nuevoArreglo = new String[placas.length + 1];

        for (int i = 0; i < placas.length; i++) {
            nuevoArreglo[i] = placas[i];
        }

        nuevoArreglo[placas.length] = nuevaPlaca;

        return nuevoArreglo;
    }

    public void pedirVehivuloManualmente() {
        boolean terminar = false;
        do {
            String placa = pedirPlaca();
            String tipo = pedirTipo();
            String origen = pedirOrigen();
            String destino = pedirDestino();
            int urgencia = pedirNivelDeUrgencia();
            int tiempoEspera = pedirTiempoEspera();

            Vehiculo vehiculo = new Vehiculo(tipo, placa, origen, destino, urgencia, tiempoEspera);
            validarTamaño(vehiculo);
            getTablaHash().agregarActualizarVehiculo(placa, vehiculo);
            boolean salir = false;
            do {
                cartel.pedirIngreserOtro();
                int opcion = entrada.nextInt();
                switch (opcion) {
                    case 1 ->
                        salir = true;
                    case 2 -> {
                        terminar = true;
                        salir = true;
                    }
                    default ->
                        System.out.println("ingrese una opcion valida");
                }
            } while (!salir);
        } while (!terminar);
        getTablaHash().imprimirListas();
    }

    public void validarTamaño(Vehiculo vehiculo) {

        if (vehiculo.getFilaorigen() > mayorFila) {
            mayorFila = vehiculo.getFilaorigen();
        }

        if (vehiculo.getFiladestino() > mayorFila) {
            mayorFila = vehiculo.getFiladestino();
        }
        if (vehiculo.getColorigen() > mayorCol) {
            mayorCol = vehiculo.getColorigen();
        }
        if (vehiculo.getColdestino() > mayorCol) {
            mayorCol = vehiculo.getColdestino();
        }

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

    public String pedirOrigen() {
        entrada.nextLine();
        String origen = "";
        do {

            cartel.pedirOrgen();
            origen = entrada.nextLine();
            return origen;
        } while (true);
    }

    public String pedirDestino() {
        entrada.nextLine();
        String destino = "";
        do {

            cartel.pedirDestino();
            destino = entrada.nextLine();
            return destino;
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
            }
        } while (true);
    }

    public void crearEncabezados(int cols, int filas) {
        crearVacias(filas, cols * 2);
        encabezadosColumnas(cols);
        encabezadosFilas(filas);
    }

    public void crearAvenidas(int cols, int filas) {

        crarAvenidas(cols, filas);
        crarAvenidasAbajo(cols, filas);
    }

    public void crearTs(int cols, int filas) {

        crarTInferiores(cols - 2, filas);
        crarTSuperiores(cols - 2);
    }

    public void crearEsquinas(int cols, int filas) {

        definirEsquina1();
        definirEsquina2((cols * 2) - 1);
        definirEsquina3(filas);
        definirEsquina4(filas, (cols * 2) - 1);

    }

    public void crearInteriosres(int cols, int filas) {

        crarIntersec(cols, filas);
        crearCalles(cols, filas);
        crearCrucesLateralesIzq(cols, filas);
        crearCrucesLateralesDer((cols * 2) - 1, filas);
    }

    public void crearVacias(int fil, int col) {
        for (int i = 0; i < fil + 1; i++) {
            for (int j = 0; j < col; j++) {
                matrizOrtogonal.insertarNodo(i, j, "         ", 0, 0);
            }
        }
    }

    public void encabezadosFilas(int fil) {
        int cont = 1;

        for (int i = 2; i < (fil); i += 6) {

            char letra = (char) (64 + cont);
            cont++;
            matrizOrtogonal.insertarNodo(i, 0, "    " + letra + "    ", 0, 0);

        }
    }

    public void encabezadosColumnas(int col) {
        int cont = 1;

        for (int i = 1; i < (col * 2); i += 2) {

            matrizOrtogonal.insertarNodo(0, i, "    " + cont + "    ", 0, 0);
            cont++;
        }
    }

    public void crarTSuperiores(int tam) {
        String[] partes = {"═════════", " ═  ╦  ═ ", "═╗     ╔═"};
        boolean CambioDireccion = false;
        for (int k = 3; k < (tam * 2) + 2; k += 2) {
            for (int j = 1; j < 4; j++) {
                if (j - 1 == 1) {
                    int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, k).getValor(), k);
                    int calle = obtenerCalle(matrizOrtogonal.buscarNodo(j, 0).getValor(), j);

                    matrizOrtogonal.insertarNodo(j, k, "" + partes[j - 1] + "", calle, ave);
                    crearColasTSuperiores(j, k, CambioDireccion);
                    CambioDireccion = !CambioDireccion;
                } else {
                    matrizOrtogonal.insertarNodo(j, k, "" + partes[j - 1] + "", 0, 0);
                }
            }
        }
    }

    public void crearColasTSuperiores(int i, int j, boolean CambioDireccion) {
        if (CambioDireccion) {
            matrizOrtogonal.buscarNodo(i, j).setColaArriba(new ColaAutos());
        }
        matrizOrtogonal.buscarNodo(i, j).setColaDerecha(new ColaAutos());
        matrizOrtogonal.buscarNodo(i, j).setColaIzquierda(new ColaAutos());
    }

    public void crarAvenidas(int tam, int col) {
        String via = " ║  ╨  ║ ";
        for (int i = 4; i < (col * 3); i += 6) {
            for (int k = 1; k < (tam * 2); k += 4) {
                for (int j = i; j < i + 3; j++) {
                    matrizOrtogonal.insertarNodo(j, k, "" + via + "", 0, 0);
                }
            }
        }
    }

    public void crearColasCrucesLateralesIzq(int i, int j) {
        matrizOrtogonal.buscarNodo(i, j).setColaArriba(new ColaAutos());
        matrizOrtogonal.buscarNodo(i, j).setColaIzquierda(new ColaAutos());
    }

    public void crearCrucesLateralesIzq(int tam, int col) {
        String[] partes = {" ║     ╔═", " ║  ╠    ", " ║     ╚═"};
        for (int i = 7; i < (col) - 2; i += 6) {

            for (int j = i; j < i + 3; j++) {
                if ((i + 2) - j == 1) {
                    int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, 1).getValor(), 1);
                    int calle = obtenerCalle(matrizOrtogonal.buscarNodo(j, 0).getValor(), j);

                    matrizOrtogonal.insertarNodo(j, 1, "" + partes[(i + 2) - j] + "", calle, ave);
                    crearColasCrucesLateralesIzq(j, 1);
                } else {
                    matrizOrtogonal.insertarNodo(j, 1, "" + partes[(i + 2) - j] + "", 0, 0);
                }
            }
        }
    }

    public void crearColasCrucesLateralesDer(int i, int j) {

        String direccion = matrizOrtogonal.buscarNodo(5, j).getValor();

        if (direccion.equals(" ║  ╨  ║ ")) {
            matrizOrtogonal.buscarNodo(i, j).setColaArriba(new ColaAutos());

        } else {
            matrizOrtogonal.buscarNodo(i, j).setColaAbajo(new ColaAutos());

        }

        matrizOrtogonal.buscarNodo(i, j).setColaDerecha(new ColaAutos());
    }

    public void crearCrucesLateralesDer(int tam, int col) {
        String[] partes = {"═╗     ║ ", "    ╣  ║ ", "═╝     ║ "};
        for (int i = 7; i < (col) - 2; i += 6) {

            for (int j = i; j < i + 3; j++) {
                if ((i + 2) - j == 1) {
                    int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, tam).getValor(), tam);
                    int calle = obtenerCalle(matrizOrtogonal.buscarNodo(j, 0).getValor(), j);
                    crearColasCrucesLateralesDer(j, tam);
                    matrizOrtogonal.insertarNodo(j, tam, "" + partes[(i + 2) - j] + "", calle, ave);
                } else {
                    matrizOrtogonal.insertarNodo(j, tam, "" + partes[(i + 2) - j] + "", 0, 0);
                }
            }
        }
    }

    public void crarIntersec(int tam, int col) {
        String[] partes = {"═╗     ╔═", " ═     ═ ", "═╝     ╚═"};
        for (int i = 7; i < (col) - 2; i += 6) {
            for (int k = 3; k < (tam * 2) - 3 + 2; k += 2) {
                for (int j = i; j < i + 3; j++) {
                    if ((i + 2) - j == 1) {
                        int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, k).getValor(), k);
                        int calle = obtenerCalle(matrizOrtogonal.buscarNodo(j, 0).getValor(), j);
                        matrizOrtogonal.insertarNodo(j, k, "" + partes[(i + 2) - j] + "", calle, ave);
                        crearColasIterscciones(j, k);
                    } else {
                        matrizOrtogonal.insertarNodo(j, k, "" + partes[(i + 2) - j] + "", 0, 0);
                    }
                }
            }
        }
    }

    public void crearColasIterscciones(int i, int j) {

        String direccion = matrizOrtogonal.buscarNodo(5, j).getValor();

        if (direccion.equals(" ║  ╨  ║ ")) {
            matrizOrtogonal.buscarNodo(i, j).setColaArriba(new ColaAutos());

        } else {
            matrizOrtogonal.buscarNodo(i, j).setColaAbajo(new ColaAutos());

        }

        matrizOrtogonal.buscarNodo(i, j).setColaDerecha(new ColaAutos());
        matrizOrtogonal.buscarNodo(i, j).setColaIzquierda(new ColaAutos());
    }

    public void crarAvenidasAbajo(int tam, int col) {
        String via = " ║  ╥  ║ ";
        for (int i = 4; i < (col * 3); i += 6) {
            for (int k = 3; k < (tam * 2); k += 4) {
                for (int j = i; j < i + 3; j++) {

                    matrizOrtogonal.insertarNodo(j, k, "" + via + "", 0, 0);
                }

            }
        }

    }

    public void crearCalles(int tam, int col) {
        String[] partes = {"═════════", " ═  ═  ═ ", "═════════"};
        for (int i = 1; i < (col); i += 6) {
            for (int k = 2; k < (tam * 2); k += 2) {
                for (int j = i; j < i + 3; j++) {

                    matrizOrtogonal.insertarNodo(j, k, "" + partes[(i + 2) - j] + "", 0, 0);
                }

            }
        }

    }

    public void crarTInferiores(int tam, int fil) {
        String[] partes = {"═════════", " ═  ╩  ═ ", "═╝     ╚═"};
        boolean CambioDireccion = false;
        for (int k = 3; k < (tam * 2) + 2; k += 2) {
            for (int j = (fil - 2); j < fil + 1; j++) {
                if (fil - j == 1) {
                    int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, k).getValor(), k);
                    int calle = obtenerCalle(matrizOrtogonal.buscarNodo(j, 0).getValor(), j);
                    matrizOrtogonal.insertarNodo(j, k, "" + partes[fil - j] + "", calle, ave);
                    crearColasTInferiores(j, k, CambioDireccion);
                    CambioDireccion = !CambioDireccion;
                } else {
                    matrizOrtogonal.insertarNodo(j, k, "" + partes[fil - j] + "", 0, 0);
                }

            }

        }

    }

    public void crearColasTInferiores(int i, int j, boolean CambioDireccion) {
        if (!CambioDireccion) {
            matrizOrtogonal.buscarNodo(i, j).setColaAbajo(new ColaAutos());
        }
        matrizOrtogonal.buscarNodo(i, j).setColaDerecha(new ColaAutos());
        matrizOrtogonal.buscarNodo(i, j).setColaIzquierda(new ColaAutos());
    }

    public void definirEsquina2(int col) {
        String[] partes = {"═══════╗ ", " ═  ╗  ║ ", "═╗     ║ "};

        for (int i = 1; i < 4; i++) {

            if (i - 1 == 1) {
                int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, col).getValor(), col);
                int calle = obtenerCalle(matrizOrtogonal.buscarNodo(i, 0).getValor(), i);
                matrizOrtogonal.insertarNodo(i, col, "" + partes[i - 1] + "", calle, ave);
                crearColaEsquina2(i, col);

            } else {
                matrizOrtogonal.insertarNodo(i, col, "" + partes[i - 1] + "", 0, 0);
            }

        }
    }

    public void definirEsquina3(int fil) {
        String[] partes = {" ╚═══════", " ║  ╚  ═ ", " ║     ╚═"};

        for (int i = (fil - 2); i < fil + 1; i++) {
            if (fil - i == 1) {
                int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, 1).getValor(), 1);
                int calle = obtenerCalle(matrizOrtogonal.buscarNodo(i, 0).getValor(), i);

                matrizOrtogonal.insertarNodo(i, 1, "" + partes[fil - i] + "", calle, ave);
                matrizOrtogonal.buscarNodo(i, 1).setColaIzquierda(new ColaAutos());
            } else {
                matrizOrtogonal.insertarNodo(i, 1, "" + partes[fil - i] + "", 0, 0);
            }

        }
    }

    public void definirEsquina4(int fil, int col) {
        String[] partes = {"═══════╝ ", "   ═╝  ║ ", "═╝     ║ "};

        for (int i = (fil - 2); i < fil + 1; i++) {
            if (fil - i == 1) {
                int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, col).getValor(), col);
                int calle = obtenerCalle(matrizOrtogonal.buscarNodo(i, 0).getValor(), i);
                matrizOrtogonal.insertarNodo(i, col, "" + partes[fil - i] + "", calle, ave);
                crearColaEsquina4(i, col);

            } else {
                matrizOrtogonal.insertarNodo(i, col, "" + partes[fil - i] + "", 0, 0);
            }

        }
    }

    public void crearColaEsquina2(int i, int j) {
        String direccion = matrizOrtogonal.buscarNodo(5, j).getValor();

        if (direccion.equals(" ║  ╨  ║ ")) {
            matrizOrtogonal.buscarNodo(i, j).setColaArriba(new ColaAutos());

        } else {
            matrizOrtogonal.buscarNodo(i, j).setColaDerecha(new ColaAutos());

        }
    }

    public void crearColaEsquina4(int i, int j) {
        String direccion = matrizOrtogonal.buscarNodo(5, j).getValor();

        if (direccion.equals(" ║  ╨  ║ ")) {
            matrizOrtogonal.buscarNodo(i, j).setColaDerecha(new ColaAutos());

        } else {
            matrizOrtogonal.buscarNodo(i, j).setColaAbajo(new ColaAutos());

        }
    }

    public void definirEsquina1() {
        String[] partes = {" ╔═══════", " ║  ╔  ═ ", " ║     ╔═"};
        for (int i = 1; i < 4; i++) {
            if (i - 1 == 1) {
                int ave = obtenerAvenida(matrizOrtogonal.buscarNodo(0, 1).getValor(), 1);
                int calle = obtenerCalle(matrizOrtogonal.buscarNodo(i, 0).getValor(), i);
                matrizOrtogonal.insertarNodo(i, 1, "" + partes[i - 1] + "", calle, ave);
                matrizOrtogonal.buscarNodo(i, 1).setColaArriba(new ColaAutos());
            } else {
                matrizOrtogonal.insertarNodo(i, 1, "" + partes[i - 1] + "", 0, 0);
            }
        }
    }

    public int obtenerCalle(String calle, int fila) {
        String letra = calle.replace("    ", "");
        char c = letra.charAt(0);
        return (c + 1) - 'A';
    }

    public int obtenerAvenida(String ave, int columna) {
        String letra = ave.replace("    ", "");
        return Integer.parseInt(letra);
    }

    /**
     * @return the arbol
     */
    public ArbolAVL getArbol() {
        return arbol;
    }

    /**
     * @param arbol the arbol to set
     */
    public void setArbol(ArbolAVL arbol) {
        this.arbol = arbol;
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
