package calculadora;

import org.junit.jupiter.api.Test;

import static calculadora.Cociente.*;
import static org.junit.jupiter.api.Assertions.*;

class CocienteTest {

    @Test
    void dividir_dosEnteros_deberiaFuncionar() {
        // Dado
        int a = 10;
        int b = 2;
        int resultadoEsperado = 5;

        // Cuando
        int resultadoActual = Cociente.dividir(a,b);

        // Entonces
        assertEquals(resultadoEsperado,resultadoActual);
    }

    @Test
    void dividir_dosReales_deberiaFuncionar() {
        // Dado
        double a = 10.5;
        double b = 2;
        double resultadoEsperado = 5.25;

        // Cuando
        double resultadoActual = Cociente.dividir(a,b);

        // Entonces
        assertEquals(resultadoEsperado,resultadoActual);
    }

    @Test
    void calcularInverso_unReal_deberiaFuncionar() {
        // Dado
        double a = 2.5;
        double resultadoEsperado= 0.4;

        // Cuando
        double resultadoActual = Cociente.calcularInverso(a);

        // Entonces
        assertEquals(resultadoEsperado,resultadoActual);
    }

    @Test
    void calcularRaizCuadrada_unReal_deberiaFuncionar() {
        // Dado
        double a = 16;
        double resultadoEsperado = 4;

        // Cuando
        double resultadoActual = Cociente.calcularRaizCuadrada(a);

        // Entonces
        assertEquals(resultadoEsperado,resultadoActual);
    }
}