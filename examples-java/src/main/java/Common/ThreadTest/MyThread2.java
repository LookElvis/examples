package Common.ThreadTest;

/**
 * Created by liuxiang on 2019/4/19.
 */
public class MyThread2 implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is running1...");
        try {
            Thread.sleep(60);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + " is running2...");
    }
}
