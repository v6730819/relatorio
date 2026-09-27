package questao3;

public class Deposito {
    private int items = 0;

    public int getNumItens() {
        return items;
    }

    public boolean retirar() {
        if (items > 0) {
            items = getNumItens() - 1;
            return true;
        }
        return false;
    }

    public boolean colocar() {
        items = getNumItens() + 1;
        return true;
    }

    public static void main(String[] args) {
        Deposito dep = new Deposito();
        Produtor p = new Produtor(dep, 50);
        Consumidor c1 = new Consumidor(dep, 150);
        Consumidor c2 = new Consumidor(dep, 100);
        Consumidor c3 = new Consumidor(dep, 150);
        Consumidor c4 = new Consumidor(dep, 100);
        Consumidor c5 = new Consumidor(dep, 150);

        c1.setName("C1");
        c2.setName("C2");
        c3.setName("C3");
        c4.setName("C4");
        c5.setName("C5");

        p.start();

        c1.start(); c2.start(); c3.start();
        c4.start(); c5.start();

        System.out.println("Execucao do main da classe Deposito terminada");
    }
}