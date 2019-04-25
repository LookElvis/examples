package LeetCode.Easy.E001_100;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * f(i) = max {f(i-1), f(i-1)+nums[i]}
 * https://leetcode.com/submissions/detail/177839030/
 * Created by liuxiang on 2018/9/22.
 */
public class E053_Maximum_Subarray {
    public static void main(String[] args) {
        int[] nums = {-2, -8, -3, -4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return new Integer(-1);
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int maximum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) {
                nums[i] += nums[i-1];
            }
            if(nums[i] > maximum) {
                maximum = nums[i];
            }
        }
        return maximum;
    }
}
