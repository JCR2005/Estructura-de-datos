#ifndef TRAMPA_HPP
#define TRAMPA_HPP

#include <iostream> 

using namespace std;


class Trampa
{
private:
    
    int nivel;
    int posx;
    int posy;
    int posz;
    int daño;
    std::string simbolo=" TT ";    
public:
    std::string concatenarCoordenadas();
    Trampa(int n, int px, int py, int pz, int d);
    std::string getSimbolo();
    int getDaño();
    int getCapa();
};



#endif