import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Collector {
    private final Lock lock;
    private final Condition condition;
    private int hydrogenCounter;
    private int oxygenCounter;

    public Collector() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        hydrogenCounter = 0;
        oxygenCounter = 0;
    }

    public void collectAtoms(Atom atom) {
        try {
            lock.lockInterruptibly();
            boolean isHydrogen = atom instanceof Hydrogen;
            if (isHydrogen) {
                while (hydrogenCounter >= 2) {
                    condition.await();
                }
            } else {
                while (oxygenCounter >= 1) {
                    condition.await();
                }
            }

            if (isHydrogen)
            {
                hydrogenCounter++;
            }
            else
            {
                oxygenCounter++;
            }

            atom.printElementName();
            if (hydrogenCounter == 2 && oxygenCounter == 1){
                hydrogenCounter = 0;
                oxygenCounter = 0;
                System.out.println();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

            condition.signal();
            lock.unlock();
        }
    }
}
