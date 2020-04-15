package New.Test10;

import java.util.Scanner;

/**
 * 阿里妈妈11
 * Created by Elvis on 2020/4/15.
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        //  结果等于 n * 2 ^ (n - 1)
        System.out.println((n * powSelf(2, n - 1)) % mod);
    }

    public static int mod = 1000000007;
    //  快速幂的实现
    public static long powSelf(int x, int n) {
        // n >= 0
        if (n == 0) {
            return 1;
        }
        long res = 1;
        long temp = x % mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * temp) % mod;
            }
            n >>= 1;
            temp = (temp * temp) % mod;
        }
        return res;
    }

}
