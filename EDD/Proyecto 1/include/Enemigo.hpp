#ifndef ENEMIGO_HPP
#define ENEMIGO_HPP

#include <iostream> 

using namespace std;


class Enemigo
{
private:
    std::string ubicacion;
    int nivel;
    int posx;
    int posy;
    int posz;
    int daño;
    std::string simbolo=" EE ";    
public:
    Enemigo(int n, int px, int py, int pz, int d);
    std::string getSimbolo();
    int getDaño();
    int getCapa();
    std::string concatenarCoordenadas();
};



#endif