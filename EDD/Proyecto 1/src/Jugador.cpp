#include "../include/Jugador.hpp"



Jugador::Jugador(int n, int px, int py, int pz,std::string no) {
    vida = n;
    posx = px;
    posy = py;
    posz = pz;
    nombre=no;
    simbolo = " JJ "; 
}

matrizOrtogonal::Nodo* Jugador::moverIzquierda(EncabezadoCapas& capas,int t) {
    EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, posz);
    matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(posx,posy);
    if (nodo->izquierda==nullptr)
    {
        carteles.fueraDelMapa();
        return nullptr;
    }
    cola->encolar(obtenerMovimiento(nodo->izquierda,"Izquierda(←)"));
    nodo->valor=nodo->izquierda->valor;
    nodo->izquierda->valor=" JJ ";
    posy=posy-1;
    movimiento++;
   
    return nodo->izquierda;
}

std::string Jugador::obtenerMovimiento(matrizOrtogonal::Nodo* nodo, std:: string direccion){

    std::string coordenada1="|("+to_string(posx)+","+to_string(posy)+","+to_string(posz)+")";
    std::string coordenada2="("+to_string(nodo->fila)+","+to_string(nodo->columna)+","+to_string(nodo->capa)+")";
    return coordenada1+"→"+coordenada2+"| movimiento hacia "+direccion;
}
matrizOrtogonal::Nodo* Jugador::moverDerecha(EncabezadoCapas& capas,int t) {
    EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, posz);
    matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(posx,posy);

    if (nodo->derecha==nullptr)
    {
        carteles.fueraDelMapa();
        return nullptr;
    }
    cola->encolar(obtenerMovimiento(nodo->derecha,"Derecha(→)"));
    nodo->valor=nodo->derecha->valor;
    nodo->derecha->valor=" JJ ";
    posy=posy+1;
    movimiento++;
    return nodo->derecha;
}


matrizOrtogonal::Nodo* Jugador::moverAtras(EncabezadoCapas& capas,int t) {
    EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, posz);
    matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(posx,posy);

    if (nodo->atras==nullptr)
    {
        carteles.fueraDelMapa();
        return nullptr;
    }
    cola->encolar(obtenerMovimiento(nodo->atras,"Atras(↓)"));
    nodo->valor=nodo->atras->valor;
    nodo->atras->valor=" JJ ";
    posx=posx+1;
    movimiento++;
    return nodo->atras;
}


matrizOrtogonal::Nodo* Jugador::moverAdelante(EncabezadoCapas& capas,int t) {
    EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, posz);
    matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(posx,posy);

    if (nodo->adelante==nullptr)
    {
        carteles.fueraDelMapa();
        return nullptr;
    }
    cola->encolar(obtenerMovimiento(nodo->adelante,"Adelante(↑)"));
    nodo->valor=nodo->adelante->valor;
    nodo->adelante->valor=" JJ ";
    posx=posx-1;
    movimiento++;
    return nodo->adelante;
}


matrizOrtogonal::Nodo* Jugador::moverArriba(EncabezadoCapas& capas,int t) {
    EncabezadoCapas::EncabezadoCapa* encabezadoArriba = capas.buscarOCrear(capas.capas, posz+1);
    EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, posz);
    matrizOrtogonal::Nodo* nodoArriva= encabezadoArriba->matriz.BuscarNodo(posx,posy);
    matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(posx,posy);
    if (nodoArriva==nullptr)
    {
        carteles.fueraDelMapa();
        return nullptr;
    }
    cola->encolar(obtenerMovimiento(nodoArriva,"Arriba(↑)"));
    nodo->valor=nodoArriva->valor;
    nodoArriva->valor=" JJ ";
    posz=posz+1;
    movimiento++;
    return  nodoArriva;
}


matrizOrtogonal::Nodo* Jugador::moverAbajo(EncabezadoCapas& capas,int t) {
    EncabezadoCapas::EncabezadoCapa* encabezadoAbajo = capas.buscarOCrear(capas.capas, posz-1);
    EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, posz);
    matrizOrtogonal::Nodo* nodoAbajo= encabezadoAbajo->matriz.BuscarNodo(posx,posy);
    matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(posx,posy);
    if (nodoAbajo==nullptr) {
        carteles.fueraDelMapa();
        return nullptr;
    }
    cola->encolar(obtenerMovimiento(nodoAbajo,"Abajo(↓)"));
    nodo->valor=nodoAbajo->valor;
    nodoAbajo->valor=" JJ ";
    posz=posz-1;
    movimiento++;
    return nodoAbajo;
}

int Jugador::getMovimiento(){

    return movimiento;
}

int Jugador::getVida(){

    return vida;
}

int Jugador::getPuntos(){

    return puntos;
}
std::string Jugador::getNombre(){

    return nombre;
}

void Jugador::setVida(int v){
    if (v>100)
    {
       vida=100;
       return;
    } 
    vida=v;
}

void Jugador::setMovimiento(int m){

    movimiento=m;
}
void Jugador::setPuntos(int p){

    puntos=p;
}
void Jugador::setNombre(std::string n){

    nombre=n;
}