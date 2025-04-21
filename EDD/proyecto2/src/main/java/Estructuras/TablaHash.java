package Estructuras;

/**
 *
 * @author carlos
 */
public class TablaHash {

    ListaHas[] maps = new ListaHas[20];

    public TablaHash() {
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new ListaHas();
        }
    }

    public void agregarActualizarVehiculo(String id, Vehiculo vehiculo) {
        int hash = Math.abs(id.hashCode() % maps.length);
        System.out.println("__________________");
        System.out.println(hash);
        System.out.println("__________________");
        maps[hash].actualizar(id, vehiculo);
    }

    public void imprimirListas() {
        for (int i = 0; i < maps.length; i++) {
            System.out.println("__________________");
            maps[i].imprimir();
            System.out.println("__________________");
        }
    }

}

class ObjetoMap {

    public ObjetoMap(String id, Vehiculo vehiculo) {
        this.id = id;
        this.vehiculo = vehiculo;
    }

    private String id;
    private Vehiculo vehiculo;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

}
