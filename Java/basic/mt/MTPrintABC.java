import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MTPrintABC {
    public static void main(String[] args) {
        //Object lock = new Object();
        //SyncPrintLetter s1 = new SyncPrintLetter("A", 0, lock);
        //SyncPrintLetter s2 = new SyncPrintLetter("B", 1, lock);
        //SyncPrintLetter s3 = new SyncPrintLetter("C", 2, lock);
        //
        //Thread t1 = new Thread(s1);
        //Thread t2 = new Thread(s2);
        //Thread t3 = new Thread(s3);
        //t1.start();
        //t2.start();
        //t3.start();

        ReentrantLock lock = new ReentrantLock();
        Condition ca = lock.newCondition();
        Condition cb = lock.newCondition();
        Condition cc = lock.newCondition();
        CondPrintLetter a = new CondPrintLetter("A", ca, cb, lock, 0);
        CondPrintLetter b = new CondPrintLetter("B", cb, cc, lock, 1);
        CondPrintLetter c = new CondPrintLetter("C", cc, ca, lock, 2);
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(a);
        es.submit(b);
        es.submit(c);
        es.shutdown();
        System.out.println("main over");
    }
}



class SyncPrintLetter implements Runnable {

    private static int count = 0;
    private final String letter;
    private final int cond;
    private final Object lock;

    public SyncPrintLetter(String letter, int cond, Object lock) {
        this.letter = letter;
        this.cond = cond;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (count % 3 != cond) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(letter);
                ++count;
                lock.notifyAll();
            }
        }
    }
}

class CondPrintLetter implements  Runnable {

    private final String letter;
    private final Condition curCond;
    private final Condition nextCond;
    private final Lock lock;

    private final int flag;
    private static int count = 0;

    CondPrintLetter(String letter, Condition cond, Condition nextCond, Lock lock, int flag) {
        this.letter = letter;
        this.curCond = cond;
        this.nextCond = nextCond;
        this.lock = lock;
        this.flag = flag;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                while (count % 3 != flag) {
                    curCond.await();
                }
                System.out.print(letter);
                ++count;
                nextCond.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}