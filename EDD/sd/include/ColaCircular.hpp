#ifndef COLACIRCULAR_HPP
#define COLACIRCULAR_HPP


class ColaCircular {
private:
    int* cola;   
    int frente, final; 
    int capacidad;  
    int elementos; 
public:
    ColaCircular(int* ids, int numJugadores);
    ColaCircular();
    ~ColaCircular();

    void mezclarCola();
    void encolar(int id);
    int desencolar();
    bool estaVacia();
};

#endif
