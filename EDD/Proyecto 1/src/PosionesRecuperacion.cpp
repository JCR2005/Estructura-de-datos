#include "../include/PosionesRecuperacion.hpp"

#include <iostream>

PocionesRecuperacion::PocionesRecuperacion(int r, int px, int py,int pz, int n) 
{
    regenercion=r;
    posx=px;
    posy=py;
    posz=pz;
    nivel=n;
}
std::string PocionesRecuperacion::getSimbolo(){

    return simbolo;
}

int PocionesRecuperacion::getRegeneracion(){

    return regenercion;
}