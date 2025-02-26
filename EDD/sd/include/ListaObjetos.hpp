#ifndef LISTA_OBJETOS_HPP  
#define LISTA_OBJETOS_HPP  

#include <string>  
#include <iostream> 

template <typename T>
class ListaObjetos {
private:
    struct Nodo {
        T* objeto;
        Nodo* siguiente;
        Nodo(T* objeto) : objeto(objeto), siguiente(nullptr) {}
    };
    Nodo* cabeza;

public:
    ListaObjetos() : cabeza(nullptr) {}

    void agregar(T* objeto) {
        Nodo* nuevo = new Nodo(objeto);
        if (!cabeza) {
            cabeza = nuevo;
        } else {
            Nodo* actual = cabeza;
            while (actual->siguiente) {
                actual = actual->siguiente;
            }
            actual->siguiente = nuevo;
        }
    }
    T* buscar(int id) {
        Nodo* actual = cabeza;
        while (actual) {
            if (actual->objeto->getId() == id) { 
                return actual->objeto;
            }
            actual = actual->siguiente;
        }
        return nullptr;  
    }


    void eliminarElemento(int id){
        
        Nodo* actual = cabeza;
    
        Nodo* anterior = nullptr;
        if (actual!=nullptr && actual->objeto->getId()==id)

        {
            cabeza=actual->siguiente;
            delete actual;
            return;
        }
        
        while (actual != nullptr) {
            if (actual->objeto->getId() == id) {
               
                anterior->siguiente = actual->siguiente;  
                delete actual;  
                return;
            }
          
            anterior = actual;  
            actual = actual->siguiente; 
        }
            
    }

    void imprimir() {
        Nodo* actual = cabeza;
        while (actual) {
            std::cout  << ", ID: " << actual->objeto->getId()
                      << " | ";
            actual = actual->siguiente;
        }
        std::cout << "NULL" << std::endl;
    }

    void imprimirFichas() {
        Nodo* actual = cabeza;
        while (actual) {
            std::cout  << ", ID: " << actual->objeto->getLetraAsignada()
                      << " | ";
            actual = actual->siguiente;
        }
        std::cout << "NULL" << std::endl;
    }

    ~ListaObjetos() {
        Nodo* actual = cabeza;
        while (actual) {
            Nodo* temp = actual;
            delete actual->objeto;
            actual = actual->siguiente;
            delete temp;
        }
    }
};

#endif  
