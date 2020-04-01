package Common.ThreadTest;

/**
 * Created by Elvis on 2020/3/9.
 */
public class ThreadPrint {
    private int orderNum = 3;
    public static int num = 1;
    public static void main(String[] args) {
        ThreadPrint orderThread = new ThreadPrint();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num <= 100) {
                    orderThread.printA();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num <= 100) {
                    orderThread.printB();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num <= 100) {
                    orderThread.printC();
                }
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
        if (num <= 100) {
            System.out.println("This is A " + num);
        }
        num++;
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
        if (num <= 100) {
            System.out.println("This is B " + num);
        }
        num++;
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
        if (num <= 100) {
            System.out.println("This is C " + num);
        }
        num++;
        notifyAll();
    }
}
