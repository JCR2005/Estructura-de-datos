

#include "../include/ConfiguracionInicialPartida.hpp"
#include <iostream>
#include <cmath>
#include <cstdlib>  
#include <ctime>    

Carteles carteles;


EncabezadoCapas capas;
Jugador* jugador;
Tesoro* tesoro;
    void ConfiguracionInicialPartida::configuracionInicial(){
        
        pedirNombre();
        pedirTamañoTablero();
        realizarCreaciones(tamañoTablero);
        partida juego(jugador, capas, tamañoTablero);
        juego.settesoro(tesoro);
        juego.setPartidas(partidas);
        juego.setReporte(this->reporte);
        juego.iniciarPartida();

    }

    void ConfiguracionInicialPartida::eliminarPunteros(){
        delete jugador;
        jugador = nullptr;
        delete tesoro;
        tesoro = nullptr;


    }
    void ConfiguracionInicialPartida::pedirNombre(){
            carteles.pedirNombre();
            cin.ignore();
            std::getline(cin, nombre); 
            carteles.bienbenida(nombre);
    }
    void ConfiguracionInicialPartida::pedirTamañoTablero(){
        do
        {
            carteles.menuConfiguracionParita();
            
            cin>>tamañoTablero;
            
            if (tamañoTablero<2)
            {
            carteles.advertencia1();
            }
        } while (tamañoTablero<2);
    }


void ConfiguracionInicialPartida::realizarCreaciones(int tamañoTablero){

    int cantidad1 = calcularCantidadEneTram(tamañoTablero);
    int cantida2= calcularCantidadPosPis(cantidad1,tamañoTablero);

    crearTablero(tamañoTablero);
    crearJugador(tamañoTablero);
    crearEnemigos(cantidad1,tamañoTablero);
    crearTrampas(cantidad1,tamañoTablero);
    crearPociones(cantida2,tamañoTablero);
    crearTesoro(tamañoTablero);
    crearPistas(cantida2,tamañoTablero);
}

int ConfiguracionInicialPartida::calcularCantidadEneTram(int tamañoTablero){
    return ceil((double) (tamañoTablero * tamañoTablero)/4);
}

int ConfiguracionInicialPartida::calcularCantidadPosPis(int cantidad,int tamaño){
    return cantidad - ceil((double) (tamaño * tamaño)/25);
}


void ConfiguracionInicialPartida::crearEnemigos(int cantidaEnemigo, int tamaño){
    srand(time(0)); 
    bool agregado=false;
    for (int i = 0; i < cantidaEnemigo; i++){   
        
        agregado=false;
        do{ 
            int x = rand() % tamaño+1;  int y = rand() % tamaño+1; 
            int z = rand() % tamaño+1;  int daño = rand() % 50;  
            EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, z);
            matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(x,y); 
            if (nodo->valor==" ██ " &&  nodo->simbolo==0) { 
                Enemigo* enemigo = new Enemigo(z, x, y, z,daño);
                nodo->any=enemigo;
                nodo->simbolo=1;
                agregado=true;
            }
        } while (!agregado);   
    } 
}


void ConfiguracionInicialPartida::crearTrampas(int cantidaEnemigo, int tamaño){
    srand(time(0)); 
    bool agregado=false;
    for (int i = 0; i < cantidaEnemigo; i++){   
        
        agregado=false;
        do{ 
            int x = rand() % tamaño+1;  int y = rand() % tamaño+1; 
            int z = rand() % tamaño+1;  int daño = rand() % 50;  
            EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, z);
            matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(x,y); 
            if (nodo->valor==" ██ " &&  nodo->simbolo==0) { 
                Trampa* trampa = new Trampa(z, x, y, z,daño);
                nodo->any=trampa;
                nodo->simbolo=2;
                agregado=true;
            }
        } while (!agregado);   
    } 
}
   

void ConfiguracionInicialPartida::crearPociones(int cantidad, int tamaño){
    srand(time(0)); 
    bool agregado=false;
    for (int i = 0; i < cantidad; i++){   
        
        agregado=false;
        do{ 
            int x = rand() % tamaño+1;  int y = rand() % tamaño+1; 
            int z = rand() % tamaño+1;  int recuperacion = rand() % 50;  
            EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, z);
            matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(x,y); 
            if (nodo->valor==" ██ " &&  nodo->simbolo==0) { 
                PocionesRecuperacion* pocion = new  PocionesRecuperacion(recuperacion,x,y,z,z);
                nodo->any=pocion;
                nodo->simbolo=3;
                agregado=true;
            }
        } while (!agregado);   
    } 
}
   
void ConfiguracionInicialPartida::crearPistas(int cantidad, int tamaño){
    srand(time(0)); 
    bool agregado=false;
    for (int i = 0; i < cantidad; i++){   
        
        agregado=false;
        do{ 
            int x = rand() % tamaño+1;  int y = rand() % tamaño+1; 
            int z = rand() % tamaño+1;   
            EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, z);
            matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(x,y); 
            if (nodo->valor==" ██ " &&  nodo->simbolo==0) { 
                Pista* pista = new  Pista(z,x,y,z);
                nodo->any=pista;
                nodo->simbolo=4;
                pista->setSimbolo(pista->definirPista(tesoro->getPosX(),tesoro->getPosY(),tesoro->getPosZ())); 
                agregado=true;
            }
        } while (!agregado);   
    } 
}




void ConfiguracionInicialPartida::crearTablero(int tamaño){

    int cont=0;
        for (int cap = 1; cap < tamaño+1; cap++)
        {
            EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, cap);
              cout << "insersion capa: "<< encabezado->indice<<endl;
              encabezado->matriz.filas=nullptr;
              encabezado->matriz.columnas=nullptr;
            for (int f = 1; f < tamaño+1; f++) {
                for (int c = 1; c < tamaño+1; c++) {
                    cont++;
                   cout<<encabezado->indice;
                   cout << "insertarNodo(" << f << ", " << c << ", " << cap << ", " << to_string(cont) << ")" << endl;
                    encabezado->matriz.insertarNodo(f,c,cap," ██ ");
                   
                }
            }
          
        }
        

        for (int cap = 1; cap < tamaño+1; cap++)
        {
            EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, cap);
              cout << "insersion capa: "<< encabezado->indice<<endl;
             
             cout<< encabezado->matriz.BuscarNodo(1,1)->derecha->valor <<endl;
                encabezado->matriz.mostrarMatriz();

              
          
        }
 
}

void ConfiguracionInicialPartida::crearTesoro(int tamaño){
    bool agregado=false;
    srand(time(0)); 
   
    do{ 
        int x = rand() % tamaño+1;      
       
        int y = rand() % tamaño+1; 
        
        int z = rand() % tamaño+1;  
       
        EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, z);
        matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(x,y);
        
        if (nodo->valor==" ██ " &&  nodo->simbolo==0) { 
            
             tesoro = new Tesoro(z, x, y, z);
            nodo->any=tesoro;
            nodo->simbolo=5;
            agregado=true;
        }
    } while (!agregado);   
}

void ConfiguracionInicialPartida::crearJugador(int tamaño){
    bool agregado=false;
    srand(time(0)); 
   
    do{ 
        int x = rand() % tamaño+1;      
        cout<<x;
        int y = rand() % tamaño+1; 
        cout<<y; 
        int z = rand() % tamaño+1;  
        cout<<z;
        EncabezadoCapas::EncabezadoCapa* encabezado = capas.buscarOCrear(capas.capas, z);
        matrizOrtogonal::Nodo* nodo= encabezado->matriz.BuscarNodo(x,y);
        
        if (nodo->valor==" ██ ") { 
            
             jugador = new Jugador(100, x, y, z, nombre);
            nodo->valor=" JJ ";
         
          
            agregado=true;
        }
    } while (!agregado);   
}

reportePartida* ConfiguracionInicialPartida::getPartidas() {
    return partidas;
}
void ConfiguracionInicialPartida::setPartidas(reportePartida* p){
    this->partidas=p;

}

Jugador*& ConfiguracionInicialPartida::getJugador() {
    return jugador;
}

Tesoro*& ConfiguracionInicialPartida::getTesoro() {
    return tesoro;
}