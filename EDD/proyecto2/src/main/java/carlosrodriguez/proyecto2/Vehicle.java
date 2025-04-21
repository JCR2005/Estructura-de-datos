package carlosrodriguez.proyecto2;

import java.io.*;
import java.util.*;

/**
 *
 * @author carlos
 */
// ============================
// Modelo de dominio
// ============================
// ============================
// Modelo de dominio
// ============================
public class Vehicle {

    public static void main(String[] args) {
        String[] claves = {
            "manzana", "banana", "pera", "pera", "uva", "melon",
            "kiwi", "fresa", "sandia", "coco", "papaya"
        };

        for (String clave : claves) {
            int hash = Math.abs(clave.hashCode() % 20);
            System.out.println("Clave: " + clave + " → Índice: " + hash);
        }

    }
}
