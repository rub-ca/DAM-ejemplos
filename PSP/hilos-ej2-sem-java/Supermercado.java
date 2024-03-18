import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Supermercado implements Runnable {

    public static String VACIOS_TODOS = "|                      |                      |                      |";
    public static int contadorVacios = 0;

    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(2);
        Supermercado supermercado = new Supermercado(semaforo);

        System.out.print("\n|        CAJA 0        |        CAJA 1        |        CAJA 2        |");

        supermercado.run();
    }

    private CajaHilo[] cajas;

    public Supermercado(Semaphore s) {
        cajas = new CajaHilo[3];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new CajaHilo("Caja " + i, s);
            cajas[i].start();
        }
    }

    public void imprimirCajas() {
        String imprimir = "|" + cajas[0].imprimiendo + "|" + cajas[1].imprimiendo + "|" + cajas[2].imprimiendo + "|";

        System.out.print("\n" + imprimir);

        // Si se imprimen vacias 5 veces salimos
        if (VACIOS_TODOS.equals(imprimir)) contadorVacios++;
        if (contadorVacios == 5) System.exit(0);

    }

    @Override
    public void run() {
        while (true) {
            try {
                imprimirCajas();
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
