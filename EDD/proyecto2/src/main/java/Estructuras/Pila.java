package Estructuras;

public class Pila {
    private NodoPila cima;
    private int tamanio;

    private class NodoPila {
        MatrizOrtogonal dato;
        NodoPila siguiente;

        NodoPila(MatrizOrtogonal dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Pila() {
        cima = null;
        tamanio = 0;
    }

    public void apilar(MatrizOrtogonal valor) {
        NodoPila nuevo = new NodoPila(valor);
        nuevo.siguiente = cima;
        cima = nuevo;
        tamanio++;
    }

    public MatrizOrtogonal desapilar() {
        if (estaVacia()) {
            return null;
        }
        MatrizOrtogonal dato = cima.dato;
        cima = cima.siguiente;
        tamanio--;
        return dato;
    }

    public MatrizOrtogonal verCima() {
        if (estaVacia()) {
            return null;
        }
        return cima.dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int obtenerTamanio() {
        return tamanio;
    }

    public void vaciar() {
        cima = null;
        tamanio = 0;
    }
}
