#include "../include/reportePartida.hpp"

void reportePartida::insertarPista(int p, int t, int m, std::string n) {
    Nodo* nodo = new Nodo(p, t, m, n);

    if (inicio == nullptr || nodo->puntos > inicio->puntos) {
        nodo->siguiente = inicio;
        inicio = nodo;
    } else {
        Nodo* actual = inicio;

        while (actual->siguiente != nullptr && nodo->puntos <= actual->siguiente->puntos) {
            actual = actual->siguiente;
        }

        nodo->siguiente = actual->siguiente;
        actual->siguiente = nodo;
    }
}


void reportePartida::ImprimirLista(){
    int cont=0;
    if (inicio != nullptr) {
        Nodo* actual = inicio;
        while (actual != nullptr) {
            cont++;
            if (cont>=10) {
                cout << "No."<<cont <<" | nombre: "<<actual->nombre <<" |puntos: " <<actual->puntos  <<" |timepo de partida: " <<actual->tiempo  <<" segundos |cantidad de movimeintos: " <<actual->movimeintos   << endl;
            }else{
                cout << "No.0"<<cont <<" | nombre: "<<actual->nombre <<" |puntos: " <<actual->puntos  <<" |timepo de partida: " <<actual->tiempo  <<" segundos |cantidad de movimeintos: " <<actual->movimeintos   << endl;
            }
           actual = actual->siguiente;
        }
    } else {
        cout << "No hay ningun registro" << endl;
    }
}