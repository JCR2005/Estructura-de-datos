#ifndef CONFIGURACIONINICIALPARTIDA_HPP
#define CONFIGURACIONINICIALPARTIDA_HPP

#include "../include/reportePartida.hpp"
#include "../include/Carteles.hpp"
#include "../include/Pista.hpp"
#include "../include/Tesoro.hpp"
#include "../include/Jugador.hpp"
#include "../include/EncabezadoCapas.hpp"
#include "../include/matrizOrtogonal.hpp"
#include "../include/ partida.hpp"
#include "../include/Enemigo.hpp"
#include "../include/Trampa.hpp"
#include "../include/PosionesRecuperacion.hpp"
#include "../include/ReporteFinPartida.hpp"
#include <iostream> 
using namespace std;

class ConfiguracionInicialPartida
{
private:
    
    reportePartida* partidas= new reportePartida();
    std::string nombre;    
    int tamañoTablero;
    ReporteFinPartida* reporte=new ReporteFinPartida();

public:
    Jugador*& getJugador();
    Tesoro*& getTesoro();
    void eliminarPunteros();
    void pedirTamañoTablero();
    void pedirNombre();
    void configuracionInicial();
    void crearTablero(int tamaño);
    int calcularCantidadEneTram(int tamañoTablero);
    int calcularCantidadPosPis(int cantidad,int tamaño);
    void crearJugador(int tamaño);
    void crearEnemigos(int cantidaEnemigo,int tamaño);
    void crearTrampas(int cantidaEnemigo, int tamaño);
    void crearPociones(int cantidad, int tamaño);
    void crearPistas(int cantidad, int tamaño);
    void crearTesoro(int tamaño);
    void realizarCreaciones(int tamañoTablero);
    reportePartida* getPartidas();
    void setPartidas(reportePartida* p);
};

#endif