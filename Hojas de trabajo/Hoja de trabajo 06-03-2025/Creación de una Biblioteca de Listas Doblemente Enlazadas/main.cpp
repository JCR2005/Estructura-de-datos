#include "ListaDoble.h"

int main() {
    ListaDoble lista;

    lista.insertarInicio(3);
    lista.insertarInicio(2);
    lista.insertarFinal(4);
    lista.insertarFinal(5);

    std::cout << "Lista desde inicio: ";
    lista.imprimirDesdeInicio();

    std::cout << "Lista desde final: ";
    lista.imprimirDesdeFinal();

    std::cout << "Buscando 4: " << (lista.buscar(4) ? "Encontrado" : "No encontrado") << std::endl;

    lista.convertirEnCircular();
    std::cout << "Lista convertida en circular." << std::endl;

    return 0;
}
