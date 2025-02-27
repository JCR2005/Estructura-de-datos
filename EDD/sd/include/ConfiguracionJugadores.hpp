#ifndef CONFIGURACIONDEJUGADORES_HPP
#define CONFIGURACIONDEJUGADORES_HPP
#include "../include/FuncionesComunes.hpp"
#include "../include/ListaObjetos.hpp"
#include "../include/Jugador.hpp"
#include "../include/Ficha.hpp"


class ConfiguracionJugadores {

private:
    Ficha* ficha = nullptr; 
    ListaObjetos<Jugador> jugadores;
    FuncionesComunes funcion;
    int numeroDeJugadores=0;
    char* letras=nullptr;
    int* turnos=nullptr;
    int totalFichasRepartir=0;
    int totalComodines=0;
    int totalFichasEntrantes=0;
    int fichasPorJugador;

public:
    
    int getNumeroDeJugadores() const;
    int getTotalFichasRepartir() const; 
    void crearJugadores();
    int* getTurnos(); 
    ListaObjetos<Jugador>& getJugadores();  
    void configuracionFichas(char letra[], int tamaño);
    void configuracion();   
    void AsignarFichas(char letra[], int puntajeLetras[], int tamaño);
    void mezclarFichas(char letra[], int tamaño);
};

#endif // CONFIGURACIONDEJUGADORES_HPP
