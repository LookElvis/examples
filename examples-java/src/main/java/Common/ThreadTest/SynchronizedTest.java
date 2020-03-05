package Common.ThreadTest;

/**
 * Created by Elvis on 2020/3/5.
 */
public class SynchronizedTest {
    public static void main(String[] args) throws Exception{
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        SynchronizedTest synchronizedTest2 = new SynchronizedTest();
//        synchronizedTest1.Test3();
//        synchronizedTest2.Test3();
//        Test1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest1.Test1();
//                Test3();
            }
        }, "Thread1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedTest2.Test1();
//                Test4();
            }
        }, "Thread2").start();

    }

    public synchronized void Test1() {
        try {
            System.out.println("Test1");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void Test2() {
        try {
            System.out.println("Test2");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void Test3(){
        try {
            System.out.println("Test3");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void Test4(){
        try {
            System.out.println("Test4");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
