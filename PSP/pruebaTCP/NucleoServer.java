import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class NucleoServer extends Thread {
    private Semaphore sem;
    private Socket socket;

    public NucleoServer(Semaphore s, Socket con) {
        sem = s;
        socket = con;
    }

    public void run() {
        try {
            sem.acquire();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String id = dis.readUTF();
            System.out.println("                             log entra id: " + id);
            ServidorTcp.nucleos.add(id);
            int tiempoEspera = Integer.parseInt(dis.readUTF());
            float num1 = Float.parseFloat(dis.readUTF());
            float num2 = Float.parseFloat(dis.readUTF());
            String operator = dis.readUTF();
            sleep(tiempoEspera);

            switch (operator) {
                case "+":
                    dos.writeUTF("" + (num1 + num2));
                    break;
                case "-":
                    dos.writeUTF("" + (num1 - num2));
                    break;
                case "*":
                    dos.writeUTF("" + (num1 * num2));
                    break;
                case "/":
                    dos.writeUTF("" + (num1 / num2));
                    break;
            }
            socket.close();
            System.out.println("                             log sale id: " + id);
            ServidorTcp.nucleos.remove(id);
            // El release esta en el finally
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
        }
    }
}
