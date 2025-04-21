#ifndef PISTA_HPP
#define PISTA_HPP

#include <cstdlib>
#include <iostream> 

using namespace std;


class Pista
{
private:
    
    int distanciaFilas=0;
    int distanciaColumnas=0;
    int distanciaCapas=0;
    int nivel;
    int posx;
    int posy;
    int posz;
   
    std::string id=" ¿？ ";
    std::string simbolo=" ¿？ ";    
public:
    Pista(int n, int px, int py, int pz);
    std::string getSimbolo();
    void setSimbolo(std::string s);
    std::string getId();
    std::string definirPista(int x, int y, int z);

    int getDistanciaFilas();
    void setDistanciaFilas(int valor);

    int getDistanciaColumnas();
    void setDistanciaColumnas(int valor);

    int getDistanciaCapas();
    void setDistanciaCapas(int valor);

};



#endif