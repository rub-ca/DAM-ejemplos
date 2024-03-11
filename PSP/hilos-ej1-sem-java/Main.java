import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int[] arrayTiemposEspera = new int[9];
        for (int x = 0; x < arrayTiemposEspera.length; x++) {
            arrayTiemposEspera[x] = (int) (Math.random() * 7) + 3;
        }

        System.out.println("\nSe generan 9 usuarios, del 1 al 9 ambos inclusive");
        System.out.println("Hay 5 cajeros disponibles\n");
        System.out.println("Tiempos de espera aleatorios para cada usuario:");

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int idUser = (x * 3) + y + 1; // El id lleva + 1
                int indiceUser = (x * 3) + y; // El indice no
                ATM.printColorUser(idUser);
                System.out.print("User " + idUser + ": " + arrayTiemposEspera[indiceUser] + "  segundos     ");
                ATM.printColorUser(-1);
            }
            System.out.println("");
        }

        System.out.println("\n\n");

        Semaphore semaforo = new Semaphore(5);

        for (int x = 1; x < 10; x++) {
            ATM atm = new ATM(semaforo, x, arrayTiemposEspera[x - 1]);
            atm.start();
        }

        System.out.println("| CAJERO A  |  CAJERO B  |  CAJERO C  |  CAJERO D  |  CAJERO E  |");

        Consola c = new Consola();
        c.start();


    }
}
