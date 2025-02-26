#include "../include/Ficha.hpp"
#include <iostream>

using namespace std;


Ficha::Ficha(char l, int v,int id) 
    : letraAsignada(l), valor(v), comodin(false),idFicha(id),
      posicion_x(0), posicion_y(0), estado(true) {}

Ficha::Ficha(char l, bool c, int id) 
    : letraAsignada(l), comodin(c), valor(0),idFicha(id),
      posicion_x(0), posicion_y(0), estado(true) {}


void Ficha::setId(int i) {
    idFicha = i;
}

int Ficha::getId() const {
    return idFicha;
}
void Ficha::setLetraAsignada(char letra) {
    letraAsignada = letra;
}

char Ficha::getLetraAsignada() const {
    return letraAsignada;
}

void Ficha::setValor(int v) {
    valor = v;
}

int Ficha::getValor() const {
    return valor;
}

void Ficha::setPosicionX(int x) {
    posicion_x = x;
}

int Ficha::getPosicionX() const {
    return posicion_x;
}

void Ficha::setPosicionY(int y) {
    posicion_y = y;
}

int Ficha::getPosicionY() const {
    return posicion_y;
}

void Ficha::setEstado(bool e) {
    estado = e;
}

bool Ficha::getEstado() const {
    return estado;
}
