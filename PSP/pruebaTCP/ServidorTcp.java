import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ServidorTcp extends Thread {
    public static int PUERTO = 50005;

    public static ArrayList<String> nucleos = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(PUERTO);

        // Pongo maximo de 3 porque se ve mejor el funcionamiento
        Semaphore semaforo = new Semaphore(3);

        System.out.println("\n\n **  Servidor escuchando en el puerto " + PUERTO + "  **");
        System.out.println("\n      IDS EN USO        |        LOGS");

        new ServidorTcp().start();
        while (true) {
            Socket cliente = servidor.accept();
            new NucleoServer(semaforo, cliente).start();
        }
    }

    public void run() {
        // Imprimimos cada medio segundo los logs
        // con los id que estan actualmente en activo
        while (true) {
            try {
                for (String s : nucleos) {
                    System.out.print("  Id: " + s);
                }
                System.out.print("\n");
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}