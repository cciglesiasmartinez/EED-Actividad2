# Actividad 2: Javadoc y JUnit
Repositorio para Actividad 2 de la asignatura "Entornos de Desarrollo" (Javadoc y JUnit).

## Notas sobre el código
* ¿Utilizamos la sobrecarga de métodos? Me parece bastante apropiado para la mayoría de clases, puesto que muchas comparten un mismo método con diferente firma (suma de dos reales, suma de dos enteros, etcétera), por lo que podemos emplear un mismo método "sumar" sobrecargado para realizar todas las operaciones pedidas.
* La clase "Main" será el punto de entrada del código (método public static void main). Esta clase tendrá un sólo método "mostrarMenu" que redirigirá a métodos "mostrarMenu" de cada una de las clases de operación (Suma, Resta, etc). De este modo, tendremos una suerte de "menú principal" con submenús que implementará cada uno en su propia clase. Es importante que estos submenús (por ejemplo, Suma.mostrarMenu()) ofrezcan la posibilidad de volver al menú principal (Main.mostrarMenu()).
* Siempre que sea posible, evitar código repetitivo.
* Máximo ancho de línea: 140 carácteres.
### Algunas convenciones sobre nombres...
* Atributos y variables en general deben ser sustantivos (valorAcumulado, parametro, etc).
* Métodos deben ser verbos o verbos + complementos (sumar, calcularValor, mostrarMenu, etc).
* Emplear camelCase para atributos, variables y métodos. Emplear PascalCase para clases.
* Siempre nombres muy descriptivos, que suenen prácticamente "tontos" de lo obvios que resultan. No obstante, creo que se pueden hacer excepciones en los parámetros de métodos como sumar, que pueden ser perfectamente ser "a" y "b" por ejemplo. ¿Qué opináis?
* Evitar citar el tipo de los datos en el nombre siempre que sea posible. Por ejemplo, preferentemente usar "valor" en vez de "valorEntero".

## Notas sobre los tests
* Hay que buscar una convención para los nombres. Al final de este documento figuran algunos tests para cada clase con su nombre correspondiente, aunque sería interesante discutir y buscar alternativas mejores.
* Cuando empleemos tests sencillos (@Test) podemos usar la estructura "GIVEN-WHEN-THEN" en el cuerpo del test. Por ejemplo:
```
  @Test
  void sumar_dosEnteros_deberiaFuncionar() {
    // Dado (given)
    int a = 5;
    int b = 2;
    int resultadoEsperado = 7;
    
    // Cuando (when)
    int resultadoActual = Suma.sumar(a,b);
    
    // Entonces (then)
    assertEquals(resultadoEsperado,resultadoActual);
  }
```

## Notas sobre los commits
* Podemos emplear el formato estándar de Linus Torvalds y adaptarlo un poco. Mi sugerencia sería escribir una primera línea a modo de "título" en infinitivo o imperativo que explique directamente qué se hace el commit, seguido de un pequeño "cuerpo" donde se exponga en detalle qué es lo que se ha hecho y cómo (si procediese). Adjunto un ejemplo más abajo.
* Sería conveniente evitar subir commits demasiado pequeños o con descripciones muy vagas.
* No todos los commits deben de tener un cuerpo extenso, en algunos quizá puede bastar con un buen "título".
### Ejemplo de commit
```
Añade cambios en el fichero README

He añadido algunas sugerencias y guías para el código del proyecto en el fichero README. Mayormente ideas sobre convenciones.
```

## Notas sobre los comentarios Javadoc
* Documentar cada clase al comienzo.
```
/**
 * <Descripción de la clase>
 *
 * @author <Nombre y apellidos>
 * @version <La versión>
 */
```
* Documentar cada método.
```
/**
 * <Descripción del método>
 *
 * @param <Variable> <Descripción del parámetro>
 * @return <Descripción del retorno si procede>
 */
```

## Sugerencia para la estructura general del programa
Esto es una sugerencia que nos puede servir como modelo inicial a seguir para estructurar el programa. Incluye clases, atributos y firmas de los métodos.
### Clase Main
```
public static void main(String args[])
public static void mostrarMenu()
```
### Clase Suma
```
private static double valorAcumulado;
    Atributo para almacenar valor acumulado
public static void mostrarMenu()
    Método para mostrar menú
public static int sumar(int a, int b)
    Caso para sumar dos enteros
public static double sumar(double a, double b)
    Caso para sumar dos reales
public static double sumar(double a, double b, double c)
    Caso para sumar tres reales
public static double sumar(double a)
    Caso para sumar con valor Acumulado
```
### Clase Resta
```
private static double valorAcumulado;
public static void mostrarMenu()
public static int restar(int a, int b)
public static double restar(double a, double b)
public static double restar(double a, double b, double c)
public static double restar(double a)
```
### Clase Producto
```
public static void mostrarMenu()
public static int multiplicar(int a, int b)
public static double multiplicar(double a, double b)
public static double multiplicar(double a, double b, double c)
public static int elevar(int base, int exponente)
```
### Clase Cociente
```
public static void mostrarMenu()
public static int dividir(int a, int b)
public static double dividir(double a, double b)
public static double calcularInverso(double a)
public static double raizCuadrada(double a)
```
### Clase Modulo
```
public static void mostrarMenu()
public static int calcularModulo(int a, int b)
public static double calcularValorAbsoluto(double a)
```

## Sugerencia para los test
Algunos tests que podrían ser aplicables para cada clase. La convención sobre el nombre de los tests debería ser discutida, esto es sólo una sugerencia.
### Tests para Suma
```
sumar_dosEnteros_deberiaFuncionar
sumar_dosReales_deberiaFuncionar
sumar_enteroYReal_deberiaFallar
sumar_noNumeros_deberiaFallar
```
### Tests para Resta
```
restar_dosEnteros_deberiaFuncionar
restar_dosReales_deberiaFuncionar
restar_enteroYReal_deberiaFallar
restar_valoresNoNumericos_deberiaFallar
restar_demasiadosArgumentos_deberiaFallar
```
### Tests para Producto
```
multiplicar_valoresNoNumericos_deberiaFallar
multiplicar_dosReales_deberiaFuncionar
multiplicar_dosEnteros_deberiaFuncionar
multiplicar_tresReales_deberiaFuncionar
```
### Tests para Cociente
```
dividir_entreCero_deberiaFallar
dividir_dosReales_deberiaFuncionar
dividir_dosEnteros_deberiaFuncionar
calcularInverso_deberiaFuncionar
calcularInverso_valorNoNumerico_deberiaFallar
dividir_valoresNoNumericos_deberiaFallar
calcularRaizCuadradada_valoresNoNumericos_deberiaFallar
calcularRaizCuadrada_valorNumerico_deberiaFuncionar
```
### Tests para Modulo
```
calcularModulo_valoresCorrectos_deberiaFuncionar
calcularModulo_valoresNoNumericos_deberiaFallar
calcularValorAbsoluto_valorNumerico_deberiaFuncionar
calcularValorAbsoluto_valorNoNumerico_deberiaFallar
```

## Estructura de directorios
```
doc/
src/
test/
.gitignore
README.md
```
* Documentación JavaDoc generada via IntelliJ en doc/.
* Código de las clases en src/, a priori no parece necesario crear paquetes.
* Todos los tests en test/.

## Notas
¡Todo tipo de sugerencias, cambios y correcciones son bienvenidos!