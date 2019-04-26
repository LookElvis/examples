package LeetCode.Easy.E001_100;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * https://leetcode.com/submissions/detail/178081399/
 * Created by liuxiang on 2018/9/24.
 */
public class E058_Length_of_Last_Word {
    public static void main(String[] args) {
        String s = " hello world ";
        System.out.println(s);
        System.out.println(s.trim());
//        int result = lengthOfLastWord(s);
//        System.out.println(result);
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.trim().length() == 0) {
            return 0;
        }
        String[] strings = s.split(" ");
        String lastWord = strings[strings.length-1];
        return lastWord.length();
    }
}
