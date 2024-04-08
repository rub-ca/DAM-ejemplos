import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Servidor extends Thread {
    public static int PACK_LENG = 1024;
    public static int PUERTO = 50005;
    public static ArrayList<String> nucleos = new ArrayList<String>();

    private HashMap<String, Object> respuesta;
    private DatagramSocket servidor;
    private Semaphore semaforo;

    public Servidor(DatagramSocket ds, HashMap<String, Object> r, Semaphore s) {
        respuesta = r;
        servidor = ds;
        semaforo = s;
    }

    public void run() {
        try {
            semaforo.acquire();
            String msg = (String) respuesta.get("mensaje");
            System.out.println("                             log msg recibido: " + msg);
            // 0 id    1 numero1    2 operacion    3 numero 2     4 espera
            String[] datos = msg.split(" ");
            nucleos.add(datos[0]);

            sleep(Integer.parseInt(datos[4]));

            float resultadoOp = 0;

            switch (datos[2]) {
                case "+":
                    resultadoOp = Float.parseFloat(datos[1]) + Float.parseFloat(datos[3]);
                    break;
                case "-":
                    resultadoOp = Float.parseFloat(datos[1]) - Float.parseFloat(datos[3]);
                    break;
                case "*":
                    resultadoOp = Float.parseFloat(datos[1]) * Float.parseFloat(datos[3]);
                    break;
                case "/":
                    resultadoOp = Float.parseFloat(datos[1]) / Float.parseFloat(datos[3]);
                    break;
            }

            String mensajeEnviar = datos[1] + " " + datos[2] + " " + datos[3] + " = " + resultadoOp;

            // Se envia un mensaje al cliente
            Tools.enviarUdp(servidor, mensajeEnviar, (InetAddress) respuesta.get("inetAddress"),
                    (int) respuesta.get("puerto"));

            System.out.println("                             log msg enviado: " + mensajeEnviar + "\n");

            nucleos.remove(datos[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaforo.release();
        }
    }

    public static void main(String[] args) {
        try {
            // Conexiones
            Semaphore semaforo = new Semaphore(3);
            InetSocketAddress addr = new InetSocketAddress("127.0.0.1", PUERTO);
            DatagramSocket servidor = new DatagramSocket(addr);

            System.out.println("\n\n **  Servidor escuchando en el puerto " + PUERTO + "  **");
            System.out.println("\n      IDS EN USO        |        LOGS");

            // Hilo anonimo que es la consola del servidor
            new Thread(() -> {
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
            }).start();

            while (true) {
                // Se recibe el mensaje del cliente
                HashMap<String, Object> respuesta = Tools.recibirUDP(servidor);
                // El semaforo actua despues de recibir el datagrama udp
                // antes no hay control sobre cuantos llegan paralelamente
                new Servidor(servidor, respuesta, semaforo).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
