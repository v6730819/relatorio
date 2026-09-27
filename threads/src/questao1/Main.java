package questao1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int VALOR_MAXIMO = 10;
    public static final long SLEEP_TIME = 3;

    public static void main(String[] args) {
        System.out.println("Corrida");

        List<RacerRunnableInterface> impares = new ArrayList<>();
        List<RacerThreadClass> pares = new ArrayList<>();

        for (int i = 1; i <= VALOR_MAXIMO; i++) {
            if (i % 2 != 0) {
                RacerRunnableInterface racer = new RacerRunnableInterface(String.valueOf(i), SLEEP_TIME);
                if (i == 1) {
                    racer.setPriority(Thread.MAX_PRIORITY);
                } else {
                    racer.setPriority(Thread.NORM_PRIORITY);
                }
                impares.add(racer);
            } else {
                RacerThreadClass racer = new RacerThreadClass(i, SLEEP_TIME);
                if (i == 2) {
                    racer.setPriority(Thread.MIN_PRIORITY);
                } else {
                    racer.setPriority(Thread.NORM_PRIORITY);
                }
                pares.add(racer);
            }
        }

        System.out.println("\n impares");
        for (RacerRunnableInterface racer : impares) {
            racer.start();
        }

        for (RacerRunnableInterface racer : impares) {
            try {
                racer.getThread().join();
            } catch (InterruptedException e) {
                System.err.println("A execucao foi interrompida");
            }
        }

        System.out.println("\n pares");
        for (RacerThreadClass racer : pares) {
            racer.start();
        }

        for (RacerThreadClass racer : pares) {
            try {
                racer.join();
            } catch (InterruptedException e) {
                System.err.println("A execucao foi interrompida");
            }
        }
    }
}