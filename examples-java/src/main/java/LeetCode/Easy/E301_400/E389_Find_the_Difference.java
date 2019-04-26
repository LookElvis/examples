package LeetCode.Easy.E301_400;

/**
 * https://leetcode.com/problems/find-the-difference/description/
 * https://leetcode.com/submissions/detail/188170806/
 * Created by liuxiang on 2018/11/8.
 */
public class E389_Find_the_Difference {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        char result = findTheDifference(s, t);
        System.out.println(result);
    }

    public static char findTheDifference(String s, String t) {
        StringBuilder stringBuilder = new StringBuilder(s).append(t);
        char[] chars = stringBuilder.toString().toCharArray();
        char result = 0;
        for (int i = 0; i < chars.length; i++) {
            result ^= chars[i];
        }
        return result;
    }
}
