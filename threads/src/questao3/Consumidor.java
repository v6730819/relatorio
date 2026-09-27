package questao3;

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
        int caixasRetiradas = 0;
        while (caixasRetiradas < LIMITE) {

            if (deposito.retirar()) {
                caixasRetiradas++;
                System.out.println("Consumidor " + Thread.currentThread().getName() +
                        " retirou uma caixa. Total restante: " + deposito.getNumItens());
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    System.err.println("Consumidor interrompido");
                    break;
                }
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.err.println("Consumidor interrompido no tempo de espera");
                    break;
                }
            }
        }
        System.out.println("Consumidor " + Thread.currentThread().getName() + " encerrou");
    }
}