#ifndef REPORTEPARTIDAS_HPP
#define REPORTEPARTIDAS_HPP 
#include <iostream> 
#include <atomic>   

#include "../include/Carteles.hpp"
#include "../include/reportePartida.hpp"


using namespace std;

class ReportePartidas
{
private:
    reportePartida* partidas= new reportePartida();
    Carteles cartel;
public:
    void ventanaInicial();
    void cargarArchivo();
    void ObtenerContenido(std::string ruta);
    void insertarRegstro(std::string linea);
    void mostraReporte();
    reportePartida* getPartidas();
};



#endif