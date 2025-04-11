#ifndef COLACOORDENADAS_HPP
#define COLACOORDENADAS_HPP

#include <string>
#include <iostream>

class ColaCoordenadas {
private:
    struct Nodo {
        std::string valor;
        Nodo* siguiente;

        Nodo(const std::string& val) : valor(val), siguiente(nullptr) {}
    };

    Nodo* frente;
    Nodo* final;

public:
    ColaCoordenadas();
    ~ColaCoordenadas();

    void encolar( std::string valor); 
    void desencolar();                      
    std::string obtenerFrente();      
    bool estaVacia() ;                  
    void mostrar();                   
};

#endif
