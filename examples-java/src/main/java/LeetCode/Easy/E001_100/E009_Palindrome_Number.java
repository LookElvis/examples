package LeetCode.Easy.E001_100;


/**
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * https://leetcode.com/problems/palindrome-number/solution/
 * Created by liuxiang on 2018/9/18.
 */
public class E009_Palindrome_Number {
    public static void main(String[] args) {
        int x = 2235321;
        boolean result = isPalindrome(x);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        for (int i = 0, j = temp.length()-1; i <= temp.length()/2; i++, j--) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
