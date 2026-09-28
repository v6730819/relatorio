package questao1;

public class RacerRunnableInterface implements Runnable {
    private String id;
    private long sleepTime;
    private static final int REPETICOES = 1000;

    public RacerRunnableInterface(String id, long sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for(int i = 1; i <= REPETICOES; i++) {
            System.out.println("Racer " + id + " - imprimindo (" + i + "/1000)");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Racer " + id + " - interrompido");
                break;
            }
        }
    }
}