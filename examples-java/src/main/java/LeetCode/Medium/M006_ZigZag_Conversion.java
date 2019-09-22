package LeetCode.Medium;

/**
 * Created by liuxiang on 2019/9/20.
 */
public class M006_ZigZag_Conversion {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String result = convert(s, numRows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String [] strings = new String[numRows];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "";
        }
        boolean dir = true;
        int line = 0;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (dir) {
                strings[line] += t;
                line++;
                if (line == numRows - 1) {
                    dir = false;
                }
            } else {
                strings[line] += t;
                line--;
                if (line == 0) {
                    dir = true;
                }
            }
        }

        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += strings[i];
        }

        return result;
    }
}
