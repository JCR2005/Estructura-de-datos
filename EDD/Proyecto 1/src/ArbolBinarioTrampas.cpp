#include "../include/ArbolBinarioTrampas.hpp"
#include <iostream>
using namespace std;

ArbolBinarioTrampas::Nodo* ArbolBinarioTrampas::crearNodo(Trampa* trampa) {
    return new Nodo(trampa, trampa->getCapa());
}

void ArbolBinarioTrampas::insertarNodo(Trampa* trampa) {
    insertarNodoRecursivo(arbol, trampa);
}

void ArbolBinarioTrampas::insertarNodoRecursivo(Nodo*& actual, Trampa* trampa) {
    if (actual == nullptr) {
        actual = crearNodo(trampa);
    } else {
        if (trampa->getCapa() <= actual->nivel) {
            insertarNodoRecursivo(actual->izquierdo, trampa);
        } else {
            insertarNodoRecursivo(actual->derecho, trampa);
        }
    }
}

void ArbolBinarioTrampas::mostrarArbol() {
    mostrarArbolRecursivo(arbol, 0);
    conta=0;
    generarImagenDelArbol();
}

void ArbolBinarioTrampas::mostrarArbolRecursivo(Nodo* actual, int contador) {
    if (actual == nullptr) return;

    mostrarArbolRecursivo(actual->derecho, contador + 1);
    conta++;
    cout<<"nivel "<<conta <<"  |  ";
    for (int i = 0; i < contador; ++i) {
        cout << "   ";
    }
    cout   <<"| capa: " << actual->nivel  <<"| Ubicacion: " <<actual->trampa->concatenarCoordenadas()  <<"| Daño:" << actual->trampa->getDaño() << endl;
    mostrarArbolRecursivo(actual->izquierdo, contador + 1);
}

void ArbolBinarioTrampas::generarImagenDelArbol() {
    std::ofstream archivo("arbolTrampas.dot");
    archivo << "digraph Arbol {\n";
    archivo << "    node [shape=circle, style=filled, fillcolor=lightblue];\n";
    generarDotRecursivo(arbol, archivo);
    archivo << "}\n";
    archivo.close();

    int res = system("dot -Tpng arbolTrampas.dot -o arbolTrampas.png");
    if (res == 0) {
    
    } else {
       
    }
}

void ArbolBinarioTrampas::generarDotRecursivo(Nodo* actual, std::ofstream& archivo) {
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

void ArbolBinarioTrampas::mostrarTrampas() {
    mostrarTrampasRecursivo(arbol);
    conta=0;
}

void ArbolBinarioTrampas::mostrarTrampasRecursivo(Nodo* actual) {
    if (actual == nullptr) return;

    mostrarTrampasRecursivo(actual->derecho);
    conta++;
    cout<<"______________"<<endl;
    cout<<"Trampa numero "<<conta;
    cout<<endl;
    cout<<"Ubicacion: "<<actual->trampa->concatenarCoordenadas() <<endl;
    cout<<"Daño: " << actual->trampa->getDaño() << endl;
    mostrarTrampasRecursivo(actual->izquierdo);
}

ArbolBinarioTrampas::Nodo* ArbolBinarioTrampas::getArbol() {
    return arbol;
}

void ArbolBinarioTrampas::setArbol(Nodo* nuevoArbol) {
    arbol = nuevoArbol;
}
