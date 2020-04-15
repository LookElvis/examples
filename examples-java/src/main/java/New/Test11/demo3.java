package New.Test11;

/**
 * Created by Elvis on 2020/4/15.
 */
/**
 * 第三题：设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1，结果为0。
 * 写出程序。
 */
public class demo3 {
    private volatile int num;
    public static void main(String[] args) {
        demo3 demo3 = new demo3();
        Add add = demo3.new Add();
        Minus minus = demo3.new Minus();
        Thread t1, t2;
        for(int i = 0; i < 2; i++){
            t1 = new Thread(add);
            t1.start();
            t2 = new Thread(minus);
            t2.start();
        }
    }

    class Add implements Runnable {
        @Override
        public void run() {
            add();
        }
    }

    class Minus implements Runnable {
        @Override
        public void run() {
            minus();
        }
    }

    public synchronized void add() {
        num++;
        System.out.println(num);
    }

    public synchronized void minus(){
        num--;
        System.out.println(num);
    }
}
