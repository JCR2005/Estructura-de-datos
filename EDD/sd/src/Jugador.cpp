#include "../include/Jugador.hpp"



#include <iostream>

using namespace std;

Jugador::Jugador(std::string n, int id) {
    idJugador=id;
    nombre = n;
    puntaje = 0; 
}



void Jugador::setPuntaje(int p) {
    puntaje = p;
}

void Jugador::setFichasRestantes(int fi) {
    fichasRestantes = fi;
}

int Jugador::getPuntaje() const {
    return puntaje;
}


int Jugador::getSaltos() const {
    return saltoPArtida;
}

int Jugador::getFichasRestantes() const {
    return fichasRestantes;
}

void Jugador::setId(int i) {
    idJugador = i;
}

int Jugador::getId() const {
    return idJugador;
}

void Jugador::setSaltos(int s) {
    saltoPArtida = s;
}
void Jugador::setNombre(const std::string& n) {
    nombre = n;
}

std::string Jugador::getNombre() const {
    return nombre;
}

void Jugador::setFichas(const ListaObjetos<Ficha>& f) {
    fichas = f;
}


ListaObjetos<Ficha>& Jugador::getFichas() {
    return fichas; 
}



