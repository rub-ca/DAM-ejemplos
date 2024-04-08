import java.util.Arrays;
import java.util.Comparator;

public class Poblacion {

    public static final int POBLACION_SIZE = 100;

    public static final int PROBMUTARFILA = 4;

    public Individuo[] indis;

    public Poblacion(int[][] datosIniciales) {
        indis = new Individuo[POBLACION_SIZE];

        for (int x = 0; x < indis.length; x++) {
            indis[x] = new Individuo(datosIniciales);
            indis[x].randomizar();
            indis[x].evaluarSimple();
        }
    }

    public Poblacion(Individuo[] i) {
        indis = new Individuo[POBLACION_SIZE];
        for (int x = 0; x < POBLACION_SIZE; x++) {
            indis[x] = new Individuo(i[x]);
            indis[x].nota = i[x].nota;
        }
    }

    public boolean isExito() {
        ordenadarPorNota();
        return indis[0].nota == 0;
    }

    public void ordenadarPorNota() {
        for (int x = 0; x < indis.length; x++) {
            indis[x].evaluarSimple();
        }
        Arrays.sort(indis, Comparator.comparing(Individuo::getNota));
    }

    // SE USA EN DEBUG
    public String[] getStringIndis() {
        String[] devolver = new String[POBLACION_SIZE];

        for (int x = 0; x < POBLACION_SIZE; x++) {
            devolver[x] = indis[x].getStringIndi();
        }

        return devolver;
    }

    public static Poblacion evolucionar(Poblacion p, int[][] datosIniciales) {
        Individuo[] nuevos = new Individuo[POBLACION_SIZE];

        for (int x = 0; x < 10; x++) {
            nuevos[x] = new Individuo(p.indis[x]);
        }
        for (int x = 10; x < 30; x++) {
            nuevos[x] = new Individuo(datosIniciales);
            nuevos[x].randomizar();
        }
        for (int x = 30; x < 60; x++) {
            int aleatorio1 = (int) (Math.random() * POBLACION_SIZE);
            int aleatorio2 = (int) (Math.random() * x);

            //nuevos[x] = Individuo.cruzarIndividuosDos(p.indis[aleatorio1], nuevos[aleatorio2]);
            nuevos[x] = Individuo.cruzarIndividuos(p.indis[aleatorio1], p.indis[x - 30]);
        }
        for (int x = 60; x < 100; x++) {
            int aleatorio1 = (int) (Math.random() * POBLACION_SIZE);
            nuevos[x] = Individuo.mutarIndividuo(p.indis[aleatorio1]);
        }
        return new Poblacion(nuevos);
    }

    public static Individuo resolverPorGenetica(int[][] datosI) {
        Poblacion p = new Poblacion(datosI);
        p = Poblacion.evolucionar(p, datosI);
        p.ordenadarPorNota();

        long contador = 0;
        while (!p.isExito()) {
            p = Poblacion.evolucionar(p, datosI);
            p.ordenadarPorNota();

            if (contador % 400 == 0) {
                System.out.println("c: " + contador);
            }
            contador++;

            if (contador > 1000) {
                return resolverPorGenetica(datosI);
            }
        }
        return p.indis[0];
    }
}
