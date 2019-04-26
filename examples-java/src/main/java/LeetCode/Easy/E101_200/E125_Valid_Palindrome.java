package LeetCode.Easy.E101_200;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * https://leetcode.com/submissions/detail/182845245/
 * Created by liuxiang on 2018/10/15.
 */
public class E125_Valid_Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int lPointer = 0;
        int rPointer = chars.length-1;
        while (lPointer <= rPointer) {
            while ((chars[lPointer] < 'a' || chars[lPointer] > 'z') && (chars[lPointer] < '0' || chars[lPointer] > '9')) {
                lPointer++;
                if(lPointer >= chars.length) {
                    return true;
                }
            }
            while ((chars[rPointer] < 'a' || chars[rPointer] > 'z') && (chars[rPointer] < '0' || chars[rPointer] > '9')) {
                rPointer--;
            }
            if (chars[lPointer] == chars[rPointer]) {
                lPointer++;
                rPointer--;
            } else {
                return false;
            }
        }
        return true;
    }
}
