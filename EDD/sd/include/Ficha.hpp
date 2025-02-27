#ifndef FICHA_HPP
#define FICHA_HPP
#include <ostream>

class Ficha {

private:
    bool comodin;
    char letraAsignada;
    int valor;
    int posicion_x;
    int posicion_y;
    bool estado;
    int idFicha;

public:
    Ficha(char l, int v,int id);
    Ficha(char l, bool c,int id);
    void setId(int i);
    int getId() const;

    // Setter y Getter para letraAsignada
    void setLetraAsignada(char letra);
    char getLetraAsignada() const;

    // Setter y Getter para valor
    void setValor(int v);
    int getValor() const;

    // Setter y Getter para posicion_x
    void setPosicionX(int x);
    int getPosicionX() const;

    // Setter y Getter para posicion_y
    void setPosicionY(int y);
    int getPosicionY() const;

    // Setter y Getter para estado
    void setEstado(bool e);
    bool getEstado() const;

    friend std::ostream& operator<<(std::ostream& os, const Ficha& ficha) {
        os << "[Letra: " << ficha.letraAsignada 
           << ", Valor: " << ficha.valor 
           << ", Posición: (" << ficha.posicion_x << ", " << ficha.posicion_y << ")"
           << ", Estado: " << (ficha.estado ? "Activo" : "Inactivo") << "]";
        return os;
    }
};

#endif // FICHA_HPP
