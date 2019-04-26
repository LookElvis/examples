package LeetCode.Easy.E001_100;

/**
 * https://leetcode.com/submissions/detail/178114436/
 * Created by liuxiang on 2018/9/24.
 */
public class E066_Plus_One {
    public static void main(String[] args) {
        int[] digits = {9};
        int[] result = plusOne(digits);
        for (int i=0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        if(digits[digits.length-1] != 9) {
            digits[digits.length-1]++;
            return digits;
        }

        boolean isNew = true;
        int i = digits.length-1;
        for (; i >= 0; i--) {
            if (digits[i] != 9) {
                isNew = false;
                break;
            }
        }
        int[] result;
        if(!isNew) {
            digits[i]++;
            for (int j=i+1; j < digits.length; j++) {
                digits[j] = 0;
            }
            digits[digits.length-1]=0;
            return digits;
        } else {
            result = new int[digits.length+1];
            result[0] = 1;
            for (int j=1; j < result.length; j++) {
                result[j] = 0;
            }
            return result;
        }
    }
}
