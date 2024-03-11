public class Consola extends Thread {
    public Consola() {
        super();
    }

    public void run() {
        while (true) {
            try {
                ATM.printUsando();
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
