#ifndef TABLERO_HPP
#define TABLERO_HPP
#include <string>
#include "../include/Jugador.hpp"
#include "../include/FuncionesComunes.hpp"
#include "../include/Pila.hpp"



class Tablero{
private:

   Pila palabrasEncontradas;
   FuncionesComunes funciones;
   std::string tablero[18][18];
   int* valor;
   int tam;
   char* letras;
public:


   void verificarPalabrasVertical(Jugador* ju,std::string* pala, int x, int y,int num);
   void verificarPalabrasHorizonal(Jugador* ju,std::string* pala, int x, int y,int num);
   void crearTablero();
   void imprimirTablero();
   void agregarFicha(Jugador* j,std::string* palabras,int num);
   void eliminarFicha();
   void buscarPalabras( Jugador* j,std::string texto, std::string* palabras, int numPalabras);
   void AsignarFichas(char* letra, int* puntajeLetras, int tamaño);

   Pila& getPalabrasEncontradas();
};

#endif
