package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * https://leetcode.com/submissions/detail/189725632/
 * Created by liuxiang on 2018/11/15.
 */
public class E438_Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        Utils.printArrayList(list);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[26];

        for (int i = 0; i < p.length(); i++) {
            nums[p.charAt(i) - 97]++;
        }

        for (int j = 0; j <= s.length() - p.length(); j++) {
            String compare = s.substring(j, j + p.length());
            int[] temp = nums.clone();
            boolean isRight = true;
            for (int m = 0; m < compare.length(); m++) {
                if (--temp[compare.charAt(m) - 97] < 0) {
                    isRight = false;
                    break;
                }
            }

            if (isRight) {
                list.add(j);
            }
        }

        return list;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        char[] ptrn = p.toCharArray();
        char[] str = s.toCharArray();

        int[] w = new int[26];

        for(char c : ptrn) w[c - 'a']++;

        int start = 0;

        List<Integer> result = new LinkedList<>();

        for(int i = 0; i<str.length; i++){
            int cIndex = str[i] - 'a';

            w[cIndex]--;
            // the crucial bit, if we have seen the character too many times
            // or it is a character that is not in the pattern, rewind the starting index
            while(w[cIndex] < 0){
                w[str[start] - 'a']++;
                start++;
            }

            if(i - start + 1 == ptrn.length){
                result.add(start);
                w[str[start] - 'a']++;
                start++;
            }
        }


        return result;
    }
}
