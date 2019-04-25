package LeetCode.Easy.E101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * https://leetcode.com/submissions/detail/183775817/
 * Created by liuxiang on 2018/10/19.
 */
public class E171_Excel_Sheet_Column_Number {
    public static void main(String[] args) {
        String s = "ZY";
        int result = titleToNumber(s);
        System.out.println(result);
    }

    public static int titleToNumber(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int bit = 0;
        int count = 0;
        int begin = 1;

        for (int j = 0; j < chars.length; j++) {
            map.put(j, begin);
            begin *= 26;
        }

        for (int i = chars.length-1; i >= 0; i--, bit++) {
            count += (chars[i]-'A'+1) * map.get(bit);
        }

        return count;
    }
}