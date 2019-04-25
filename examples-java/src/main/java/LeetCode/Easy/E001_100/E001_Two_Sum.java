package LeetCode.Easy.E001_100;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * https://leetcode.com/articles/two-sum/
 * Created by liuxiang on 2018/9/16.
 */
public class E001_Two_Sum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 56, 23};
        int target = 14;
        int[] result = new int[2];
        result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
