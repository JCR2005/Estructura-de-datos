#ifndef LISTAENLAZADAPISTAS_HPP
#define LISTAENLAZADAPISTAS_HPP
#include "../include/Pista.hpp"
#include <iostream> 
#include <any>
using namespace std;

class ListaEnlazadaPistas
{

private:
    struct Nodo {
        Pista* pista;
        Nodo* siguiente;

        Nodo(Pista* p) : pista(p), siguiente(nullptr) {}
    };
    Nodo* inicio=nullptr;
  
      
public:

void insertarPista(Pista* pista);
void ImprimirLista();
};





#endif