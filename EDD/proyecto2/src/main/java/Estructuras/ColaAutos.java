package Estructuras;

/**
 *
 * @author carlos
 */
public class ColaAutos {

    /**
     * @return the complejidad
     */
    public int getComplejidad() {
        return complejidad;
    }

    /**
     * @param complejidad the complejidad to set
     */
    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }

    private class Nodo {

        Vehiculo valor;
        Nodo siguiente;

        Nodo(Vehiculo valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }
    private int complejidad = 0;
    private String id;
    private Nodo frente;
    private Nodo fin;

    public ColaAutos() {
        this.frente = null;
        this.fin = null;
        this.id = id;
    }

    public void encolar(Vehiculo valor) {
        Nodo nuevo = new Nodo(valor);

        if (estaVacia()) {
            frente = fin = nuevo;
            this.setComplejidad(this.getComplejidad() + 1);
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
            this.setComplejidad(this.getComplejidad() + 1);
        }
    }

    public void desencolar() {
        if (!estaVacia()) {
            frente = frente.siguiente;
            this.setComplejidad(this.getComplejidad() - 1);
            if (frente == null) {
                fin = null;
            }
        }
    }

    public Vehiculo obtenerFrente() {
        if (!estaVacia()) {
            return frente.valor;
        }
        return null;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        if (frente == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        int cont = 0;
        Nodo actual = frente;
        while (actual != null) {
            cont++;

            System.err.println(" Vehiculo No." + cont + " " + actual.valor.getSimbolo());
            System.out.println(" Tipo: " + actual.valor.getTipo());
            System.out.println(" Placa: " + actual.valor.getPlaca());
            System.out.println(" Prioridad: " + actual.valor.getNivelUrgencia());
            System.out.println(" Destino: " + actual.valor.getFiladestino() + "," + actual.valor.getColdestino());
            System.out.println(" Tiempo de Espera: " + actual.valor.getTiempoEspera());
            System.out.println("____________________________");
            actual = actual.siguiente;

        }

    }

    public void aumetarTiempo() {
        if (frente == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = frente;
        while (actual != null) {
            actual.valor.setTiempoEspera(actual.valor.getTiempoEspera() + 1);
            actual.valor.setTimeposperados(actual.valor.getTimeposperados()+ 1);

            actual = actual.siguiente;

        }

    }

    public void ordenarBurbujaSenal() {
        if (frente == null || frente.siguiente == null) {
            return;
        }

        boolean huboIntercambio;

        do {
            huboIntercambio = false;
            Nodo actual = frente;

            while (actual.siguiente != null) {
                Vehiculo v1 = actual.valor;
                Vehiculo v2 = actual.siguiente.valor;

                if (debeIntercambiar(v1, v2)) {

                    actual.valor = v2;
                    actual.siguiente.valor = v1;
                    huboIntercambio = true;
                }

                actual = actual.siguiente;
            }
        } while (huboIntercambio);
    }

    private boolean debeIntercambiar(Vehiculo v1, Vehiculo v2) {

        if (v1.getNivelUrgencia() < v2.getNivelUrgencia()) {
            return true;
        }

        if (v1.getNivelUrgencia() == v2.getNivelUrgencia()
                && v1.getTiempoEspera() < v2.getTiempoEspera()) {
            return true;
        }

        return false;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    public ColaAutos(ColaAutos original) {
        this.frente = null;
        this.fin = null;
        this.complejidad = 0;
        this.id = original.id;

        Nodo actual = original.frente;
        while (actual != null) {
            this.encolar(actual.valor); // MISMA referencia de Vehiculo
            actual = actual.siguiente;
        }
    }

}
