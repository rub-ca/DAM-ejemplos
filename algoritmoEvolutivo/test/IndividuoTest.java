import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(Parameterized.class)
class IndividuoTest {
    /*    _____  ______          _____  __  __ ______
         |  __ \|  ____|   /\   |  __ \|  \/  |  ____|
         | |__) | |__     /  \  | |  | | \  / | |__
         |  _  /|  __|   / /\ \ | |  | | |\/| |  __|
         | | \ \| |____ / ____ \| |__| | |  | | |____
         |_|  \_\______/_/    \_\_____/|_|  |_|______|


        La funcion 'private static Stream<Arguments> generator()' crea y devuelve los casos de prueba.
        Los casos de pruebas necesitan dos objetos Individuo que se cruzaran y resultaran en un tercero.

        *\*\* ¿En que consiste la prueba testIndiCruzado()? *\*\*

              Se reciben dos individuos, A y B, y se cruzan generando un tercer individuo R
              El individuo generado debe estar compuesto por genes (filas) de A o B'

              La prueba consiste en comprobar que, efectivamente, los genes de R pertenecen a A o a B

     * */

    @ParameterizedTest
    @MethodSource("generator")
    public void testIndiCruzado(Individuo a, Individuo b) {
        Individuo indiResultante = Individuo.cruzarIndividuos(a, b);

        // Todos los genes (filas) del individuo resultante deben proceder del individuo a o b
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                assertTrue(indiResultante.filas[x].filaGen[y] == a.filas[x].filaGen[y] || indiResultante.filas[x].filaGen[y] == b.filas[x].filaGen[y]);
            }
        }
    }

    private static Stream<Arguments> generator() {
        // Datos de sudokus resueltos
        String sUno = "875419623123567489469238157214356798357891246698724315536182974782943561941675832";
        String sDos = "698713524123456789457298136214365897365987241789124365531642978976831452842579613";
        String sTre = "613954827245178369789236145124365798356789214897412536431597682562841973978623451";
        String sCua = "523867914146239578789145236214356789357498162698712345432581697865973421971624853";
        String sCin = "346172985125389467798456123213547698457698231689213574532761849861934752974825316";
        String sSei = "851743269239156784674298315123465897465879132798312456316524978547981623982637541";

        // Individuos que se van a cruzar, el individuo resultante del cruce es el testeado
        Individuo i1 = new Individuo(sUno);
        Individuo i2 = new Individuo(sDos);
        Individuo i3 = new Individuo(sTre);
        Individuo i4 = new Individuo(sCua);
        Individuo i5 = new Individuo(sCin);
        Individuo i6 = new Individuo(sSei);

        return Stream.of(
                // Pruebas a realizar
                Arguments.of(i1, i2), Arguments.of(i1, i3), Arguments.of(i1, i4), Arguments.of(i1, i5), Arguments.of(i1, i6),
                Arguments.of(i2, i3), Arguments.of(i2, i4), Arguments.of(i2, i5), Arguments.of(i2, i6),
                Arguments.of(i3, i4), Arguments.of(i3, i5), Arguments.of(i3, i6),
                Arguments.of(i4, i5), Arguments.of(i4, i6),
                Arguments.of(i5, i6));
    }


}