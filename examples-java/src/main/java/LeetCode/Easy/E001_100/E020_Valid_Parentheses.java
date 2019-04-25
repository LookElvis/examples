package LeetCode.Easy.E001_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * https://leetcode.com/submissions/detail/177296907/
 * Created by liuxiang on 2018/9/20.
 */
public class E020_Valid_Parentheses {
    public static void main(String[] args) {
//        String s = "(([]){})";
//        String s = "){";
//        String s = "{[]}";
        String s = "((";
        boolean result = isValid(s);
        System.out.println(result);
    }

    public static boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        if(s.length() % 2 != 0) {
            return false;
        }

        Map map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");

        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(String.valueOf(chars[i]))) {
                stack.push(map.get(String.valueOf(chars[i])));
            } else {
                if(stack.empty()) {
                    return false;
                }
                if(!stack.peek().equals(String.valueOf(chars[i]))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(!stack.empty()) {
            return false;
        }

        return true;
    }
}
