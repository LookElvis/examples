package LeetCode.Easy.E201_300;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * https://leetcode.com/submissions/detail/186247411/
 * Created by liuxiang on 2018/10/30.
 */
public class E263_Ugly_Number {
    public static void main(String[] args) {
        int num = 2147483647;
        boolean result = isUgly(num);
        System.out.println(result);
    }

    public static boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num == 2147483647) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if ((i != 2) && (i != 3) && (i != 5)) {
                    return false;
                }
                num /= i;
                i--;
            }
        }
        if ((num != 2) && (num != 3) && (num != 5)) {
            return false;
        }
        return true;
    }
}
