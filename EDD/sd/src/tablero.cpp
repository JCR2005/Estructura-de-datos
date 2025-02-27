#include "../include/tablero.hpp"
#include <iostream>
#include <cstring>
#include <string>
#include <random>
#include <algorithm>


using namespace std;

 Pila& Tablero::getPalabrasEncontradas() {
      return palabrasEncontradas;
  }

void Tablero::AsignarFichas(char* l, int* puntajeLetras, int tamaño) {

    tam=tamaño;
    valor=puntajeLetras;
    letras=l;
}

void Tablero::imprimirTablero(){

        for (int i = 0; i < 18; i++) {
            cout << "                                                                ";
            for (int j = 0; j < 18; j++) {                                               
            
                    cout << tablero[i][j]+"";  
            }
            cout << "\n";
        }
       
}

void Tablero::agregarFicha(Jugador* j,std::string* palabras, int num) {
    int x, y, id;
    std::string letra;
    int opcion;

    cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"; 
    cout << "           »ingrese el id de su ficha \n";
    cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
    cout << "\ningrese el id aqui: ";
    
     do {
        cout << "\nIngrese el ID aquí: ";
        if (!(cin >> id)) {
            cout << "Error: Debe ingresar un número válido para el ID.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            continue;
        }

        if (j->getFichas().buscar(id) == nullptr) {
            cout << "Error: El ID ingresado no existe en su lista de fichas. Intente de nuevo.\n";
        } else {
            break;
        }
    } while (true);
    
 
    while (true) {
        funciones.LimpiarConsola();      
        
        imprimirTablero();

        cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"; 
        cout << "           »ingrese la fila a colocar su ficha \n";
        cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
        cout << "\ningrese su fila aqui: ";
        
        while (!(cin >> x) || x < 0 || x > 18) {
            cout << "Error: Debe ingresar un número entre 0 y 16.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Ingrese nuevamente la fila: ";
        }

        cout << "          ╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗\n"; 
        cout << "           »ingrese la columna a colocar su ficha \n";
        cout << "          ╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝\n";
        cout << "\ningrese su columna aqui: ";

        while (!(cin >> y) || y < 0 || y > 18) {
            cout << "Error: Debe ingresar un número entre 0 y 16.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Ingrese nuevamente la columna: ";
        }

     
        if ((x + 1)> 17 && (y + 1) > 17) {
            cout << "Error: La suma de la fila y la columna no puede ser mayor a 15.\n";
            cout << "\nPresiona Enter Continuar...";
            cin.ignore();
            cin.get(); 
            continue; 
        }

        cout << tablero[x + 1][y + 1] +"\n";
        if ( tablero[x + 1][y + 1] != "░░ " ) {
            cout << "Error: No se puede colocar la ficha en esta posición (bloqueado, fuera de tablero o contiene una letra).\n";
            cout << "\nPresiona Enter Continuar...";
            cin.ignore();
            cin.get();            
            continue; 
        }

        break; 
    }

   
    letra = j->getFichas().buscar(id)->getLetraAsignada();
    
    tablero[x + 1][y + 1] = letra + "  ";

    
 
    do
    {
    funciones.LimpiarConsola();
    imprimirTablero();

    funciones.MensajeNo7();

     cin >> opcion;
    
        cin.clear(); 
        cin.ignore(10000, '\n');  

        switch(opcion) {
            case 1: {
              j->getFichas().buscar(id)->setPosicionX(x + 1);
              j->getFichas().buscar(id)->setPosicionY(y + 1);
              

              j->getFichas().eliminarElemento(id);
                j->setFichasRestantes(j->getFichasRestantes()-1);
                
                verificarPalabrasHorizonal(j,palabras,x+1,y+1,num);
                verificarPalabrasVertical(j,palabras,x+1,y+1,num);

            }
                break;
            case 2:

                funciones.MensajeNo8(j->getNombre());

               
                    cin >> opcion;
                    
                    cin.clear(); 
                    cin.ignore(10000, '\n');  

                    switch(opcion) {
                        case 1: {
                            tablero[x + 1][y + 1] = "░░ ";
                            funciones.MensajeNo9();
                            opcion = 2;  
                            return;
                        }
                         case 2: {
                            
                           
                           break;
                        }
                        
                        default:
                            funciones.LimpiarConsola();
                            funciones.MensajeNo1();
                    }
               


                break;
        
            default:
                
                funciones.LimpiarConsola();
                funciones.MensajeNo1();
            
        }
    } while (opcion != 1);
    

}



       
void Tablero::verificarPalabrasHorizonal(Jugador* j,std::string* pala, int x, int y,int num){
        std::string cadenaIzqHori = "";
        std::string cadenaDerHori = "";
        std::string palabra="";
        std::string izq=" ";
        std::string der=" ";

        int cont = 1;

       
        while ((y - cont) >= 2 && 
            tablero[x][y - cont] != "░░ " &&
            tablero[x][y - cont] != "▆▆ " &&
            tablero[x][y - cont] != "▓▓ ") {
            
            cadenaIzqHori = tablero[x][y - cont] + cadenaIzqHori;
            cont++;
        }

        cont = 1;  

      
        while ((y + cont) < 18 && 
            tablero[x][y + cont] != "░░ " &&
            tablero[x][y + cont] != "▆▆ " &&
            tablero[x][y + cont] != "▓▓ ") {
            
            cadenaDerHori += tablero[x][y + cont]; 
            cont++;
        }

        palabra=cadenaIzqHori+ tablero[x][y] +cadenaDerHori;
        palabra.erase(std::remove(palabra.begin(), palabra.end(), ' '), palabra.end());

          cadenaDerHori=tablero[x][y]+cadenaDerHori;
         cadenaIzqHori=cadenaIzqHori+tablero[x][y];
           cadenaIzqHori.erase(std::remove(cadenaIzqHori.begin(), cadenaIzqHori.end(), ' '), cadenaIzqHori.end());
            cadenaDerHori.erase(std::remove(cadenaDerHori.begin(), cadenaDerHori.end(), ' '), cadenaDerHori.end());
        buscarPalabras(j,palabra,pala,num);
        buscarPalabras(j,cadenaDerHori,pala,num);
         buscarPalabras(j,cadenaIzqHori,pala,num);

        

      
        


}


       
void Tablero::verificarPalabrasVertical(Jugador* j,std::string* pala, int x, int y,int num){
        std::string cadenaIzqHori = "";
        std::string cadenaDerHori = "";
        std::string palabra="";
        int cont = 1;

       
        while ((x - cont) >= 2 && 
            tablero[x- cont][y ] != "░░ " &&
            tablero[x- cont][y] != "▆▆ " &&
            tablero[x- cont][y] != "▓▓ ") {
            
            cadenaIzqHori = tablero[x- cont][y] + cadenaIzqHori;
            cont++;
        }

        cont = 1;  

      
        while ((x + cont) < 18 && 
            tablero[x+ cont][y] != "░░ " &&
            tablero[x+ cont][y] != "▆▆ " &&
            tablero[x+ cont][y] != "▓▓ ") {
            
            cadenaDerHori += tablero[x+ cont][y]; 
            cont++;
        }

        palabra=cadenaIzqHori+ tablero[x][y] +cadenaDerHori;
        palabra.erase(std::remove(palabra.begin(), palabra.end(), ' '), palabra.end());
         cadenaDerHori=tablero[x][y]+cadenaDerHori;
         cadenaIzqHori=cadenaIzqHori+tablero[x][y];
        buscarPalabras(j,palabra,pala,num);
         buscarPalabras(j,cadenaDerHori,pala,num);
          buscarPalabras(j,cadenaIzqHori,pala,num);
      
        


}

void Tablero::buscarPalabras( Jugador* ju,std::string texto, std::string* palabras, int numPalabras) {

    funciones.LimpiarConsola();
    int n = texto.size();    
    std::string prueba="";
    std::cout << n <<numPalabras  << "\n";    
    char caracteres[n + 1];  
    
    std::strcpy(caracteres, texto.c_str());
    int punteo=0;
    for (int i = 0; i < n; i++) {
        prueba = prueba+caracteres[i];

        for (int j = 0; j < numPalabras; j++) {

            if (prueba==palabras[j])
            {   

                for (int q = 0; q < n; q++)
                {
                    for (int p = 0; p < tam; p++)
                    {
                        if (caracteres[q]==letras[p])
                        {
                            punteo=punteo+valor[p];


                        }
                        
                    }
                    
                }
                palabrasEncontradas.agregarDatos(palabras[j]);
                palabras[j]="";
                ju->setPuntaje(ju->getPuntaje()+punteo);
                std::cout << punteo << ", \n";
                std::cout << palabras[j] << ", \n";
                std::cout << prueba << ", ";
                std::cout << palabras[j] << ", \n";
                funciones.MensajeNo10(prueba,punteo);
            }
        }
    }
     prueba="";
     for (int i = 0; i < n; i++) {
        prueba =caracteres[i]+ prueba;

        for (int j = 0; j < numPalabras; j++) {

            if (prueba==palabras[j])
            {   

                for (int q = 0; q < n; q++)
                {
                    for (int p = 0; p < tam; p++)
                    {
                        if (caracteres[q]==letras[p])
                        {
                            punteo=punteo+valor[p];


                        }
                        
                    }
                    
                }
                palabrasEncontradas.agregarDatos(palabras[j]);
                palabras[j]="";
                ju->setPuntaje(ju->getPuntaje()+punteo);
                std::cout << punteo << ", \n";
                std::cout << palabras[j] << ", \n";
                std::cout << prueba << ", ";
                std::cout << palabras[j] << ", \n";
                funciones.MensajeNo10(prueba,punteo);
            }
        }
    }
    prueba="";
    for (int i = n - 1; i >= 0; i--) { 
        prueba =  prueba+caracteres[i] ;  

        for (int j = 0; j < numPalabras; j++) {  
            if (prueba == palabras[j]) {  
                 for (int q = 0; q < n; q++)
                {
                    for (int p = 0; p < tam; p++)
                    {
                        if (caracteres[q]==letras[p])
                        {
                            punteo=punteo+valor[p];
                        }
                        
                    }
                    
                }

                 palabrasEncontradas.agregarDatos(palabras[j]);
                 funciones.MensajeNo10(prueba,punteo);
                palabras[j]="";
                ju->setPuntaje(ju->getPuntaje()+punteo);
                std::cout << punteo << ", \n";
                std::cout << palabras[j] << ", \n";
                std::cout << prueba << ", ";
                std::cout << palabras[j] << ", \n";
            }
        }
    }
 prueba="";
    for (int i = n - 1; i >= 0; i--) { 
        
        prueba =  caracteres[i]+prueba ;  

        for (int j = 0; j < numPalabras; j++) {  
            if (prueba == palabras[j]) {  
                 for (int q = 0; q < n; q++)
                {
                    for (int p = 0; p < tam; p++)
                    {
                        if (caracteres[q]==letras[p])
                        {
                            punteo=punteo+valor[p];
                        }
                        
                    }
                    
                }

                 palabrasEncontradas.agregarDatos(palabras[j]);
                 funciones.MensajeNo10(prueba,punteo);
                palabras[j]="";
                ju->setPuntaje(ju->getPuntaje()+punteo);
                std::cout << punteo << ", \n";
                std::cout << palabras[j] << ", \n";
                std::cout << prueba << ", ";
                std::cout << palabras[j] << ", \n";
            }
        }
    }
    std::cout << "\n"; 
 
}

void Tablero::crearTablero(){
   
     for (int i = 0; i < 18; i++) {
        for (int j = 0; j < 18; j++) {

            tablero[1][0]="   ";
            tablero[0][0]="    ";
            if (i==0 && j<17)
            {
                if (j<10)
                {
                  tablero[0][j+1]=" "+std::to_string(j)+" ";
                }else{
                    tablero[0][j+1]=std::to_string(j)+" ";
                }
                
                 
            }else if (j==0 && i<17)
            {
                 if (i<10)
                {
                  tablero[i+1][0]=" "+std::to_string(i)+" ";
                }else{
                     tablero[i+1][0]=" "+std::to_string(i);
                }
                

            }else if ((i == 1 || i == 17 || j == 1 || j == 17)&&(j!=0)) {
                tablero[i][j] = "▆▆ ";  
            } else {
                tablero[i][j] = "░░ ";  
            }
        }
    }
     tablero[0][0]="   ";
     tablero[17][0]="   ";
     tablero[0][17]="   ";

      int cont=0;
    
    int x[15];
    int y[15];
    std::random_device rd;  
    std::mt19937 gen(rd()); 

    std::uniform_int_distribution<> distrib(2, 16);
    while (cont<10)
    {
            if (tablero[distrib(gen)][distrib(gen)]!="▓▓ ")
            {
                cont++;
                tablero[distrib(gen)][distrib(gen)]="▓▓ ";
            }
        
    }


}



