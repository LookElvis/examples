package LeetCode.Easy.E201_300;

import LeetCode.PublicClass.Utils;

/**
 * Given an array nums, write a function to moveRight all 0's to
 * the end of it while maintaining the relative order of the non-zero elements.
 * https://leetcode.com/problems/move-zeroes/solution/
 * Created by liuxiang on 2018/11/1.
 */
public class E283_Move_Zeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Utils.printIntArrays(nums);
        System.out.println();
        moveZeroes(nums);
        Utils.printIntArrays(nums);
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = 0;
                nums[index] = temp;
                index++;
            }
        }
    }
}
