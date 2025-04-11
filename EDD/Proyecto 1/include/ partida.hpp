#ifndef PARTIDA_HPP
#define PARTIDA_HPP 

#include "../include/ArbolBinarioTrampas.hpp"
#include "../include/ArbolBinarioEnemigo.hpp"
#include "../include/EncabezadoCapas.hpp"
#include "../include/Jugador.hpp"
#include "../include/Carteles.hpp"
#include "../include/matrizOrtogonal.hpp"
#include "../include/reportePartida.hpp"
#include "../include/Trampa.hpp"
#include "../include/Enemigo.hpp"
#include "../include/Pista.hpp"
#include "../include/Tesoro.hpp"
#include "../include/PosionesRecuperacion.hpp"
#include "../include/ListaEnlazadaPistas.hpp"

#include "../include/ReporteFinPartida.hpp"

#include <iostream> 
#include <atomic>       

using namespace std;

class  partida{

        private:
                Tesoro* tesoro;
                reportePartida* partidas;
                ReporteFinPartida* reporte;
                ArbolBinarioEnemigo* arbol=new ArbolBinarioEnemigo();
                ArbolBinarioTrampas* arbolTrampas=new ArbolBinarioTrampas();
                bool juegoTerminado=false;
                Jugador* jugador;
                EncabezadoCapas& matriz;
                Carteles carteles;
                int tam;
                ListaEnlazadaPistas* pistas=new ListaEnlazadaPistas();
                std::atomic<bool> stopFlag{false};
                std::atomic<int> segundos{0};
                
        public:
                void liberarMemoria();
                partida(Jugador* j, EncabezadoCapas& capas,int t) : jugador(j), matriz(capas),tam(t) {}
                void iniciarPartida();
                void imprimirTablero();
                void realizarMovimeintos();
                void ejecutarAccionNodo(matrizOrtogonal::Nodo* nodo);
                void accionTrampa(matrizOrtogonal::Nodo* nodo);
                void accionEnemigo(matrizOrtogonal::Nodo* nodo);
                void accionPocion(matrizOrtogonal::Nodo* nodo);
                void accionPista(matrizOrtogonal::Nodo* nodo);
                void accionTesoro(matrizOrtogonal::Nodo* nodo);
                void validarVidaJugador();
                void procesoJuego();
                void contadorDeTiempo();
                void setReporte(ReporteFinPartida* nuevoReporte);
                ReporteFinPartida* getReporte();
                void generarReporte();
                reportePartida* getPartidas();
                void setPartidas(reportePartida* p);
                void settesoro(Tesoro* t);
                void eliminarPunteros();
};

#endif