package Common.AlgrithmTest;

/**
 * 给个正整数 n 要是偶数就n = n/2 要是1奇数就 n = n-1 or n = n+1 .问让n变成 1最少需要几步
 * Created by Elvis on 2020/3/4.
 */
public class SingleDouble {
    public static void main(String[] args) {
        int n = 13;
        SingleDouble s = new SingleDouble();
        System.out.println(s.minStep(n));
    }

    public int minStep(int n) {
        int t = 0;
        while ((n & 1) == 0) {
            n >>= 1;
            t++;
        }
        if (n == 1) {
            return t;
        }
        return Math.min(minStep(n + 1), minStep(n - 1)) + t + 1;
    }
}
