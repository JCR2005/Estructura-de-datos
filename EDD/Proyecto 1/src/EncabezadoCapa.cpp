#include "../include/EncabezadoCapas.hpp"
#include <iostream>
using namespace std;



EncabezadoCapas::EncabezadoCapa::EncabezadoCapa(int idx) {
    indice = idx;
    siguiente = nullptr;
}

EncabezadoCapas::EncabezadoCapa* EncabezadoCapas::buscarOCrear(EncabezadoCapa*& lista, int indice) {
    EncabezadoCapa* actual = lista;
    EncabezadoCapa* anterior = nullptr;

    while (actual && actual->indice < indice) {
        anterior = actual;
        actual = actual->siguiente;
    }

    if (!actual || actual->indice != indice) {
        EncabezadoCapa* nuevo = new EncabezadoCapa(indice);
        nuevo->siguiente = actual;
        if (anterior) anterior->siguiente = nuevo;
        else lista = nuevo;
        return nuevo;
    }

    return actual;
}