#include "../include/ConfiguracionJuego.hpp"

#include "../include/QuickSort.hpp"
#include <iostream>
using namespace std;


Tablero& ConfiguracionJuego::getPalabrasEncontradas() {
    return tablero;
}

CargaDeArchivo& ConfiguracionJuego::getPalabrasNoEncontradas() {
    return cargaArchivo;
}

void ConfiguracionJuego::iniciarPartida(){
    cargaArchivo.CargarArchivo();
    añadirJugadores();
    Partida();
    cout << "";
            
}

void ConfiguracionJuego::añadirJugadores(){
    configJujadores.configuracion();
    configJujadores.configuracionFichas(cargaArchivo.getLetrasTotales(),cargaArchivo.getTamañoTotalLetras());
    configJujadores.AsignarFichas(cargaArchivo.getLetras(),cargaArchivo.getPuntajeLetras(),cargaArchivo.getTamanoArregloLetra());
}

void ConfiguracionJuego::Partida(){

    
   
 
    
    tablero.crearTablero();
    tablero.AsignarFichas(cargaArchivo.getLetras(),cargaArchivo.getPuntajeLetras(),cargaArchivo.getTamanoArregloLetra());
    ColaCircular colaCircular(configJujadores.getTurnos(),configJujadores.getNumeroDeJugadores());
    colaCircular.mezclarCola();

    int numeroFichas=configJujadores.getTotalFichasRepartir()/configJujadores.getNumeroDeJugadores();    

    while (true) {
        bool sinPalabras = true;
        int turno = colaCircular.desencolar();
        Jugador* jugador = configJujadores.getJugadores().buscar(turno);
        int fichares=jugador->getFichasRestantes();
        ordenarFichas(jugador,configJujadores.getTotalFichasRepartir(),numeroFichas);
       
        funciones.MensajeNo5(jugador->getNombre(),jugador->getPuntaje());
        int c=0;
        funciones.MensajeNo20();
        cout << "          ║" ;
        for (int i = 0; i < cargaArchivo.getTamanoPalabras(); i++)
        {
            if (c<30)
            {
                cout << cargaArchivo.getPalabras()[i] << "║ ";
                c++;
            }else{
                cout << "║" << cargaArchivo.getPalabras()[i] << "║\n";
                c=0;
            }
        }
         cout << "\n";
        tablero.imprimirTablero();
        string  cadena_1="          ";
        string  cadena_2="          ";
        string  cadena_3="          ";
        string  cadena_4="          ";
        string  cadena_5="          ";
         int cont=1;
         int cont_1=0;
        
         cout << "         ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n";
        for (int i = 1; i < configJujadores.getTotalFichasRepartir()+1; i++)
        {
          
            if (jugador) {
                Ficha* ficha = jugador->getFichas().buscar(ids[i]);
                
                if (ficha) {
                     cont_1++;
                 
                    if (ficha->getId()<10)
                    {
                            

                         if (cont>10 || cont_1==fichares)
                         {
                            cadena_4=cadena_4+"╔════╦═══╦═══╗\n";
                            cadena_5=cadena_5+"⌨ ID ║ ✎ ║PTS║\n";
                            cadena_1=cadena_1+"╠════╦═══╦═══╣\n";
                            cadena_2=cadena_2+"  0"+to_string(ficha->getId()) +" ║ "+ficha->getLetraAsignada()+" ║ "+to_string(ficha->getValor())+" ║\n";
                            cadena_3=cadena_3+"╚════╩═══╩═══╝\n";
                            cont=1;

                            cout <<cadena_4;
                            cout <<cadena_5;
                            cout <<cadena_1;
                            cout <<cadena_2;
                            cout <<cadena_3;

                            cadena_1="          ";
                            cadena_2="          ";
                            cadena_3="          ";
                            cadena_5="          ";
                            cadena_4="          ";

                            
                         } else{
                            
                            cadena_4=cadena_4+"╔════╦═══╦═══╗ ";
                            cadena_5=cadena_5+"⌨ ID ║ ✎ ║PTS║ ";
                            cadena_1=cadena_1+"╠════╦═══╦═══╣ ";
                            cadena_2=cadena_2+"  0"+to_string(ficha->getId()) +" ║ "+ficha->getLetraAsignada()+" ║ "+to_string(ficha->getValor())+" ║ ";
                            cadena_3=cadena_3+"╚════╩═══╩═══╝ ";
                            cont++;
                         }
                    } else if (ficha->getId()>99)
                    {
                            

                         if (cont>10 || cont_1==fichares)
                         {
                            cadena_4=cadena_4+"╔═════╦═══╦═══╗\n";
                            cadena_5=cadena_5+"⌨  ID ║ ✎ ║PTS║\n";
                            cadena_1=cadena_1+"╠═════╦═══╦═══╣\n";
                            cadena_2=cadena_2+"  "+to_string(ficha->getId()) +" ║ "+ficha->getLetraAsignada()+" ║ "+to_string(ficha->getValor())+" ║\n";
                            cadena_3=cadena_3+"╚═════╩═══╩═══╝\n";
                            cont=1;

                            cout <<cadena_4;
                            cout <<cadena_5;
                            cout <<cadena_1;
                            cout <<cadena_2;
                            cout <<cadena_3;

                            cadena_1="          ";
                            cadena_2="          ";
                            cadena_3="          ";
                            cadena_5="          ";
                            cadena_4="          ";

                            
                         } else{
                            cadena_4=cadena_4+"╔═════╦═══╦═══╗ ";
                            cadena_5=cadena_5+"⌨  ID ║ ✎ ║PTS║ ";
                            cadena_1=cadena_1+"╠═════╦═══╦═══╣ ";
                            cadena_2=cadena_2+"  "+to_string(ficha->getId()) +" ║ "+ficha->getLetraAsignada()+" ║ "+to_string(ficha->getValor())+" ║ ";
                            cadena_3=cadena_3+"╚═════╩═══╩═══╝ ";
                            cont++;
                         }
                    }else{
                        if (cont>10  || cont_1==fichares)
                         {  
                            cadena_4=cadena_4+"╔════╦═══╦═══╗\n";
                            cadena_5=cadena_5+"⌨ ID ║ ✎ ║PTS║\n";
                            cadena_1=cadena_1+"╠════╦═══╦═══╣\n";
                            cadena_2=cadena_2+"  "+to_string(ficha->getId()) +" ║ "+ficha->getLetraAsignada()+" ║ "+to_string(ficha->getValor())+" ║\n";
                            cadena_3=cadena_3+"╚════╩═══╩═══╝\n";
                            cont=1;
                            cout <<cadena_4;
                            cout <<cadena_5;
                            cout <<cadena_1;
                            cout <<cadena_2;
                            cout <<cadena_3;

                            cadena_1="          ";
                            cadena_2="          ";
                            cadena_3="          ";
                            cadena_5="          ";
                            cadena_4="          ";
                         }else{
                            cadena_4=cadena_4+"╔════╦═══╦═══╗ ";
                            cadena_5=cadena_5+"⌨ ID ║ ✎ ║PTS║ ";
                            cadena_1=cadena_1+"╠════╦═══╦═══╣ ";
                            cadena_2=cadena_2+"  "+to_string(ficha->getId()) +" ║ "+ficha->getLetraAsignada()+" ║ "+to_string(ficha->getValor())+" ║ ";
                            cadena_3=cadena_3+"╚════╩═══╩═══╝ ";
                            cont++;
                         }
                         
                    }
                    
                   
                }

            }

               
        }

       


         cout << "         ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";

        funciones.MensajeNo6();
        int opcion = 0;

        do {
          
            
            if (!(cin >> opcion)) {
                cout << "Error: Debe ingresar un número válido.\n";
                cin.clear(); 
                cin.ignore(10000, '\n');  
                continue;  
            }

            cin.ignore(10000, '\n');  

            if (opcion != 1 && opcion != 2) {
                cout << "Error: Opción no válida. Solo se permite 1 o 2.\n";
                continue;
            }

            switch (opcion) {
                case 1:
                    tablero.agregarFicha(jugador, cargaArchivo.getPalabras(),cargaArchivo.getTamanoPalabras());

                    if (jugador->getFichasRestantes()==0)
                    {
                        
                        funciones.MensajeNo12();
                        definirGanador();

                        return;
                    }
                      jugador->setSaltos(0);
                    
                    break;
                case 2:

                    jugador->setSaltos(jugador->getSaltos()+1);
                    
                    break;
            }
            
        } while (opcion != 1 && opcion != 2);  


        colaCircular.encolar(turno); 
        
        for (int i = 0; i < cargaArchivo.getTamanoPalabras(); i++) {
            if (!cargaArchivo.getPalabras()[i].empty()) {
                sinPalabras = false;
            }
        }

        if (sinPalabras) {
            funciones.MensajeNo11();
            definirGanador();
           return;
        }
            
   

       bool todosMayorIgualTres = true; 
        for (int i = 0; i < configJujadores.getNumeroDeJugadores(); i++) {
            Jugador* jugador = configJujadores.getJugadores().buscar(i);
            if (jugador == nullptr) {
                continue; 
            }

            if (jugador->getSaltos() < 3) {
                todosMayorIgualTres = false; 
                break; 
            }
        }

        if (todosMayorIgualTres) {
            funciones.MensajeNo13();
            definirGanador();
            return; 
        }

    
    }


}
void ConfiguracionJuego::definirGanador() {
    int numJugadores = configJujadores.getNumeroDeJugadores();
    puntaje = new int[numJugadores + 1];  
    std::string nombre;

    for (int i = 0; i < numJugadores; i++) {
        Jugador* jugador = configJujadores.getJugadores().buscar(i + 1);  
        if (jugador != nullptr) { 
            cout << jugador->getPuntaje() << "" << endl;
            cout << jugador->getNombre() << " " << endl;
            puntaje[i + 1] = jugador->getPuntaje();  
            cin.get();  
        }
    }
  
    MergeSort e;
    e.mergeSort(puntaje, 1, numJugadores);  

    
    for (int i = 1; i <= numJugadores; i++) {
        Jugador* jugador = configJujadores.getJugadores().buscar(i);  
        if (jugador->getPuntaje() == puntaje[numJugadores]) {  
            nombre = jugador->getNombre();
        }
    }

    
    funciones.MensajeNo14(nombre, puntaje[numJugadores]);

    cin.get();  
}

void ConfiguracionJuego::puntajes(){
    int numJugadores = configJujadores.getNumeroDeJugadores();
      
    cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"; 
    cout << "           » El ganador es  \n";
    cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
   
    for (int i = 1; i <= numJugadores; i++) {
        Jugador* jugador = configJujadores.getJugadores().buscar(i);  
        
        for (int h = 0; h < numJugadores; h++)
        {
            if (jugador->getPuntaje() == puntaje[h]) {  
            
                cout  << "           » Nombre: "<< jugador->getNombre() <<"|" << endl;
                cout  << "           » Puntaje "<< jugador->getPuntaje()  << "|" << endl;
            }
        }
        
        
        
    }


}


void ConfiguracionJuego::ordenarFichas(Jugador* j, int numFichasTotales,int numFichas){
    int cont=0;
    Ficha* ficha;
    int* valorFichasOrdenados = new int[numFichas]; 
    int* idsOrdenados = new int[numFichas];
    ids = new int[numFichas];

     for (int i = 1; i < numFichasTotales+1; i++)
        {
            if (j) {
                 ficha = j->getFichas().buscar(i);
                if (ficha) {
                    valorFichasOrdenados[cont]=ficha->getValor();
                    idsOrdenados[cont]=ficha->getId();

                    cont++;
                }
            }
        }

    MergeSort ordenar;
    ordenar.mergeSort(valorFichasOrdenados,0,numFichas);
    ordenar.mergeSort(idsOrdenados,0,numFichas);

    for (int i = 1; i < numFichas+1; i++)
    {
        for (int q = 1; q < numFichas+1; q++)
            
        {
            ficha  = j->getFichas().buscar(idsOrdenados[q]);

            if (ficha)
            {
                if (ficha->getValor()==valorFichasOrdenados[i])
                {

                    ids[i]=idsOrdenados[q];
                    idsOrdenados[q]=0;
                break;
                }
            }
        }
          
    }

   
}