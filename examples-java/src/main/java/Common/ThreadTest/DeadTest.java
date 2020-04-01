package Common.ThreadTest;

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
    //用于标识两个线程
    private boolean flag;
    //两个资源
    static final Object obj1 = new Object();
    static final Object obj2 = new Object();
    public DeadLock(boolean flag) {
        this.flag = flag;
    }
    @Override
    public void run() {
        if (flag) {
            while (true) {
                //保持1并请求2
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "持有obj1");
                    synchronized (obj2) {
                        System.out.println(Thread.currentThread().getName() + "持有obj2");
                    }
                }
            }
        } else {
            while (true) {
                //保持2并请求1
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