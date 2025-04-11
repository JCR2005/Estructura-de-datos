
#include "../include/ partida.hpp"
#include <iostream>
#include <chrono>
#include <thread>
using namespace std;
using namespace std::chrono;

void partida::contadorDeTiempo() {
    auto start = high_resolution_clock::now();
    segundos.store(0);

   
    while (!stopFlag.load()) {
        auto now = high_resolution_clock::now();
        auto duration = duration_cast<seconds>(now - start);
        
        if (duration.count() > segundos) {
            segundos = duration.count();
        }
        this_thread::sleep_for(milliseconds(100));
    }
}
void partida::iniciarPartida(){
    
    thread t1(&partida::procesoJuego, this);
    thread t2(&partida::contadorDeTiempo, this);
      

    
    t1.join();
    t2.join();
}

void partida::procesoJuego(){

    do
    {   carteles.DatosJugador(jugador->getVida(),jugador->getNombre(),jugador->getMovimiento());
       
        imprimirTablero();
        carteles.menuJugador();
        realizarMovimeintos();
       
      
    } while (!juegoTerminado);
}

void partida::imprimirTablero(){
    for (int cap = 1; cap < tam+1; cap++)
        {
            EncabezadoCapas::EncabezadoCapa* encabezado = matriz.buscarOCrear(matriz.capas, cap);
              cout <<endl << "Nivel : "<< encabezado->indice<<endl;
                encabezado->matriz.mostrarMatriz();
        }
}

void partida::realizarMovimeintos(){
    char opcion;
    cin>> opcion;
    switch (opcion){
        case 'a': ejecutarAccionNodo(jugador->moverIzquierda(matriz, tam)); break;
        case 'd': ejecutarAccionNodo(jugador->moverDerecha(matriz, tam)); break;
        case 'w': ejecutarAccionNodo(jugador->moverAdelante(matriz, tam)); break;
        case 's': ejecutarAccionNodo(jugador->moverAtras(matriz, tam)); break;
        case 'q': ejecutarAccionNodo(jugador->moverArriba(matriz, tam)); break;
        case 'e': ejecutarAccionNodo(jugador->moverAbajo(matriz, tam)); break;
        default: carteles.opcionIncorrcta(); break;
    }
}



void partida::ejecutarAccionNodo(matrizOrtogonal::Nodo* nodo){
    if (nodo == nullptr) { return; }
    int simbolo= nodo->simbolo;
    switch (simbolo) {

    case 1:accionEnemigo(nodo); break;
    case 2:accionTrampa(nodo); break;
    case 3:accionPocion(nodo); break;
    case 4:accionPista(nodo); break;
    case 5:accionTesoro(nodo); break;
    default: break;
    }
    validarVidaJugador();
}

void partida::accionTrampa(matrizOrtogonal::Nodo* nodo){

    try{    
    Trampa* trampa = std::any_cast<Trampa*>(nodo->any);
    if (jugador->getVida()-trampa->getDaño()<=0){
        jugador->setVida(0);
       return;
    }

    jugador->setVida(jugador->getVida()-trampa->getDaño());
    nodo->simbolo=0;
    arbolTrampas->insertarNodo(trampa);
    carteles.encontrarTrampa(trampa->getDaño(),jugador->getVida());
    }
    catch(const std::bad_any_cast& e    )
    {
        std::cerr << e.what() << '\n';
    }
   
}


void partida::accionEnemigo(matrizOrtogonal::Nodo* nodo){
    if (nodo == nullptr) { return; }
    try{    
    Enemigo* enemigo = std::any_cast<Enemigo*>(nodo->any);
    if (jugador->getVida()-enemigo->getDaño()<=0){
        jugador->setVida(0);
       return;
    }
    jugador->setVida(jugador->getVida()-enemigo->getDaño());
    nodo->simbolo=0;
    arbol->insertarNodo(enemigo);
    carteles.encontrarEnemigo(enemigo->getDaño(),jugador->getVida());
    }
    catch(const std::bad_any_cast& e    )
    {
        std::cerr << e.what() << '\n';
    }
   
}

void partida::accionPocion(matrizOrtogonal::Nodo* nodo){
    if (nodo == nullptr) { return; }
    try{    

    PocionesRecuperacion* pocion = std::any_cast<PocionesRecuperacion*>(nodo->any);
    jugador->setVida(jugador->getVida()+pocion->getRegeneracion());
    carteles.encontrarPocion(pocion->getRegeneracion(),jugador->getVida());
    nodo->simbolo=0;
    }
    catch(const std::bad_any_cast& e    )
    {
        std::cerr << e.what() << '\n';
    }
   
}

void partida::accionPista(matrizOrtogonal::Nodo* nodo){
    if (nodo == nullptr) { return; }
    try{    
    Pista* pista = std::any_cast<Pista*>(nodo->any);
    carteles.encontrarPista(pista->getSimbolo());
    nodo->simbolo=0;
    pistas->insertarPista(pista);
    }
    catch(const std::bad_any_cast& e )
    {
        std::cerr << e.what() << '\n';
    }
   
}

void partida::accionTesoro(matrizOrtogonal::Nodo* nodo){
    if (nodo == nullptr) { return; }
    try{   
    Tesoro* tesoro = std::any_cast<Tesoro*>(nodo->any); 
    jugador->setPuntos((tam*100)/jugador->getMovimiento());
    carteles.encontrarTesoro(jugador->getVida(),jugador->getNombre(),jugador->getMovimiento(),jugador->getPuntos(),segundos);
    juegoTerminado=true;
    stopFlag.store(true);
    reporte->setTesoro(tesoro);
    reporte->setPartidas(partidas);
    generarReporte();
    reporte->generarReportes();

    }
    catch(const std::bad_any_cast& e    )
    {
        std::cerr << e.what() << '\n';
    }
   
}

void partida::validarVidaJugador(){
    
    if (jugador->getVida()<=0)
    {      
        stopFlag.store(true);
        jugador->setPuntos((tam*100)/jugador->getMovimiento());
        juegoTerminado=true;
        carteles.encontrarMuerte(0,jugador->getNombre(),jugador->getMovimiento(),jugador->getPuntos(),segundos);
        reporte->setTesoro(tesoro);
        reporte->setPartidas(partidas);
        generarReporte();
        reporte->generarReportes();
      
    }
    
}

void partida::generarReporte(){
    reporte->setNombreJugador(jugador->getNombre());
    reporte->setTiempoPartida(segundos);
    reporte->setCatidadMovimientos(jugador->getMovimiento());
    reporte->setPuntaje(jugador->getPuntos());
    reporte->setCoordenadad(jugador->cola);
    reporte->setPistas(pistas);
    reporte->setArbolEnemigo(arbol);
    reporte->setArbolTrampas(arbolTrampas);
}

void partida::liberarMemoria() {
    delete tesoro;
    delete pistas;
    delete reporte;
    delete arbol;
    delete arbolTrampas;

 
    tesoro = nullptr;
    pistas = nullptr;
    reporte = nullptr;
    arbol = nullptr;
    arbolTrampas = nullptr;
}


void  partida::setReporte(ReporteFinPartida* nuevoReporte) {
    this->reporte = nuevoReporte;
}

ReporteFinPartida*  partida::getReporte() {
    return reporte;
}

reportePartida* partida::getPartidas() {
    return partidas;
}
void partida::setPartidas(reportePartida* p){
    this->partidas=p;

}


void partida::settesoro(Tesoro* t){
    this->tesoro=t;

}