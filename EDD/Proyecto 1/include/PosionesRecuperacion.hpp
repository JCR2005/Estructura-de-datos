#ifndef POCIONESRECUPERACION_HPP
#define POCIONESRECUPERACION_HPP

#include <iostream> 

using namespace std;


class PocionesRecuperacion
{
private:
    
    int nivel;
    int regenercion;
    int posx;
    int posy;
    int posz;
    std::string simbolo=" PR ";
public:

PocionesRecuperacion(int r, int px, int py,int pz, int n);
std::string getSimbolo();
int getRegeneracion();
};


#endif