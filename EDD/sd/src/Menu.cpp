#include "../include/Menu.hpp"
#include "../include/FuncionesComunes.hpp"
#include "../include/ConfiguracionJuego.hpp"
#include "../include/Logo.hpp"
#include <iostream>
using namespace std;

void Menu::MostrarMenu() {
    ConfiguracionJuego configuracion;  // Declaración de la configuración del juego
    int opcion = 0;  // Variable para almacenar la opción seleccionada por el usuario

    do {
        FuncionesComunes funciones;  // Creación de un objeto de funciones comunes
        funciones.LimpiarConsola();  // Limpiar la consola para mostrar un nuevo menú

        Logo logo;  // Creación de un objeto de logo
        logo.mostrarLogo();  // Mostrar el logo en la pantalla

        // Mostrar el menú principal
        cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n";
        cout << "          ║                                                                                1.Jugar                                                                             ║\n";
        cout << "          ║                                                                                                                                                                    ║\n";
        cout << "          ║                                                                                2.Reportes                                                                          ║\n";
        cout << "          ║                                                                                                                                                                    ║\n";
        cout << "          ║                                                                                3.Salir                                                                             ║\n";
        cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
        
        // Solicitar al usuario que seleccione una opción del menú
        cout << "\nSelecciona una opción: ";
        cin >> opcion;

        // Limpiar posibles errores de entrada y el buffer de la consola
        cin.clear();  
        cin.ignore(10000, '\n');  
        int cont=1;
        switch(opcion) {
            case 1: // Caso para iniciar el juego
                configuracion.iniciarPartida();  // Iniciar la partida
                cout << "\nSelecciona una opción: ";  // Mostrar nuevamente la solicitud de opción

                
                break;
            case 2: 
            funciones.LimpiarConsola();
                cont=1;
                cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"; 
                cout << "                                                                                            REPORTES\n";
                cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
            
                cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"; 
                cout << "           »  1.PALABRAS A JUGADA \n";
                cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
                
                while (true) {
                    std::string dato = configuracion.getPalabrasEncontradas().getPalabrasEncontradas().desempila() ;
                    if (dato.empty()) break; 
                    std::cout <<"          Palabra encontrada numero " << cont << ": "  << dato << std::endl;
                    cont++;
                }
                
                cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"; 
                cout << "           »  1.PALABRAS NO JUGADAS \n";
                cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
               
                    for (int i = 0; i < configuracion.getPalabrasNoEncontradas().getTamanoPalabras(); i++)
                    {
                        std::string dato = configuracion.getPalabrasNoEncontradas().getPalabras()[i];
                       
                        if (dato!=" ")
                        {
                            std::cout <<"          Palabra no encontrada:" << dato << std::endl;
                        }
                        
                      
                    }
                    

                    configuracion.puntajes();
                  
                  
                cin.ignore(10000, '\n');
                cin.get();
                
                break;
                
            default:  // Caso en el que la opción no es válida
                funciones.LimpiarConsola();  // Limpiar la consola
                funciones.MensajeNo1();  // Mostrar mensaje de error por opción no válida
                break;
        }

    } while (opcion != 3);  // El ciclo continuará hasta que el usuario seleccione la opción 3 (Salir)
}
