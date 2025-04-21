
package Estructuras;

/**
 *
 * @author carlos
 */
public class Cola {
    
    private class Nodo {
        Object valor;
        Nodo siguiente;

        Nodo(Object valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(Object valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public void desencolar() {
        if (!estaVacia()) {
            frente = frente.siguiente;
            if (frente == null) {
                fin = null;
            }
        }
    }

    public Object obtenerFrente() {
        if (!estaVacia()) {
            return frente.valor;
        }
        return null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        Nodo actual = frente;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }
}
