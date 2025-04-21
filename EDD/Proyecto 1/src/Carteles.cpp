#include "../include/Carteles.hpp"

#include <iostream>


void Carteles::LimpiarConsola() {
    std::cout << "\033[2J\033[H";
}

void Carteles::menuConfiguracionParita(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"  Ingrese en tamaño de su tablero(este numero sera el numero de filas y columnas) "  <<endl;
    cout        <<"                         (Tamaño minimo aceptado es de 2)                         "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;

}
void Carteles::pedirNombre(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                            Ingrese su nombre por favor                           "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;

}

void Carteles::bienbenida(std::string nombere){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"BIENBENIDO " <<nombere  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"(Presione enter paracontinuar)                                                    "  <<endl;
    cin.get();
}

void Carteles::advertencia1(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                  El tamaño minimo es de 2, vuleva a intentarlo                   "  <<endl;
    cout        <<"                    (Presione enter para volver a intentarlo)                     "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cin.get();
    cin.get();
}

void Carteles::menuJugador(){

    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                                     →d.Derecho                                   "  <<endl;
    cout        <<"                                     ←a.izquierda                                 "  <<endl;
    cout        <<"                                     ↑w.adelante                                  "  <<endl;
    cout        <<"                                     ↓s.atras                                     "  <<endl;
    cout        <<"__________________________________________________________________________________"  <<endl;
    cout        <<"                                     ↑q.arriba                                    "  <<endl;
    cout        <<"                                     ↓e.abajo                                     "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"Elija su movimiento:                                                              "  <<endl;
 
}

void Carteles::fueraDelMapa(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                        No puede salir fuera del limite del mapa                  "  <<endl;
    cout        <<"                            (Presione enter para continuar)                       "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cin.get();
    cin.get();
    LimpiarConsola();
}

void Carteles::encontrarTrampa(int daño, int vida){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                       Que mal, te has encontrado una trampa!!!                   "  <<endl;
    cout        <<"                           (Presione enter para continuar)                        "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"Daño hecho: " << daño <<"| vida restante: " <<vida  <<endl;
    cin.get();
    cin.get();
}


void Carteles::encontrarEnemigo(int daño, int vida){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                       Que mal, te has encontrado un enemigo!!!                   "  <<endl;
    cout        <<"                           (Presione enter para continuar)                        "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"Daño hecho: " << daño <<"| vida restante: " <<vida  <<endl;
    cin.get();
    cin.get();
}

void Carteles::encontrarPocion(int recuperacion, int vida){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                      Que bien, te has encontrado una pocion!!!!                  "  <<endl;
    cout        <<"                           (Presione enter para continuar)                        "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"vida recuperada: " << recuperacion <<"| vida: " <<vida  <<endl;
    cin.get();
    cin.get();
}

void Carteles::encontrarPista(std::string pista){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                       Que bien, te has encontrado una pista!!!                   "  <<endl;
    cout        <<"                           (Presione enter para continuar)                        "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"La pista nos dice: " << pista <<endl;
    cin.get();
    cin.get();
}

void Carteles::encontrarTesoro(int vida, std::string nombre, int movimientos, int puntos,int seconsd){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                       Que bien, te has encontrado el tesoro!!!                   "  <<endl;
    cout        <<"                                eres todo un explorador                           "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                                  Datos de la partida                             "  <<endl;
    cout        <<endl;
    cout        <<"Vida: " <<vida <<"|  Nombre: " <<nombre  <<endl;
    cout        <<"Movimeintos hechos: "<<movimientos <<"|  Puntos: " <<puntos  <<endl;
    cout        <<"Tiempo de partida: "<<seconsd <<" segundos"  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cin.get();
    cin.get();
}
void Carteles::encontrarMuerte(int vida, std::string nombre, int movimientos, int puntos,int seconsd){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                             Que mal, has perdido la vida!!!                      "  <<endl;
    cout        <<"                                en otra vida lo lograras                           "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                                  Datos de la partida                             "  <<endl;
    cout        <<endl;
    cout        <<"Vida: " <<vida <<"|  Nombre: " <<nombre  <<endl;
    cout        <<"Movimeintos hechos: "<<movimientos   <<"|  Puntos: " <<puntos <<endl;
    cout        <<"Tiempo de partida: "<<seconsd <<" segundos"  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cin.get();
    cin.get();
}
void Carteles::opcionIncorrcta(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                            La opcion ingresada no es valida!                     "  <<endl;
    cout        <<"                             (Presione enter para continuar)                      "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cin.get();
    LimpiarConsola();
}

void Carteles::rutaIncorrecta(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                             La ruta ingresada no es valida!                     "  <<endl;
    cout        <<"                             (Presione enter para continuar)                      "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cin.get();
    LimpiarConsola();
}

void Carteles::datosEnontrados(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                                    Datos encontrados                             "  <<endl;
    cout        <<"                             (Presione enter para continuar)                      "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
}


void Carteles::ListaDePartidas(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                                   Partidas encontrados                             "  <<endl;
    cout        <<"                             (Presione enter para continuar)                      "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
}
void Carteles::reportePartidas(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                              REPORTES DE PARTIDAD JUGADAS                        "  <<endl;
    cout <<endl;
    cout        <<"                              1.Cargar archivo csv                                "  <<endl;
    cout        <<"                              2.Ver reporte de partidas                           "  <<endl; 
    cout        <<"                              3.Regresar                                          "  <<endl;  
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"Ingrese su opcion aqui:";
}

void Carteles::ingresarRuta(){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                          Ingrese la ruta de su archivo-                           "  <<endl;
    cout        <<"                         (pege la ruta de su archivo csv)                         "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"Ingrese aqui:";
}
void Carteles::DatosJugador(int vida, std::string nombre, int movimientos){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"Vida: " <<vida <<"|  Nombre: " <<nombre  <<endl;
    cout        <<"Movimeintos hechos: "<<movimientos  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
}

void Carteles::encabzadoReporte(std::string nombre, int movimientos, int puntos,int seconsd){
    LimpiarConsola();
    cout <<endl <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                                        REPORTE                                   "  <<endl;
    cout        <<"                                     DE LA PARTIDA                                "  <<endl;
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
    cout        <<"                                   Datos del jugador                             "  <<endl;
    cout        <<endl;
    cout        <<"Nombre: " <<nombre  <<endl;
    cout        <<"Movimeintos hechos: "<<movimientos <<endl;
    cout        <<"Puntos: " <<puntos  <<endl;
    cout        <<"Tiempo de partida: "<<seconsd <<" segundos"  <<endl;
    cout        <<"__________________________________________________________________________________"  <<endl;
}


void Carteles::reporteTesoro( int fila, int columna,int capa){
    cout        <<"                                   Datos del tesoro                             "  <<endl;
    cout        <<endl;
    cout        <<"La ubicacion del tesoro es: " <<endl;
    cout        <<endl;
    cout        <<"         Fila: "<<fila <<endl;
    cout        <<"      Columna: "<<columna <<endl;
    cout        <<"         capa: "<<capa <<endl;
    cout        <<"__________________________________________________________________________________"  <<endl;
}

void Carteles::trayectoriaJugador(){
    cout        <<"                                 Este fue tu recorrido                            "  <<endl;
    cout        <<endl;
}

void Carteles::pistaEncontradas(){
    cout        <<"__________________________________________________________________________________"  <<endl;
    cout        <<"                                  Pistas encontradas                              "  <<endl;
    cout        <<endl;
}

void Carteles::EnemigosEncontrado(){
    cout        <<"__________________________________________________________________________________"  <<endl;
    cout        <<"                                 Enemigos encontradas                             "  <<endl;
    cout        <<endl;
}

void Carteles::TrampasEncontrado(){
    cout        <<"__________________________________________________________________________________"  <<endl;
    cout        <<"                                  Trampas encontradas                             "  <<endl;
    cout        <<endl;
}

void Carteles::DiagramaArbolEnemigo(){
    cout        <<"__________________________________________________________________________________"  <<endl;
    cout        <<"                              Diagramas de arbol Enemigo                          "  <<endl;
    cout        <<endl;
}

void Carteles::DiagramaArbolTrampa(){
    cout        <<"__________________________________________________________________________________"  <<endl;
    cout        <<"                              Diagramas de arbol Trampas                          "  <<endl;
    cout        <<endl;
}

void Carteles::Ramkin(){
    cout        <<"__________________________________________________________________________________"  <<endl;
    cout        <<"                        Raking de partida segun su puntuacion                     "  <<endl;
    cout        <<endl;
}

void Carteles::linea(){
    cout        <<"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"  <<endl;
}