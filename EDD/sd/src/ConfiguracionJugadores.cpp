#include "../include/ConfiguracionJugadores.hpp"
#include <iostream>
#include <cstdlib>  // Para rand() y srand()
#include <ctime>    // Para time()
#include <random> 
using namespace std;

// Método principal para configurar los jugadores
void ConfiguracionJugadores::configuracion() {
    crearJugadores();
}

// Solicita al usuario el número de jugadores (entre 2 y 10), luego crea una instancia
// de cada jugador, asignando su nombre y número de turno, y agrega cada jugador al contenedor 'jugadores'.
// El proceso se repite hasta que se hayan creado todos los jugadores especificados por el usuario.
void ConfiguracionJugadores::crearJugadores() {
    int cont = 0;
    std::string nombre_n;
    
    do {
        funcion.LimpiarConsola();
        funcion.MensajeNo3();
        cout << "Ingrese el número de jugadores (mínimo 2, máximo 10)...: ";
        cin >> numeroDeJugadores;
        cin.ignore();
    } while (numeroDeJugadores < 2 || numeroDeJugadores > 10);
    
    turnos = new int[numeroDeJugadores];

    while (cont < numeroDeJugadores) {
        cont++;
        funcion.LimpiarConsola();
        funcion.MensajeNo4(cont);
        cin >> nombre_n;

        Jugador* jugador = new Jugador(nombre_n, cont);
        turnos[cont - 1] = cont;
        jugadores.agregar(jugador);
        
    }
}


// Método para mezclar las fichas aleatoriamente
void ConfiguracionJugadores::mezclarFichas(char letra[], int tamaño) {
    srand(time(0)); 

    for (int i = tamaño - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        swap(letra[i], letra[j]); 
    }
}

// El método tiene como objetivo organizar y distribuir las fichas de manera equitativa entre los jugadores,
// asegurando que cada uno reciba al menos 4 fichas. También ajusta el número total de fichas y comodines según el número de jugadores,
// y garantiza que el total de fichas sea un múltiplo del número de jugadores.
void ConfiguracionJugadores::configuracionFichas(char letra[], int t) {
    totalFichasEntrantes = t;

    int multiplo_mayor = ((t + numeroDeJugadores - 1) / numeroDeJugadores) * numeroDeJugadores;
    int comodines = multiplo_mayor - t;
    int totalFichas = t + comodines;

    while ((totalFichas / numeroDeJugadores) < 4) {
        totalFichas += numeroDeJugadores;
        comodines += numeroDeJugadores;
    }

    fichasPorJugador = totalFichas / numeroDeJugadores;

    totalFichasRepartir = totalFichas;
    totalComodines = comodines;

    letras = letra; 
}


// El método tiene como objetivo asignar fichas a los jugadores en función de las letras disponibles y su puntaje,
// distribuyendo las fichas equitativamente entre ellos y asignando comodines de manera aleatoria.
void ConfiguracionJugadores::AsignarFichas(char l[], int puntajeLetras[], int tamaño) {
    int cont = 1;
   
    for (int i = 0; i < totalFichasEntrantes; i++) {
        for (int j = 0; j < tamaño; j++) {
            if (letras[i] == l[j]) {
                Ficha* nuevaFicha = new Ficha(letras[i], puntajeLetras[j],i+1);
                Jugador* jugadorEncontrado = jugadores.buscar(cont);

                if (jugadorEncontrado) {
                    jugadorEncontrado->getFichas().agregar(nuevaFicha);
                } else {
                    cout << "Error: Jugador con ID " << cont << " no encontrado." << endl;
                }
            }
        }

        cont = (cont % numeroDeJugadores) + 1;
    }

    for (int i = 1; i < numeroDeJugadores+1; i++)
    {
        Jugador* jugadorEncontrado = jugadores.buscar(i);
        jugadorEncontrado->setFichasRestantes(fichasPorJugador);
    }
        std::random_device rd;  
        std::mt19937 gen(rd()); 
        std::uniform_int_distribution<> dis(0, totalFichasEntrantes-1); 
        std::uniform_int_distribution<> dist(1, 9);
        
    for (int i = 0; i < totalComodines; i++) {
         int numeroAleatorio = dis(gen);
         int numeroAleatorio2 = dist(gen);
        Ficha* nuevaFicha = new Ficha(letras[numeroAleatorio], puntajeLetras[numeroAleatorio2],i + 1 +totalFichasEntrantes);
        Jugador* jugadorEncontrado = jugadores.buscar(cont);
        
        if (jugadorEncontrado) {
            jugadorEncontrado->getFichas().agregar(nuevaFicha);
        } else {
            cout << "Error: Jugador con ID " << cont << " no encontrado." << endl;
        }

        cont = (cont % numeroDeJugadores) + 1;
    }
}

// Devuelve una referencia a la lista de jugadores, evitando copias innecesarias.
// Esto permite modificar la lista directamente desde donde se llame a la función.
ListaObjetos<Jugador>& ConfiguracionJugadores::getJugadores() {
    return jugadores;
}

// Retorna el número total de jugadores configurados.
// La función es constante, lo que significa que no modifica el estado del objeto.
int ConfiguracionJugadores::getNumeroDeJugadores() const {
    return numeroDeJugadores;
}

// Devuelve el número total de fichas que se deben repartir entre los jugadores.
// También es una función constante, lo que garantiza que no altera el objeto.
int ConfiguracionJugadores::getTotalFichasRepartir() const {
    return totalFichasRepartir;
}

// Devuelve un puntero al arreglo de turnos.
// para evitar fugas o accesos inválidos.
int* ConfiguracionJugadores::getTurnos() {
    return turnos;
}
