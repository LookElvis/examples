package LeetCode.Easy.E201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * https://leetcode.com/submissions/detail/184727959/
 * Created by liuxiang on 2018/10/23.
 */
public class E205_Isomorphic_Strings {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        boolean result = isIsomorphic(s, t);
        System.out.println(result);
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, String> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), String.valueOf(i));
            } else {
                map1.put(s.charAt(i), map1.get(s.charAt(i))+"+"+String.valueOf(i));
            }

            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), String.valueOf(i));
            } else {
                map2.put(t.charAt(i), map2.get(t.charAt(i))+"+"+String.valueOf(i));
            }
        }

        for (int j = 0; j < s.length(); j++) {
            if (!map1.get(s.charAt(j)).equals(map2.get(t.charAt(j)))) {
                return false;
            }
        }
        return true;
    }
}
