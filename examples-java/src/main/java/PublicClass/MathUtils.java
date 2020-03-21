package PublicClass;

/**
 * 数学工具类
 * Created by Elvis on 2020/3/21.
 */
public class MathUtils {
    // 辗转相除法求最大公约数
    public static int calGCD(int x, int y) {
        int t = x;
        for (int i = 1; i <= t; i++) {
            int c = x > y ? x : y;//两个数字的大值
            int d = x < y ? x : y;//两个数字的小值
            x = c % d;
            y = d;
            if (x == 0) {
                return d;
            }
        }
        return -1;
    }


    // 求1-N的逆元,避免另一种方式超时
    public static long[] reverseArray(int N, int MOD) {
//        int N = 200000 + 5;
//        int MOD = (int) 1e9 + 7;
        long inv[] = new long[N];
        inv[1] = 1;
        for (int i = 2; i < N; i++) {
            inv[i] = (MOD - MOD / i) * 1L * inv[MOD % i] % MOD;
        }
        return inv;
    }

    // 某个分数的逆元 = 分子 * (分母 % p的逆元) = 分子 * Fermat(分母, p)
    public static long Fermat(long a, long p){//费马求a关于b的逆元
        return pow_mod(a, p - 2, p);
    }
    public static long pow_mod(long a, long b, long p){//a的b次方求余p
        long ret = 1;
        while(b != 0){
            if((b & 1) == 1) {
                ret = (ret * a) % p;
            }
            a = (a * a) % p;
            b >>= 1;
        }
        return ret;
    }
}
