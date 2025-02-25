package calculadora;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculadora.Resta.*;
import static org.junit.jupiter.api.Assertions.*;

class RestaTest {

    @Test
    void restar_dosEnteros_deberiaFuncionar() {
        // Dado
        int a = 3;
        int b = 1;
        int resultadoEsperado = 2;

        // Cuando
        int resultadoActual = restar(a,b);

        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @ParameterizedTest
    @CsvSource({
            "3,10,-7",
            "10,3,7"
    })
    void restar_dosEnterosParametrizado_deberiaFuncionar(int a, int b, int resultadoEsperado) {
        // Cuando
        int resultadoActual = restar(a,b);

        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    void restar_tresReales_deberiaFuncionar() {
        // Dado
        double a = 7.75;
        double b = 2.25;
        double c = 1.05;
        double resultadoEsperado = 4.45;

        // Cuando
        double resultadoActual = restar(a,b,c);

        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    void restar_dosReales_deberiaFuncionar() {
        // Dado
        double a = 4.75;
        double b = 0.30;
        double resultadoEsperado = 4.45;

        // Cuando
        double resultadoActual = restar(a,b);

        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @Test
    void restar_unRealAcumulado_deberiaFuncionar() {
        // Dado
        double a = -5;
        double resultadoEsperado = 0;

        // Cuando
        double primerResultado = restar(a);
        double resultadoActual = restar(primerResultado);

        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, 1, ArithmeticException", // Test para números grandes (límite de int)
            "2147483647, 2, ArithmeticException",
            "-2147483647,-2147483647, ArithmeticException"
    })
    void restar_dosNumerosGrandes_deberiaLanzarExcepcion(long a, long b, String excepcionEsperada) {
        // Cuando
        if (excepcionEsperada.equals("ArithmeticException")) {
            // Entonces
            assertThrows(ArithmeticException.class, () -> Suma.sumar((int) a, (int) b));
        }
    }

}