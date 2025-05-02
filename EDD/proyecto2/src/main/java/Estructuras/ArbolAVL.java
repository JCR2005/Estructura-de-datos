package Estructuras;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ArbolAVL {

    private class NodoAVL {
        MatrizOrtogonal.Nodo valor;
        int complejidad;
        int altura;
        NodoAVL izquierda, derecha;

        NodoAVL(MatrizOrtogonal.Nodo valor) {
            this.valor = valor;
            this.complejidad = valor.getConplejidad();
            this.altura = 1;
        }
    }

    private NodoAVL raiz;

    private int altura(NodoAVL n) {
        return n == null ? 0 : n.altura;
    }

    private int balance(NodoAVL n) {
        return n == null ? 0 : altura(n.izquierda) - altura(n.derecha);
    }

    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda;
        NodoAVL t2 = x.derecha;

        x.derecha = y;
        y.izquierda = t2;

        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;

        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha;
        NodoAVL t2 = y.izquierda;

        y.izquierda = x;
        x.derecha = t2;

        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;

        return y;
    }

    public void insertar(MatrizOrtogonal.Nodo valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoAVL insertarRec(NodoAVL nodo, MatrizOrtogonal.Nodo valor) {
        if (nodo == null) {
            return new NodoAVL(valor);
        }

        int comp = valor.getConplejidad();

        if (comp <= nodo.complejidad) {
            nodo.izquierda = insertarRec(nodo.izquierda, valor);
        } else {
            nodo.derecha = insertarRec(nodo.derecha, valor);
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int b = balance(nodo);

        if (b > 1 && comp <= nodo.izquierda.complejidad) {
            return rotarDerecha(nodo);
        }

        if (b < -1 && comp > nodo.derecha.complejidad) {
            return rotarIzquierda(nodo);
        }

        if (b > 1 && comp > nodo.izquierda.complejidad) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        if (b < -1 && comp <= nodo.derecha.complejidad) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public MatrizOrtogonal.Nodo buscarPorID(int id) {
        return buscarRec(raiz, id);
    }

    private MatrizOrtogonal.Nodo buscarRec(NodoAVL nodo, int id) {
        if (nodo == null) {
            return null;
        }
        if (nodo.valor.getId() == id) {
            return nodo.valor;
        }

        MatrizOrtogonal.Nodo izq = buscarRec(nodo.izquierda, id);
        if (izq != null) {
            return izq;
        }

        return buscarRec(nodo.derecha, id);
    }

    public void imprimirArbol() {
       

        try {
            generarImagen("arbol.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void imprimirRec(NodoAVL nodo, int nivel) {
        if (nodo != null) {
            imprimirRec(nodo.derecha, nivel + 1);
            System.out.print("        ".repeat(nivel));
            System.out.println("ID=" + nodo.valor.getId() + " (Complejidad=" + nodo.complejidad + ")");
            imprimirRec(nodo.izquierda, nivel + 1);
        }
    }

    public void generarImagen(String archivoSalida) throws IOException {
        int width = 2000;
        int height = 1600;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        dibujarArbol(g, raiz, width / 2, 60, width / 4);

        g.dispose();

        ImageIO.write(image, "png", new File(archivoSalida));
    }
private void dibujarArbol(Graphics2D g, NodoAVL nodo, int x, int y, int espacio) {
    if (nodo == null) {
        return;
    }

    int ovalWidth = 160;
    int ovalHeight = 60;

    // Dibujar óvalo
    g.setColor(Color.BLACK);
    g.fillOval(x - ovalWidth / 2, y - ovalHeight / 2, ovalWidth, ovalHeight);

    // Dibujar texto centrado
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 14));
    String texto = "Calle: " + nodo.valor.getCalle() + ", Av: " + nodo.valor.getAvenida() + ", Comp: " + nodo.complejidad;
    FontMetrics fm = g.getFontMetrics();
    int textoAncho = fm.stringWidth(texto);
    int textoAlto = fm.getAscent();
    g.drawString(texto, x - textoAncho / 2, y + textoAlto / 4);

    g.setColor(Color.BLACK);

    int verticalGap = 120; // Espacio vertical entre niveles

    // Dibujar rama izquierda
    if (nodo.izquierda != null) {
        g.drawLine(x, y + ovalHeight / 2, x - espacio, y + verticalGap - ovalHeight / 2);
        dibujarArbol(g, nodo.izquierda, x - espacio, y + verticalGap, espacio / 2);
    }

    // Dibujar rama derecha
    if (nodo.derecha != null) {
        g.drawLine(x, y + ovalHeight / 2, x + espacio, y + verticalGap - ovalHeight / 2);
        dibujarArbol(g, nodo.derecha, x + espacio, y + verticalGap, espacio / 2);
    }
}

    public void rebalancear() {
        raiz = rebalancearRec(raiz);
    }

    private NodoAVL rebalancearRec(NodoAVL nodo) {
        if (nodo == null) {
            return null;
        }

        nodo.izquierda = rebalancearRec(nodo.izquierda);
        nodo.derecha = rebalancearRec(nodo.derecha);

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = balance(nodo);

        if (balance > 1 && balance(nodo.izquierda) >= 0) {
            return rotarDerecha(nodo);
        }

        if (balance < -1 && balance(nodo.derecha) <= 0) {
            return rotarIzquierda(nodo);
        }

        if (balance > 1 && balance(nodo.izquierda) < 0) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        if (balance < -1 && balance(nodo.derecha) > 0) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }
}
