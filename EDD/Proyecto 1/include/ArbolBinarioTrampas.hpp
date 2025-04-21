#ifndef ARBOLBINARIOTRAMPAS_HPP
#define ARBOLBINARIOTRAMPAS_HPP
#include "../include/Trampa.hpp"
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <cstdlib>

class ArbolBinarioTrampas
{
private:
    struct Nodo {
        Trampa* trampa;
       
        int nivel;
        Nodo* izquierdo;
        Nodo* derecho;

        Nodo(Trampa* e, int n) : trampa(e), nivel(n), izquierdo(nullptr), derecho(nullptr) {}
    };
    int conta=0;
    Nodo* arbol = nullptr;

    void insertarNodoRecursivo(Nodo*& actual, Trampa* trampa);
    void mostrarArbolRecursivo(Nodo* actual, int contador);
    void mostrarTrampasRecursivo(Nodo* actual); 
public:
    Nodo* crearNodo(Trampa* trampa);
    void insertarNodo(Trampa* trampa);      
    void mostrarArbol();                       
    void mostrarTrampas();
    void setArbol(Nodo* nuevoArbol);
    Nodo* getArbol();
    void generarImagenDelArbol();
    void generarDotRecursivo(Nodo* actual, std::ofstream& archivo);
};

#endif
