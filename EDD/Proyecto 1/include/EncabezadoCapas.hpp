#ifndef ENCABEZADOCAPA_HPP
#define ENCABEZADOCAPA_HPP
#include "../include/matrizOrtogonal.hpp"
#include <iostream> 
#include <any>
using namespace std;

class EncabezadoCapas
{

public:

    struct EncabezadoCapa {
        int indice;
        matrizOrtogonal matriz;
        EncabezadoCapa* siguiente;

        EncabezadoCapa(int idx);
    };

    EncabezadoCapa* capas = nullptr;
    EncabezadoCapa* buscarOCrear(EncabezadoCapa*& lista, int indice);
};





#endif