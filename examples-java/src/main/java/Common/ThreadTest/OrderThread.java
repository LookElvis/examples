package Common.ThreadTest;

/**
 * Created by Elvis on 2020/3/9.
 */
public class OrderThread {
    private int orderNum = 3;
    public static void main(String[] args) {
        OrderThread orderThread = new OrderThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                orderThread.printA();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                orderThread.printB();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                orderThread.printC();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public synchronized void printA(){
        while (orderNum != 1) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        orderNum = 3;
        System.out.println("This is A");
        notifyAll();
    }

    public synchronized void printB() {
        while (orderNum != 2) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        orderNum = 1;
        System.out.println("This is B");
        notifyAll();
    }

    public synchronized void printC() {
        while (orderNum != 3) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        orderNum = 2;
        System.out.println("This is C");
        notifyAll();
    }
}
