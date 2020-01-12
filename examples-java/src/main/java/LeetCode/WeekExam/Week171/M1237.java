package LeetCode.WeekExam.Week171;

/**
 * Created by Elvis on 2020/1/12.
 */
public class M1237 {
    public static void main(String[] args) {
        int a = 14 & 1;
        int b = a | 1;
        System.out.println(b == 0);
    }

    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            int x = a & 1;
            int y = b & 1;
            int z = c & 1;
            if ((x | y) != z) {
                if (x == 1 && y == 1) {
                    count += 2;
                } else {
                    count += 1;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }
}
