package LeetCode.Easy.E001_100;

/**
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * https://leetcode.com/submissions/detail/178128859/
 * Created by liuxiang on 2018/9/24.
 */
public class E069_SqrtX {
    public static void main(String[] args) {
        int x = 15;
        int result = mySqrt(x);
        System.out.println(result);
    }

    public static int mySqrt(int x) {
        double a = x + 0.01;
        double b = Math.sqrt(a);
        int result = new Double(b).intValue();
        return result;
    }
}
