
#include "../include/ReportePartidas.hpp"
#include <iostream>
#include <fstream>
#include <string>
#include <sstream>




void ReportePartidas::ventanaInicial(){

   

    int numero;
      
    do {       
           
            cartel.reportePartidas(); 
            cin >> numero;        
            switch (numero) {
            case 1: cargarArchivo(); break;
            case 2: mostraReporte(); break; 
            default: break;
            }
            cin.ignore();
    } while (numero!=3);

}

void ReportePartidas::mostraReporte(){
    cartel.ListaDePartidas();
    partidas->ImprimirLista();
    cin.get();
  
}
void ReportePartidas::cargarArchivo(){

    bool archivoAbierto=true;
    std::string ruta="";
    do {   cin.ignore();
        cartel.ingresarRuta();
        getline(cin, ruta);
        std::ifstream archivo(ruta);
        if (!archivo.is_open()) {
            archivoAbierto=false;
            cartel.rutaIncorrecta();       
        }
        archivo.close();
    } while (!archivoAbierto);
    ObtenerContenido(ruta); 
}


void ReportePartidas::ObtenerContenido(std::string ruta){
    int cont=0 ;
    std::string linea;
    cartel.datosEnontrados();
    std::ifstream archivo(ruta);
    while (std::getline(archivo, linea)) {
        cont++;
        if (cont>1)
        {   
            insertarRegstro(linea);
            std::cout << linea << std::endl;
        }  
    }
    archivo.close(); 
}

void ReportePartidas::insertarRegstro(std::string linea){
    std::stringstream datos(linea);      
    std::string dato;
    int cont=0;
    std::string nombre;
    int puntos=0;
    int timepo=0;
    int movimientos=0;
    while (std::getline(datos, dato, ',')) {
        cont++;
        if (cont==1) { nombre  = dato;}
        if (cont==2) { puntos = std::stoi(dato);}
        if (cont==3) { timepo = std::stoi(dato);}
        if (cont==4) { movimientos = std::stoi(dato);}
    }
    partidas->insertarPista(puntos,timepo,movimientos,nombre);
   
}

reportePartida* ReportePartidas::getPartidas() {
    return partidas;
}
