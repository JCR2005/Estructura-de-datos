#include "../include/Enemigo.hpp"

#include <iostream>



Enemigo::Enemigo(int n, int px, int py,int pz, int d) 
{
    nivel=n;
    posx=px;
    posy=py;
    posz=pz;
    daño=d;
}

std::string Enemigo::getSimbolo(){

    return simbolo;
}

int Enemigo::getDaño(){

    return daño;
}

int Enemigo::getCapa(){

    return posz;
}

std::string Enemigo::concatenarCoordenadas(){
    std::string coordenada1="|("+to_string(posx)+to_string(posy)+to_string(posz)+")|";
    return coordenada1;
  
}