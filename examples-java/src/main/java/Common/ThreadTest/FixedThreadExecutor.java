package Common.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuxiang on 2018/4/16.
 */
public class FixedThreadExecutor{

    public static void main(String args[]) {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
//        try {
//            t3.sleep(60001);
//        } catch (Exception e) {
//
//        }
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();

    }

}
