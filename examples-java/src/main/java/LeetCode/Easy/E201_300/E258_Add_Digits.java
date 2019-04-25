package LeetCode.Easy.E201_300;

/**
 * Given a non-negative integer num, repeatedly add all
 * its digits until the result has only one digit.
 * https://leetcode.com/submissions/detail/186234649/
 * 九余数定理：n的树根为(n-1)%9+1
 * Created by liuxiang on 2018/10/30.
 */
public class E258_Add_Digits {
    public static void main(String[] args) {
        int num = 38;
        int result = addDigits(num);
        System.out.println(result);
    }

    public static int addDigits(int num) {
        return (num-1) % 9 + 1;
    }
}
