package LeetCode.Easy.E401_500;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * https://leetcode.com/submissions/detail/191198779/
 * Created by liuxiang on 2018/11/23.
 */
public class E485_Max_Consecutive_Ones {
    public static void main(String[] args) {
        int[] nums = {};
        int max = findMaxConsecutiveOnes(nums);
        System.out.println(max);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = nums[0] == 0 ? 0 : 1;
        int max = count;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max = count > max ? count : max;
            } else {
                count = 0;
            }
        }

        return max;
    }
}
