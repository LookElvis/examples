package LeetCode.Easy.E301_400;

/**
 * Given an integer (signed 32 bits), write a function to
 * check whether it is a power of 4.
 * https://leetcode.com/submissions/detail/187102391/
 * Created by liuxiang on 2018/11/3.
 */
public class E342_Power_of_Four {
    public static void main(String[] args) {
        int n = 32;
        boolean result = isPowerOfFour(n);
        System.out.println(result);
    }

    public static boolean isPowerOfFour(int n) {
        if (n < 1 || (Integer.bitCount(n) != 1)) {
            return false;
        }
        for (int i = 0; i < 16; i++) {
            if (n == 1) {
                return true;
            } else {
                n >>= 2;
            }
        }
        return false;
    }
}
