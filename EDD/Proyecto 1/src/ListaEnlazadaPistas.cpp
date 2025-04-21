#include "../include/ListaEnlazadaPistas.hpp"

void ListaEnlazadaPistas::insertarPista(Pista* pista){

    ListaEnlazadaPistas::Nodo* nodo = new Nodo(pista);

    if (inicio==nullptr)
    {
        inicio=nodo;
    }else{
        ListaEnlazadaPistas::Nodo* actual=inicio;
        while (actual->siguiente!=nullptr)
        {
           actual=inicio->siguiente;
        }
          actual->siguiente=nodo;
        
    }
    

}

void ListaEnlazadaPistas::ImprimirLista(){

    if (inicio != nullptr) {
        Nodo* actual = inicio;
        while (actual != nullptr) {
            cout << "Pista: " << actual->pista->getSimbolo() <<"| distancia en filas al tesoro "<<actual->pista->getDistanciaFilas() <<"| distancia en columnas al tesoro "<<actual->pista->getDistanciaColumnas() <<"| distancia en capas al tesoro "<<actual->pista->getDistanciaCapas()   << endl;
            actual = actual->siguiente;
        }
    } else {
        cout << "La lista de pistas está vacía." << endl;
    }
}