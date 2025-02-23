package calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Clase que contiene las pruebas unitarias para la clase Producto.
 *
 * @author [Tu Nombre]
 * @author [Tu Perfil de GitHub]
 * @version 1.0
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
}