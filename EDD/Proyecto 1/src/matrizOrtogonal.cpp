#include "../include/matrizOrtogonal.hpp"
#include <iostream>
using namespace std;

matrizOrtogonal::Nodo::Nodo(int f, int c, int ca, string v) {
    fila = f;
    columna = c;
    capa =ca;
    valor = v;
    derecha = izquierda = arriba = abajo =atras = adelante = nullptr;
}

matrizOrtogonal::Encabezado::Encabezado(int idx) {
    indice = idx;
    acceso = nullptr;
    siguiente = nullptr;
}

matrizOrtogonal::Encabezado* matrizOrtogonal::buscarOCrear(Encabezado*& lista, int indice) {
    Encabezado* actual = lista;
    Encabezado* anterior = nullptr;

    while (actual && actual->indice < indice) {
        anterior = actual;
        actual = actual->siguiente;
    }

    if (!actual || actual->indice != indice) {
        Encabezado* nuevo = new Encabezado(indice);
        nuevo->siguiente = actual;
        if (anterior) anterior->siguiente = nuevo;
        else lista = nuevo;
        return nuevo;
    }

    return actual;
}
void matrizOrtogonal::insertarNodo(int fila, int columna, int capa, std::string valor) {
    Encabezado* ef = buscarOCrear(filas, fila);
    Encabezado* ec = buscarOCrear(columnas, columna);

    Nodo* nuevo = new Nodo(fila, columna, capa, valor);

    Nodo* actualF = ef->acceso;
    Nodo* anteriorF = nullptr;
    while (actualF && actualF->columna < columna) {
        anteriorF = actualF;
        actualF = actualF->derecha;
    }
    nuevo->derecha = actualF;
    nuevo->izquierda = anteriorF;
    if (anteriorF) anteriorF->derecha = nuevo;
    else ef->acceso = nuevo;
    if (actualF) actualF->izquierda = nuevo;

    Nodo* actualC = ec->acceso;
    Nodo* anteriorC = nullptr;
    while (actualC && actualC->fila < fila) {
        anteriorC = actualC;
        actualC = actualC->atras;
    }
    nuevo->atras = actualC;
    nuevo->adelante = anteriorC;
    if (anteriorC) anteriorC->atras = nuevo;
    else ec->acceso = nuevo;
    if (actualC) actualC->adelante = nuevo;
}


void matrizOrtogonal::mostrarMatriz() {
    Encabezado* filaActual = filas;
    while (filaActual != nullptr) {
        Nodo* nodoActual = filaActual->acceso;
        cout<<endl;
        while (nodoActual != nullptr) {
            std::cout << nodoActual->valor << " ";
            nodoActual = nodoActual->derecha;
        }
        std::cout << std::endl;
        filaActual = filaActual->siguiente;
    }
}

matrizOrtogonal::Nodo* matrizOrtogonal::BuscarNodo(int fila, int colum) {
    Encabezado* filaActual = filas;
    while (filaActual != nullptr) {
        Nodo* nodoActual = filaActual->acceso;
        cout<<endl;
        while (nodoActual != nullptr) {
         
            if (nodoActual->fila==fila && nodoActual->columna==colum)
            {
               return nodoActual;
            }
            
            nodoActual = nodoActual->derecha;
        }
        std::cout << std::endl;
        filaActual = filaActual->siguiente;
    }
    return nullptr;
}