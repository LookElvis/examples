package LeetCode.Easy.E101_200;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * https://leetcode.com/submissions/detail/183589808/
 * Created by liuxiang on 2018/10/18.
 */
public class E168_Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        int n = 52;
        String result = convertToTitle(n);
        System.out.println(result);
    }

    public static String convertToTitle(int n) {
        String temp = "";
        while (true) {
            if (n <= 26) {
                temp = (char) ('A'+n-1) + temp;
                break;
            }
            int mod = n % 26;
            char c;
            if (mod == 0) {
                c = 'Z';
            } else {
                c = (char) ('A'+mod-1);
            }
            temp = c + temp;
            n = (n-1) / 26;
        }
        return temp;
    }
}
