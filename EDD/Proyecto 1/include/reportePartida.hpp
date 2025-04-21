#ifndef REPORTEPARTIDA_HPP
#define REPORTEPARTIDA_HPP
#include <iostream> 
using namespace std;

class reportePartida
{
private:
    struct Nodo {
        
        int puntos=0;
        int tiempo=0;
        int movimeintos=0;
        std::string nombre="";
        Nodo* siguiente;
        Nodo(int p, int t, int m, std::string n ) : puntos(p),tiempo(t),movimeintos(m),nombre(n), siguiente(nullptr) {}
    };
    Nodo* inicio=nullptr;
    
public:
    void insertarPista(int p, int t, int m, std::string n);
    void ImprimirLista();
};






#endif