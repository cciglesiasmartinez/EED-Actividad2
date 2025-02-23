package calculadora;

import java.util.Scanner;

/**
 * Este es el punto de entrada del programa.
 * @author Casandra
 * @author JC
 * @version 0.0.2
 */
public class Main {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        System.out.println("Menú principal:");
        System.out.println("1. Ejecutar una suma");
        System.out.println("2. Ejecutar un producto");
        System.out.println("3. Salir");
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
                System.exit(0);
                break;
            default:
                System.out.println("Opción no disponible.");
                mostrarMenu();
                break;
        }
    }
}