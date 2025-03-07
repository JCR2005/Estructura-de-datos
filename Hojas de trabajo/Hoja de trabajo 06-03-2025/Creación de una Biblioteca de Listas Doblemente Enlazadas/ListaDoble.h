#ifndef LISTA_DOBLE_H
#define LISTA_DOBLE_H

#include <iostream>

class Nodo {
public:
    int dato;
    Nodo* siguiente;
    Nodo* anterior;
    Nodo(int valor) : dato(valor), siguiente(nullptr), anterior(nullptr) {}
};

class ListaDoble {
private:
    Nodo* cabeza;
    Nodo* cola;
    bool esCircular;

public:
    ListaDoble();
    ~ListaDoble();
    void insertarInicio(int valor);
    void insertarFinal(int valor);
    void eliminarInicio();
    void eliminarFinal();
    bool buscar(int valor);
    void convertirEnCircular();
    void imprimirDesdeInicio();
    void imprimirDesdeFinal();
};

#endif
