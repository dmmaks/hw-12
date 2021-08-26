public class Main {
    public static void main(String[] args) {
        Collector collector = new Collector();
        for (int i = 0; i < 8; i++)
        {
            new Hydrogen(collector).start();
            new Hydrogen(collector).start();
            new Oxygen(collector).start();
        }
    }
}
