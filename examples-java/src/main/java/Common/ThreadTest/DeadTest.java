package Common.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Elvis on 2020/2/16.
 */
public class DeadTest {
    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock(true);
        DeadLock deadLock2 = new DeadLock(false);
        Thread t1 = new Thread(deadLock1);
        Thread t2 = new Thread(deadLock2);
        t1.start();
        t2.start();
    }
}

class DeadLock implements Runnable {
    private boolean flag;
    static final Object obj1 = new Object();
    static final Object obj2 = new Object();
    public DeadLock(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "持有obj1");
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + "持有obj2");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + "持有obj2");
                    synchronized (obj1) {
                        System.out.println(Thread.currentThread().getName() + "持有obj1");
                    }
                }
            }
        }
    }
}