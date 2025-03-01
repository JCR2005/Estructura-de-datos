#ifndef CONFIGURACIONJUEGO_HPP
#define CONFIGURACIONJUEGO_HPP
#include <string>
#include "../include/ConfiguracionJugadores.hpp"
#include "../include/ListaObjetos.hpp"
#include "../include/Jugador.hpp"
#include "../include/ColaCircular.hpp"
#include "../include/FuncionesComunes.hpp"
#include "../include/CargaDeArchivo.hpp"
#include "../include/tablero.hpp"

class ConfiguracionJuego {

private:
ConfiguracionJugadores configJujadores;
ListaObjetos<Jugador> jugadores;
CargaDeArchivo cargaArchivo;
ColaCircular colaCircular;
FuncionesComunes funciones;
Tablero tablero;
int* puntaje;
  
int* ids;


public:
void puntajes();
Tablero& getPalabrasEncontradas();
CargaDeArchivo& getPalabrasNoEncontradas();
void iniciarPartida();
void definirGanador();
void añadirJugadores();
void ordenarFichas(Jugador* j,int numFichasTotales, int numFichas);
void Partida();
  
};

#endif // CONFIGURACIONJUEGO_HPP
