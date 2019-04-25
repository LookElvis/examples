package LeetCode.Easy.E301_400;

/**
 * Given an integer, write a function to determine if it is
 * a power of three.
 * https://leetcode.com/problems/power-of-three/solution/
 * Created by liuxiang on 2018/11/3.
 */
public class E326_Power_of_Three {
    public static void main(String[] args) {
        int n = 28;
        System.out.println(Integer.toString(5,3));
        boolean result = isPowerOfThree(n);
        System.out.println(result);
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
