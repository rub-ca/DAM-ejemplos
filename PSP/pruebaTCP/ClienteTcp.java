import java.io.*;
import java.net.*;

public class ClienteTcp extends Thread {
    private int id;
    private String numeroA;
    private String numeroB;
    private String operacion;
    private int tiempoEspera;

    public ClienteTcp(int i) {
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
            Socket socket = new Socket("localhost", ServidorTcp.PUERTO);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF(id + "");
            dos.writeUTF(tiempoEspera + "");
            dos.writeUTF(numeroA);
            dos.writeUTF(numeroB);
            dos.writeUTF(operacion);

            String resulDelServer = dis.readUTF();

            System.out.println("Id: " + id + "   " + numeroA + operacion + numeroB + "  Result: " + resulDelServer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "Creado con id: " + id + "   " + numeroA + operacion + numeroB + "  espera: " + tiempoEspera;
    }

    public static void main(String[] args) throws IOException {
        ClienteTcp[] array = new ClienteTcp[10];
        for (int x = 0; x < array.length; x++) array[x] = new ClienteTcp(x);
        System.out.println("\n");
        for (int x = 0; x < array.length; x++) array[x].start();
    }
}