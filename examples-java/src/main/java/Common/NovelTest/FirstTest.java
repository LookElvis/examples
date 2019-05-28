package Common.NovelTest;

/**
 * Created by liuxiang on 2019/5/28.
 */
public class FirstTest {
    public static void main(String[] args) {
        int n = 800000000;
        while (true) {
            for (int i = 0; i < n; i++);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
