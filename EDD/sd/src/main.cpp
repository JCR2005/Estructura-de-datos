#include "../include/Menu.hpp"
#include "../include/Logo.hpp"
#include <iostream>
using namespace std;


int main() {
    
    
    Logo logo;
    logo.mostrarLogo();
    cout << "Presiona Enter para continuar...";
    cin.get(); 

    Menu objeto;
    objeto.MostrarMenu();
    return 0;
}