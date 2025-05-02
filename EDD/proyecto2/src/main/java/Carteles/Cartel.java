package Carteles;

import java.util.Scanner;

/**
 *
 * @author carlos
 */
public class Cartel {

    private Scanner entrada = new Scanner(System.in);

    public void limpiarConsola() {

        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }

    }

    public void menuPrincipal() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::MENU PRINCIPAL::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("                              1.Iniciar                               ");
        System.out.println("                              2.Reporte                               ");
        System.out.println("                              3.Salir                                 ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese su opción aqui: ");
    }

    public void menuPedirTamañoCiudad() {
        limpiarConsola();
        System.out.println(":::::::::::::::::::::::CONFIGURACION__INICIAL:::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("               Ingrese el tamaño de la ciudad(fxc)                    ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese el tamaño aqui: ");
    }

    public void pedirIngresarDeNuevoTamaño() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::ADVERTENCIA!::::::::::::::::::::::::::::::");
        System.out.println("                     Su tamaño es menor a 10                          ");
        System.out.println("                      (Vuelva a intentarlo)                        ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("precione enter para continuar");
        entrada.nextLine();
    }

    public void pedirIngresarBienPlaca() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::ADVERTENCIA!::::::::::::::::::::::::::::::");
        System.out.println("          El numero de placa cuenta con 8 caracteres al menos         ");
        System.out.println("                      (Vuelva a intentarlo)                           ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("precione enter para continuar");
        entrada.nextLine();
    }

    public void pedirIngresarUnTipoValido() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::ADVERTENCIA!::::::::::::::::::::::::::::::");
        System.out.println("             El tipo de vehiculo ingresado no es valido               ");
        System.out.println("                      (Vuelva a intentarlo)                           ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("precione enter para continuar");
        entrada.nextLine();
    }

    public void pedirIngresarNumeroValido() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::ADVERTENCIA!::::::::::::::::::::::::::::::");
        System.out.println("                   Debe ingresar un valor numerico                    ");
        System.out.println("                      (Vuelva a intentarlo)                           ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("precione enter para continuar");
        entrada.nextLine();
    }

    public void menuPedirVehiculos() {
        limpiarConsola();
        System.out.println(":::::::::::::::::::::::CONFIGURACION__INICIAL:::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("                  1.Ingreso manual de vehiculos                       ");
        System.out.println("                                                                      ");
        System.out.println("                  2.Ingreso automatico con archivo                    ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese el tamaño aqui: ");
    }

    public void pedirPlaca() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                   Ingrese la placa de su vehiculo                    ");
        System.out.println("                                                                      ");
        System.out.println("       (Cabe recalcar, que al introducir una placa ya registrada,     ");
        System.out.println("    no se tomara como nuevo vehiculo solo se actualizaran su datos)   ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese la placa aqui: ");
    }

    public void pedirPlacaBusqueda() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("                   Ingrese la placa de su vehiculo                    ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese la placa aqui: ");
    }

    public void pedirTipo() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                   Ingrese el tipo de su vehiculo                     ");
        System.out.println("                                                                      ");
        System.out.println("            (AMBULANCIA, POLICIA, PARTICULAR, TRANSPORTE)             ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese el tipo aqui: ");
    }

    public void pedirDestino() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("                 Ingrese el su interseccion destino                   ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public void pedirOrgen() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("                 Ingrese el su interseccion origen                   ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public void pedirNivelUrgencia() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                    Ingrese el nivel de urgencia                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese el nivel de urgencia aqui: ");
    }

    public void pedirTiempoEspera() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                     Ingrese el tiempo de espera                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese el tiempo aqui: ");
    }

    public void pedirIngreserOtro() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("                     Desea ingresar otro vehiculo                     ");
        System.out.println("                                                                      ");
        System.out.println("                                1.si                                  ");
        System.out.println("                                2.no                                  ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public void pedirRutaArchivo() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::: ARCHIVO ::::::::::::::::::::::::::::::::");
        System.out.println("                   Ingrese la ruta de su archivo                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public void pedirIngresarDeNuevoRuta() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::ADVERTENCIA!::::::::::::::::::::::::::::::");
        System.out.println("                   Archivo no encontrado,verifique                    ");
        System.out.println("                          la ruta ingresada                           ");
        System.out.println("                        (Vuelva a intentarlo)                         ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("precione enter para continuar");
        entrada.nextLine();
    }

    public void menuSimulacion() {

        System.out.println("\n:::::::::::::::::::::::::::::" + ":::::::::::::::::::::::::::::::::::::::::::::::::::::::MENU SIMULACION::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("         INDICADORES        |" + "                                                                      ");
        System.out.println("        (conplejidad)       |" + "                                             1.Obtener informacion de intersección                ");
        System.out.println("                            |" + "                                             2.DeshacerMovimiento                ");
        System.out.println(" Critico:     \u001B[105m\u001B[30m 7.. \u001B[0m         |" + "                                             3.Buscar vehiculo                ");
        System.out.println(" Aceptable:   \u001B[106m\u001B[30m 4-7 \u001B[0m         |" + "                                             4.Continuar simulacion                ");
        System.out.println(" Exelente:    \u001B[104m\u001B[30m 0-3 \u001B[0m         |" + "                                             5.Imprimir arbol avl                          ");
        System.out.println("                            |" + "                                             6.Terminar simulacion                                  ");
        System.out.println("                            |" + "                                                                      ");
        System.out.println(":::::::::::::::::::::::::::::" + "::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese su opción aqui: ");
    }

    public void menuSeleccionInterseecion() {
        System.out.println("\n:::::::::::::::::::::::::SELECCIONAR NODOS::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("          Ingrese su interseccion de la que desea administrar         ");
        System.out.println("                              (A1, C3)                                ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public void menuInteraccionInterseccion(String interseccion, String parte1, String parte2, String ubicacion, int conplejidad, boolean estado, boolean verde) {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::INTERACCION INTERSECCION::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("  UBICACION DE INTERSECCION :    " + ubicacion);
        System.out.println("COMPLEJIDAD DE INTERSECCION :    " + colocarColorComplejidad(conplejidad) + conplejidad + "\u001B[0m");
        System.out.println("            ESTADO SEMAFORO :    " + ColorSemaforo(estado, verde));
        System.out.println("                                                                      ");
        System.out.println("                              " + parte2);
        System.out.println("INTERSECCIÓN SELECCIONADA :   " + interseccion);
        System.out.println("                              " + parte1);
        System.out.println("                                                                      ");
    }

    public String ColorSemaforo(boolean estado, boolean verde) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_VERDE = "\u001B[32m";
        final String ANSI_ROJO = "\u001B[31m";
        final String CUADRO = "■";

        if (estado) {
            if (verde) {
                return ANSI_VERDE + CUADRO + ANSI_RESET;
            } else {
                return ANSI_ROJO + CUADRO + ANSI_RESET;
            }
        } else {
            return "Inhabilitado";
        }
    }

    public void menuInterseccion() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("                      1.Ver colas                                     ");
        System.out.println("                      2.Configurar semaforo                           ");
        System.out.println("                      4.Regresar                                      ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public void menuReportes() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
        System.out.println("               1.Vehiculos por tiempo Promedio de espera              ");
        System.out.println("               2.Vehiculos por prioridad                              ");
        System.out.println("               3.Vehiculos por tiempo de espera                       ");
        System.out.println("               4.Placas has duplicada                                 ");
        System.out.println("               5.Arbol de complejidad de intersecciones               ");
        System.out.println("               6.Ver ultimos 20 movimientos de simulacion             ");
        System.out.println("               7.Regresar                                             ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public void menuColas() {
        limpiarConsola();
        System.out.println(":::::::::::::::::::::::::INTERACCION COLAS::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
    }

    public void menuCola(String nombreCola, int complejidad, String estado) {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(" ·" + nombreCola.toUpperCase() + "                                    ");
        System.out.println("                                                                      ");
        System.out.println(" Complejidad de la cola:  " + colocarColorComplejidad(complejidad) + complejidad + "\u001B[0m");
        System.out.println("                                                                      ");
        System.out.println("                      1.Ver vehiculos en cola                         ");
        System.out.println("                      5.Regresar                                      ");
        System.out.println("                                                                      ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese aqui: ");
    }

    public String colocarColorComplejidad(int conplejidad) {

        if (conplejidad < 4) {
            return "\u001B[34m" + "Exelente | ";
        } else if (conplejidad < 7) {
            return "\u001B[36m" + "Aceptable | ";
        } else if (conplejidad >= 7) {
            return "\u001B[35m" + "Critico | ";
        }
        return "";

    }

    public String colocarColorComplejidadFondo(int complejidad) {
        String reset = "\u001B[0m";

        if (complejidad == 0) {
            return "\u001B[100m\u001B[97m";
        } else if (complejidad < 4) {
            return "\u001B[104m\u001B[30m";
        } else if (complejidad < 7) {
            return "\u001B[106m\u001B[30m";
        } else {
            return "\u001B[105m\u001B[30m";
        }
    }

    public void mostrarVehiculos() {
        limpiarConsola();
        System.out.println(":::::::::::::::::::::::::VEHICULOS EN COLA::::::::::::::::::::::::::::");
        System.out.println("                                                                      ");
    }

    public void mostrarVehiculosp2() {
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("precione enter para continuar");
        entrada.nextLine();
    }

}
