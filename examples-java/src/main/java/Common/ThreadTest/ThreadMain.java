package Common.ThreadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuxiang on 2019/4/19.
 */
public class ThreadMain {
    public static void main(String[] args) {
//        Thread thread = new MyThread();
////        thread.run();
//        thread.start();
//        System.out.println("liu");

        MyThread2 thread2 = new MyThread2();
        Thread thread = new Thread(thread2);
        thread.start();
        System.out.println("liu");
    }
}
