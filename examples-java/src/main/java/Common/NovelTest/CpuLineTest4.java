package Common.NovelTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuxiang on 2019/5/27.
 */
public class CpuLineTest4 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(8);

        Thread t1 = new CpuThread();
        Thread t2 = new CpuThread();
        Thread t3 = new CpuThread();
        Thread t4 = new CpuThread();
        Thread t5 = new CpuThread();
        Thread t6 = new CpuThread();
        Thread t7 = new CpuThread();
        Thread t8 = new CpuThread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
//        pool.execute(t5);
//        pool.execute(t6);
//        pool.execute(t7);
//        pool.execute(t8);

        pool.shutdown();
    }
}
