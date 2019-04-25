package LeetCode.Easy.E301_400;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * https://leetcode.com/submissions/detail/187746270/
 * 此题关键为将int转化为long然后二分
 * Created by liuxiang on 2018/11/6.
 */
public class E367_Valid_Perfect_Square {
    public static void main(String[] args) {
        int num = 808201;
        boolean result = isPerfectSquare(num);
        System.out.println(result);
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long begin = 1;
        long end = num / 2;

        long nums = (long)num;
        while (begin <= end) {
            long mid = (end - begin) / 2 + begin;

            if (mid * mid == nums) {
                return true;
            } else if (mid * mid < nums) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
