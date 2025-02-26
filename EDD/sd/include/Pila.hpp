#ifndef PILA_HPP
#define PILA_HPP
#include <string> 

class Nodo{
    public:
    std::string dato;
    Nodo* siguiente;

    Nodo(std::string d){
        dato=d;
        siguiente = nullptr;
    }

};


class Pila{

private: 

    Nodo* frente;
    Nodo* final;

    

public:

    Pila() {  
        frente = nullptr;
        final=nullptr;
       
    }

        void agregarDatos(std::string dato){

            Nodo* nodoNuevo=new Nodo(dato);

            if (frente==nullptr)
            {
            frente=nodoNuevo;
            final=nodoNuevo;

            }else{
                nodoNuevo->siguiente=frente;
                frente=nodoNuevo;
                
            }
            

        }

        std::string desempila(){


           if (frente)
           {
                std::string dat=frente->dato;
                 Nodo* nuevoFrente=frente->siguiente;
                 frente=nuevoFrente;

                return dat;

           }
           
            return "";
            
        }

};


#include <iostream>

#endif