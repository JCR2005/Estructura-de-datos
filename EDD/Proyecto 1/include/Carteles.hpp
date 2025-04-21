#ifndef CARTELES_HPP
#define CARTELES_HPP    

#include <iostream> 

using namespace std;

class Carteles
{
private:
    
public:
    void LimpiarConsola();
    void menuConfiguracionParita();
    void advertencia1();
    void menuJugador();
    void fueraDelMapa();
    void opcionIncorrcta();
    void pedirNombre();
    void bienbenida(std::string nombere);
    void DatosJugador(int vida, std::string nombre, int movimientos);
    void encontrarTrampa(int daño, int vida);
    void encontrarEnemigo(int daño, int vida);
    void encontrarPocion(int recuperacion, int vida);
    void encontrarPista(std::string pista);
    void encontrarTesoro(int vida, std::string nombre, int movimientos, int puntos, int segundos);
    void encontrarMuerte(int vida, std::string nombre, int movimientos, int puntos, int segundos);
    void encabzadoReporte(std::string nombre, int movimientos, int puntos,int seconsd);
    void reporteTesoro( int fila, int columna,int capa);
    void trayectoriaJugador();
    void pistaEncontradas();
    void EnemigosEncontrado();
    void TrampasEncontrado();
    void DiagramaArbolTrampa();
    void DiagramaArbolEnemigo();
    void reportePartidas();
    void ingresarRuta();
    void rutaIncorrecta();
    void datosEnontrados();
    void ListaDePartidas();
    void Ramkin();
    void linea();
};


#endif