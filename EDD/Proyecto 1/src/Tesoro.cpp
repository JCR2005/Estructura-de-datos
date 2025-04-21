#include "../include/Tesoro.hpp"

#include <iostream>


Tesoro::Tesoro(int n, int px, int py,int pz) 
{
    nivel=n;
    posx=px;
    posy=py;
    posz=pz;
}

std::string Tesoro::getSimbolo(){
    return simbolo;
}


int Tesoro::getPosX(){
    return posx;
}

int Tesoro::getPosY(){
    return posy;
}

int Tesoro::getPosZ(){
    return posz;
}