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
        int resultadoActual = Suma.sumar(a,b);
        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

}