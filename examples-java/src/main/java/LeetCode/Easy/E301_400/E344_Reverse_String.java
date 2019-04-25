package LeetCode.Easy.E301_400;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * https://leetcode.com/submissions/detail/187314247/
 * Created by liuxiang on 2018/11/4.
 */
public class E344_Reverse_String {
    public static void main(String[] args) {
        String s = "aabcda";
        String result = reverseString(s);
        System.out.println(result);
    }

    public static String reverseString(String s) {
        StringBuilder result = new StringBuilder(s);
        return result.reverse().toString();
    }
}
