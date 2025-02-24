package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase contiene las operaciones de tipo resta.
 *
 * @author Sandra
 * @version 0.0.1
 */
public class Resta {

    private static double valorAcumulado;
    private static final Scanner entradaTeclado = new Scanner(System.in);

    /**
     * Ejecuta la resta de dos términos enteros.
     *
     * @param a Primer parámetro de la resta
     * @param b Segundo parámetro de la resta
     * @return Devuelve el resultado de restar a y b
     */
    public static int restar(int a, int b) {
        return a - b;
    }
    /**
     * Método para mostrar el submenú de la clase calculadora.Suma. Al igual que el menú principal de Calculadora,
     * es un menú sencillo, que se llama recursivamente una vez se ejecuta alguna de las opciones salvo la de regresar
     * al menú principal.
     */
    public static void mostrarMenu() {
        System.out.println("1. Restar dos números enteros");
        System.out.println("2. Restar dos números reales");
        System.out.println("3. Restar tres números reales");
        System.out.println("4. Restar con valor acumulado");
        System.out.println("5. Volver al menú principal");
        int opcion = entradaTeclado.nextInt();
        switch(opcion) {
            case 1:
                List<Integer> dosParametrosEnteros = pedirParametros(2, Integer.class);
                System.out.println("Resultado: " + restar(dosParametrosEnteros.get(0), dosParametrosEnteros.get(1)));
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
     * Este método está destinado a solicitar el número de parámetros según el tipo numérico de los mismos para
     * devolver un ArrayList del tipo correspondiente con los parámetros asociados. Ha sido implementado con el fin
     * de evitar código repetitivo en el menú provisto por el método mostrarMenu de esta misma clase. La clave de
     * este método es emplear un tipo genérico <TipoNumerico> que extiende la clase Number.
     *
     * @param numeroParametros El número de parámetros a solicitar.
     * @param tipo El tipo de los parámetros solicitados (Integer o Double).
     * @return Devuelve un ArrayList según el tipo especificado en el parámetro tipo.
     * @param <TipoNumerico> Tipo genérico que extiende la clase Number, para englobar valores Integer y Double.
     */
    private static <TipoNumerico extends Number> List<TipoNumerico> pedirParametros(
            int numeroParametros, Class<TipoNumerico> tipo) {
        List<TipoNumerico> parametros = new ArrayList<TipoNumerico>();
        for (int i = 1; i<= numeroParametros; i++) {
            if (tipo == Double.class) {
                System.out.println("Introduce un número real: ");
                Double parametro = entradaTeclado.nextDouble();
                parametros.add(tipo.cast(parametro));
            }
            if (tipo == Integer.class) {
                System.out.println("Introduce un número entero: ");
                Integer parametro = entradaTeclado.nextInt();
                parametros.add(tipo.cast(parametro));
            }
        }
        return parametros;
    }

}
