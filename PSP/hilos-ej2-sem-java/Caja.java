public class Caja {
    public String nombre;
    public Cliente[] clientes;

    public Caja(String n) {
        nombre = n;
        clientes = new Cliente[(int) (Math.random() * 3) + 1];

        System.out.println("[*] Se esta creando la " + nombre + " con " + clientes.length + " clientes");

        for (int i = 0; i < clientes.length; i++) clientes[i] = new Cliente("clnt " + i);

        System.out.print("\n");
    }
}
