package LeetCode.Easy.E101_200;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * https://leetcode.com/problems/factorial-trailing-zeroes/submissions/
 * Created by liuxiang on 2018/10/19.
 */
public class E172_Factorial_Trailing_Zeroes {
    public static void main(String[] args) {
        int n = 625;
        int result = trailingZeroes(n);
        System.out.println(result);
    }

    public static int trailingZeroes(int n) {
        int ret = 0;
        while (n/5 != 0) {
            ret += n/5;
            n /= 5;
        }
        return ret;
    }
}
