#include "../include/Inicio.hpp"
#include "../include/MenuPrincipal.hpp"
#include "../include/ConfiguracionInicialPartida.hpp"
#include "../include/ReportePartidas.hpp"
#include <iostream>
using namespace std;

void Inicio::Iniciar(){

        MenuPrincipal MenuPrincipal;
        ConfiguracionInicialPartida configuracionInicial;
        ReportePartidas* reporteGeneral=new ReportePartidas();
        int numero;
      
        do
        {
                MenuPrincipal.menu();
                cin >> numero;        
                switch (numero)
                {
                case 1:
                configuracionInicial.setPartidas(reporteGeneral->getPartidas());
                configuracionInicial.configuracionInicial();
                        break;
                case 2:
                reporteGeneral->ventanaInicial();
                        break; 
                default:
                        break;
                }
        
        } while (numero!=3);
        
        delete reporteGeneral;
        reporteGeneral = nullptr;

        delete configuracionInicial.getJugador();
        configuracionInicial.getJugador()=nullptr;
        delete configuracionInicial.getTesoro();
        configuracionInicial.getTesoro()=nullptr;
        
}