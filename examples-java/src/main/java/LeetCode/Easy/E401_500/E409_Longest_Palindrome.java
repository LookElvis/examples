package LeetCode.Easy.E401_500;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * https://leetcode.com/submissions/detail/188807321/
 * Created by liuxiang on 2018/11/11.
 */
public class E409_Longest_Palindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        int result = longestPalindrome(s);
        System.out.println(result);
    }

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();

        int count1 = 0;
        int count2 = 0;
        for (Character c: chars) {
            if (!set.contains(c)) {
                set.add(c);
                count1++;
            } else {
                set.remove(c);
                count1--;
                count2 += 2;
            }
        }

        return count1 == 0 ? count2 : count2 + 1;
    }
}
