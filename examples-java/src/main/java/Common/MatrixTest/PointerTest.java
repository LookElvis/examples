package Common.MatrixTest;

/**
 * Created by liuxiang on 2019/4/12.
 */
public class PointerTest {
    public static void main(String[] args) {
        String[] intM = new String[]{"111", "222"};
        String[] intA = new String[]{"333", "444"};
        switchInt(intM, intA);
        System.out.println(intM[0]);
    }

    public static void switchInt(String[] m, String[] n) {
        m[0] = "a";
        String[] t = m;
        m = n;
        n = t;
    }
}
