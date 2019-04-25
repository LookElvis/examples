package LeetCode.Easy.E401_500;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal.
 * For negative integer, two’s complement method is used.
 * Created by liuxiang on 2018/11/10.
 */
public class E405_Convert_a_Number_to_Hexadecimal {
    public static void main(String[] args) {
        int num = -1;
        String result = toHex(num);
        System.out.println(result);
    }

    public static String toHex(int num) {
         return Integer.toHexString(num);
    }
}
