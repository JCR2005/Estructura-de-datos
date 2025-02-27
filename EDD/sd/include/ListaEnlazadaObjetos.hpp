#ifndef LISTAENLAZADAOBJETOS_HPP
#define LISTAENLAZADAOBJETOS_HPP

#include <iostream>
#include <algorithm>

template <typename T>
class NodoObjeto {
public:
    T dato;
    NodoObjeto* siguiente;

    
    NodoObjeto(const T& valor) : dato(valor), siguiente(nullptr) {}
};

template <typename T>
class ListaEnlazadaObjetos {
public:
    NodoObjeto<T>* cabeza;  


    ListaEnlazadaObjetos() : cabeza(nullptr) {}

   
    void agregar(const T& valor);

   
    void imprimir() const;

    void ordenar();
     void ordenarFichas();


    T* buscarPorId(int id);

   
    ~ListaEnlazadaObjetos();
};



template <typename T>
void ListaEnlazadaObjetos<T>::agregar(const T& valor) {
    NodoObjeto<T>* nuevoNodo = new NodoObjeto<T>(valor);
    if (!cabeza) {
        cabeza = nuevoNodo;
    } else {
        NodoObjeto<T>* temp = cabeza;
        while (temp->siguiente) {
            temp = temp->siguiente;
        }
        temp->siguiente = nuevoNodo;
    }
}

template <typename T>
void ListaEnlazadaObjetos<T>::imprimir() const {
    NodoObjeto<T>* temp = cabeza;
    while (temp) {
        std::cout << temp->dato << std::endl;
        temp = temp->siguiente;
    }
}

template <typename T>
void ListaEnlazadaObjetos<T>::ordenarFichas() {
    if (!cabeza) return;

    NodoObjeto<T>* temp1 = cabeza;
    while (temp1) {
        NodoObjeto<T>* min = temp1;
        NodoObjeto<T>* temp2 = temp1->siguiente;

        while (temp2) {
            if (temp2->dato.getValor() < min->dato.getValor()) {
                min = temp2;
            }
            temp2 = temp2->siguiente;
        }

        if (min != temp1) {
            std::swap(min->dato, temp1->dato);
        }

        temp1 = temp1->siguiente;
    }
}


template <typename T>
void ListaEnlazadaObjetos<T>::ordenar() {
    if (!cabeza) return;

    NodoObjeto<T>* temp1 = cabeza;
    while (temp1) {
        NodoObjeto<T>* min = temp1;
        NodoObjeto<T>* temp2 = temp1->siguiente;

        while (temp2) {
            if (temp2->dato < min->dato) {
                min = temp2;
            }
            temp2 = temp2->siguiente;
        }

        if (min != temp1) {
            std::swap(min->dato, temp1->dato);
        }

        temp1 = temp1->siguiente;
    }
}

template <typename T>
T* ListaEnlazadaObjetos<T>::buscarPorId(int id) {
    NodoObjeto<T>* temp = cabeza;
    while (temp) {
        if (temp->dato.getId() == id) {
            return &temp->dato;  
        }
        temp = temp->siguiente;
    }
    return nullptr;  
}

template <typename T>
ListaEnlazadaObjetos<T>::~ListaEnlazadaObjetos() {
    NodoObjeto<T>* temp = cabeza;
    while (temp) {
        NodoObjeto<T>* siguiente = temp->siguiente;
        delete temp;
        temp = siguiente;
    }
}

#endif 
