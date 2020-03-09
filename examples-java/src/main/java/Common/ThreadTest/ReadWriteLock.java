package Common.ThreadTest;

/**
 * Created by Elvis on 2020/3/9.
 */
public class ReadWriteLock {
    private int readLock = 0;
    private int writeLock = 0;

    public synchronized void lockRead() throws Exception{
        while (writeLock > 0) {
            wait();
        }
        readLock++;
    }

    public synchronized void unlockRead() {
        readLock--;
        notifyAll();
    }

    public synchronized void lockWrite() throws Exception{
        while (writeLock > 0) {
            wait();
        }
        writeLock++;
        while (readLock > 0) {
            wait();
        }
    }

    public synchronized void unlockWrite() {
        writeLock--;
        notifyAll();
    }
}
