import java.util.Scanner;

/**
 * Este es el punto de entrada del programa. Únicamente dispone de un método mostrarMenu además del método main, desde
 * el cual se comenzará la ejecución y desde dónde llamaremos a mostrarMenu.
 *
 * @author Casandra
 * @version 0.0.1
 */
public class Calculadora {

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
        System.out.println("Bienvenido a la Calculadora");
        System.out.println("1. Ejecutar una suma");
        System.out.println("2. Salir");
        Scanner entradaTexto = new Scanner(System.in);
        int opcion = entradaTexto.nextInt();
        switch (opcion) {
            case 1:
                Suma.mostrarMenu();
                break;
            case 2:
                System.exit(0);
        }
    }
}