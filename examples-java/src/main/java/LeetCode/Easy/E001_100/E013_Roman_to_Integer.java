package LeetCode.Easy.E001_100;


/**
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * https://leetcode.com/problems/roman-to-integer/discuss/170244/Java-Solution
 * Created by liuxiang on 2018/9/18.
 */
public class E013_Roman_to_Integer {
    public static void main(String[] args) {
        String str = "LVIII";
        int result = romanToInt(str);
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        int result = 0;
        int i = 0;

        for ( ; i < s.length()-1; ) {
            String temp1 = s.substring(i, i+2);
            int r1 = switchRoman2(temp1);
            if(r1 != 0) {
                result += r1;
                i += 2;
            } else {
                String temp2 = s.substring(i, i+1);
                int r2 = switchRoman1(temp2);
                result += r2;
                i += 1;
            }
        }
        if(i != s.length()) {
            result += switchRoman1(s.substring(i, i+1));
        }
        return result;
    }

    public static int switchRoman2(String temp) {
        int num = 0;
        switch (temp) {
            case "CM": num = 900; break;
            case "CD": num = 400; break;
            case "XC": num = 90; break;
            case "XL": num = 40; break;
            case "IX": num = 9; break;
            case "IV": num = 4; break;
            default: num = 0; break;
        }
        return num;
    }

    public static int switchRoman1(String temp) {
        int num = 0;
        switch (temp) {
            case "M": num = 1000; break;
            case "D": num = 500; break;
            case "C": num = 100; break;
            case "L": num = 50; break;
            case "X": num = 10; break;
            case "V": num = 5; break;
            case "I": num = 1; break;
            default: num = 0;
        }
        return num;
    }
}
