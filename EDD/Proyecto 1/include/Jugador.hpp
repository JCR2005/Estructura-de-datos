#ifndef JUGADOR_HPP
#define JUGADOR_HPP
#include "../include/Carteles.hpp"
#include "../include/ColaCoordenadas.hpp"
#include "../include/EncabezadoCapas.hpp"
#include "../include/matrizOrtogonal.hpp"
#include <iostream>
#include <string>

class Jugador {
public:
    ColaCoordenadas* cola=new ColaCoordenadas();
    std::string simbolo;
    std::string nombre;
    int puntos=0;
    int vida;
    int posx;
    int movimiento=0;
    int posy;
    int posz;
    Carteles carteles;

    Jugador(int n, int px, int py, int pz, std::string no);

    int getVida();
    int getPuntos();
    int getMovimiento();
    std::string getNombre();
    void setNombre(std::string n);
    void setVida(int v);
    void setPuntos(int p);
    void setMovimiento(int m);
    std::string obtenerMovimiento(matrizOrtogonal::Nodo* nodo, std:: string direccion);
    matrizOrtogonal::Nodo* moverIzquierda(EncabezadoCapas& capas,int t);
    matrizOrtogonal::Nodo* moverDerecha(EncabezadoCapas& capas,int t); 
    matrizOrtogonal::Nodo* moverArriba(EncabezadoCapas& capas,int t); 
    matrizOrtogonal::Nodo* moverAbajo(EncabezadoCapas& capas,int t);
    matrizOrtogonal::Nodo* moverAtras(EncabezadoCapas& capas,int t);    
    matrizOrtogonal::Nodo* moverAdelante(EncabezadoCapas& capas,int t);
};

#endif
