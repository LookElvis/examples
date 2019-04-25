package LeetCode.Easy.E301_400;

/**
 * Given an integer array nums, find the sum of the elements
 * between indices i and j (i ≤ j), inclusive.
 * https://leetcode.com/submissions/detail/186903462/
 * Created by liuxiang on 2018/11/2.
 */
public class E303_Range_Sum_Query_Immutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        int i = 0;
        int j = 2;
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(i, j);
        System.out.println(param_1);
    }

    static class NumArray {
        int[] temp;

        public NumArray(int[] nums) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += nums[i];
                nums[i] = count;
            }
            temp = nums;
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return temp[j];
            } else {
                return temp[j] - temp[i-1];
            }
        }
    }
}


