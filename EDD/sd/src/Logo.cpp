#include "../include/Logo.hpp"
#include "../include/FuncionesComunes.hpp"
#include <iostream>
using namespace std;


void Logo::mostrarLogo() {
    FuncionesComunes funciones;
    funciones.LimpiarConsola();
     
    cout << "                                                                   ╔═════════════════════════════════════════════════════╗\n"; 
    cout << "                                                                   ║ ▆▆▆▆   ▆▆▆▆  ▆▆▆▆   ▆▆▆▆▆  ▆▆▆▆▆  ▆▆▆▆▆  ▆     ▆▆▆▆▆║\n";
    cout << "                                                                   ║▆       ▆     ▆   ▆  ▆   ▆  ▆    ▆ ▆    ▆ ▆     ▆    ║\n";
    cout << "                                                                   ║ ▆▆▆    ▆     ▆▆▆▆   ▆▆▆▆▆  ▆▆▆▆▆  ▆▆▆▆▆  ▆     ▆▆▆▆ ║\n";
    cout << "                                                                   ║    ▆   ▆     ▆   ▆  ▆   ▆  ▆    ▆ ▆    ▆ ▆     ▆    ║\n";
    cout << "                                                                   ║▆▆▆▆    ▆▆▆▆  ▆   ▆  ▆   ▆  ▆▆▆▆▆  ▆▆▆▆▆  ▆▆▆▆▆ ▆▆▆▆▆║\n";
    cout << "                                                                   ╚═════════════════════════════════════════════════════╝\n";
}