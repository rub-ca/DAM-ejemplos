import java.util.ArrayList;

public class Recursivo {

    public static final int SIZE = 9;

    // INICIO CODIGO PRUEBA
    public static String sudoku1 = "020639500" + "079000683" + "003080090" + "210008009" + "800300040"
            + "304201800" + "000503908" + "080072130" + "002800050";

    public static void pruebaRecursivo() {
        // Cargamos los datos
        int[][] datos = new int[SIZE][SIZE];
        int indice = 0;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                datos[x][y] = Integer.parseInt(String.valueOf(sudoku1.charAt(indice)));
                indice++;
            }
        }
        resolver(datos);
        imprimir(datos);
    }
    // FIN CODIGO PRUEBA

    private static void imprimir(int[][] datos) {
        System.out.println("\n");
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(" " + datos[x][y] + " ");
                if (y == 2 || y == 5) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            if (x == 2 || x == 5) {
                System.out.print("\n");
            }
        }
    }

    public static boolean resolver(int[][] tablero) {
        for (int fila = 0; fila < SIZE; fila++) {
            for (int columna = 0; columna < SIZE; columna++) {
                if (tablero[fila][columna] == 0) {
                    for (int metiendo = 1; metiendo < 10; metiendo++) {
                        if (posibleSitio(tablero, metiendo, fila, columna)) {
                            tablero[fila][columna] = metiendo;
                            if (resolver(tablero)) {
                                return true;
                            } else {
                                tablero[fila][columna] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean posibleSitio(int[][] tablero, int numero, int fila, int columna) {
        return !estaEnColumna(tablero, numero, columna) && !estaEnCuadro(tablero, numero, fila, columna) && !estaEnFila(tablero, numero, fila);
    }

    private static boolean estaEnFila(int[][] tablero, int numero, int fila) {
        for (int x = 0; x < 9; x++) {
            if (tablero[fila][x] == numero) {
                return true;
            }
        }
        return false;
    }

    private static boolean estaEnColumna(int[][] tablero, int numero, int columna) {
        for (int x = 0; x < 9; x++) {
            if (tablero[x][columna] == numero) {
                return true;
            }
        }
        return false;
    }

    private static boolean estaEnCuadro(int[][] tablero, int numero, int fila, int columna) {
        int posFila = fila - fila % 3;
        int posColumna = columna - columna % 3;

        for (int x = posFila; x < posFila + 3; x++) {
            for (int y = posColumna; y < posColumna + 3; y++) {
                if (tablero[x][y] == numero) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[][] generarSudokuAleatorio() {
        // Inicializamos la lista de numero a meter en cada fila
        ArrayList<Integer> listaAMeter = new ArrayList<>();
        for (int x = 1; x < 10; x++) {
            listaAMeter.add(x);
        }

        // Inidcializamos el vector que vamos a devolver
        int[][] datos = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                datos[x][y] = 0;
            }
        }

        // Inicializamos la primera fila
        for (int x = 0; x < 9; x++) {
            int aleatorio = (int) (Math.random() * listaAMeter.size());
            datos[0][x] = listaAMeter.get(aleatorio);
            listaAMeter.remove(aleatorio);
        }

        // Volvemos a annadir los numeros a meter
        for (int x = 1; x < 10; x++) {
            listaAMeter.add(x);
        }

        resolver(datos);

        // Tenemos que quitar 6 numeros por fila
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 6; y++) {
                int aleatorio = (int) (Math.random() * 9);
                datos[x][aleatorio] = 0;
            }
        }

        return datos;
    }
}
