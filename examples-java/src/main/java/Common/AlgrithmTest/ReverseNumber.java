package Common.AlgrithmTest;

/**
 * Created by Elvis on 2020/3/21.
 */
public class ReverseNumber {
    public static void main(String[] args) {
        int n = 784532;
        System.out.println(reverse(n));
    }

    public static int reverse(int n) {
        int t = 0;
        int res = 0;
        while (n != 0) {
            t = n % 10;
            n /= 10;
            res += t;
            if (n != 0) {
                res *= 10;
            }
        }
        return res;
    }
}
