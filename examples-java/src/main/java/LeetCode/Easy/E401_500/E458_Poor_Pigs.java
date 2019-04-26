package LeetCode.Easy.E401_500;

/**
 * https://leetcode.com/problems/poor-pigs/
 * https://leetcode.com/submissions/detail/190410663/
 * Created by liuxiang on 2018/11/19.
 */
public class E458_Poor_Pigs {
    public static void main(String[] args) {
        int buckets = 1024;
        int minutesToDie = 10;
        int minutesToTest = 100;
        int result = poorPigs(buckets, minutesToDie, minutesToTest);
        System.out.println(result);
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pow = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        for (; ; ) {
            boolean isTrue = Math.pow(pow, pigs) < buckets ? true : false;
            if (isTrue) {
                pigs++;
            } else {
                return pigs;
            }
        }
    }
}
