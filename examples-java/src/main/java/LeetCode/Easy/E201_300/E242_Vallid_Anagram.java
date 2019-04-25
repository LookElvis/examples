package LeetCode.Easy.E201_300;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * https://leetcode.com/submissions/detail/186018477/
 * Created by liuxiang on 2018/10/29.
 */
public class E242_Vallid_Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nabaram";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-97] += 1;
            chars[t.charAt(i)-97] -= 1;
        }
        for (int j = 0; j < 26; j++) {
            if (chars[j] != 0) {
                return false;
            }
        }
        return true;
    }
}
