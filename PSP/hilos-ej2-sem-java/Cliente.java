public class Cliente {
    public String nombre;
    public int[] esperaProductos;

    public Cliente(String n) {
        nombre = n;
        esperaProductos = new int[(int) (Math.random() * 5) + 1];

        System.out.println("\t[+] Se esta creando el " + nombre + " con " + esperaProductos.length + " productos");
        for (int i = 0; i < esperaProductos.length; i++) {
            // 10 segundos era demasiado
            esperaProductos[i] = (int) (Math.random() * 7) + 1;
            esperaProductos[i] *= 1000;
            System.out.println("\t\t[-] Producto " + i + " con " + esperaProductos[i] + " ms de espera");
        }
    }
}
