package LeetCode.Easy.E201_300;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * https://leetcode.com/submissions/detail/184697533/
 * Created by liuxiang on 2018/10/23.
 */
public class E204_Count_Primes {
    public static void main(String[] args) {
        int n = 100;
        int result = countPrimes(n);
        System.out.println(result);
    }

    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] bits = new boolean[n];
        bits[0] = true;
        bits[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if (bits[i]) {
                continue;
            }

            for (int j = 2; i*j< n; j++) {
                bits[i*j] = true;
            }
        }

        int count = 0;
        for (int m = 0; m < bits.length; m++) {
            if (!bits[m]) {
                 count++;
            }
        }
        return count;
    }
}
