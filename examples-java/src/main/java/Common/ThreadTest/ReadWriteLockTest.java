package Common.ThreadTest;

/**
 * Created by Elvis on 2020/3/9.
 */

public class ReadWriteLockTest {
    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLock = new ReadWriteLockDemo();
        //启动写线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLock.write(1);
            }
        }, "Write1").start();
        //启动10个读线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLock.read();
                }
            }).start();
        }
        //启动写线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLock.write(2);
            }
        }, "Write2").start();
    }
}

class ReadWriteLockDemo {
    private ReadWriteLock readWriteLock = new ReadWriteLock();
    private int num = 0; //共享资源

    //读
    public void read() {
        try {
            readWriteLock.lockRead();
            System.out.println(Thread.currentThread().getName() + " read " + num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.unlockRead();
        }
    }

    //写
    public void write(int number) {
        try {
            readWriteLock.lockWrite();
            this.num = number;
            System.out.println(Thread.currentThread().getName() + " write " + num);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            readWriteLock.unlockWrite();
        }
    }
}

class ReadWriteLock {
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