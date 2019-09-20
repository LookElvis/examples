package LeetCode.Easy.E001_100;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * https://leetcode.com/problems/reverse-integer/solution/
 * Created by liuxiang on 2018/9/16.
 */
public class E007_Reverse_Integer {
    public static void main(String[] args) {
//        int Result = reverse(1563847412);
        int result = reverse(-1234);
        System.out.println(result);
    }
    public static int reverse(int x) {
        int result = 0;
        int rest = 0;
        int num = x;
        int lenth = 1;
        int muti = 1;
        while(num/10 != 0){
            num = num / 10;
            lenth ++;
            muti *= 10;
        }

        int temp = 0;
        int re = 0;
        while (x != 0) {
            rest = x % 10;

            temp = rest * muti;

            if(rest != 0 && temp / rest != muti) {
                return 0;
            }

            re = result;
            result = result + temp;
            if(re > 0 && temp > 0 && result < 0) {
                return 0;
            }
            if(re < 0 && temp < 0 && result >0) {
                return 0;
            }

            muti /= 10;
            x /= 10;
        }
        return result;
    }
}
