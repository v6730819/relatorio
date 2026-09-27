package questao3;

public class Produtor extends Thread {
    private Deposito deposito;
    private int sleepTime;
    private static final int LIMITE = 100;

    public Produtor(Deposito deposito, int sleepTime) {
        this.deposito = deposito;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 1; i <= LIMITE; i++) {
            deposito.colocar();
            System.out.println("Uma caixa fabricada. Total no deposito: " + deposito.getNumItens());
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.err.println("Produtor interrompido");
                break;
            }
        }
        System.out.println("Encerrado");
    }
}
