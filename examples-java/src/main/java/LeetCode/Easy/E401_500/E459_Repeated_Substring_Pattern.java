package LeetCode.Easy.E401_500;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * https://leetcode.com/submissions/detail/190417357/
 * Created by liuxiang on 2018/11/19.
 */
public class E459_Repeated_Substring_Pattern {
    public static void main(String[] args) {
        String s = "bb";
        boolean result = repeatedSubstringPattern(s);
        System.out.println(result);
    }

    public static boolean repeatedSubstringPattern(String s) {
        int i = 1;
        int j = s.length() / 2;
        while (i <= j) {
            if (helper(s, i) || helper(s, j)) {
                return true;
            }
            i++;
            j--;
        }

        return false;
    }

    public static boolean helper(String s, int length) {
        if (s.length() % length != 0) {
            return false;
        }

        String temp = s.substring(0, length);
        for (int i = length; i < s.length(); i = i + length) {
            if (!temp.equals(s.substring(i, i + length))) {
                return false;
            }
        }

        return true;
    }
}
