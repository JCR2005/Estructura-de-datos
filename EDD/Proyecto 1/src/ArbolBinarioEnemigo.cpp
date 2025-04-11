#include "../include/ArbolBinarioEnemigo.hpp"
#include <iostream>
using namespace std;

ArbolBinarioEnemigo::Nodo* ArbolBinarioEnemigo::crearNodo(Enemigo* enemigo) {
    return new Nodo(enemigo, enemigo->getCapa());
}

void ArbolBinarioEnemigo::insertarNodo(Enemigo* enemigo) {
    insertarNodoRecursivo(arbol, enemigo);
}

void ArbolBinarioEnemigo::insertarNodoRecursivo(Nodo*& actual, Enemigo* enemigo) {
    if (actual == nullptr) {
        actual = crearNodo(enemigo);
    } else {
        if (enemigo->getCapa() <= actual->nivel) {
            insertarNodoRecursivo(actual->izquierdo, enemigo);
        } else {
            insertarNodoRecursivo(actual->derecho, enemigo);
        }
    }
}

void ArbolBinarioEnemigo::mostrarArbol() {
    mostrarArbolRecursivo(arbol, 0);
    conta=0;
    generarImagenDelArbol();
}

void ArbolBinarioEnemigo::mostrarArbolRecursivo(Nodo* actual, int contador) {
    if (actual == nullptr) return;

    mostrarArbolRecursivo(actual->derecho, contador + 1);
    conta++;
    cout<<"nivel "<<conta <<"  |  ";
    for (int i = 0; i < contador; ++i) {
        cout << "   ";
        
    }
    cout <<"| capa: " << actual->nivel <<"| Ubicacion: " <<actual->enemigo->concatenarCoordenadas()  <<"| Daño:" << actual->enemigo->getDaño() << endl;
    mostrarArbolRecursivo(actual->izquierdo, contador + 1);
}
void ArbolBinarioEnemigo::generarImagenDelArbol() {
    std::ofstream archivo("arbolEnemigo.dot");
    archivo << "digraph Arbol {\n";
    archivo << "    node [shape=circle, style=filled, fillcolor=lightblue];\n";
    generarDotRecursivo(arbol, archivo);
    archivo << "}\n";
    archivo.close();

    int res = system("dot -Tpng arbolEnemigo.dot -o arbolEnemigo.png");
    if (res == 0) {
     
    } else {
        
    }
}

void ArbolBinarioEnemigo::generarDotRecursivo(Nodo* actual, std::ofstream& archivo) {
    if (!actual) return;

   
    std::stringstream nodoActual;
    nodoActual << "\"" << actual << "\""; 
    archivo << "    " << nodoActual.str() << " [label=\"" << actual->nivel << "\"];\n";

    if (actual->izquierdo) {
        std::stringstream izq;
        izq << "\"" << actual->izquierdo << "\"";  
        archivo << "    " << nodoActual.str() << " -> " << izq.str() << ";\n";
        generarDotRecursivo(actual->izquierdo, archivo);
    }

    if (actual->derecho) {
        std::stringstream der;
        der << "\"" << actual->derecho << "\"";  
        archivo << "    " << nodoActual.str() << " -> " << der.str() << ";\n";
        generarDotRecursivo(actual->derecho, archivo);
    }
}



void ArbolBinarioEnemigo::mostrarEnemigos() {
    mostrarEnemigosRecursivo(arbol);
    conta=0;
}

void ArbolBinarioEnemigo::mostrarEnemigosRecursivo(Nodo* actual) {
    if (actual == nullptr) return;

    mostrarEnemigosRecursivo(actual->derecho);
    conta++;
    cout<<"______________"<<endl;
    cout<<"Enemigo numero "<<conta;
    cout<<endl;
    cout<<"Ubicacion: "<<actual->enemigo->concatenarCoordenadas() <<endl;
    cout<<"Daño: " << actual->enemigo->getDaño() << endl;
    mostrarEnemigosRecursivo(actual->izquierdo);
}

ArbolBinarioEnemigo::Nodo* ArbolBinarioEnemigo::getArbol() {
    return arbol;
}

void ArbolBinarioEnemigo::setArbol(Nodo* nuevoArbol) {
    arbol = nuevoArbol;
}
