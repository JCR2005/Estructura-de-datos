#include "../include/Menu.h"

#include <iostream>
using namespace std;

int main()
{
    Menu menu;
    menu.mostrarMenu();    
    cout << "╔═════════════════════════════════════════════════════╗\n"; 
    cout << "║ ▆▆▆▆   ▆▆▆▆  ▆▆▆▆   ▆▆▆▆▆  ▆▆▆▆▆  ▆▆▆▆▆  ▆     ▆▆▆▆▆║\n";
    cout << "║▆       ▆     ▆   ▆  ▆   ▆  ▆    ▆ ▆    ▆ ▆     ▆    ║\n";
    cout << "║ ▆▆▆    ▆     ▆▆▆▆   ▆▆▆▆▆  ▆▆▆▆▆  ▆▆▆▆▆  ▆     ▆▆▆▆ ║\n";
    cout << "║    ▆   ▆     ▆   ▆  ▆   ▆  ▆    ▆ ▆    ▆ ▆     ▆    ║\n";
    cout << "║▆▆▆▆    ▆▆▆▆  ▆   ▆  ▆   ▆  ▆▆▆▆▆  ▆▆▆▆▆  ▆▆▆▆▆ ▆▆▆▆▆║\n";
    cout << "╚═════════════════════════════════════════════════════╝\n";
    cout << "Presiona Enter para continuar...";
    cin.get(); 
   int opcion;

    do {
        cout << "\n=== MENU ===\n";
        cout << "1. Jugar\n";
        cout << "2. Ver Reportes\n";
        cout << "3. Salir\n";
        cout << "Seleccione una opción: ";
        cin >> opcion;

        switch (opcion) {
            case 1:
     
                break;
            case 2:
               
                break;
            case 3:
                cout << "Saliendo...\n";
                break;
            default:
                cout << "Opción inválida, intenta de nuevo.\n";
        }
    } while (opcion != 3);
string letters[15][15];

 for (int i = 0; i < 15; i++) {
        for (int j = 0; j < 15; j++) {
            if (i == 0 || i == 14 || j == 0 || j == 14) {
                letters[i][j] = "▆";  // Asignar borde
            } else {
                letters[i][j] = "-";   // Interior vacío
            }
        }
    }

    // Imprimir la matriz para verificar
    for (int i = 0; i < 15; i++) {
        cout << "     ";
        for (int j = 0; j < 15; j++) {
           
                cout << letters[i][j]+"  ";  // Espacio vacío para los interiores
           
               
            
        }
        cout << "\n";
    }
    return 0;
}
