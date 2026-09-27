package questao2;

public class Consumidor extends Thread {
    private Deposito deposito;
    private int sleepTime;
    private static final int LIMITE = 20;

    public Consumidor(Deposito deposito, int sleepTime) {
        this.deposito = deposito;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 1; i <= LIMITE; i++) {
            deposito.retirar();
            System.out.println("Consumidor " + Thread.currentThread().getName() + " retirou uma caixa. Total restante: " + deposito.getNumItens());
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.err.println("Consumidor interrompido");
                break;
            }
        }
        System.out.println("Consumidor " + Thread.currentThread().getName() + " encerrou");
    }
}
