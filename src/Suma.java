import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase contiene las operaciones de tipo suma. Es una clase compuesta por un único atributo privado estático y
 * por métodos públicos estáticos pensados para ser accedidos
 *
 * @author Casandra
 * @version 0.0.1
 */
public class Suma {

    /**
     * Atributo destinado a acumular valores para la ejecución del método sumar con valor acumulado.
     */
    private static double valorAcumulado;

    /**
     * Método para ejecutar la suma de dos números enteros.
     *
     * @param a El primer término a sumar
     * @param b El segundo término a sumar
     * @return Devuelve el valor resultado de sumar a y b
     */
    public static int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Método para ejecutar la suma de dos números reales
     *
     * @param a El primer término real a sumar
     * @param b El segundo término real a sumar
     * @return Devuelve el valor resultado de sumar a y b
     */
    public static double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Método para mostrar el submenú de la clase Suma. Al igual que el menú principal de Calculadora, es un menú
     * sencillo, que se llama recursivamente una vez se ejecuta alguna de las opciones salvo la de regresar al
     * menú principal.
     */
    public static void mostrarMenu() {
        System.out.println("1. Sumar dos enteros");
        System.out.println("2. Sumar dos reales");
        System.out.println("3. Volver al menú principal");
        Scanner entradaTeclado = new Scanner(System.in);
        int opcion = entradaTeclado.nextInt();
        switch(opcion) {
            case 1:
                List<Integer> parametrosEnteros = pedirParametros(entradaTeclado, 2, Integer.class);
                System.out.println("Resultado: " + sumar(parametrosEnteros.get(0), parametrosEnteros.get(1)));
                mostrarMenu();
                break;
            case 2:
                List<Double> parametrosReales = pedirParametros(entradaTeclado, 2, Double.class);
                System.out.println("Resultado: " + sumar(parametrosReales.get(0), parametrosReales.get(1)));
                mostrarMenu();
                break;
            case 3:
                Calculadora.mostrarMenu();
                break;
            default:
                mostrarMenu();
        }
    }

    /**
     * Este método está destinado a solicitar el número de parámetros según el tipo numérico de los mismos para
     * devolver un ArrayList del tipo correspondiente con los parámetros asociados. Ha sido implementado con el fin
     * de evitar código repetitivo en el menú provisto por el método mostrarMenu de esta misma clase. La clave de
     * este método es emplear un tipo genérico <TipoNumerico> que extiende la clase Number.
     *
     * @param entrada Objeto de tipo Scanner que capturará los valores introducidos via teclado.
     * @param numeroParametros El número de parámetros a solicitar.
     * @param tipo El tipo de los parámetros solicitados (Integer o Double).
     * @return Devuelve un ArrayList según el tipo especificado en el parámetro tipo.
     * @param <TipoNumerico> Tipo genérico que extiende la clase Number, para englobar valores Integer y Double.
     */
    private static <TipoNumerico extends Number> List<TipoNumerico> pedirParametros(
            Scanner entrada, int numeroParametros, Class<TipoNumerico> tipo) {
        List<TipoNumerico> parametros = new ArrayList<TipoNumerico>();
        for (int i = 1; i<= numeroParametros; i++) {
            if (tipo == Double.class) {
                System.out.println("Introduce un número real: ");
                Double parametro = entrada.nextDouble();
                parametros.add(tipo.cast(parametro));
            }
            if (tipo == Integer.class) {
                System.out.println("Introduce un número entero: ");
                Integer parametro = entrada.nextInt();
                parametros.add(tipo.cast(parametro));
            }
        }
        return parametros;
    }

}
