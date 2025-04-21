package Estructuras;

/**
 *
 * @author carlos
 */
public class Vehiculo {

    public Vehiculo(String tipo, String placa, int tiempoEspera, int nivelUrgencia) {
        this.tipo = tipo;
        this.tiempoEspera = tiempoEspera;
        this.nivelUrgencia = nivelUrgencia;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tiempoEspera
     */
    public int getTiempoEspera() {
        return tiempoEspera;
    }

    /**
     * @param tiempoEspera the tiempoEspera to set
     */
    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    /**
     * @return the nivelUrgencia
     */
    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    /**
     * @param nivelUrgencia the nivelUrgencia to set
     */
    public void setNivelUrgencia(int nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    private String tipo = "";
    private String placa = "";
    private int tiempoEspera = 0;
    private int nivelUrgencia = 0;
    private String destino;
    private String origen;
}
