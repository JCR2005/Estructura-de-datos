package Estructuras;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author carlos
 */
public class Vehiculo {

    /**
     * @return the interseccionesPasadas
     */
    public int getInterseccionesPasadas() {
        return interseccionesPasadas;
    }

    /**
     * @param interseccionesPasadas the interseccionesPasadas to set
     */
    public void setInterseccionesPasadas(int interseccionesPasadas) {
        this.interseccionesPasadas = interseccionesPasadas;
    }

    /**
     * @return the Timeposperados
     */
    public int getTimeposperados() {
        return Timeposperados;
    }

    /**
     * @param Timeposperados the Timeposperados to set
     */
    public void setTimeposperados(int Timeposperados) {
        this.Timeposperados = Timeposperados;
    }

    public Vehiculo(String tipo, String placa, String origen, String destino, int nivelUrgencia, int tiemEspe) {
        this.tipo = tipo;
        this.tiempoEspera = tiempoEspera;
        this.filaorigen = obtenerFila(origen);
        this.colorigen = obtenerColunma(origen);
        this.coldestino = obtenerColunma(destino);
        this.filadestino = obtenerFila(destino);
        this.nivelUrgencia = nivelUrgencia;
        this.tiempoEspera = tiemEspe;
        this.placa = placa;
        this.pornersimbolo(tipo);
    }

    private String tipo = "";
    private String placa = "";
    private int tiempoEspera = 0;
    private int nivelUrgencia = 0;
    private int filadestino;
    private int coldestino;
    private int filaorigen;
    private int colorigen;
    private String simbolo = "";
    private int interseccionesPasadas= 1;
    private int Timeposperados;

    public int obtenerFila(String nodo) {
        int fila = nodo.charAt(0);

        return (fila + 1) - 'A';
    }

    public int obtenerColunma(String nodo) {

        String numeroStr = nodo.substring(1);
        return Integer.parseInt(numeroStr);
    }

    public void pornersimbolo(String tipo) {
        if (tipo.equals("AMBULANCIA")) {
            this.setSimbolo("🚑");
        } else if (tipo.equals("POLICIA")) {
            this.setSimbolo("🚓");
        } else if (tipo.equals("PARTICULAR")) {
            this.setSimbolo(elegirParticular());
        } else if (tipo.equals("TRANSPORTE")) {
            this.setSimbolo("🚌");
        }
    }

    public String elegirParticular() {
        Random random = new Random();
        int numero = 1;

        for (int i = 0; i < 20; i++) {
            numero = random.nextInt(5) + 1;
        }
        return switch (numero) {
            case 1 ->
                "🚗";
            case 2 ->
                "🚙";
            case 3 ->
                "🏍️";
            case 4 ->
                "🛵";
            default ->
                "🛻";
        };
    }

    /**
     * @return the filadestino
     */
    public int getFiladestino() {
        return filadestino;
    }

    /**
     * @return the coldestino
     */
    public int getColdestino() {
        return coldestino;
    }

    /**
     * @return the filaorigen
     */
    public int getFilaorigen() {
        return filaorigen;
    }

    /**
     * @return the colorigen
     */
    public int getColorigen() {
        return colorigen;
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

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

}
