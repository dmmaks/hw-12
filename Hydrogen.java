public class Hydrogen extends Thread implements Atom {
    Collector collector;

    public Hydrogen(Collector collector) {
        this.collector = collector;


    }

    @Override
    public void printElementName() {
        System.out.print("H");
    }

    @Override
    public void run() {
        collector.collectAtoms(this);
    }
}
