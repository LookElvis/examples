package LeetCode.Easy.E001_100;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * https://leetcode.com/submissions/detail/178126307/
 *
 * Created by liuxiang on 2018/9/24.
 */
public class E067_Add_Binary {
    public static void main(String[] args) {
        String a = "101";
        String b = "1101";
        String result = addBinary(a, b);
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        int addLenth = a.length()-b.length();
        String temp = "";
        for (int i=0; i < Math.abs(addLenth); i++){
            temp += "0";
        }
        if(addLenth > 0) {
            b = temp + b;
        } else {
            a = temp + a;
        }

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        String middleRes = "00";
        String result = "";
        char a0, a1, b0, b1;
        for (int j=a.length()-1; j >= 0; j--) {
            if(middleRes.charAt(0) == '0') {
                middleRes = addOperator(charsA[j], charsB[j]);
            } else {
                a0 = addOperator(charsA[j], charsB[j]).charAt(0);
                a1 = addOperator(charsA[j], charsB[j]).charAt(1);
                b0 = addOperator(a1, '1').charAt(0);
                b1 = addOperator(a1, '1').charAt(1);
                if(a0=='1' || b0=='1') {
                    middleRes = "1" + b1;
                } else {
                    middleRes = "0" + b1;
                }
            }
            result = middleRes.charAt(1) + result;
        }

        if(middleRes.charAt(0) == '1') {
            result = "1" + result;
        }

        return result;
    }

    public static String addOperator(char a, char b) {
        if(a == '0' && b =='0') {
            return "00";
        }
        if(a == '0' && b =='1') {
            return "01";
        }
        if(a == '1' && b =='0') {
            return "01";
        }
        if(a == '1' && b =='1') {
            return "10";
        }
        return "";
    }
}