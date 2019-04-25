package LeetCode.Easy.E201_300;

/**
 * Given an array containing n distinct numbers taken from
 * 0, 1, 2, ..., n, find the one that is missing from the array.
 * https://leetcode.com/problems/missing-number/solution/
 * Created by liuxiang on 2018/10/31.
 */
public class E268_Missing_Number {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int result = missingNumber(nums);
        System.out.println(result);
    }

    public static int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += i - nums[i];

        }
        result += nums.length;
        return result;
    }
}
