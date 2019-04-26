package LeetCode.Easy.E001_100;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * https://leetcode.com/submissions/detail/178290062/
 * Created by liuxiang on 2018/9/25.
 */
public class E070_Climbing_Stairs {
    public static void main(String[] args) {
        int n = 6;
        int result = climbStairs(n);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        int i1 = 1;
        int i2 = 2;
        int result = 0;
        for (int i=3; i <= n; i++) {
            result = i1 + i2;
            i1 = i2;
            i2 = result;
        }

        return result;
    }
}
