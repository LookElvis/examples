package LeetCode.Easy.E401_500;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Created by liuxiang on 2018/11/16.
 */
public class E441_Arranging_Coins {
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        int result = arrangeCoins(n);
        System.out.println(result);
    }

    public static int arrangeCoins(int n) {
        long temp = (long) 2 * n;
        int i = (int) Math.pow(temp, 0.5);

        while ((long) i * i < temp - i) {
            i++;
        }

        if ((long) i * i != temp - i) {
            i--;
        }

        return i;
    }
}
