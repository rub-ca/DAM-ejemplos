public class Main {

    /*
    Algortimo genetico para resolver sudokus
    Se implementan ejemplos basicos de pruebas unitarias con JUnit
    */
    public static String sudoku1Libro = "963174050008305600200000001800407006006000300700901004500000002007206900040508070";

    public static void main(String[] args) {
        lanzarVentana();
    }

    private static void lanzarVentana() {
        java.awt.EventQueue.invokeLater(() -> new Frame().setVisible(true));
    }

    private static void hacerPruebasConsola() {
        int cantidadPruebas = 20;
        for (int x = 0; x < cantidadPruebas; x++) {
            Poblacion.resolverPorGenetica(getArrayDatosFromString(sudoku1Libro)).printIndividuo();
        }
    }

    private static int[][] getArrayDatosFromString(String datos) {
        int[][] ret = new int[9][9];
        int indice = 0;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                ret[x][y] = Integer.parseInt(String.valueOf(datos.charAt(indice)));
                indice++;
            }
        }
        return ret;
    }
}