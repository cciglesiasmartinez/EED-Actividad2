package calculadora;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase que contiene las pruebas unitarias para la clase Producto.
 *
 * @author JC
 * @version 0.0.1
 */
class ProductoTest {

    /**
     * Prueba el método multiplicar para dos números reales.
     */
    @Test
    void multiplicarDosReales() {
        assertEquals(6.0, Producto.multiplicar(2.0, 3.0), 0.001);
    }

    /**
     * Prueba el método multiplicar para dos números enteros.
     */
    @Test
    void multiplicarDosEnteros() {
        assertEquals(6, Producto.multiplicar(2, 3));
    }

    /**
     * Prueba el método multiplicar para tres números reales.
     */
    @Test
    void multiplicarTresReales() {
        assertEquals(24.0, Producto.multiplicar(2.0, 3.0, 4.0), 0.001);
    }

    /**
     * Prueba el método elevar (potencia).
     */
    @Test
    void elevar() {
        assertEquals(8.0, Producto.elevar(2.0, 3.0), 0.001);
    }

    /**
     * Test parametrizado para probar producto con dos enteros
     */
    @ParameterizedTest
    @CsvSource({
       "2,5,10",
       "-3,2,-6"
    })
    void multiplicar_DosEnteros_deberiaFuncionar(int a, int b, int resultadoEsperado) {
        // Cuando
        int resultadoActual = Producto.multiplicar(a,b);
        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    /**
     * Test parametrizado para probar producto con dos reales
     */
    @ParameterizedTest
    @CsvSource({
            "2.5,2,5",
            "3,3.3,9.899999999999999"
    })
    void multiplicar_DosEnteros_deberiaFuncionar(double a, double b, double resultadoEsperado) {
        // Cuando
        double resultadoActual = Producto.multiplicar(a,b);
        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }

    /**
     * Test parametrizado para probar producto con tres reales
     */
    @ParameterizedTest
    @CsvSource({
            "2.5,2,5,25",
            "3.5,4.5,3,47.25"
    })
    void multiplicar_TresEnteros_deberiaFuncionar(double a, double b, double c, double resultadoEsperado) {
        // Cuando
        double resultadoActual = Producto.multiplicar(a,b,c);
        // Entonces
        assertEquals(resultadoEsperado, resultadoActual);
    }
}