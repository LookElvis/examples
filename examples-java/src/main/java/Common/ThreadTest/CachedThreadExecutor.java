package Common.ThreadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuxiang on 2018/4/16.
 */
public class CachedThreadExecutor {

    public static void main(String args[]) {

        ExecutorService pool = Executors.newCachedThreadPool();

        Thread t1 = new MyThread();
        pool.execute(t1);
//        t1.run();
        Thread t2 = new MyThread();
        pool.execute(t2);
//        t2.run();
        Thread t3 = new MyThread();
        pool.execute(t3);
        Thread t4 = new MyThread();
        pool.execute(t4);

        pool.shutdown();

    }

}
