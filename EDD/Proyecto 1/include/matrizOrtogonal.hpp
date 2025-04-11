
#ifndef MATRIZORTOGONAL_HPP
#define MATRIZORTOGONAL_HPP

#include <iostream> 
#include <any>
using namespace std;

class matrizOrtogonal
{

    public:
    struct Nodo {
        int fila, columna, capa;
        std::string valor;
        std::any any=nullptr;
        int simbolo=0;
        Nodo* derecha;
        Nodo* izquierda;
        Nodo* arriba;
        Nodo* abajo;
        Nodo* atras;
        Nodo* adelante;
    
        Nodo(int f, int c, int ca, string v);
    };
    

struct Encabezado {
    int indice;
    Nodo* acceso;
    Encabezado* siguiente;

    Encabezado(int idx);
};

Encabezado* filas = nullptr;
Encabezado* columnas = nullptr;

Nodo* BuscarNodo(int fila, int colum);
Encabezado* buscarOCrear(Encabezado*& lista, int indice);
void insertarNodo(int fila, int columna,int capa, string valor);
void mostrarMatriz();
};

#endif