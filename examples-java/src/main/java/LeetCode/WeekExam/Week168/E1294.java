package LeetCode.WeekExam.Week168;

/**
 * Created by Elvis on 2019/12/22.
 */
public class E1294 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = 0;
            int t = nums[i];
            while (t != 0) {
                t /= 10;
                c++;
            }
            if ((c & 1) == 0) {
                count++;
            }
        }
        return count;
    }
}
