package LeetCode.Easy.E101_200;

/**
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * https://leetcode.com/submissions/detail/184268634/
 * Created by liuxiang on 2018/10/21.
 */
public class E198_House_Robber {
    public static void main(String[] args) {
        int[] nums = {2,1,9,13};
        int result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {
            int max = i >= 3 ? Math.max(nums[i-2], nums[i-3]) : nums[i-2];
            nums[i] = nums[i] + max;
        }
        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }
}
