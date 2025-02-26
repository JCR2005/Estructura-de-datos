#include "../include/ColaCircular.hpp"
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

ColaCircular::ColaCircular(int* ids, int numJugadores) {
    capacidad = numJugadores;
    cola = new int[capacidad];
    frente = 0;
    final = capacidad - 1;
    elementos = capacidad;

    for (int i = 0; i < capacidad; i++) {
        cola[i] = ids[i];
    }

    mezclarCola(); 
}
ColaCircular::ColaCircular() {

}
ColaCircular::~ColaCircular() {
    delete[] cola;
}

void ColaCircular::mezclarCola() {
    srand(time(0));
    for (int i = capacidad - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        swap(cola[i], cola[j]);
    }
}

void ColaCircular::encolar(int id) {
    final = (final + 1) % capacidad;
    cola[final] = id;
    elementos++;
}

int ColaCircular::desencolar() {
    if (elementos == 0) {
        cout << "se vacio la cosa" << endl;
        return -1;
    }

    int idJugador = cola[frente];  
    frente = (frente + 1) % capacidad;  
    elementos--;
    return idJugador;
}

bool ColaCircular::estaVacia() {
    return elementos == 0;
}
