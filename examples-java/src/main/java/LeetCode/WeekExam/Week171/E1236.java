package LeetCode.WeekExam.Week171;

/**
 * Created by Elvis on 2020/1/12.
 */
public class E1236 {
    public static void main(String[] args) {

    }

    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (!hasZero(i) && !hasZero(n - i)) {
                return new int[] {i, n - i};
            }
        }
        return new int[] {};
    }

    public boolean hasZero(int n) {
        while (n != 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
