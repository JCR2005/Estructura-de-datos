#ifndef ARBOLBINARIOENEMIGO_HPP
#define ARBOLBINARIOENEMIGO_HPP
#include "../include/Enemigo.hpp"
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <cstdlib>
class ArbolBinarioEnemigo
{
private:
    struct Nodo {
        Enemigo* enemigo;
        int nivel;
        Nodo* izquierdo;
        Nodo* derecho;

        Nodo(Enemigo* e, int n) : enemigo(e), nivel(n), izquierdo(nullptr), derecho(nullptr) {}
    };

    Nodo* arbol = nullptr;
    int conta=0;
    void insertarNodoRecursivo(Nodo*& actual, Enemigo* enemigo);
    void mostrarArbolRecursivo(Nodo* actual, int contador);
    void mostrarEnemigosRecursivo(Nodo* actual); 
public:
    Nodo* crearNodo(Enemigo* enemigo);
    void insertarNodo(Enemigo* enemigo);      
    void mostrarArbol();                       
    void mostrarEnemigos();
    void setArbol(Nodo* nuevoArbol);
    Nodo* getArbol();
    void generarImagenDelArbol();
    void generarDotRecursivo(Nodo* actual, std::ofstream& archivo);
};

#endif
