package questao1;

public class RacerThreadClass extends Thread {
    private int id;
    private long sleepTime;
    private static final int REPETICOES = 1000;

    public RacerThreadClass(int id, long sleepTime) {
        this.sleepTime = sleepTime;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= REPETICOES; i++) {
            System.out.println("Racer " + id + " - imprimindo (" + i + "/1000)");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Racer " + id + " foi interrompido");
                break;
            }
        }
    }
}
