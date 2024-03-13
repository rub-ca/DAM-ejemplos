package tools;

public class MainCalculoSubneting {
    public static void main(String[] args) {
        String introducido1 = "192.168.112.165/25";
        String introducido2 = "13.13.13.13/13";

        iniciar(introducido1);
        System.out.println("\n");
        iniciar(introducido2);
    }

    private static void iniciar(String introducido) {
        String[] arrayI = introducido.split("/");
        String ip = arrayI[0];
        String cidr = arrayI[1];

        // Guarda la ip en decimal
        String[] octetosDecimal = ip.split("\\.");

        // Guarda la ip en binario
        String[] octetosBinario = new String[octetosDecimal.length];
        for (int x = 0; x < octetosDecimal.length; x++) octetosBinario[x] = getStrBinario(octetosDecimal[x]);

        // 7/8 -> 0   15/8 -> 1    23/8 -> 2    31/8 -> 3
        // La division truncada es el indice del octeto
        int divisionTruncada = Integer.parseInt(cidr) / 8;
        int modulo = Integer.parseInt(cidr) % 8;

        // La parte de red es la parte izquierda del octeto hasta el modulo
        String binParteRed = "";
        for (int x = 0; x < modulo; x++) binParteRed += octetosBinario[divisionTruncada].charAt(x);
        binParteRed = ponerCerosABinario(binParteRed, true, 8);

        // La parte de hosts es la parte derecha del octeto desde el modulo
        String binParteHost = "";
        for (int x = modulo; x < 8; x++) binParteHost += octetosBinario[divisionTruncada].charAt(x);
        binParteHost = ponerCerosABinario(binParteHost, false, 8);

        // La direccion de red se calcula cogiendo los octetos previos no afectados,
        // sumando el octecto afectado (solo la parte correspondiente) y rellenando el resto con ceros a la derecha
        String direccionDeRed = "";
        for (int x = 0; x < divisionTruncada; x++) {
            direccionDeRed += octetosBinario[x];
        }
        direccionDeRed += binParteRed;

        // Rellenamos con ceros a la derecha
        direccionDeRed = ponerCerosABinario(direccionDeRed, true, 32);

        // Imprimimos la direccion de red
        System.out.println("ip: " + ip + "  cidr: " + cidr);
        printIpBinariaPuntos(direccionDeRed);
        printIpBinariaDecimal(direccionDeRed);
    }

    private static void printIpBinariaPuntos(String impri) {
        // Recibimos un string de 32 digitos que representan la ip,
        // lo imprimos en cuatro octetos poniendo ceros entre medias
        System.out.print("Direccion de red : ");
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 8; y++) {
                int indice = (8 * x) + y;
                System.out.print(impri.charAt(indice));
            }
            if (x != 3) System.out.print(".");
        }
        System.out.print("\n");
    }

    private static void printIpBinariaDecimal(String impri) {
        // Recibimos un string de 32 digitos que representan la ip,
        // convertimos cada octeto a int y lo imprimimos
        System.out.print("Direccion de red : ");
        for (int x = 0; x < 4; x++) {
            int inicial = 8 * x;
            String subStr = impri.substring(inicial, inicial + 8);
            System.out.print(Integer.parseInt(subStr, 2));
            if (x != 3) System.out.print(".");
        }
    }

    private static String getStrBinario(String numeroEnDecimal) {
        // Recibimos un entero y devolvemos el binario con 8 digitos
        // Rellenamos con ceros a la izquierda si es necesario
        String retorno = Integer.toBinaryString(Integer.parseInt(numeroEnDecimal));
        int cantidadCeros = 8 - retorno.length();
        for (int y = 0; y < cantidadCeros; y++) retorno = "0" + retorno;
        return retorno;
    }

    private static String ponerCerosABinario(String binario, boolean derecha, final int objetivo) {
        // Rellenamos un binario hasta tener 8 digitos
        // Recibimos un binario y un boleano que representa si queremos rellenar
        // con ceros a la izquierda o a la derecha
        int cantidad = objetivo - binario.length();
        if (derecha) for (int x = 0; x < cantidad; x++) binario = binario + "0";
        else for (int x = 0; x < cantidad; x++) binario = "0" + binario;
        return binario;
    }
}
