package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * https://leetcode.com/submissions/detail/181671702/
 *
 * Created by liuxiang on 2018/10/9.
 */
public class M003_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "ohvhjdml";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                count++;
            } else {
                index = map.get(chars[i]);
                count = i - index;
                map.clear();
                for (int m = index + 1; m <= i; m++) {
                    map.put(chars[m], m);
                }
            }
            if(count > max) {
                max = count;
            }
        }
        return max;
    }
}