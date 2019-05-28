package Common.NovelTest;

import Common.ThreadTest.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuxiang on 2019/5/27.
 */
public class CpuLineTest {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newFixedThreadPool(8);

        Thread t1 = new CpuThread();
        Thread t2 = new CpuThread();
        Thread t3 = new CpuThread();
        Thread t4 = new CpuThread();
        Thread t5 = new CpuThread();
        Thread t6 = new CpuThread();
        Thread t7 = new CpuThread();
        Thread t8 = new CpuThread();
        Thread t11 = new CpuThread();
        Thread t22 = new CpuThread();
        Thread t33 = new CpuThread();
        Thread t44 = new CpuThread();
        Thread t55 = new CpuThread();
        Thread t66 = new CpuThread();
        Thread t77 = new CpuThread();
        Thread t88 = new CpuThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t11.start();
        t22.start();
        t33.start();
        t44.start();
        t55.start();
        t66.start();
        t77.start();
        t88.start();
    }
}
