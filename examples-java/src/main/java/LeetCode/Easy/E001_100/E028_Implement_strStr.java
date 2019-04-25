package LeetCode.Easy.E001_100;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * https://leetcode.com/submissions/detail/177482655/
 * Created by liuxiang on 2018/9/21.
 */
public class E028_Implement_strStr {
    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        int result = strStr(haystack, needle);
        haystack.indexOf(needle);
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        char[] chars = haystack.toCharArray();
        int len = needle.length();

        for (int i=0; i <= chars.length-len; i++) {
            if (haystack.substring(i, i+len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
