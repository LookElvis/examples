package Common.ThreadTest;

/**
 * Created by liuxiang on 2018/4/14.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is running1...");
        try {
            Thread.sleep(60);
        } catch (Exception e) {

        }
        System.out.println(Thread.currentThread().getName() + " is running2...");
        System.out.println(Thread.currentThread().getId() + " is finishing...");
    }
}

