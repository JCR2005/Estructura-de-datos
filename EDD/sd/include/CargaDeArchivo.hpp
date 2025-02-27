#ifndef CARGADEARCHIVOS_HPP
#define CARGADEARCHIVOS_HPP

#include <fstream>
#include <string>

//Se encarga de adminatrar la carga de archico
//que contiene las palabras a jugar
class CargaDeArchivo {
private:
    char* letras;
    char* letrasTotales;
    int* puntajeLetras;
    int tamanoArregloLetra;
    int tamañoPalabras;
    int tamañoTotalLetras;

public:
    CargaDeArchivo(); 
    void asignarPuntajeLetra(int& tamaño);
    void asignarValorLetras(std::ifstream& archivo);
    void contarLetrasTotales(std::ifstream& archivo);
    void CargarArchivo();
    void GuardarPalabras(std::ifstream& archivo);
    void revolverLetras();
    void ordenarPalabras();
    char* añadirLetra(char letra, char*& letras, int& tamaño);
    char* getLetras();
    std::string* getPalabras();
    char* getLetrasTotales();
    int* getPuntajeLetras();
    int getTamanoArregloLetra() const;
    int getTamanoPalabras() const;
    int getTamañoTotalLetras() const;
};

#endif // CARGADEARCHIVOS_HPP
