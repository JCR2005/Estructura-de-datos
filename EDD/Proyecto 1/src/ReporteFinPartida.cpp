#include "../include/ReporteFinPartida.hpp"




void ReporteFinPartida::generarReportes(){
    carteles.encabzadoReporte(nombreJugador,catidadMovimientos,puntaje,tiempoPartida);
    agragarReportePartida();
    carteles.reporteTesoro(tesoro->getPosX(),tesoro->getPosY(),tesoro->getPosZ());
    carteles.trayectoriaJugador();
    cola->mostrar();
    carteles.pistaEncontradas();
    pistas->ImprimirLista();
    carteles.EnemigosEncontrado();
    arbolEnemigos->mostrarEnemigos();
    carteles.TrampasEncontrado();
    arobolTrampas->mostrarTrampas();
    carteles.DiagramaArbolEnemigo();
    arbolEnemigos->mostrarArbol();
    carteles.DiagramaArbolTrampa();
    arobolTrampas->mostrarArbol();
    carteles.Ramkin();
    partidas->ImprimirLista();
    carteles.linea();
    cin.get();
}

void ReporteFinPartida::agragarReportePartida(){

    partidas->insertarPista(puntaje,tiempoPartida,catidadMovimientos,nombreJugador);
}

ListaEnlazadaPistas* ReporteFinPartida::getPistas()  {
    return pistas;
}

int ReporteFinPartida::getTiempoPartida()  {
    return tiempoPartida;
}

int ReporteFinPartida::getPuntaje()  {
    return puntaje;
}

std::string ReporteFinPartida::getNombreJugador()  {
    return nombreJugador;
}

int ReporteFinPartida::getCatidadMovimientos()  {
    return catidadMovimientos;
}

Tesoro* ReporteFinPartida::getTesoro()  {
    return tesoro;
}

ColaCoordenadas* ReporteFinPartida::getCoodenadas(){

    return cola;
}

void ReporteFinPartida::setPistas(ListaEnlazadaPistas* p) {
    pistas = p;
}

void ReporteFinPartida::setTiempoPartida(int tiempo) {
    tiempoPartida = tiempo;
}

void ReporteFinPartida::setPuntaje(int p) {
    puntaje = p;
}

void ReporteFinPartida::setNombreJugador( std::string nombre) {
    nombreJugador = nombre;
}

void ReporteFinPartida::setCatidadMovimientos(int mov) {
    catidadMovimientos = mov;
}

void ReporteFinPartida::setTesoro(Tesoro* nodo) {
    tesoro = nodo;
}

void ReporteFinPartida::setCoordenadad(ColaCoordenadas* coordenadas){
    this->cola=coordenadas;
}

void ReporteFinPartida::setArbolTrampas(ArbolBinarioTrampas* arbol){

    arobolTrampas=arbol;
}

void ReporteFinPartida::setArbolEnemigo(ArbolBinarioEnemigo* arbol){

    arbolEnemigos=arbol;
}

void ReporteFinPartida::setPartidas(reportePartida* p){
    this->partidas=p;

}