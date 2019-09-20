package LeetCode.Medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Created by liuxiang on 2018/11/26.
 */
public class M005_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        String s = "ebabccbade";
        String longest = longestPalindrome(s);
        System.out.println(longest);
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length == 0 || s == null) {
            return "";
        }

        int max = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < length; i++) {
            int pre = i - 1;
            int suf = i + 1;
            if (pre < 0 || suf > length - 1) {
                if (1 > max) {
                    max = 1;
                    result = s.charAt(i) + "";
                }
            }
            int count = 1;
            while (pre >= 0 && suf <= length - 1) {
                if (s.charAt(pre) == s.charAt(suf)) {
                    count += 2;
                    pre--;
                    suf++;
                } else {
                    break;
                }
            }

            if (count > max) {
                max = count;
                result = s.substring(pre + 1, suf);
            }
        }

        for (int i = 0; i < length - 1; i++) {
            int pre = i;
            int suf = i + 1;
            int count = 0;
            while (pre >= 0 && suf <= length - 1) {
                if (s.charAt(pre) == s.charAt(suf)) {
                    count += 2;
                    pre--;
                    suf++;
                } else {
                    break;
                }
            }

            if (count > max) {
                max = count;
                result = s.substring(pre + 1, suf);
            }
        }

        return result;
    }
}