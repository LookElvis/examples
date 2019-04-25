package LeetCode.Easy.E401_500;

import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/keyboard-row/
 * Created by liuxiang on 2019/3/18.
 */
public class E500_Keyboard_Row {
    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace","bmxxmCBV",""};
        String[] results = findWords(words);
        Utils.printObjectArrays(results);
    }

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String regex1 = "[qwertyuiop]*";
        Pattern p1 = Pattern.compile(regex1);
        String regex2 = "[asdfghjkl]*";
        Pattern p2 = Pattern.compile(regex2);
        String regex3 = "[zxcvbnm]*";
        Pattern p3 = Pattern.compile(regex3);
        Matcher m1, m2, m3;

        for (int i = 0; i < words.length; i++) {
            String t = words[i].toLowerCase();
            m1 = p1.matcher(t);
            m2 = p2.matcher(t);
            m3 = p3.matcher(t);
            if (m1.matches() || m2.matches() || m3.matches()) {
                list.add(words[i]);
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
