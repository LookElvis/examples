package LeetCode.Easy.E101_200;

import LeetCode.PublicClass.Utils;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * https://leetcode.com/problems/rotate-array/solution/
 * Created by liuxiang on 2018/10/20.
 */
public class E189_Rotate_Array {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        Utils.printIntArrays(nums);
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            nums = null;
            return;
        }
        if(k >= nums.length) {
            k %= nums.length;
        }
        int[] temp = new int[nums.length-k];
        for (int i = 0; i < nums.length-k; i++) {
            temp[i] = nums[i];
        }

        for (int j=0, m=nums.length-k; j < k; j++,m++) {
            nums[j] = nums[m];
        }

        for (int g=0, n=k; n < nums.length; g++,n++) {
            nums[n] = temp[g];
        }
    }
}
