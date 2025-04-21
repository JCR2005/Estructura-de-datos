package Estructuras;

/**
 *
 * @author carlos
 */
public class MatrizOrtogonal {

    public class Nodo {
        int fila, columna, capa;
        String valor;
        Object any = null;
        int simbolo = 0;

        Nodo derecha;
        Nodo izquierda;
        Nodo arriba;
        Nodo abajo;
        Nodo atras;
        Nodo adelante;

        public Nodo(int f, int c, int ca, String v) {
            this.fila = f;
            this.columna = c;
            this.capa = ca;
            this.valor = v;
            this.derecha = this.izquierda = this.arriba = this.abajo = this.atras = this.adelante = null;
        }
    }

    public class Encabezado {
        int indice;
        Nodo acceso;
        Encabezado siguiente;

        public Encabezado(int idx) {
            this.indice = idx;
            this.acceso = null;
            this.siguiente = null;
        }
    }

    private Encabezado filas = null;
    private Encabezado columnas = null;

    private Encabezado buscarOCrear(Encabezado lista, int indice, boolean esFila) {
        Encabezado actual = lista;
        Encabezado anterior = null;

        while (actual != null && actual.indice < indice) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null || actual.indice != indice) {
            Encabezado nuevo = new Encabezado(indice);
            nuevo.siguiente = actual;
            if (anterior != null) {
                anterior.siguiente = nuevo;
            } else {
                if (esFila) filas = nuevo;
                else columnas = nuevo;
            }
            return nuevo;
        }

        return actual;
    }

    public void insertarNodo(int fila, int columna, int capa, String valor) {
        Encabezado ef = buscarOCrear(filas, fila, true);
        Encabezado ec = buscarOCrear(columnas, columna, false);

        Nodo nuevo = new Nodo(fila, columna, capa, valor);

        Nodo actualF = ef.acceso;
        Nodo anteriorF = null;
        while (actualF != null && actualF.columna < columna) {
            anteriorF = actualF;
            actualF = actualF.derecha;
        }
        nuevo.derecha = actualF;
        nuevo.izquierda = anteriorF;
        if (anteriorF != null) anteriorF.derecha = nuevo;
        else ef.acceso = nuevo;
        if (actualF != null) actualF.izquierda = nuevo;

        Nodo actualC = ec.acceso;
        Nodo anteriorC = null;
        while (actualC != null && actualC.fila < fila) {
            anteriorC = actualC;
            actualC = actualC.atras;
        }
        nuevo.atras = actualC;
        nuevo.adelante = anteriorC;
        if (anteriorC != null) anteriorC.atras = nuevo;
        else ec.acceso = nuevo;
        if (actualC != null) actualC.adelante = nuevo;
    }

    public void mostrarMatriz() {
        Encabezado filaActual = filas;
        while (filaActual != null) {
            Nodo nodoActual = filaActual.acceso;
            System.out.println();
            while (nodoActual != null) {
                System.out.print(nodoActual.valor + " ");
                nodoActual = nodoActual.derecha;
            }
            System.out.println();
            filaActual = filaActual.siguiente;
        }
    }

    public Nodo buscarNodo(int fila, int colum) {
        Encabezado filaActual = filas;
        while (filaActual != null) {
            Nodo nodoActual = filaActual.acceso;
            System.out.println();
            while (nodoActual != null) {
                if (nodoActual.fila == fila && nodoActual.columna == colum) {
                    return nodoActual;
                }
                nodoActual = nodoActual.derecha;
            }
            System.out.println();
            filaActual = filaActual.siguiente;
        }
        return null;
    }
}
