package calculadora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase para las operaciones de división.
 *
 * @author Mario
 * @version 0.0.1
 */
public class Cociente {

    private static final Scanner entradaTeclado = new Scanner(System.in);

    /**
     * División de dos reales.
     *
     * @param a Dividendo
     * @param b Divisor
     * @return Devuelve el resultado de la división
     * @throws ArithmeticException Lanza una excepción si el divisor es 0
     */
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;

    }
    /**
     * Inverso de un número real.
     *
     * @param a Término del cual se ha de calcular el inverso.
     * @return El inverso del parámetro.
     */
    public static double calcularInverso(double a) {
        return 1/a;
    }

    /**
     * Raíz cuadrada de un número real.
     *
     * @param a Término del cual se ha de calcular la raíz cuadrada.
     * @return La raíz cuadrada del parámetro.
     */
    public static double calcularRaizCuadrada(double a) {
        return Math.sqrt(a);
    }

    /**
     * División de dos enteros.
     *
     * @param a Dividendo
     * @param b Divisor
     * @return Devuelve el resultado de la división
     * @throws ArithmeticException Lanza una excepción si el divisor es 0
     */
    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        return a / b;
    }

    /**
     * Método para mostrar el submenú de la clase calculadora.Suma. Al igual que el menú principal de Calculadora,
     * es un menú sencillo, que se llama recursivamente una vez se ejecuta alguna de las opciones salvo la de regresar
     * al menú principal.
     */
    public static void mostrarMenu() {
        System.out.println("1. Dividir dos números enteros");
        System.out.println("2. Dividir dos números reales");
        System.out.println("3. Calcular inverso de un número real");
        System.out.println("4. Calcular raíz cuadrada de un número real");
        System.out.println("5. Volver al menú principal");
        int opcion = entradaTeclado.nextInt();
        switch(opcion) {
            case 1:
                List<Integer> dosParametrosEnteros = pedirParametros(2, Integer.class);
                System.out.println("Resultado: " + dividir(dosParametrosEnteros.get(0), dosParametrosEnteros.get(1)));
                mostrarMenu();
                break;
            case 2:
                List<Double> dosParametrosReales = pedirParametros(2, Double.class);
                System.out.println("Resultado: " + dividir(dosParametrosReales.get(0), dosParametrosReales.get(1)));
                mostrarMenu();
                break;
            case 3:
                List<Double> unParametroRealInverso = pedirParametros(1, Double.class);
                System.out.println("Resultado: " + calcularInverso(unParametroRealInverso.get(0)));
                mostrarMenu();
                break;
            case 4:
                List<Double> unParametroRealRaiz = pedirParametros(1, Double.class);
                System.out.println("Resultado: " + calcularRaizCuadrada(unParametroRealRaiz.get(0)));
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

