#ifndef JUGADOR_HPP
#define JUGADOR_HPP
#include "../include/Ficha.hpp"
#include "../include/ListaObjetos.hpp"

#include <string> 

class Jugador {
private:
    int puntaje=0;
      int fichasRestantes=0;
    std::string nombre;
    int idJugador;
    int saltoPArtida=0;
    ListaObjetos<Ficha> fichas;

public:
    Jugador(std::string n, int id);
    void setPuntaje(int p);
     void setSaltos(int s);
      int getSaltos() const;
    void setFichasRestantes(int fi);
    int getPuntaje() const;
    int getFichasRestantes() const;

    void setId(int i);
    int getId() const;

    void setNombre(const std::string& n);
    std::string getNombre() const;

    void setFichas(const ListaObjetos<Ficha>& f);
    ListaObjetos<Ficha>& getFichas();  

};

#endif // JUGADOR_HPP
