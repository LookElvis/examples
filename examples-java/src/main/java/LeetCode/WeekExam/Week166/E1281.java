package LeetCode.WeekExam.Week166;

/**
 * Created by Elvis on 2019/12/8.
 */
public class E1281 {
    public int subtractProductAndSum(int n) {
        int count = 0;
        int mul = 1;
        while (n != 0) {
            int tmp = n % 10;
            count += tmp;
            mul *= tmp;
            n /= 10;
        }
        return mul - count;
    }
}
