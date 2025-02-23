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
            "2147483647, 1, 2147483648" // Test para números grandes (límite de int)
    })
    void sumar_dosEnterosGrandes_deberiaFuncionar(long a, long b, long resultadoEsperado) {
        // Cuando
        long resultadoActual = (long) Suma.sumar((int) a, (int) b); // Convertimos a int para usar el método sumar existente
        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
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