#ifndef REPORTEFINPARTIDA_HPP
#define REPORTEFINPARTIDA_HPP
#include "../include/Tesoro.hpp"
#include "../include/ListaEnlazadaPistas.hpp"
#include "../include/ArbolBinarioEnemigo.hpp"
#include "../include/ArbolBinarioTrampas.hpp"
#include <iostream>
#include <string>
#include "../include/ColaCoordenadas.hpp"
#include "../include/reportePartida.hpp"
#include "../include/Carteles.hpp"
class ReporteFinPartida
{
private:
    reportePartida* partidas;
    ArbolBinarioEnemigo* arbolEnemigos;  
    ArbolBinarioTrampas* arobolTrampas;
    Carteles carteles;
    ListaEnlazadaPistas* pistas;
    int tiempoPartida=0;
    int puntaje=0;
    std::string nombreJugador;
    int catidadMovimientos;
    Tesoro* tesoro=nullptr;
    ColaCoordenadas* cola=new ColaCoordenadas();

public:
   
    ListaEnlazadaPistas* getPistas() ;
    int getTiempoPartida() ;
    int getPuntaje() ;
    std::string getNombreJugador() ;
    int getCatidadMovimientos() ;
    Tesoro* getTesoro() ;
    ColaCoordenadas* getCoodenadas() ;

    void setCoordenadad(ColaCoordenadas* coordenadas);
    void setArbolTrampas(ArbolBinarioTrampas* arbol);
    void setArbolEnemigo(ArbolBinarioEnemigo* arbol);
    void setPistas(ListaEnlazadaPistas* p);
    void setTiempoPartida(int tiempo);
    void setPuntaje(int p);
    void setNombreJugador( std::string nombre);
    void setCatidadMovimientos(int mov);
    void setTesoro(Tesoro* nodo);
    void generarReportes();
    void setPartidas(reportePartida* p);
    void agragarReportePartida();
};




#endif