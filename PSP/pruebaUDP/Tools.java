import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class Tools {
    public static void enviarUdp(DatagramSocket ds, String mensaje, InetAddress inetAddress, int puerto) throws IOException {
        byte[] buffer = mensaje.getBytes();
        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, inetAddress, puerto);
        ds.send(paquete);
    }

    public static HashMap<String, Object> recibirUDP(DatagramSocket ds) throws IOException {
        // Se crea un buffer y un paquete para recibir el mensaje
        byte[] buffer = new byte[Servidor.PACK_LENG];
        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
        // Se recibe el mensaje del ds
        ds.receive(paquete);

        // Creamos un hasmap y lo rellenamos
        HashMap<String, Object> respuesta = new HashMap<>();

        String mensaje = new String(buffer);
        // Eliminamos los caracteres no imprimibles
        mensaje = mensaje.replaceAll("[^\\p{Print}]", "");
        respuesta.put("mensaje", mensaje);
        respuesta.put("puerto", paquete.getPort());
        respuesta.put("inetAddress", paquete.getAddress());

        return respuesta;
    }
}
