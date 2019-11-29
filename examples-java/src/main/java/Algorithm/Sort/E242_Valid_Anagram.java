package Algorithm.Sort;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Elvis on 2019/11/29.
 */
public class E242_Valid_Anagram {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) == null ? 1 : map.get(s.charAt(i)) + 1);
            map.put(t.charAt(i), map.get(t.charAt(i)) == null ? -1 : map.get(t.charAt(i)) - 1);
        }

        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            Character tmp = it.next();
            if (map.get(tmp) != 0) {
                return false;
            }
        }
        return true;
    }
}
