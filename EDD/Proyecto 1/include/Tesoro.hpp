#ifndef TESORO_HPP
#define TESORO_HPP

#include <iostream> 

using namespace std;


class Tesoro
{
private:
   
    int nivel;
    int posx;
    int posy;
    int posz;
    
    std::string simbolo=" 〷 ";    
public:
    Tesoro(int n, int px, int py, int pz);
    std::string getSimbolo();
    int getPosX();
    int getPosY();
    int getPosZ();
};



#endif