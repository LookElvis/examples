package LeetCode.Easy.E401_500;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required
 * to make all array elements equal, where a moveRight is incrementing n - 1 elements by 1.
 * https://leetcode.com/submissions/detail/190085157/
 * Created by liuxiang on 2018/11/17.
 */
public class E453_Minimum_Moves_to_Equal_Array_Elements {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        int result = minMoves(nums);
        System.out.println(result);
    }

    public static int minMoves(int[] nums) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            count += nums[i];
        }

        return count - min * nums.length;
    }
}
