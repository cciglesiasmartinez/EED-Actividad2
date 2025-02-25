package calculadora;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SumaTest {

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "3,-1,2",
            "-5,-5,-10"
    })
    void sumar_dosEnteros_deberiaFuncionar(int a, int b, int resultadoEsperado) {
        // Cuando
        int resultadoActual = Suma.sumar(a, b);
        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, 1, ArithmeticException", // Test para números grandes (límite de int)
            "2147483647, 2, ArithmeticException",
            "-2147483647,-2147483647, ArithmeticException"

    })
    void sumar_dosEnterosGrandes_deberiaLanzarExcepcion(long a, long b, String excepcionEsperada) {
        // Cuando
        if (excepcionEsperada.equals("ArithmeticException")) {
            // Entonces
            assertThrows(ArithmeticException.class, () -> Suma.sumar((int) a, (int) b));
        }
    }

    @ParameterizedTest
    @CsvSource({
            "5,0,5",
            "-3,0,-3",
            "0,0,0"
    })
    void sumar_cero_deberiaFuncionar(int a, int b, int resultadoEsperado) {
        // Cuando
        int resultadoActual = Suma.sumar(a, b);
        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }
}