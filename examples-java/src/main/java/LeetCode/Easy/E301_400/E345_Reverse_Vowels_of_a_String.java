package LeetCode.Easy.E301_400;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * https://leetcode.com/submissions/detail/187319863/
 * Created by liuxiang on 2018/11/4.
 */
public class E345_Reverse_Vowels_of_a_String {
    public static void main(String[] args) {
        String s = "leetcode";
        String result = reverseVowels(s);
        System.out.println(result);
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (isVowels(chars[i])) {
                list.add(i);
            }
         }

         for (int m = 0, n = list.size() - 1; m < n; m++, n--) {
            char temp = 0;
            temp = chars[list.get(m)];
            chars[list.get(m)] = chars[list.get(n)];
            chars[list.get(n)] = temp;
         }
        return new String(chars);
    }

    public static boolean isVowels(Character c) {
        boolean s = (c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u')
                || (c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U');
        return s;
    }
}
