package LeetCode.Easy.E401_500;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * https://leetcode.com/submissions/detail/189213974/
 * Created by liuxiang on 2018/11/13.
 */
public class E415_Add_Strings {
    public static void main(String[] args) {
        String num1 = "85";
        String num2 = "345";
        String result = addStrings(num1, num2);
        System.out.println(result);
    }

    public static String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }

        String string = "";
        boolean isTen = false;
        int temp;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        for (; i >= 0; i--, j--) {
            temp = Integer.parseInt(String.valueOf(num1.charAt(i)))
                    + Integer.parseInt(String.valueOf(j < 0 ? "0" : num2.charAt(j)))
                    + (isTen == true ? 1 : 0);
            string = (temp % 10) + string;
            isTen = temp >= 10 ? true : false;
        }

        return isTen == true ? ("1" + string) : string;
    }
}
