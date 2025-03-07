#include "ListaDoble.h"

ListaDoble::ListaDoble() : cabeza(nullptr), cola(nullptr), esCircular(false) {}

ListaDoble::~ListaDoble() {
    if (!esCircular) {
        while (cabeza) {
            eliminarInicio();
        }
    }
}

void ListaDoble::insertarInicio(int valor) {
    Nodo* nuevo = new Nodo(valor);
    if (!cabeza) {
        cabeza = cola = nuevo;
    } else {
        nuevo->siguiente = cabeza;
        cabeza->anterior = nuevo;
        cabeza = nuevo;
    }
}

void ListaDoble::insertarFinal(int valor) {
    Nodo* nuevo = new Nodo(valor);
    if (!cola) {
        cabeza = cola = nuevo;
    } else {
        cola->siguiente = nuevo;
        nuevo->anterior = cola;
        cola = nuevo;
    }
}

void ListaDoble::eliminarInicio() {
    if (!cabeza) return;
    Nodo* temp = cabeza;
    cabeza = cabeza->siguiente;
    if (cabeza) {
        cabeza->anterior = nullptr;
    } else {
        cola = nullptr;
    }
    delete temp;
}

void ListaDoble::eliminarFinal() {
    if (!cola) return;
    Nodo* temp = cola;
    cola = cola->anterior;
    if (cola) {
        cola->siguiente = nullptr;
    } else {
        cabeza = nullptr;
    }
    delete temp;
}

bool ListaDoble::buscar(int valor) {
    Nodo* actual = cabeza;
    while (actual) {
        if (actual->dato == valor) {
            return true;
        }
        actual = actual->siguiente;
    }
    return false;
}

void ListaDoble::convertirEnCircular() {
    if (!cabeza || esCircular) return;
    cola->siguiente = cabeza;
    cabeza->anterior = cola;
    esCircular = true;
}

void ListaDoble::imprimirDesdeInicio() {
    if (!cabeza) return;
    Nodo* actual = cabeza;
    do {
        std::cout << actual->dato << " ";
        actual = actual->siguiente;
    } while (actual && actual != cabeza);
    std::cout << std::endl;
}

void ListaDoble::imprimirDesdeFinal() {
    if (!cola) return;
    Nodo* actual = cola;
    do {
        std::cout << actual->dato << " ";
        actual = actual->anterior;
    } while (actual && actual != cola);
    std::cout << std::endl;
}
