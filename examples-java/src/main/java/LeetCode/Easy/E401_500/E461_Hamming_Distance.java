package LeetCode.Easy.E401_500;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * https://leetcode.com/submissions/detail/190611186/
 * Created by liuxiang on 2018/11/20.
 */
public class E461_Hamming_Distance {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(Integer.MAX_VALUE);
        int result = hammingDistance(x, y);
        System.out.println(result);
    }

    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
