import java.util.concurrent.Semaphore;

public class CajaHilo extends Thread {
    public static String ESPACIOS = "                      ";
    public Caja caja;
    public Semaphore semaforo;

    // Si no se esta usando no se pondra nada
    // Si esta usando se pondra el cliente y el producto
    String imprimiendo;

    public CajaHilo(String nombre, Semaphore s) {
        caja = new Caja(nombre);
        semaforo = s;
        imprimiendo = ESPACIOS;
    }

    public void run() {
        for (int x = 0; x < caja.clientes.length; x++) {
            try {
                semaforo.acquire();
                procesarCompra(x);
                semaforo.release();
                // Hay que poner este tiempo de espera para que le de tiempo de entrar
                // al otro hilo antes de que continue la siguiente iteracion del for
                // Esto ocasiana que durante breves instantes pueda haber solo una caja en uso
                // mientras entra el hilo
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void procesarCompra(int indiceCliente) {
        try {

            Cliente c = caja.clientes[indiceCliente];
            // Como se esta usando se pondra el cliente y el producto

            // Recorremos cada producto del cliente
            for (int x = 0; x < c.esperaProductos.length; x++) {
                imprimiendo = ESPACIOS;
                darFormatoImprimiendo(c.nombre, x);
                Thread.sleep(c.esperaProductos[x]);
            }
            imprimiendo = ESPACIOS;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void darFormatoImprimiendo(String nombre, int pro) {
        // Hay veces que el hilo imprime mientras se esta formateando
        // Por eso necesitamos una variable preImprimiendo
        // En esta funcion sumamos espacios a derecha e izquierda
        int lenTotal = ESPACIOS.length();

        String preImprimiendo = nombre + "  -  prdc: " + pro;
        int espaciosToAdd = lenTotal - preImprimiendo.length();

        int mitad = espaciosToAdd / 2;
        for (int x = 0; x < mitad; x++) {
            preImprimiendo = preImprimiendo + " ";
            preImprimiendo = " " + preImprimiendo;
        }

        if (espaciosToAdd % 2 != 0) preImprimiendo = preImprimiendo + " ";

        imprimiendo = preImprimiendo;
    }
}
