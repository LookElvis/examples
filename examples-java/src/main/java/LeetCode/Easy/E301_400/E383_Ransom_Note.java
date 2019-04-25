package LeetCode.Easy.E301_400;

import LeetCode.PublicClass.Utils;

/**
 * https://leetcode.com/problems/ransom-note/description/
 * https://leetcode.com/submissions/detail/187956562/
 * Created by liuxiang on 2018/11/7.
 */
public class E383_Ransom_Note {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        boolean result = canConstruct(ransomNote, magazine);
        System.out.println(result);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] temp = new int[26];
        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        for (int i = 0; i < maga.length; i++) {
            temp[maga[i] - 97]++;
        }

        for (int j = 0; j < ransom.length; j++) {
            if (--temp[ransom[j] - 97] < 0) {
                return false;
            }
        }

        Utils.printIntArrays(temp);
        return true;
    }
}
