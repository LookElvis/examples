package Common.ThreadTest;

/**
 * Created by liuxiang on 2019/4/23.
 */
public class ThreadDrawTest {
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
        ThreadAccount acct = new ThreadAccount("1234567",1000);
        new DrawThread("甲",acct,800).start();
        new DrawThread("乙",acct,800).start();
    }
}
