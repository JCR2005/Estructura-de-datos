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
        System.out.println("                                                                      ");
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

    public void pedirTipo() {
        limpiarConsola();
        System.out.println("::::::::::::::::::::::::::::::VEHICULO::::::::::::::::::::::::::::::::");
        System.out.println("                   Ingrese el tipo de su vehiculo                     ");
        System.out.println("                                                                      ");
        System.out.println("            (AMBULANCIA, POLICIA, PARTICULAR, TRANSPORTE)             ");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("Ingrese el tipo aqui: ");
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
}
