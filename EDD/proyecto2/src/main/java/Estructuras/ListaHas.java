package Estructuras;

/**
 *
 * @author carlos
 */
public class ListaHas {

    private Nodo cabeza;

    public ListaHas() {
        this.cabeza = null;
    }

    public void insertar(String clave, Vehiculo valor) {
        Nodo nuevo = new Nodo(clave, valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    public Object obtener(String clave) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void actualizar(String clave, Vehiculo valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                actual.valor = valor;
                return;
            }
            actual = actual.siguiente;
        }
        insertar(clave, valor);
    }

    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println("Clave: " + actual.clave + " → Valor: " + actual.valor.getTipo());
            actual = actual.siguiente;
        }
    }
}

class Nodo {

    String clave;
    Vehiculo valor;
    Nodo siguiente;

    public Nodo(String clave, Vehiculo valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
