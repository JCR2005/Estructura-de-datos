

#include "../include/CargaDeArchivo.hpp"
#include "../include/MergeSortString.hpp"
#include <random>
#include "../include/FuncionesComunes.hpp"
#include <sys/stat.h> 
#include <cstdlib>  
#include <ctime>  
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <algorithm>
#include <cctype>   

using namespace std;

FuncionesComunes funcion;

std::string* arr;

// Constructor de la clase CargaDeArchivo.
// Este constructor inicializa los punteros a nullptr y establece los valores
// de las variables miembro en 0, asegurando que el objeto esté en un estado limpio
// y listo para su uso posterior.

CargaDeArchivo::CargaDeArchivo() 
    : letras(nullptr), letrasTotales(nullptr), puntajeLetras(nullptr), 
      tamanoArregloLetra(0), tamañoTotalLetras(0) {}


// Método para obtener el puntero a las letras totales.
// Retorna un puntero al arreglo de caracteres 'letrasTotales' que almacena
// todas las letras procesadas del archivo.
char* CargaDeArchivo::getLetrasTotales() {
    return letrasTotales;
}

// Método para obtener el puntero al puntaje de las letras.
// Retorna un puntero al arreglo de enteros 'puntajeLetras' que almacena
// el puntaje asociado con cada letra procesada.
int* CargaDeArchivo::getPuntajeLetras() {
    return puntajeLetras;
}

// Método para obtener el puntero al arreglo de palabras.
// Retorna un puntero al arreglo de cadenas de caracteres 'arr' que almacena
// las palabras procesadas del archivo.
std::string* CargaDeArchivo::getPalabras() {
    return arr;
}

// Método para obtener el tamaño del arreglo de letras.
// Retorna el número de elementos en el arreglo 'tamanoArregloLetra', que indica
// la cantidad total de letras procesadas.
int CargaDeArchivo::getTamanoArregloLetra() const {
    return tamanoArregloLetra;
}

// Método para obtener el tamaño total de las letras.
// Retorna el número total de letras procesadas, representado por 'tamañoTotalLetras'.
int CargaDeArchivo::getTamañoTotalLetras() const {
    return tamañoTotalLetras;
}

// Método para obtener el tamaño del arreglo de palabras.
// Retorna el número de palabras almacenadas en 'tamañoPalabras'.
int CargaDeArchivo::getTamanoPalabras() const {
    return tamañoPalabras;
}

// Método para obtener el puntero a las letras.
// Retorna un puntero al arreglo de caracteres 'letras' que almacena
// las letras procesadas, pero no necesariamente todas como en 'letrasTotales'.
char* CargaDeArchivo::getLetras() {
    return letras;
}
// Método que maneja la carga de un archivo CSV, asegurando que sea válido y
// realizando varias operaciones sobre los datos del archivo como contar letras,
// asignar valores, revolver letras, asignar puntajes y guardar las palabras.
void CargaDeArchivo::CargarArchivo() {
   
    string rutaArchivo;
    struct stat buffer;
    while (true) {
        funcion.LimpiarConsola();
        funcion.MensajeNo2();
        getline(cin, rutaArchivo); 
        ifstream archivo(rutaArchivo);
        if (rutaArchivo.empty()) {
            funcion.MensajeNo2_1();
            continue;
        }else if (rutaArchivo.size() < 4 || rutaArchivo.substr(rutaArchivo.size() - 4) != ".csv") {
            funcion.MensajeNo2_1();
            continue;
        }else if (stat(rutaArchivo.c_str(), &buffer) != 0) {
            funcion.MensajeNo2_1();
            continue;
        }else if (!archivo) {
            funcion.MensajeNo2_1();
            continue;
        }
        break;

    }

    ifstream archivo(rutaArchivo); 
    archivo.clear();
    archivo.seekg(0);
    contarLetrasTotales(archivo);
    
    archivo.clear();
    archivo.seekg(0);
    asignarValorLetras(archivo);
    
    revolverLetras();
    
    archivo.clear();
    archivo.seekg(0);
    asignarPuntajeLetra(tamanoArregloLetra);
    
    archivo.clear();
    archivo.seekg(0);
    GuardarPalabras(archivo);
    
    archivo.close();

    cout << "\n Archivo CSV cargado exitosamente. Presiona Enter para continuar...";
    cin.get();
}

// Método que revuelca el arreglo de letras almacenado en 'letras'.
// los elementos del arreglo 'letras', asegurando una distribución uniforme de los mismos.
void CargaDeArchivo::revolverLetras() {
    srand(time(0)); 
    for (int i = tamanoArregloLetra - 1; i > 0; i--) {
        
        int j = rand() % (i + 1);

        char temp = letras[i];
        letras[i] = letras[j];
        letras[j] = temp;
    }
}

// Método que cuenta todas las letras alfabéticas en un archivo CSV y las almacena
// en el arreglo 'letrasTotales'. También guarda el total de letras en la variable 'tamañoTotalLetras'.
void CargaDeArchivo::contarLetrasTotales(std::ifstream& archivo) {
    char c; 
    int cont = 0; 

    letrasTotales = nullptr; 
    
    if (!archivo.is_open()) {
        return;
    }

    while (archivo.get(c)) {
        if (isalpha(c)) {
            char* temp = new char[cont + 1];
           
            if (letrasTotales != nullptr) {
                for (int i = 0; i < cont; i++) {
                    temp[i] = letrasTotales[i];
                }
            }
           
            temp[cont] = c;
            delete[] letrasTotales;
            letrasTotales = temp;

            cont++;
        }
    }

    tamañoTotalLetras = cont;
}


// Método que procesa un archivo CSV, cuenta el número de palabras en él y las guarda en un arreglo 'arr'.
// Al final, imprime las palabras almacenadas y muestra la cantidad total de ellas.
void CargaDeArchivo::GuardarPalabras(std::ifstream& archivo) {
    std::string linea;
    int cont = 0;

    while (std::getline(archivo, linea)) {
        linea.erase(std::remove(linea.begin(), linea.end(), '<'), linea.end());
        linea.erase(std::remove(linea.begin(), linea.end(), '>'), linea.end());

        std::stringstream ss(linea);
        std::string palabra;

        while (std::getline(ss, palabra, ',')) {
            cont++;
        }
    }

    tamañoPalabras = cont;
    arr = new std::string[tamañoPalabras];

    archivo.clear();
    archivo.seekg(0, std::ios::beg);

    int i = 0;
    while (std::getline(archivo, linea)) {
        linea.erase(std::remove(linea.begin(), linea.end(), '<'), linea.end());
        linea.erase(std::remove(linea.begin(), linea.end(), '>'), linea.end());

        std::stringstream ss(linea);
        std::string palabra;

        while (std::getline(ss, palabra, ',')) {
            arr[i] = palabra;
            i++;
        }
    }
    ordenarPalabras();
}

// Este método asigna puntajes aleatorios a un arreglo de letras. 
// Se genera un número aleatorio entre 1 y 9 para cada letra y se almacena en un arreglo `puntajeLetras`.
// El tamaño de este arreglo está determinado por el parámetro `tamaño`.
// Después de asignar los puntajes, se imprime el arreglo de puntajes generados.
void CargaDeArchivo::asignarPuntajeLetra(int& tamaño) {

    int* auxiliar = new int[tamaño];

    for (int i = 0; i < tamaño; i++) {
        std::random_device rd;
        std::mt19937 gen(rd());
        std::uniform_int_distribution<> dis(1, 9);
        int numeroAleatorio = dis(gen);

        if (numeroAleatorio != auxiliar[i]) {
            auxiliar[i] = numeroAleatorio;
        }
    }
    
    puntajeLetras = auxiliar;

}

// Este método lee un archivo carácter por carácter, y agrega cada letra al arreglo `letras`.
// Utiliza el método `añadirLetra` para asegurarse de que solo se añadan letras alfabéticas y que no haya letras duplicadas en el arreglo.
// Al finalizar la lectura del archivo, imprime las letras almacenadas.
void CargaDeArchivo::asignarValorLetras(std::ifstream& archivo) {
    char c;
    while (archivo.get(c)) {
        char* nuevo = añadirLetra(c, letras, tamanoArregloLetra);
        if (nuevo != letras) {
            letras = nuevo;
        }
    }
}

// Este método agrega una letra al arreglo `letras` si no está ya presente.
// Si el arreglo es nulo o está vacío, inicializa el arreglo con la primera letra.
// Si la letra ya existe en el arreglo, no la agrega.
// Si no existe, la añade al final del arreglo, creando un nuevo arreglo con un tamaño mayor y copiando los valores previos.
char* CargaDeArchivo::añadirLetra(char letra, char*& letras, int& tamaño) {
    letra = tolower(letra);
    if (!isalpha(letra)) {
        return letras;
    }

    if (letras == nullptr) {
        letras = new char[1];
        letras[0] = letra;
        tamaño = 1;
        return letras;
    }

    for (int i = 0; i < tamaño; i++) {
        if (letras[i] == letra) {
            return letras;
        }
    }

    char* auxiliar = new char[tamaño + 1];

    if (tamaño > 0 && letras != nullptr) {
        std::copy(letras, letras + tamaño, auxiliar);
    }

    auxiliar[tamaño] = letra;
    tamaño++;

    if (letras != nullptr) {
        delete[] letras;
    }
    tamanoArregloLetra = tamaño;
    return auxiliar;
}

// Ordena el arreglo 'arr' de palabras en orden alfabético.
void CargaDeArchivo::ordenarPalabras() {
    for (int i = 0; i < tamañoPalabras - 1; i++) {
        for (int j = 0; j < tamañoPalabras - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                std::string temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
