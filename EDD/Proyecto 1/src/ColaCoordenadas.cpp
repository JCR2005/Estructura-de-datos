#include "../include/ColaCoordenadas.hpp"
using namespace std;

ColaCoordenadas::ColaCoordenadas() : frente(nullptr), final(nullptr) {}

ColaCoordenadas::~ColaCoordenadas() {
    while (!estaVacia()) {
        desencolar();
    }
}

void ColaCoordenadas::encolar(std::string valor) {
    Nodo* nuevo = new Nodo(valor);
    if (estaVacia()) {
        frente = final = nuevo;
    } else {
        final->siguiente = nuevo;
        final = nuevo;
    }
}

void ColaCoordenadas::desencolar() {
    if (!estaVacia()) {
        Nodo* temp = frente;
        frente = frente->siguiente;
        delete temp;

        if (frente == nullptr) {
            final = nullptr; 
        }
    }
}

string ColaCoordenadas::obtenerFrente()  {
    if (!estaVacia()) {
        return frente->valor;
    } else {
        return "";
    }
}

bool ColaCoordenadas::estaVacia()  {
    return frente == nullptr;
}

void ColaCoordenadas::mostrar()  {
    Nodo* actual = frente;
    while (actual != nullptr) {
        cout << actual->valor <<endl;
        actual = actual->siguiente;
    }
}
