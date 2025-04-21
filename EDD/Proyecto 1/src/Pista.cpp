#include "../include/Pista.hpp"

#include <iostream>


Pista::Pista(int n, int px, int py,int pz) 
{
    nivel=n;
    posx=px;
    posy=py;
    posz=pz;
}

std::string Pista::getSimbolo(){
    return simbolo;
}

void Pista::setSimbolo(std::string s){
    simbolo=s;
}

std::string Pista::definirPista(int x, int y, int z){

    cout<< x <<" " << y <<" "<< z <<endl;
    cout<< posx <<" " << posy <<" "<< posz <<endl;
    distanciaFilas = abs(posx - x);
    distanciaColumnas = abs(posy - y);
    distanciaCapas=abs(posz-z);
    if (posz==z)
    { 
        if ((x==posx+1  && posy==y)||(x==posx-1 && posy==y)||(y==posy+1  && posx==x)||(y==posy-1  && posx==x)||(x==posx-1 && y==posy-1)||(x==posx-1 && y==posy+1)||(x==posx+1 && y==posy-1)||(x==posx+1 && y==posy+1))
        {
           
            return "\033[31mCALIENTE\033[0m";
        }

        return  "\033[38;5;214mTIBIO\033[0m";
        
    }else {

       return "\033[34mFRIO\033[0m";
    }
}

std::string Pista::getId(){

    return id;
}

int Pista::getDistanciaFilas() {
    return distanciaFilas;
}

void Pista::setDistanciaFilas(int valor) {
    distanciaFilas = valor;
}

int Pista::getDistanciaColumnas() {
    return distanciaColumnas;
}

void Pista::setDistanciaColumnas(int valor) {
    distanciaColumnas = valor;
}

int Pista::getDistanciaCapas() {
    return distanciaCapas;
}

void Pista::setDistanciaCapas(int valor) {
    distanciaCapas = valor;
}
