public class Oxygen extends Thread implements Atom {
    Collector collector;

    public Oxygen(Collector collector) {
        this.collector = collector;


    }

    @Override
    public void printElementName() {
        System.out.print("O");
    }

    @Override
    public void run() {
        collector.collectAtoms(this);
    }
}