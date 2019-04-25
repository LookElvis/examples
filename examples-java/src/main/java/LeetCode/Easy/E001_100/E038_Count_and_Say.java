package LeetCode.Easy.E001_100;

/**
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * https://leetcode.com/submissions/detail/177694803/
 * Created by liuxiang on 2018/9/22.
 */
public class E038_Count_and_Say {
    public static void main(String[] args) {
        int n = 6;
        String result = countAndSay(n);
        System.out.println(result);
    }

    public static String countAndSay(int n) {
        String strNum = "1";
        String thisNum;
        char[] chars;
        int count;

        for (int i = 1; i < n; i++) {
            chars = strNum.toCharArray();
            thisNum = "";
            count = 1;
            for (int j = 1; j < chars.length; j++) {
                if(chars[j] == chars[j-1]) {
                    count++;
                } else {
                    thisNum = thisNum + count + "" + chars[j-1];
                    count = 1;
                }
            }

            thisNum += count + "" + chars[chars.length-1];
            strNum = thisNum;
        }

        return strNum;
    }
}
