import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class Cliente extends Thread {

    private int id;
    private String numeroA;
    private String numeroB;
    private String operacion;
    private int tiempoEspera;

    public Cliente(int i) {
        id = i;
        numeroA = (int) (Math.random() * 10 + 1) + "";
        numeroB = (int) (Math.random() * 10 + 1) + "";

        tiempoEspera = (int) (Math.random() * 4 + 1) * 1000;

        int op = (int) (Math.random() * 4);
        switch (op) {
            case 0:
                operacion = "+";
                break;
            case 1:
                operacion = "-";
                break;
            case 2:
                operacion = "*";
                break;
            case 3:
                operacion = "/";
                break;
        }
        System.out.println(this);
    }

    public void run() {
        try {
            // Conexiones
            InetAddress serverAddr = InetAddress.getByName("localhost");
            DatagramSocket datagramSocket = new DatagramSocket();

            // Se crea el mensaje con la informacion
            String mensajeEnviar = id + " " + numeroA + " " + operacion + " " + numeroB + " " + tiempoEspera;

            // Se envia el mensaje al servidor
            Tools.enviarUdp(datagramSocket, mensajeEnviar, serverAddr, Servidor.PUERTO);

            // Se recibe el mensaje del servidor
            HashMap<String, Object> respuesta = Tools.recibirUDP(datagramSocket);
            // Se imprime el mensaje
            System.out.println("Mensaje recibido: " + respuesta.get("mensaje"));

            // Se cierra el socket
            datagramSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String toString() {
        return "Creado con id: " + id + "   " + numeroA + operacion + numeroB + "  espera: " + tiempoEspera;
    }

    public static void main(String[] args) {
        Cliente[] array = new Cliente[20];
        for (int x = 0; x < array.length; x++) array[x] = new Cliente(x);
        System.out.println("\n");
        for (int x = 0; x < array.length; x++) array[x].start();
    }
}
