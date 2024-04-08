import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(Parameterized.class)
class GenTest {
    /*    _____  ______          _____  __  __ ______
         |  __ \|  ____|   /\   |  __ \|  \/  |  ____|
         | |__) | |__     /  \  | |  | | \  / | |__
         |  _  /|  __|   / /\ \ | |  | | |\/| |  __|
         | | \ \| |____ / ____ \| |__| | |  | | |____
         |_|  \_\______/_/    \_\_____/|_|  |_|______|


      La funcion 'private static Stream<Arguments> generator()' crea y devuelve los casos de prueba.
      Los casos de pruebas necesitan un objeto Gen y un array con las posibles respuestas de indices validas.


      *\*\* ¿En que consiste la prueba testGetDosNoFijos()? *\*\*

          Un gen representa la fila de un sudoku. Ejemplo de fila valida = '123456789'
                                                                 Indices = '012345678'
          Un objeto Gen es generado como '103 050 709'

          Los ceros representan valores a adivinar

          Tras randomizar el gen el resultado seria algo asi: '183 652 749'

          La funcion getDosNoFijos() del gen randomizado devolvera dos indices,
          esos indices deben coincidir con los indices donde se encontraban los '0'



      *\*\* ¿En que consiste la prueba testFila()? *\*\*

          Un objeto Gen es generado como '103 050 709'

          Tras randomizar el gen el resultado seria algo asi: '183 652 749'

          Esta prueba testea la randomizacion.

          Cada gen debe tener todos los digitos del 1..9 y sin repetidos

     * */


    @ParameterizedTest
    @MethodSource("generator")
    public void testGetNoFijos(Gen g, int[] indicesValidos) {
        int[] indicesObtenidos = g.getDosNoFijos();
        // Recorremos los indices obtenidos
        for (int obt = 0; obt < indicesObtenidos.length; obt++) {
            // Recorremos los indices validos
            // Si llegamos al final sin encontrar un resultado valido es error
            for (int x = 0; x < indicesValidos.length; x++) {
                if (indicesObtenidos[obt] == indicesValidos[x]) break;
                if (x == indicesValidos.length - 1) Assertions.fail();
            }
        }
    }

    @ParameterizedTest
    @MethodSource("generator")
    public void testFila(Gen g, int[] indicesValidos) {
        // Los indices validos no se utilizan pero estamos reutilizando el generador.

        // Comprobamos que la fila esta bien sumando y multiplicando todos sus numeros
        int sumaTotal = 0;
        int multiTotal = 1;
        for (int x = 0; x < 9; x++) {
            sumaTotal += g.filaGen[x];
            multiTotal *= g.filaGen[x];
        }

        if (sumaTotal != 45 || multiTotal != 362880) Assertions.fail();
    }

    private static Stream<Arguments> generator() {
        /*
        Pasamos el gen para poder reutilizar este generador en las dos funciones de prueba.
        La otra forma seria hacer un generador que pasase el gen para el testFila()
        y otro generador diferente que pasase dos arrays para el test testGetDosNoFijos().
        Pero no nos gusta el codigo redundante :)
        */

        return Stream.of(
                // Pruebas con 1 opcion valida
                Arguments.of(new Gen("423156780").randomizar(), new int[]{8}),
                Arguments.of(new Gen("107823456").randomizar(), new int[]{1}),
                Arguments.of(new Gen("423156708").randomizar(), new int[]{7}),

                // Pruebas con 2 opciones validas
                Arguments.of(new Gen("423156080").randomizar(), new int[]{6, 8}),
                Arguments.of(new Gen("100723456").randomizar(), new int[]{1, 2,}),
                Arguments.of(new Gen("423156008").randomizar(), new int[]{6, 7}),

                // Pruebas con 3 opciones validas
                Arguments.of(new Gen("000123456").randomizar(), new int[]{0, 1, 2,}),
                Arguments.of(new Gen("123000456").randomizar(), new int[]{3, 4, 5,}),
                Arguments.of(new Gen("423156000").randomizar(), new int[]{6, 7, 8,}),

                // Pruebas con 4 opciones validas
                Arguments.of(new Gen("104060708").randomizar(), new int[]{1, 3, 5, 7}),

                // Pruebas con 5 opciones validas
                Arguments.of(new Gen("000001234").randomizar(), new int[]{0, 1, 2, 3, 4}),
                Arguments.of(new Gen("357800000").randomizar(), new int[]{4, 5, 6, 7, 8}),

                // Pruebas con las 7 opciones validas
                Arguments.of(new Gen("100200000").randomizar(), new int[]{1, 2, 4, 5, 6, 7, 8}),
                Arguments.of(new Gen("000000091").randomizar(), new int[]{0, 1, 2, 3, 4, 5, 6}),
                Arguments.of(new Gen("000051000").randomizar(), new int[]{0, 1, 2, 3, 6, 7, 8}),
                Arguments.of(new Gen("010000030").randomizar(), new int[]{0, 2, 3, 4, 5, 6, 8}),

                // Pruebas con las 9 opciones validas
                Arguments.of(new Gen("000000000").randomizar(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new Gen("000000000").randomizar(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new Gen("000000000").randomizar(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new Gen("000000000").randomizar(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})
        );
    }


}