package Common.NovelTest;

/**
 * Created by liuxiang on 2018/4/14.
 */
public class CpuThread extends Thread{
    @Override
    public void run() {
        int busyTime = 10;
        int idleTime = busyTime;
        long startTime = 0;
        while (true) {
            startTime = System.currentTimeMillis();     // busy loop
            while ((System.currentTimeMillis() - startTime) <= busyTime) ;     // idle
            // loop
            try {
                Thread.sleep(idleTime);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

