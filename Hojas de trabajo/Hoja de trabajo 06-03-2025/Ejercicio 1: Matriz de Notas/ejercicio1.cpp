#include <iostream>
#include <string>

using namespace std;

const int x = 4;
const int y = 3;

void ingresarDatos(string estudiantes[], int notas[x][y]) {
    string nombre;
    int nota;

    for (int i = 0; i < x; i++) {
        cout << "Ingrese nombre del estudiante " << i + 1 << ": ";
        cin >> nombre;
        estudiantes[i] = nombre;

        for (int j = 0; j < y; j++) {
            cout << "Ingrese la nota " << j + 1 << ": ";
            cin >> nota;
            notas[i][j] = nota;
        }
    }
}

int calcularPromedio(int notas[y]) {
    int suma = 0;
    for (int j = 0; j < y; j++) {
        suma += notas[j];
    }
    return suma / y;
}

void mostrarResultados(string estudiantes[], int notas[x][y]) {
    int promedio;
    for (int i = 0; i < x; i++) {
        promedio = calcularPromedio(notas[i]);
        cout << "\n╔════════════════════════════════════╗\n";
        cout << "| Estudiante: " << estudiantes[i] << " | \n";
        cout << "| Promedio: " << promedio << " pts |\n";
        cout << "╚════════════════════════════════════╝\n";
    }
}

int main() {
    string estudiantes[x];
    int notas[x][y];

    ingresarDatos(estudiantes, notas);
    mostrarResultados(estudiantes, notas);

    return 0;
}
