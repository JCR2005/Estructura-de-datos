package Estructuras;

import Carteles.Cartel;

/**
 *
 * @author carlos
 */
public class MatrizOrtogonal {

    public static final String RESET = "\u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    Cartel cartel = new Cartel();

    public class Nodo {

        /**
         * @return the fila
         */
        public int getFila() {
            return fila;
        }

        /**
         * @param fila the fila to set
         */
        public void setFila(int fila) {
            this.fila = fila;
        }

        /**
         * @return the columna
         */
        public int getColumna() {
            return columna;
        }

        /**
         * @param columna the columna to set
         */
        public void setColumna(int columna) {
            this.columna = columna;
        }

        /**
         * @return the conplejidad
         */
        public int getConplejidad() {
            return conplejidad;
        }

        /**
         * @param conplejidad the conplejidad to set
         */
        public void setConplejidad(int conplejidad) {
            this.conplejidad = conplejidad;
        }

        /**
         * @return the derecha
         */
        public Nodo getDerecha() {
            return derecha;
        }

        /**
         * @param derecha the derecha to set
         */
        public void setDerecha(Nodo derecha) {
            this.derecha = derecha;
        }

        /**
         * @return the izquierda
         */
        public Nodo getIzquierda() {
            return izquierda;
        }

        /**
         * @param izquierda the izquierda to set
         */
        public void setIzquierda(Nodo izquierda) {
            this.izquierda = izquierda;
        }

        /**
         * @return the atras
         */
        public Nodo getAtras() {
            return atras;
        }

        /**
         * @param atras the atras to set
         */
        public void setAtras(Nodo atras) {
            this.atras = atras;
        }

        /**
         * @return the adelante
         */
        public Nodo getAdelante() {
            return adelante;
        }

        /**
         * @param adelante the adelante to set
         */
        public void setAdelante(Nodo adelante) {
            this.adelante = adelante;
        }

        /**
         * @return the colaIzquierda
         */
        public ColaAutos getColaIzquierda() {
            return colaIzquierda;
        }

        /**
         * @param colaIzquierda the colaIzquierda to set
         */
        public void setColaIzquierda(ColaAutos colaIzquierda) {
            this.colaIzquierda = colaIzquierda;
        }

        /**
         * @return the colaDerecha
         */
        public ColaAutos getColaDerecha() {
            return colaDerecha;
        }

        /**
         * @param colaDerecha the colaDerecha to set
         */
        public void setColaDerecha(ColaAutos colaDerecha) {
            this.colaDerecha = colaDerecha;
        }

        /**
         * @return the colaAbajo
         */
        public ColaAutos getColaAbajo() {
            return colaAbajo;
        }

        /**
         * @param colaAbajo the colaAbajo to set
         */
        public void setColaAbajo(ColaAutos colaAbajo) {
            this.colaAbajo = colaAbajo;
        }

        /**
         * @return the colaArriba
         */
        public ColaAutos getColaArriba() {
            return colaArriba;
        }

        /**
         * @param colaArriba the colaArriba to set
         */
        public void setColaArriba(ColaAutos colaArriba) {
            this.colaArriba = colaArriba;
        }

        /**
         * @return the calle
         */
        public int getCalle() {
            return calle;
        }

        /**
         * @return the avenida
         */
        public int getAvenida() {
            return avenida;
        }

        /**
         * @return the valor
         */
        public String getValor() {
            return valor;
        }

        /**
         * @param valor the valor to set
         */
        public void setValor(String valor) {
            this.valor = valor;
        }

        /**
         * @return the semafor
         */
        public boolean isSemafor() {
            return semafor;
        }

        /**
         * @param semafor the semafor to set
         */
        public void setSemafor(boolean semafor) {
            this.semafor = semafor;
        }

        /**
         * @return the tiempoSemaforo
         */
        public int getTiempoSemaforo() {
            return tiempoSemaforo;
        }

        /**
         * @param tiempoSemaforo the tiempoSemaforo to set
         */
        public void setTiempoSemaforo(int tiempoSemaforo) {
            this.tiempoSemaforo = tiempoSemaforo;
        }

        /**
         * @return the verde
         */
        public boolean isVerde() {
            return verde;
        }

        /**
         * @param verde the verde to set
         */
        public void setVerde(boolean verde) {
            this.verde = verde;
        }
        private int calle;
        private int avenida;
        private int id;
        private int fila;
        private int columna;
        private String valor;
        private Nodo derecha;
        private Nodo izquierda;
        private Nodo atras;
        private Nodo adelante;
        private int conplejidad = 0;
        private ColaAutos colaIzquierda;
        private ColaAutos colaDerecha;
        private ColaAutos colaAbajo;
        private ColaAutos colaArriba;
        private boolean semafor = false;
        private boolean verde = false;
        private int tiempoSemaforo = 0;

        public Nodo() {
        }

        public Nodo(int f, int c, String v, int ca, int av) {

            this.fila = f;
            this.calle = ca;
            this.avenida = av;
            this.id = Integer.parseInt(f + "" + c);
            this.columna = c;
            this.valor = v;
            this.derecha = this.izquierda = this.atras = this.adelante = null;
        }

        public Nodo(int s, int w) {

            this.id = s;
            this.conplejidad = w;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
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
                if (esFila) {
                    filas = nuevo;
                } else {
                    columnas = nuevo;
                }
            }
            return nuevo;
        }

        return actual;
    }

    public void insertarNodo(int fila, int columna, String valor, int ca, int av) {
        Encabezado ef = buscarOCrear(filas, fila, true);
        Encabezado ec = buscarOCrear(columnas, columna, false);

        Nodo actualF = ef.acceso;

        while (actualF != null) {
            if (actualF.getColumna() == columna && actualF.getFila() == fila) {
                actualF.setValor(valor);
                actualF.calle = ca;
                actualF.avenida = av;
                return;
            }

            if (actualF.getColumna() > columna) {
                break;
            }
            actualF = actualF.getDerecha();
        }

        Nodo nuevo = new Nodo(fila, columna, valor, ca, av);

        actualF = ef.acceso;
        Nodo anteriorF = null;
        while (actualF != null && actualF.getColumna() < columna) {
            anteriorF = actualF;
            actualF = actualF.getDerecha();
        }
        nuevo.setDerecha(actualF);
        nuevo.setIzquierda(anteriorF);
        if (anteriorF != null) {
            anteriorF.setDerecha(nuevo);
        } else {
            ef.acceso = nuevo;
        }
        if (actualF != null) {
            actualF.setIzquierda(nuevo);
        }

        Nodo actualC = ec.acceso;
        Nodo anteriorC = null;
        while (actualC != null && actualC.getFila() < fila) {
            anteriorC = actualC;
            actualC = actualC.getAtras();
        }
        nuevo.setAtras(actualC);
        nuevo.setAdelante(anteriorC);
        if (anteriorC != null) {
            anteriorC.setAtras(nuevo);
        } else {
            ec.acceso = nuevo;
        }
        if (actualC != null) {
            actualC.setAdelante(nuevo);
        }
    }

    public void mostrarMatriz() {
        Encabezado filaActual = filas;
        while (filaActual != null) {
            Nodo nodoActual = filaActual.acceso;
            System.out.println();
            while (nodoActual != null) {
                String valor = nodoActual.getValor();
                String parteIzq = valor.substring(0, 3);
                String parteCentral = valor.substring(3, 6);
                String parteDer = valor.substring(6, 8);

                System.out.print("\u001B[100m\u001B[97m" + parteIzq + RESET + calcularComplejidadInter(nodoActual) + parteCentral + RESET + "\u001B[100m\u001B[97m" + parteDer + RESET);

                nodoActual = nodoActual.getDerecha();
            }
            filaActual = filaActual.siguiente;
        }
    }

    public String calcularComplejidadInter(MatrizOrtogonal.Nodo nodo) {
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
            if ((complejidad / cont) >= 1) {
                nodo.setConplejidad(complejidad / cont);
                return cartel.colocarColorComplejidadFondo(complejidad / cont);
            } else {
                if (complejidad != 0) {
                    nodo.setConplejidad(1);
                    return cartel.colocarColorComplejidadFondo(1);
                }

            }

        }

        return "\u001B[100m\u001B[97m";

    }

    public MatrizOrtogonal() {
    }

    public MatrizOrtogonal(MatrizOrtogonal original) {
        Encabezado filaActual = original.filas;
        while (filaActual != null) {
            Nodo nodoOriginal = filaActual.acceso;
            while (nodoOriginal != null) {
                Nodo nuevoNodo = new Nodo(
                        nodoOriginal.getFila(),
                        nodoOriginal.getColumna(),
                        nodoOriginal.getValor(),
                        nodoOriginal.getCalle(),
                        nodoOriginal.getAvenida()
                );

                nuevoNodo.setConplejidad(nodoOriginal.getConplejidad());
                nuevoNodo.setSemafor(nodoOriginal.isSemafor());
                nuevoNodo.setVerde(nodoOriginal.isVerde());
                nuevoNodo.setTiempoSemaforo(nodoOriginal.getTiempoSemaforo());

                if (nodoOriginal.getColaArriba() != null) {
                    nuevoNodo.setColaArriba(new ColaAutos(nodoOriginal.getColaArriba()));
                }

                if (nodoOriginal.getColaAbajo() != null) {
                    nuevoNodo.setColaAbajo(new ColaAutos(nodoOriginal.getColaAbajo()));
                }

                if (nodoOriginal.getColaDerecha() != null) {
                    nuevoNodo.setColaDerecha(new ColaAutos(nodoOriginal.getColaDerecha()));
                }

                if (nodoOriginal.getColaIzquierda() != null) {
                    nuevoNodo.setColaIzquierda(new ColaAutos(nodoOriginal.getColaIzquierda()));
                }

                this.insertarNodo(
                        nuevoNodo.getFila(),
                        nuevoNodo.getColumna(),
                        nuevoNodo.getValor(),
                        nuevoNodo.getCalle(),
                        nuevoNodo.getAvenida()
                );

                Nodo nodoInsertado = this.buscarNodo(nuevoNodo.getFila(), nuevoNodo.getColumna());
                nodoInsertado.setConplejidad(nuevoNodo.getConplejidad());
                nodoInsertado.setSemafor(nuevoNodo.isSemafor());
                nodoInsertado.setVerde(nuevoNodo.isVerde());
                nodoInsertado.setTiempoSemaforo(nuevoNodo.getTiempoSemaforo());
                nodoInsertado.setColaArriba(nuevoNodo.getColaArriba());
                nodoInsertado.setColaAbajo(nuevoNodo.getColaAbajo());
                nodoInsertado.setColaDerecha(nuevoNodo.getColaDerecha());
                nodoInsertado.setColaIzquierda(nuevoNodo.getColaIzquierda());

                nodoOriginal = nodoOriginal.getDerecha();
            }
            filaActual = filaActual.siguiente;
        }
    }

    public Nodo buscarNodo(int fila, int colum) {
        Encabezado filaActual = filas;
        while (filaActual != null) {
            Nodo nodoActual = filaActual.acceso;
            System.out.println();
            while (nodoActual != null) {
                if (nodoActual.getFila() == fila && nodoActual.getColumna() == colum) {
                    return nodoActual;
                }
                nodoActual = nodoActual.getDerecha();
            }
            System.out.println();
            filaActual = filaActual.siguiente;
        }
        return null;
    }
}
