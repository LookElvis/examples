package LeetCode.Easy.E201_300;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * https://leetcode.com/submissions/detail/184473882/
 * Created by liuxiang on 2018/10/22.
 */
public class E201_Happy_Number {
    public static void main(String[] args) {
        int n = 19;
        boolean result = isHappy(n);
        System.out.println(result);
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        while (result != 1) {
            result = 0;
            while (n != 0) {
                result += (n%10) * (n%10);
                n /= 10;
            }

            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            n = result;
        }

        return true;
    }
}
