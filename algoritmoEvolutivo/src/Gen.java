import java.util.ArrayList;
import java.util.List;

public class Gen {
    public int[] filaGen; // Y indice
    public List<Integer> listaAMeter;
    public boolean[] filaFijos;

    public Gen() {
        // Inicializamos las variables con datos nulos
        filaGen = new int[9];
        filaFijos = new boolean[9];
        for (int x = 0; x < 9; x++) {
            filaGen[x] = -1;
            filaFijos[x] = false;
        }

        // Inicializamos la listaNumerosAMeter con todos los posibles numeros
        listaAMeter = new ArrayList<Integer>();
        for (int x = 1; x < 10; x++) {
            listaAMeter.add(x);
        }
    }

    // Constructor usado por JUnit
    public Gen(String genAMeter) {
        this();
        for (int x = 0; x < 9; x++) {
            if (genAMeter.charAt(x) == '0') {
                filaGen[x] = 0;
                filaFijos[x] = false;
            } else {
                filaFijos[x] = true;
                filaGen[x] = Integer.parseInt(genAMeter.charAt(x) + "");
                listaAMeter.remove(Integer.valueOf(filaGen[x]));
            }
        }
    }

    public void printGen() {
        System.out.print("Gen : ");
        for (int x = 0; x < 9; x++) {
            System.out.print(filaGen[x]);
        }
        System.out.println("");
    }

    public Gen randomizar() {
        for (int x = 0; x < 9; x++)
            if (!filaFijos[x])
                randomizarNumero(x);
        return this;
    }

    public int[] getDosNoFijos() {
        int x = (int) (Math.random() * 9);
        while (filaFijos[x]) {
            x = (int) (Math.random() * 9);
        }

        int y = (int) (Math.random() * 9);
        while (filaFijos[y]) {
            y = (int) (Math.random() * 9);
        }

        int[] retorno = new int[2];
        retorno[0] = x;
        retorno[1] = y;
        return retorno;
    }

    private void randomizarNumero(int casilla) {
        int indiceAleatorio = (int) (Math.random() * listaAMeter.size());
        filaGen[casilla] = listaAMeter.get(indiceAleatorio);
        listaAMeter.remove(indiceAleatorio);
    }
}
