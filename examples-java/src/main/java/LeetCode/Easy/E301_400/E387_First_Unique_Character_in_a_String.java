package LeetCode.Easy.E301_400;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in
 * it and return it's index. If it doesn't exist, return -1.
 * https://leetcode.com/submissions/detail/188168718/
 * Created by liuxiang on 2018/11/8.
 */
public class E387_First_Unique_Character_in_a_String {
    public static void main(String[] args) {
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
            } else {
                map.put(chars[i], -1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Character c : map.keySet()) {
            int temp = map.get(c);
            if (temp < min && temp >= 0) {
                min = temp;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
