package LeetCode.Easy.E101_200;

/**
 * Write a function that takes an unsigned integer and returns the number
 * of '1' bits it has (also known as the Hamming weight).
 * https://leetcode.com/problems/number-of-1-bits/solution/
 * Created by liuxiang on 2018/10/21.
 */
public class E191_number_of_1_bits {
    public static void main(String[] args) {
        int n =   -2147483648 ;
        int result = hammingWeight(n);
        System.out.println(result);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while (i < 32) {
            if ((n&1) == 1) {
                count++;
            }
            n >>= 1;
            i++;
        }
        return count;
    }
}