#ifndef ALMACENARFICHAS;_HPP
#define ALMACENARPALABRAS_HPP

#include <string>

class Nodo {
public:
    std::string dato;  
    Nodo* siguiente;  

    
    Nodo(const std::string& valor);
};

class AlmacenarPalabras {
public:
    Nodo* cabeza;  

   
    AlmacenarPalabras();

   
    void agregar(const std::string& valor);

    
    void imprimir() const;

     void ordenar();

  
    ~AlmacenarPalabras();
};

#endif // ALMACENARPALABRAS_HPP
