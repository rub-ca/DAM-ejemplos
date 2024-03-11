import java.util.concurrent.Semaphore;

public class ATM extends Thread {
    public Semaphore sem;
    public int id;

    public int tiempoEspera;

    public ATM(Semaphore s, int i, int t) {
        sem = s;
        id = i;
        tiempoEspera = t * 1000;
    }

    public void run() {
        try {
            sem.acquire();
            ponerIdEnUso(id);
            sleep(tiempoEspera);
            quitarIdEnUso(id);
            sem.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    // Intento dejarlo bonito
    private static int[] idsEnUso = {-1, -1, -1, -1, -1};
    private static int contVaciosTodos = 0;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN


    private static void ponerIdEnUso(int id) {
        for (int x = 0; x < idsEnUso.length; x++) {
            if (idsEnUso[x] == -1) {
                idsEnUso[x] = id;
                break;
            }
        }
    }

    private static void quitarIdEnUso(int id) {
        for (int x = 0; x < idsEnUso.length; x++) {
            if (idsEnUso[x] == id) {
                idsEnUso[x] = -1;
                break;
            }
        }
    }

    public static void printColorUser(int i) {
        switch (i) {
            case -1:
                System.out.print(ANSI_RESET);
                break;

            case 1:
                System.out.print(ANSI_BLACK);
                break;
            case 2:
                System.out.print(ANSI_WHITE);
                break;
            case 3:
                System.out.print(ANSI_RED);
                break;
            case 4:
                System.out.print(ANSI_GREEN);
                break;
            case 5:
                System.out.print(ANSI_YELLOW);
                break;
            case 6:
                System.out.print(ANSI_BLUE);
                break;
            case 7:
                System.out.print(ANSI_PURPLE);
                break;
            case 8:
                System.out.print(ANSI_CYAN);
                break;
            case 9:
                System.out.print(CYAN_UNDERLINED);
                break;
        }


    }

    public static void printUsando() {
        int vacios = 0;
        System.out.print("| ");
        for (int x = 0; x < idsEnUso.length; x++) {
            if (idsEnUso[x] != -1) {
                printColorUser(idsEnUso[x]);
                System.out.print(" user  " + idsEnUso[x]);
                printColorUser(-1);
                System.out.print("  |  ");

            } else {
                System.out.print("  vacio   |  ");
                vacios++;
            }
        }
        System.out.print("\n");
        if (vacios == 5) contVaciosTodos++;
        if (contVaciosTodos > 2) System.exit(0);
    }

}
