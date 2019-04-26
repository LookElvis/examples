package LeetCode.Easy.E201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str,
 * find if str follows the same pattern.
 * https://leetcode.com/submissions/detail/186680175/
 * Created by liuxiang on 2018/11/1.
 */
public class E290_Word_Pattern {
    public static void main(String[] args) {
        String pattern = "aaaa";
        String str = "dog cat dog cat";
        boolean result = wordPattern(pattern, str);
        System.out.println(result);
    }

    public static boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] strings = str.split(" ");
        if (chars.length != strings.length) {
            return false;
        }

        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(strings[i])) {
                if (map.containsValue(chars[i])) {
                    return false;
                }
                map.put(strings[i], chars[i]);
            } else if (!map.get(strings[i]).equals(chars[i])) {
                return false;
            }
        }
        return true;
    }
}
