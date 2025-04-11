#include "../include/Trampa.hpp"

#include <iostream>

Trampa::Trampa(int n, int px, int py,int pz, int d) 
{
    nivel=n;
    posx=px;
    posy=py;
    posz=pz;
    daño=d;
}

std::string Trampa::getSimbolo(){

    return simbolo;
}

int Trampa::getDaño(){

    return daño;
}

int Trampa::getCapa(){

    return posz;
}


std::string Trampa::concatenarCoordenadas(){
    std::string coordenada1="|("+to_string(posz)+to_string(posy)+to_string(posx)+")|";
    return coordenada1;
  
}