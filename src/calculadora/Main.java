package calculadora;

import java.util.Scanner;

/**
 * Esta clase contiene el punto de entrada del programa así como el menú principal.
 *
 * @author Casandra
 * @author JC
 * @author Sandra
 * @author Mario
 * @author Carlos
 * @version 0.0.2
 */
public class Main {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    /**
     * Este método es el punto de entrada del programa.
     *
     * @param args No se esperan argumentos de ejecución.
     */
    public static void main(String[] args) {
        mostrarMenu();
    }

    /**
     * Este método contiene el menú principal de la aplicación. Cada opción de este menú conduce a un submenú ubicado en
     * una de las clases que conforman esta aplicación.
     */
    public static void mostrarMenu() {
        System.out.println("Menú principal:");
        System.out.println("1. Ejecutar una suma");
        System.out.println("2. Ejecutar un producto");
        System.out.println("3. Ejecutar una resta");
        System.out.println("4. Cociente");
        System.out.println("5. Salir");
        System.out.println("Escoja una opción...");
        int opcion = entradaTeclado.nextInt();
        switch (opcion) {
            case 1:
                Suma.mostrarMenu();
                break;
            case 2:
                Producto.mostrarMenu();
                break;
            case 3:
                Resta.mostrarMenu();
                break;
            case 4:
                Cociente.mostrarMenu();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no disponible.");
                mostrarMenu();
                break;
        }
    }
}