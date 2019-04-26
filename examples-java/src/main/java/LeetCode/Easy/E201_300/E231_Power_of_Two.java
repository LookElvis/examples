package LeetCode.Easy.E201_300;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * https://leetcode.com/submissions/detail/185377099/
 * Created by liuxiang on 2018/10/26.
 */
public class E231_Power_of_Two {
    public static void main(String[] args) {
        int n = 2;
        boolean result = isPowerOfTwo(n);
        System.out.println(result);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while (n != 1) {
            if ((n&1) != 0) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}
