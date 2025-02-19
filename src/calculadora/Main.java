package calculadora;

import java.util.Scanner;

/**
 * Este es el punto de entrada del programa. Únicamente dispone de un método mostrarMenu además del método main, desde
 * el cual se comenzará la ejecución y desde dónde llamaremos a mostrarMenu.
 *
 * @author Casandra
 * @version 0.0.1
 */
public class Main {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    /**
     * Punto de entrada de la aplicación. Desde aquí se llamará al menu.
     *
     * @param args No se contempla el uso de argumentos de ejecución.
     */
    public static void main(String[] args) {
        mostrarMenu();
    }

    /**
     * Este método mostrará el menú principal de la aplicación. Consiste en un menú muy sencillo al que se deberán
     * agregar opciones según se implementen nuevas clases. Está pensado para actuar como un menú principal desde el
     * cual se accederá a diferentes submenús (uno por cada clase) desde los cuales se ejecutarán los métodos de dichas
     * clases. Además ofrece una opción para salir de la aplicación.
     */
    public static void mostrarMenu() {
        System.out.println("Menú principal:");
        System.out.println("1. Ejecutar una suma");
        System.out.println("2. Salir");
        System.out.println("Escoja una opción...");
        int opcion = entradaTeclado.nextInt();
        switch (opcion) {
            case 1:
                Suma.mostrarMenu();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no disponbile.");
                mostrarMenu();
                break;
        }
    }
}