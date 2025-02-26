#include "../include/MergeSortString.hpp"
#include <iostream>

using namespace std;

void MergeSortString::mergeSort(string* arreglo, int ini, int final) {
   
    if (ini < final) {
        int med=(ini+final)/2;
        mergeSort(arreglo, ini, med);  
        mergeSort(arreglo, med+1, final);  
        Mezclar(arreglo,ini,med,final);
    }
}
void MergeSortString::Mezclar(string* arreglo, int ini, int medio, int final) {
    int izq = ini;
    int der = medio + 1;
    int ia = 0;
    int tamanoAux = final - ini + 1;
      string* listaAuxiliar = new string[tamanoAux];

    while (izq <= medio && der <= final) {
        if (arreglo[izq] < arreglo[der]) {
            listaAuxiliar[ia] = arreglo[izq];
            izq++;
        } else {
            listaAuxiliar[ia] = arreglo[der];
            der++;
        }
        ia++;
    }

    while (der <= final) {
        listaAuxiliar[ia] = arreglo[der];
        der++;
        ia++;
    }

    while (izq <= medio) {
        listaAuxiliar[ia] = arreglo[izq];
        izq++;
        ia++;
    }

    for (int i = 0; i < ia; i++) {
        arreglo[ini + i] = listaAuxiliar[i];
    }

     delete[] listaAuxiliar;
}
