package LeetCode.WeekExam.Week168;

import java.util.Arrays;

/**
 * Created by Elvis on 2019/12/22.
 */
public class M1295 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        int len = nums.length / k;
        Arrays.sort(nums);
        boolean[] isVisit = new boolean[nums.length];
        for (int i = 0; i < len; i++) {
            int j = 0;
            int t = 0;
            int c = 0;
            for (;j < nums.length; j++) {
                if (!isVisit[j]) {
                    t = nums[j];
                    c++;
                    isVisit[j] = true;
                    break;
                }
            }
            for (int m = j + 1; m < nums.length; m++) {
                if (!isVisit[m] && nums[m] == t + 1) {
                    t++;
                    c++;
                    isVisit[m] = true;
                }
                //System.out.print(t + " ");
                if (c == k) break;
            }
            if (c != k) return false;
        }
        System.out.println();
        return true;
    }
}
