package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase que implementa las operaciones de multiplicación y potencia para la calculadora.
 *
 * @author JC
 * @version 0.0.1
 */
public class Producto {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    /**
     * Multiplica dos números reales.
     *
     * @param a El primer número real.
     * @param b El segundo número real.
     * @return El producto de los dos números.
     */
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    /**
     * Multiplica dos números enteros.
     *
     * @param a El primer número entero.
     * @param b El segundo número entero.
     * @return El producto de los dos números.
     */
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Multiplica tres números reales.
     *
     * @param a El primer número real.
     * @param b El segundo número real.
     * @param c El tercer número real.
     * @return El producto de los tres números.
     */
    public static double multiplicar(double a, double b, double c) {
        return a * b * c;
    }

    /**
     * Calcula la potencia de un número (base elevado al exponente).
     *
     * @param base      La base.
     * @param exponente El exponente.
     * @return El resultado de la base elevada al exponente.
     */
    public static double elevar(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    /**
     * Muestra el submenú de la clase Producto, permitiendo al usuario seleccionar diferentes operaciones de multiplicación y potencia.
     */
    public static void mostrarMenu() {
        System.out.println("Submenú de Producto:");
        System.out.println("1. Multiplicar dos números reales");
        System.out.println("2. Multiplicar dos números enteros");
        System.out.println("3. Multiplicar tres números reales");
        System.out.println("4. Calcular potencia");
        System.out.println("5. Volver al menú principal");
        int opcion;

        while (true) {
            try {
                System.out.println("Escoja una opción: ");
                opcion = entradaTeclado.nextInt();
                entradaTeclado.nextLine(); // Consumir la nueva línea pendiente
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
                entradaTeclado.nextLine(); // Descartar la entrada incorrecta
            }
        }

        switch (opcion) {
            case 1:
                List<Double> dosParametrosReales = pedirParametros(2, Double.class);
                System.out.println("Resultado: " + multiplicar(dosParametrosReales.get(0), dosParametrosReales.get(1)));
                mostrarMenu();
                break;
            case 2:
                List<Integer> dosParametrosEnteros = pedirParametros(2, Integer.class);
                System.out.println("Resultado: " + multiplicar(dosParametrosEnteros.get(0), dosParametrosEnteros.get(1)));
                mostrarMenu();
                break;
            case 3:
                List<Double> tresParametrosReales = pedirParametros(3, Double.class);
                System.out.println("Resultado: " + multiplicar(
                        tresParametrosReales.get(0), tresParametrosReales.get(1), tresParametrosReales.get(2)));
                mostrarMenu();
                break;
            case 4:
                System.out.println("Introduce la base: ");
                double base = obtenerEntradaDouble();
                System.out.println("Introduce el exponente: ");
                double exponente = obtenerEntradaDouble();
                System.out.println("Resultado: " + elevar(base, exponente));
                mostrarMenu();
                break;
            case 5:
                Main.mostrarMenu();
                break;
            default:
                System.out.println("Opción no disponible.");
                mostrarMenu();
                break;
        }
    }

    /**
     * Solicita al usuario una lista de parámetros numéricos del tipo especificado.
     *
     * @param numeroParametros El número de parámetros a solicitar.
     * @param tipo             El tipo de los parámetros (Integer o Double).
     * @return Una lista de los parámetros introducidos por el usuario.
     * @param <TipoNumerico>   Tipo genérico que extiende la clase Number, para englobar valores Integer y Double.
     */
    private static <TipoNumerico extends Number> List<TipoNumerico> pedirParametros(
            int numeroParametros, Class<TipoNumerico> tipo) {
        List<TipoNumerico> parametros = new ArrayList<>();
        for (int i = 1; i <= numeroParametros; i++) {
            while (true) {
                try {
                    if (tipo == Double.class) {
                        System.out.println("Introduce un número real: ");
                        double parametro = obtenerEntradaDouble();
                        parametros.add(tipo.cast(parametro));
                    } else if (tipo == Integer.class) {
                        System.out.println("Introduce un número entero: ");
                        int parametro = obtenerEntradaEntera();
                        parametros.add(tipo.cast(parametro));
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                    entradaTeclado.next(); // Consume la entrada inválida para evitar un bucle infinito
                }
            }
        }
        return parametros;
    }

    /**
     * Obtiene un valor double desde la entrada del teclado, manejando excepciones si la entrada no es válida.
     *
     * @return El valor double introducido por el usuario.
     */
    private static double obtenerEntradaDouble() {
        while (true) {
            try {
                return Double.parseDouble(entradaTeclado.next());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número real válido.");
                entradaTeclado.next(); // Consume la entrada inválida para evitar un bucle infinito
            }
        }
    }

    /**
     * Obtiene un valor entero desde la entrada del teclado, manejando excepciones si la entrada no es válida.
     *
     * @return El valor entero introducido por el usuario.
     */
    private static int obtenerEntradaEntera() {
        while (true) {
            try {
                return Integer.parseInt(entradaTeclado.next());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero válido.");
                entradaTeclado.next(); // Consume la entrada inválida para evitar un bucle infinito
            }
        }
    }
}