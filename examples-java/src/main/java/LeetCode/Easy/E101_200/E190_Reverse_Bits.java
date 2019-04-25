package LeetCode.Easy.E101_200;


/**
 * Reverse bits of a given 32 bits unsigned integer.
 * https://leetcode.com/problems/reverse-bits/submissions/
 * Created by liuxiang on 2018/10/20.
 */
public class E190_Reverse_Bits {
    public static void main(String[] args) {
        int n = 1;
        int result = reverseBits(n);
        System.out.println(result);
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }
}
